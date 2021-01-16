package com.scenetec.upf.operation.repository.system;

import com.scenetec.upf.operation.model.domain.system.CardBinInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/11/08
 */
@Repository
@Mapper
public interface CardBinInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into kkpay_card_bin_info (id,createor,create_time,updateor,update_time,issuercode,issuername,cardname,cardnotrack,cardnostart_pos,cardnolen,binnum,bintrack,binstartpos,binlen,alltrack,alltrackstartpos,alltracklen,cuplogoflag,debitcreditflag,adddeletestat,clearbankno,clearbankname,status,adddata,remark1,remark2,remark3,bankcode,bankname,banktypeflag) values (#{id},#{createor},#{createTime},#{updateor},#{updateTime},#{issuercode},#{issuername},#{cardname},#{cardnotrack},#{cardnostartPos},#{cardnolen},#{binnum},#{bintrack},#{binstartpos},#{binlen},#{alltrack},#{alltrackstartpos},#{alltracklen},#{cuplogoflag},#{debitcreditflag},#{adddeletestat},#{clearbankno},#{clearbankname},#{status},#{adddata},#{remark1},#{remark2},#{remark3},#{bankcode},#{bankname},#{banktypeflag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(CardBinInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into kkpay_card_bin_info ("
        +" createor,create_time,updateor,update_time, issuercode, issuername, cardname, cardnotrack, cardnostart_pos, cardnolen, binnum, bintrack, binstartpos, binlen, alltrack, alltrackstartpos, alltracklen, cuplogoflag, debitcreditflag, adddeletestat, clearbankno, clearbankname, status, adddata, remark1, remark2, remark3, bankcode, bankname, banktypeflag"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.createor}, #{item.createTime}, #{item.updateor}, #{item.updateTime}, #{item.issuercode}, #{item.issuername}, #{item.cardname}, #{item.cardnotrack}, #{item.cardnostartPos}, #{item.cardnolen}, #{item.binnum}, #{item.bintrack}, #{item.binstartpos}, #{item.binlen}, #{item.alltrack}, #{item.alltrackstartpos}, #{item.alltracklen}, #{item.cuplogoflag}, #{item.debitcreditflag}, #{item.adddeletestat}, #{item.clearbankno}, #{item.clearbankname}, #{item.status}, #{item.adddata}, #{item.remark1}, #{item.remark2}, #{item.remark3}, #{item.bankcode}, #{item.bankname}, #{item.banktypeflag})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<CardBinInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into kkpay_card_bin_info ("
        +" createor,create_time,updateor,update_time, issuercode, issuername, cardname, cardnotrack, cardnostart_pos, cardnolen, binnum, bintrack, binstartpos, binlen, alltrack, alltrackstartpos, alltracklen, cuplogoflag, debitcreditflag, adddeletestat, clearbankno, clearbankname, status, adddata, remark1, remark2, remark3, bankcode, bankname, banktypeflag"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.createor}, #{item.createTime}, #{item.updateor}, #{item.updateTime}, #{item.issuercode}, #{item.issuername}, #{item.cardname}, #{item.cardnotrack}, #{item.cardnostartPos}, #{item.cardnolen}, #{item.binnum}, #{item.bintrack}, #{item.binstartpos}, #{item.binlen}, #{item.alltrack}, #{item.alltrackstartpos}, #{item.alltracklen}, #{item.cuplogoflag}, #{item.debitcreditflag}, #{item.adddeletestat}, #{item.clearbankno}, #{item.clearbankname}, #{item.status}, #{item.adddata}, #{item.remark1}, #{item.remark2}, #{item.remark3}, #{item.bankcode}, #{item.bankname}, #{item.banktypeflag})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"createor = VALUES(createor),"
            +"create_time = VALUES(create_time),"
            +"updateor = VALUES(updateor),"
            +"update_time = VALUES(update_time),"
            +"issuercode = VALUES(issuercode),"
            +"issuername = VALUES(issuername),"
            +"cardname = VALUES(cardname),"
            +"cardnotrack = VALUES(cardnotrack),"
            +"cardnostart_pos = VALUES(cardnostart_pos),"
            +"cardnolen = VALUES(cardnolen),"
            +"binnum = VALUES(binnum),"
            +"bintrack = VALUES(bintrack),"
            +"binstartpos = VALUES(binstartpos),"
            +"binlen = VALUES(binlen),"
            +"alltrack = VALUES(alltrack),"
            +"alltrackstartpos = VALUES(alltrackstartpos),"
            +"alltracklen = VALUES(alltracklen),"
            +"cuplogoflag = VALUES(cuplogoflag),"
            +"debitcreditflag = VALUES(debitcreditflag),"
            +"adddeletestat = VALUES(adddeletestat),"
            +"clearbankno = VALUES(clearbankno),"
            +"clearbankname = VALUES(clearbankname),"
            +"status = VALUES(status),"
            +"adddata = VALUES(adddata),"
            +"remark1 = VALUES(remark1),"
            +"remark2 = VALUES(remark2),"
            +"remark3 = VALUES(remark3),"
            +"bankcode = VALUES(bankcode),"
            +"bankname = VALUES(bankname),"
            +"banktypeflag = VALUES(banktypeflag)"
        +"</script>"
    )
    int modifyList(List<CardBinInfoDO> obj);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from kkpay_card_bin_info where id = #{id}")
    int delete(Long id);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @Delete("update kkpay_card_bin_info set status=0 where id = #{id}")
    int deleteLogic(Long id);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update kkpay_card_bin_info <set> "
            +"<if test='createor != null'> createor = #{createor}, </if> "
            +"<if test='createTime != null'> create_time = #{createTime}, </if> "
            +"<if test='updateor != null'> updateor = #{updateor}, </if> "
            +"<if test='updateTime != null'> update_time = #{updateTime}, </if> "
            +"<if test='issuercode != null'> issuercode = #{issuercode}, </if> "
            +"<if test='issuername != null'> issuername = #{issuername}, </if> "
            +"<if test='cardname != null'> cardname = #{cardname}, </if> "
            +"<if test='cardnotrack != null'> cardnotrack = #{cardnotrack}, </if> "
            +"<if test='cardnostartPos != null'> cardnostart_pos = #{cardnostartPos}, </if> "
            +"<if test='cardnolen != null'> cardnolen = #{cardnolen}, </if> "
            +"<if test='binnum != null'> binnum = #{binnum}, </if> "
            +"<if test='bintrack != null'> bintrack = #{bintrack}, </if> "
            +"<if test='binstartpos != null'> binstartpos = #{binstartpos}, </if> "
            +"<if test='binlen != null'> binlen = #{binlen}, </if> "
            +"<if test='alltrack != null'> alltrack = #{alltrack}, </if> "
            +"<if test='alltrackstartpos != null'> alltrackstartpos = #{alltrackstartpos}, </if> "
            +"<if test='alltracklen != null'> alltracklen = #{alltracklen}, </if> "
            +"<if test='cuplogoflag != null'> cuplogoflag = #{cuplogoflag}, </if> "
            +"<if test='debitcreditflag != null'> debitcreditflag = #{debitcreditflag}, </if> "
            +"<if test='adddeletestat != null'> adddeletestat = #{adddeletestat}, </if> "
            +"<if test='clearbankno != null'> clearbankno = #{clearbankno}, </if> "
            +"<if test='clearbankname != null'> clearbankname = #{clearbankname}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='adddata != null'> adddata = #{adddata}, </if> "
            +"<if test='remark1 != null'> remark1 = #{remark1}, </if> "
            +"<if test='remark2 != null'> remark2 = #{remark2}, </if> "
            +"<if test='remark3 != null'> remark3 = #{remark3}, </if> "
            +"<if test='bankcode != null'> bankcode = #{bankcode}, </if> "
            +"<if test='bankname != null'> bankname = #{bankname}, </if> "
            +"<if test='banktypeflag != null'> banktypeflag = #{banktypeflag}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(CardBinInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, createor,create_time,updateor,update_time,issuercode,issuername,cardname,cardnotrack,cardnostart_pos,cardnolen,binnum,bintrack,binstartpos,binlen,alltrack,alltrackstartpos,alltracklen,cuplogoflag,debitcreditflag,adddeletestat,clearbankno,clearbankname,status,adddata,remark1,remark2,remark3,bankcode,bankname,banktypeflag from kkpay_card_bin_info where id = #{id}")
 	@Results(id="CardBinInfoResultMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "createor", column = "createor" )
        ,        @Result(property = "createTime", column = "create_time" )
        ,        @Result(property = "updateor", column = "updateor" )
        ,        @Result(property = "updateTime", column = "update_time" )
        ,        @Result(property = "issuercode", column = "issuercode" )
        ,        @Result(property = "issuername", column = "issuername" )
        ,        @Result(property = "cardname", column = "cardname" )
        ,        @Result(property = "cardnotrack", column = "cardnotrack" )
        ,        @Result(property = "cardnostartPos", column = "cardnostart_pos" )
        ,        @Result(property = "cardnolen", column = "cardnolen" )
        ,        @Result(property = "binnum", column = "binnum" )
        ,        @Result(property = "bintrack", column = "bintrack" )
        ,        @Result(property = "binstartpos", column = "binstartpos" )
        ,        @Result(property = "binlen", column = "binlen" )
        ,        @Result(property = "alltrack", column = "alltrack" )
        ,        @Result(property = "alltrackstartpos", column = "alltrackstartpos" )
        ,        @Result(property = "alltracklen", column = "alltracklen" )
        ,        @Result(property = "cuplogoflag", column = "cuplogoflag" )
        ,        @Result(property = "debitcreditflag", column = "debitcreditflag" )
        ,        @Result(property = "adddeletestat", column = "adddeletestat" )
        ,        @Result(property = "clearbankno", column = "clearbankno" )
        ,        @Result(property = "clearbankname", column = "clearbankname" )
        ,        @Result(property = "status", column = "status" )
        ,        @Result(property = "adddata", column = "adddata" )
        ,        @Result(property = "remark1", column = "remark1" )
        ,        @Result(property = "remark2", column = "remark2" )
        ,        @Result(property = "remark3", column = "remark3" )
        ,        @Result(property = "bankcode", column = "bankcode" )
        ,        @Result(property = "bankname", column = "bankname" )
        ,        @Result(property = "banktypeflag", column = "banktypeflag" )
        }
    )
 	CardBinInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, createor,create_time,updateor,update_time,issuercode,issuername,cardname,cardnotrack,cardnostart_pos,cardnolen,binnum,bintrack,binstartpos,binlen,alltrack,alltrackstartpos,alltracklen,cuplogoflag,debitcreditflag,adddeletestat,clearbankno,clearbankname,status,adddata,remark1,remark2,remark3,bankcode,bankname,banktypeflag from kkpay_card_bin_info where 1 = 1"
		        + "<if test='params.cardname != null'> and cardname like concat('%',#{params.cardname},'%')</if>"
		        + "<if test='params.binnum != null'> and binnum = #{params.binnum}</if>"
		        + "<if test='params.debitcreditflag != null'> and debitcreditflag = #{params.debitcreditflag}</if>"
		        + "<if test='params.issuercode != null'> and issuercode like concat('%',#{params.issuercode},'%')</if>"
		        + "<if test='params.issuername != null'> and issuername like concat('%',#{params.issuername},'%')</if>"
                +"order by update_time desc ,create_time desc"
        + "</script>"
    )
    @ResultMap("CardBinInfoResultMap")
    Page<CardBinInfoDO> pageList(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(不分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
            + "select id, createor,create_time,updateor,update_time,issuercode,issuername,cardname,cardnotrack,cardnostart_pos,cardnolen,binnum,bintrack,binstartpos,binlen,alltrack,alltrackstartpos,alltracklen,cuplogoflag,debitcreditflag,adddeletestat,clearbankno,clearbankname,status,adddata,remark1,remark2,remark3,bankcode,bankname,banktypeflag from kkpay_card_bin_info where 1 = 1"
                + "<if test='params.cardname != null'> and cardname like concat('%',#{params.cardname},'%')</if>"
                + "<if test='params.binnum != null'> and binnum = #{params.binnum}</if>"
                + "<if test='params.debitcreditflag != null'> and debitcreditflag = #{params.debitcreditflag}</if>"
                + "<if test='params.issuercode != null'> and issuercode like concat('%',#{params.issuercode},'%')</if>"
                + "<if test='params.issuername != null'> and issuername like concat('%',#{params.issuername},'%')</if>"
        + "</script>"
    )
    @ResultMap("CardBinInfoResultMap")
    List<CardBinInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from kkpay_card_bin_info <where> <trim suffixOverrides='AND'>"
            +"<if test='createor != null'> createor = #{createor} AND </if> "
            +"<if test='createTime != null'> create_time = #{createTime} AND </if> "
            +"<if test='updateor != null'> updateor = #{updateor} AND </if> "
            +"<if test='updateTime != null'> update_time = #{updateTime} AND </if> "
            +"<if test='issuercode != null'> issuercode = #{issuercode} AND </if> "
            +"<if test='issuername != null'> issuername = #{issuername} AND </if> "
            +"<if test='cardname != null'> cardname = #{cardname} AND </if> "
            +"<if test='cardnotrack != null'> cardnotrack = #{cardnotrack} AND </if> "
            +"<if test='cardnostartPos != null'> cardnostart_pos = #{cardnostartPos} AND </if> "
            +"<if test='cardnolen != null'> cardnolen = #{cardnolen} AND </if> "
            +"<if test='binnum != null'> binnum = #{binnum} AND </if> "
            +"<if test='bintrack != null'> bintrack = #{bintrack} AND </if> "
            +"<if test='binstartpos != null'> binstartpos = #{binstartpos} AND </if> "
            +"<if test='binlen != null'> binlen = #{binlen} AND </if> "
            +"<if test='alltrack != null'> alltrack = #{alltrack} AND </if> "
            +"<if test='alltrackstartpos != null'> alltrackstartpos = #{alltrackstartpos} AND </if> "
            +"<if test='alltracklen != null'> alltracklen = #{alltracklen} AND </if> "
            +"<if test='cuplogoflag != null'> cuplogoflag = #{cuplogoflag} AND </if> "
            +"<if test='debitcreditflag != null'> debitcreditflag = #{debitcreditflag} AND </if> "
            +"<if test='adddeletestat != null'> adddeletestat = #{adddeletestat} AND </if> "
            +"<if test='clearbankno != null'> clearbankno = #{clearbankno} AND </if> "
            +"<if test='clearbankname != null'> clearbankname = #{clearbankname} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='adddata != null'> adddata = #{adddata} AND </if> "
            +"<if test='remark1 != null'> remark1 = #{remark1} AND </if> "
            +"<if test='remark2 != null'> remark2 = #{remark2} AND </if> "
            +"<if test='remark3 != null'> remark3 = #{remark3} AND </if> "
            +"<if test='bankcode != null'> bankcode = #{bankcode} AND </if> "
            +"<if test='bankname != null'> bankname = #{bankname} AND </if> "
            +"<if test='banktypeflag != null'> banktypeflag = #{banktypeflag} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(CardBinInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, createor,create_time,updateor,update_time,issuercode,issuername,cardname,cardnotrack,cardnostart_pos,cardnolen,binnum,bintrack,binstartpos,binlen,alltrack,alltrackstartpos,alltracklen,cuplogoflag,debitcreditflag,adddeletestat,clearbankno,clearbankname,status,adddata,remark1,remark2,remark3,bankcode,bankname,banktypeflag from kkpay_card_bin_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='createor != null'> createor = #{createor} AND </if> "
            +"<if test='createTime != null'> create_time = #{createTime} AND </if> "
            +"<if test='updateor != null'> updateor = #{updateor} AND </if> "
            +"<if test='updateTime != null'> update_time = #{updateTime} AND </if> "
            +"<if test='issuercode != null'> issuercode = #{issuercode} AND </if> "
            +"<if test='issuername != null'> issuername = #{issuername} AND </if> "
            +"<if test='cardname != null'> cardname = #{cardname} AND </if> "
            +"<if test='cardnotrack != null'> cardnotrack = #{cardnotrack} AND </if> "
            +"<if test='cardnostartPos != null'> cardnostart_pos = #{cardnostartPos} AND </if> "
            +"<if test='cardnolen != null'> cardnolen = #{cardnolen} AND </if> "
            +"<if test='binnum != null'> binnum = #{binnum} AND </if> "
            +"<if test='bintrack != null'> bintrack = #{bintrack} AND </if> "
            +"<if test='binstartpos != null'> binstartpos = #{binstartpos} AND </if> "
            +"<if test='binlen != null'> binlen = #{binlen} AND </if> "
            +"<if test='alltrack != null'> alltrack = #{alltrack} AND </if> "
            +"<if test='alltrackstartpos != null'> alltrackstartpos = #{alltrackstartpos} AND </if> "
            +"<if test='alltracklen != null'> alltracklen = #{alltracklen} AND </if> "
            +"<if test='cuplogoflag != null'> cuplogoflag = #{cuplogoflag} AND </if> "
            +"<if test='debitcreditflag != null'> debitcreditflag = #{debitcreditflag} AND </if> "
            +"<if test='adddeletestat != null'> adddeletestat = #{adddeletestat} AND </if> "
            +"<if test='clearbankno != null'> clearbankno = #{clearbankno} AND </if> "
            +"<if test='clearbankname != null'> clearbankname = #{clearbankname} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='adddata != null'> adddata = #{adddata} AND </if> "
            +"<if test='remark1 != null'> remark1 = #{remark1} AND </if> "
            +"<if test='remark2 != null'> remark2 = #{remark2} AND </if> "
            +"<if test='remark3 != null'> remark3 = #{remark3} AND </if> "
            +"<if test='bankcode != null'> bankcode = #{bankcode} AND </if> "
            +"<if test='bankname != null'> bankname = #{bankname} AND </if> "
            +"<if test='banktypeflag != null'> banktypeflag = #{banktypeflag} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CardBinInfoResultMap")
    CardBinInfoDO selectOne(CardBinInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, createor,create_time,updateor,update_time,issuercode,issuername,cardname,cardnotrack,cardnostart_pos,cardnolen,binnum,bintrack,binstartpos,binlen,alltrack,alltrackstartpos,alltracklen,cuplogoflag,debitcreditflag,adddeletestat,clearbankno,clearbankname,status,adddata,remark1,remark2,remark3,bankcode,bankname,banktypeflag from kkpay_card_bin_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='createor != null'> createor = #{createor} AND </if> "
            +"<if test='createTime != null'> create_time = #{createTime} AND </if> "
            +"<if test='updateor != null'> updateor = #{updateor} AND </if> "
            +"<if test='updateTime != null'> update_time = #{updateTime} AND </if> "
            +"<if test='issuercode != null'> issuercode = #{issuercode} AND </if> "
            +"<if test='issuername != null'> issuername = #{issuername} AND </if> "
            +"<if test='cardname != null'> cardname = #{cardname} AND </if> "
            +"<if test='cardnotrack != null'> cardnotrack = #{cardnotrack} AND </if> "
            +"<if test='cardnostartPos != null'> cardnostart_pos = #{cardnostartPos} AND </if> "
            +"<if test='cardnolen != null'> cardnolen = #{cardnolen} AND </if> "
            +"<if test='binnum != null'> binnum = #{binnum} AND </if> "
            +"<if test='bintrack != null'> bintrack = #{bintrack} AND </if> "
            +"<if test='binstartpos != null'> binstartpos = #{binstartpos} AND </if> "
            +"<if test='binlen != null'> binlen = #{binlen} AND </if> "
            +"<if test='alltrack != null'> alltrack = #{alltrack} AND </if> "
            +"<if test='alltrackstartpos != null'> alltrackstartpos = #{alltrackstartpos} AND </if> "
            +"<if test='alltracklen != null'> alltracklen = #{alltracklen} AND </if> "
            +"<if test='cuplogoflag != null'> cuplogoflag = #{cuplogoflag} AND </if> "
            +"<if test='debitcreditflag != null'> debitcreditflag = #{debitcreditflag} AND </if> "
            +"<if test='adddeletestat != null'> adddeletestat = #{adddeletestat} AND </if> "
            +"<if test='clearbankno != null'> clearbankno = #{clearbankno} AND </if> "
            +"<if test='clearbankname != null'> clearbankname = #{clearbankname} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='adddata != null'> adddata = #{adddata} AND </if> "
            +"<if test='remark1 != null'> remark1 = #{remark1} AND </if> "
            +"<if test='remark2 != null'> remark2 = #{remark2} AND </if> "
            +"<if test='remark3 != null'> remark3 = #{remark3} AND </if> "
            +"<if test='bankcode != null'> bankcode = #{bankcode} AND </if> "
            +"<if test='bankname != null'> bankname = #{bankname} AND </if> "
            +"<if test='banktypeflag != null'> banktypeflag = #{banktypeflag} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CardBinInfoResultMap")
    List<CardBinInfoDO> selectList(CardBinInfoDO obj);


    @Update("${sql}")
    void runSql(@Param("sql") String sql);

}

