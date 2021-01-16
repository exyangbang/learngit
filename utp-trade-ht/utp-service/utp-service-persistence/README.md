### 根据运行环境打包命令
#### 开发环境
```
clean install -P dev
```
注：在开发时通过 ide工具运行工程不需要打包。直接运行就行，`dev`为默认策略。在开发阶段一些工程的配置放在此工程策略下，方便开发、维护和查询。配置方式如下：   
> 在配置文件中按如下设置可以使用不同的策略独立配置。注：此配置放到`application.yml`文件中进行配置。禁止放在`bootstrap.yml`进行配置
```、yaml

---
spring:
  profiles: dev
......
省略号下面就是开发阶段的独立配置

```
#### 测试环境
```
clean install -P test
```
#### 生产环境
```
clean install -P prd
```

### 单独工程打包
#### 只打包此工程
> 将执行打包命令时的目录切换至项目下`utp-trade-ht`，执行以下命令。如要分环境打包再加上`-P 环境名称`
````
clean package -pl ./utp-service/utp-service-persistence -am -Dmaven.test.skip=true
````