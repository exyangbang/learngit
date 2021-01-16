package cn.kingnet.utp.sdk.account.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/09/30
 */
public class Test {


    public static void main(String[] args) throws Exception {
//
////        String pfxPath = Paths.get(Test.class.getResource("/JFJT.pfx").toURI()).toFile().getAbsolutePath();
//        String pfxPath = Paths.get(Test.class.getResource("/test2.pfx").toURI()).toFile().getAbsolutePath();
////        String unSigned = "机会难得慷杰79371^&*!@#$*(+_)(*&‘；、。《》，。=2343242343242342342343&us》》>>》>>..{}[]   erAccount=test1584793557261";
//        String unSigned = "abc123";
//        String signed = RSAP7SignatureUtils.sign(pfxPath, "111111", unSigned);
//
//        System.out.println("unSigned = " + unSigned);
//        System.out.println("signed = " + signed);
//
//        boolean tf = RSAP7SignatureUtils.verify(signed, unSigned);
//        System.out.println("verify = " + tf);

        List<Integer> list = new ArrayList<>();

        Integer[] i = list.toArray(new Integer[0]);

        System.out.println("i = " + (i==null) +"==="+i.length);

    }


}
