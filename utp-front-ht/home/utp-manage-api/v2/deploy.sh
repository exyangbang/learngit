#!/bin/bash
selApp=$1
selAct=$2
rootDir=/home/utp-manage-api/v2
set -eu
cd $rootDir
export JAVA_HOME=/home/jdk1.8.0_161
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/tools.jar
COLUMNS=1
PS3="Please input a number:"
options=("start" "stop" "restart" "deploy" "backup" "exit")

# if [[ $# -eq 3 ]];then
#   app_code="$1"
#   profile="$2"
#   label="$3"

#   config_path="https://gitlab.xmylsw.com/spring-cloud-config/config-deploy/raw/master/${app_code}/${profile}/${label}.json"
#   echo "Load configuration from '${config_path}'"
#   read config_content <<< $(curl -sk ${config_path})
# else
#   echo $"Usage: $0 app_code profile label"
#   exit 1
# fi



#data from json file
len=$(jq -r '.programs[]|length' deploy.json|wc -l)
programs=($(jq -r '.programs[]|.name' deploy.json))
apppath="${rootDir}/$(jq -r '.apppath' deploy.json)"
bakpath="${rootDir}/$(jq -r '.bakpath' deploy.json)"
deploypath="${rootDir}/$(jq -r '.deploypath' deploy.json)"
consoleout="${rootDir}/$(jq -r '.consoleout' deploy.json)"
pkgroot="$(jq -r '.pkgroot' deploy.json)"
sshinfo="$(jq -r '.sshinfo' deploy.json)"

if [[ -n "$selApp" ]]; then
  app="$(jq  -r ".programs[${selApp}-1]" deploy.json)"
  app_args="$(jq -n -r "${app}|.app_args")"
  pgpkg="$(jq -n -r "${app}|.pkg")"
  jvm_args="$(jq -n -r "${app}|.jvm_args")"
  selName="$(jq -n -r "${app}|.name")"
else
select program in "${programs[@]}"
do
  [[ ${REPLY} -gt ${len} ]] && (echo "Error Input"; exit 1)
  app_args="$(jq  -r ".programs[] | select(.name == \"${program}\")|.app_args" deploy.json)"
  pgpkg="$(jq  -r ".programs[] | select(.name == \"${program}\")|.pkg" deploy.json)"
  jvm_args="$(jq  -r ".programs[] | select(.name == \"${program}\")|.jvm_args" deploy.json)"
  selName=${program}
  break
done
fi
echo "$selName $app_args $pgpkg $jvm_args"
startup() {
  if [ -f "${apppath}/$1.jar" ];then
    echo "Startup $1 ...."
    cd ${apppath}
    nohup java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${consoleout}/$1.hprof ${jvm_args} -jar "$1.jar" ${app_args} >/dev/null 2>&1 &
  else
    echo "Deploy package dosenot exist"
  fi
}

shutdown() {
  pids=$(ps -fu $USER | grep -v grep | grep java | grep "$1.jar" | awk '{print $2}')
  for pid in ${pids}; do
    echo PID for ${selName} is: ${pid}
    kill ${pid}
  done

  waitsecond=0
  while [ $waitsecond -lt 30 ]
  do
    threadcount=$(ps -fu $USER | grep -v grep | grep java | grep "$1.jar" | awk '{print $2}' | wc -l)
    if [ $threadcount -ne 0 ]
    then
      echo "Service is stoping, please wait ... $((waitsecond+1))s"
      sleep 1
      waitsecond=$((waitsecond+1))
    else
      echo "Service is stopped."
      waitsecond=$((waitsecond+30))
    fi
  done

  pids=$(ps -fu $USER | grep -v grep | grep java | grep "$1.jar" | awk '{print $2}')
  for pid in ${pids}; do
    echo PID for ${selName} is: ${pid}
    kill -9 ${pid}
    echo "Service is killed."
  done

  while [ $waitsecond -lt 60 ]
  do
    threadcount=$(ps -fu $USER | grep -v grep | grep java | grep "$1.jar" | awk '{print $2}' | wc -l)
    if [ $threadcount -ne 0 ]
    then
      echo "Service is killing, please wait ... $((waitsecond+1))s"
      sleep 1
      waitsecond=$((waitsecond+1))
    else
      waitsecond=$((waitsecond+30))
    fi
  done
}
if [[ -z "$selAct" ]]; then
select opt in "${options[@]}"
do
  case $REPLY in
  1)
    startup ${selName}
  ;;
  2)
    shutdown ${selName}
  ;;
  3)
    shutdown ${selName}
    startup ${selName}
  ;;
  4)
    read -p "Do you want to download the latest jar package from TeamCity? [y/n]" input
    if [[ "${input}" = "y" || "${input}" = "Y"  ]];then
      scp ${sshinfo}:${pkgroot}/${pgpkg} ${deploypath}
    elif [[ "${input}" = "n" || "${input}" = "N"  ]];then
       if [[ ! -f ${deploypath}/${selName}.jar ]];then
         echo "Deploy package dont exist in ${deploypath}"
         exit 1
       fi
    else
       echo "Error input, please input [y/n]"
    fi
    shutdown ${selName}
    echo "Backup the old package"
    [[ -f ${apppath}/${selName}.jar ]] && cp -a "${apppath}/${selName}.jar" ${bakpath}/$(date "+${selName}.jar-%Y%m%d")
    echo "Move the new package to deploy"
    mv ${deploypath}/${selName}.jar ${apppath}
    startup ${selName}
  ;;
  5)
    cp -a "${apppath}/${selName}.jar" ${bakpath}/$(date "+${selName}.jar-%Y%m%d")
  ;;
  6)
    break
  ;;
  *)
    echo "Error input, please run this shell again."
    exit 1
  ;;
  esac
break
done
else
 case $selAct in
  1)
    startup ${selName}
  ;;
  2)
    shutdown ${selName}
  ;;
  3)
    shutdown ${selName}
    startup ${selName}
  ;;
  4)
   if [[ -f "${rootDir}/deploy/${selName}.jar" ]]; then
    shutdown ${selName}
    sleep 3
    rm -rf ${apppath}/${selName}.jar
    mv ${rootDir}/deploy/${selName}.jar ${apppath}
    startup ${selName}
    echo "deploy finish"
   else
     echo "${selName} jar is not exist"
     exit 1
   fi
  ;;
  *)
    echo "Error input, please run this shell again."
    exit 1
  ;;
 esac
fi
