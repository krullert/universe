package io.onsense.universe;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Koen Rooijmans
 */
public class CodeTest {

    @Test
    public void code_isean8() {
        Assert.assertTrue(Code.code_isean8("48512343").booleanValue());
        Assert.assertTrue(Code.code_isean8("12345670").booleanValue());
        Assert.assertTrue(Code.code_isean8("12345670").booleanValue());
        Assert.assertTrue(Code.code_isean8("67678983").booleanValue());
        Assert.assertTrue(Code.code_isean8("80674313").booleanValue());
        Assert.assertTrue(Code.code_isean8("59001270").booleanValue());
        Assert.assertTrue(Code.code_isean8("50487066").booleanValue());
        Assert.assertTrue(Code.code_isean8("55123457").booleanValue());
        Assert.assertTrue(Code.code_isean8("96385074").booleanValue());
        Assert.assertTrue(Code.code_isean8("11111115").booleanValue());
        Assert.assertFalse(Code.code_isean8("96385abc").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111111").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111112").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111113").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111114").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111116").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111117").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111118").booleanValue());
        Assert.assertFalse(Code.code_isean8("11111119").booleanValue());
        Assert.assertFalse(Code.code_isean8("9031101").booleanValue());
        Assert.assertFalse(Code.code_isean8("9638507").booleanValue());
    }

    @Test
    public void code_isean13() {
        Assert.assertTrue(Code.code_isean13("8413000065504").booleanValue());
        Assert.assertTrue(Code.code_isean13("8480010001136").booleanValue());
        Assert.assertTrue(Code.code_isean13("5201815331227").booleanValue());
        Assert.assertTrue(Code.code_isean13("8413600298517").booleanValue());
        Assert.assertTrue(Code.code_isean13("3560070169443").booleanValue());
        Assert.assertTrue(Code.code_isean13("4045787034318").booleanValue());
        Assert.assertTrue(Code.code_isean13("3086126100326").booleanValue());
        Assert.assertTrue(Code.code_isean13("4820024790635").booleanValue());
        Assert.assertTrue(Code.code_isean13("8480010092271").booleanValue());
        Assert.assertTrue(Code.code_isean13("4000539017100").booleanValue());
        Assert.assertTrue(Code.code_isean13("7622200008018").booleanValue());
        Assert.assertTrue(Code.code_isean13("5603667020517").booleanValue());
        Assert.assertTrue(Code.code_isean13("7622400791949").booleanValue());
        Assert.assertTrue(Code.code_isean13("5709262942503").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780140013993").booleanValue());
        Assert.assertTrue(Code.code_isean13("4901780188352").booleanValue());
        Assert.assertTrue(Code.code_isean13("9771699057002").booleanValue());
        Assert.assertTrue(Code.code_isean13("4007817327098").booleanValue());
        Assert.assertTrue(Code.code_isean13("8480000823274").booleanValue());
        Assert.assertTrue(Code.code_isean13("5025121072311").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780393058673").booleanValue());
        Assert.assertTrue(Code.code_isean13("9781558604971").booleanValue());
        Assert.assertTrue(Code.code_isean13("5030159003930").booleanValue());
        Assert.assertTrue(Code.code_isean13("5000213101025").booleanValue());
        Assert.assertTrue(Code.code_isean13("5000213002834").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780201752847").booleanValue());
        Assert.assertTrue(Code.code_isean13("5449000039231").booleanValue());
        Assert.assertTrue(Code.code_isean13("8410054010412").booleanValue());
        Assert.assertTrue(Code.code_isean13("8480010045062").booleanValue());
        Assert.assertTrue(Code.code_isean13("9788430532674").booleanValue());
        Assert.assertTrue(Code.code_isean13("8480017507990").booleanValue());
        Assert.assertTrue(Code.code_isean13("3166298099809").booleanValue());
        Assert.assertTrue(Code.code_isean13("1920081045006").booleanValue());
        Assert.assertTrue(Code.code_isean13("9784872348880").booleanValue());
        Assert.assertTrue(Code.code_isean13("1920081045006").booleanValue());
        Assert.assertTrue(Code.code_isean13("9784872348880").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780345348036").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780804816632").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780764544200").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780441014989").booleanValue());
        Assert.assertTrue(Code.code_isean13("9780679601050").booleanValue());
        Assert.assertFalse(Code.code_isean13("5901234123abc").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111111").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111112").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111113").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111114").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111115").booleanValue());
        Assert.assertTrue(Code.code_isean13("1111111111116").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111117").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111118").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111119").booleanValue());
        Assert.assertFalse(Code.code_isean13("1111111111116a").booleanValue());
        Assert.assertFalse(Code.code_isean13("111111111111a").booleanValue());
        Assert.assertFalse(Code.code_isean13("a111111111116").booleanValue());
    }

    @Test
    public void code_isupca() {
        Assert.assertTrue(Code.code_isupca("036602301467").booleanValue());
        Assert.assertTrue(Code.code_isupca("027011006951").booleanValue());
        Assert.assertTrue(Code.code_isupca("781735802045").booleanValue());
        Assert.assertTrue(Code.code_isupca("456314319671").booleanValue());
        Assert.assertTrue(Code.code_isupca("434704791429").booleanValue());
        Assert.assertTrue(Code.code_isupca("024543136538").booleanValue());
        Assert.assertTrue(Code.code_isupca("036602301467").booleanValue());
        Assert.assertTrue(Code.code_isupca("752919460009").booleanValue());
        Assert.assertTrue(Code.code_isupca("606949762520").booleanValue());
        Assert.assertTrue(Code.code_isupca("061869053712").booleanValue());
        Assert.assertTrue(Code.code_isupca("619659023935").booleanValue());
        Assert.assertTrue(Code.code_isupca("070097025088").booleanValue());
        Assert.assertTrue(Code.code_isupca("045496442736").booleanValue());
        Assert.assertTrue(Code.code_isupca("070097025088").booleanValue());
        Assert.assertTrue(Code.code_isupca("071831007995").booleanValue());
        Assert.assertTrue(Code.code_isupca("890444000335").booleanValue());
        Assert.assertTrue(Code.code_isupca("049000042566").booleanValue());
        Assert.assertTrue(Code.code_isupca("023942431015").booleanValue());
        Assert.assertTrue(Code.code_isupca("066721010995").booleanValue());
        Assert.assertTrue(Code.code_isupca("059290522143").booleanValue());
        Assert.assertTrue(Code.code_isupca("057961000228").booleanValue());
        Assert.assertTrue(Code.code_isupca("059290571110").booleanValue());
        Assert.assertTrue(Code.code_isupca("067932000263").booleanValue());
        Assert.assertTrue(Code.code_isupca("069000061015").booleanValue());
        Assert.assertTrue(Code.code_isupca("071691155775").booleanValue());
        Assert.assertTrue(Code.code_isupca("807648011401").booleanValue());
        Assert.assertTrue(Code.code_isupca("023942431015").booleanValue());
        Assert.assertTrue(Code.code_isupca("060410049235").booleanValue());
        Assert.assertTrue(Code.code_isupca("312547701310").booleanValue());
        Assert.assertTrue(Code.code_isupca("625034201058").booleanValue());
        Assert.assertTrue(Code.code_isupca("071831007995").booleanValue());
        Assert.assertTrue(Code.code_isupca("605482330012").booleanValue());
        Assert.assertTrue(Code.code_isupca("073333531084").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111111").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111112").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111113").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111114").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111115").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111116").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111118").booleanValue());
        Assert.assertFalse(Code.code_isupca("111111111119").booleanValue());
        Assert.assertTrue(Code.code_isupca("111111111117").booleanValue());
        Assert.assertFalse(Code.code_isupca("11111111111a").booleanValue());
        Assert.assertFalse(Code.code_isupca("a11111111117").booleanValue());
        Assert.assertFalse(Code.code_isupca("11").booleanValue());
        Assert.assertFalse(Code.code_isupca("1111111111171").booleanValue());
        Assert.assertFalse(Code.code_isupca("abcdefghijklm").booleanValue());
    }

    @Test
    public void code_isupce() {
        Assert.assertTrue(Code.code_isupce("01234565").booleanValue());
        Assert.assertTrue(Code.code_isupce("00123457").booleanValue());
        Assert.assertTrue(Code.code_isupce("05096893").booleanValue());
        Assert.assertTrue(Code.code_isupce("04124498").booleanValue());
        Assert.assertFalse(Code.code_isupce("05096abc").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111111").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111112").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111113").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111114").booleanValue());
        Assert.assertTrue(Code.code_isupce("11111115").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111116").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111117").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111118").booleanValue());
        Assert.assertFalse(Code.code_isupce("11111119").booleanValue());
        Assert.assertFalse(Code.code_isupce("012345").booleanValue());
        Assert.assertFalse(Code.code_isupce("0123456").booleanValue());
        // TODO
//        Assert.assertTrue(Code.code_isupce("01234565").booleanValue());
//        Assert.assertTrue(Code.code_isupce("04965802").booleanValue());
//        Assert.assertTrue(Code.code_isupce("04963406").booleanValue());
//        Assert.assertTrue(Code.code_isupce("01234531").booleanValue());
//        Assert.assertTrue(Code.code_isupce("01264904").booleanValue());
    }

//    @Test
//    public void isCode39() {
//        Assert.assertTrue(Code.isCode39("TEST-SHEET").booleanValue());
//        Assert.assertTrue(Code.isCode39(" WWW.GOOGLE.COM ").booleanValue());
//        Assert.assertTrue(Code.isCode39("MOROVIA").booleanValue());
//        Assert.assertTrue(Code.isCode39("ABC123").booleanValue());
//        Assert.assertTrue(Code.isCode39("Extended !?*#").booleanValue());
//        Assert.assertTrue(Code.isCode39("12ab").booleanValue());
//        Assert.assertTrue(Code.isCode39("165627").booleanValue());
//        Assert.assertTrue(Code.isCode39("001EC947D49B").booleanValue());
//        Assert.assertTrue(Code.isCode39("165340").booleanValue());
//        Assert.assertTrue(Code.isCode39("001EC94767E0").booleanValue());
//        Assert.assertTrue(Code.isCode39("404785").booleanValue());
//        Assert.assertTrue(Code.isCode39("`abcdefghijklmnopqrstuvwxyz{|}~\u007F").booleanValue());
//        Assert.assertTrue(Code.isCode39("@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_").booleanValue());
//        Assert.assertTrue(Code.isCode39(" !\\\"#$%&'()*+,-./0123456789:;<=>?").booleanValue());
//        Assert.assertTrue(Code.isCode39("\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f").booleanValue());
//    }
//
//    @Test
//    public void isCode93() {
//        Assert.assertTrue(Code.isCode93("1234567890").booleanValue());
//        Assert.assertTrue(Code.isCode93("CODE 93").booleanValue());
//        Assert.assertTrue(Code.isCode93("DATA").booleanValue());
//        Assert.assertTrue(Code.isCode93("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").booleanValue());
//    }
//
//    @Test
//    public void isCode128() {
//        Assert.assertTrue(Code.isCode128("168901").booleanValue());
//        Assert.assertTrue(Code.isCode128("Code 128").booleanValue());
//        Assert.assertTrue(Code.isCode128("102030405060708090").booleanValue());
//        Assert.assertTrue(Code.isCode128("123456").booleanValue());
//        Assert.assertTrue(Code.isCode128("8101054321120021123456").booleanValue());
//        Assert.assertTrue(Code.isCode128("óóóó1234óóabózz").booleanValue());
//        Assert.assertTrue(Code.isCode128("005-3379497200006").booleanValue());
//        Assert.assertTrue(Code.isCode128("15182881").booleanValue());
//        Assert.assertTrue(Code.isCode128("CNK8181G2C").booleanValue());
//        Assert.assertTrue(Code.isCode128("1PEF224A4").booleanValue());
//        Assert.assertTrue(Code.isCode128("FW727").booleanValue());
//        Assert.assertTrue(Code.isCode128("31001171800000017989625355702636").booleanValue());
//        Assert.assertTrue(Code.isCode128("42094043").booleanValue());
//        Assert.assertTrue(Code.isCode128("30885909173823").booleanValue());
//        Assert.assertTrue(Code.isCode128("FGGQ6D1").booleanValue());
//        Assert.assertTrue(Code.isCode128("10064908").booleanValue());
//        Assert.assertTrue(Code.isCode128("10068408").booleanValue());
//        Assert.assertTrue(Code.isCode128("\u00f3" + "123").booleanValue());
//        Assert.assertTrue(Code.isCode128("\u00f2" + "123").booleanValue());
//        Assert.assertTrue(Code.isCode128("\u00f1" + "10958" + "\u00f1" + "17160526").booleanValue());
//
//    }
//
//    @Test
//    public void isCodabar() {
//        Assert.assertTrue(Code.isCodabar("1234567890").booleanValue());
//        Assert.assertTrue(Code.isCodabar("294/586").booleanValue());
//        Assert.assertTrue(Code.isCodabar("123455").booleanValue());
//        Assert.assertTrue(Code.isCodabar("12345").booleanValue());
//        Assert.assertTrue(Code.isCodabar("123456").booleanValue());
//        Assert.assertTrue(Code.isCodabar("3419500").booleanValue());
//        Assert.assertTrue(Code.isCodabar("31117013206375").booleanValue());
//        Assert.assertTrue(Code.isCodabar("123456789012").booleanValue());
//        Assert.assertTrue(Code.isCodabar("T123T").booleanValue());
//        Assert.assertTrue(Code.isCodabar("B515-3/B").booleanValue());
//    }
//
//    @Test
//    public void isITF() {
//        Assert.assertTrue(Code.isITF("30712345000010").booleanValue());
//        Assert.assertTrue(Code.isITF("0053611912").booleanValue());
//        Assert.assertTrue(Code.isITF("0829220875").booleanValue());
//        Assert.assertTrue(Code.isITF("0829220874").booleanValue());
//        Assert.assertTrue(Code.isITF("3018108390").booleanValue());
//        Assert.assertTrue(Code.isITF("00012345678905").booleanValue());
//        Assert.assertTrue(Code.isITF("0053611912").booleanValue());
//        Assert.assertTrue(Code.isITF("0829220875").booleanValue());
//        Assert.assertTrue(Code.isITF("0829220874").booleanValue());
//        Assert.assertTrue(Code.isITF("0817605453").booleanValue());
//        Assert.assertTrue(Code.isITF("0829220874").booleanValue());
//        Assert.assertTrue(Code.isITF("0053611912").booleanValue());
//        Assert.assertTrue(Code.isITF("070429").booleanValue());
//        Assert.assertTrue(Code.isITF("070429").booleanValue());
//        Assert.assertFalse(Code.isITF("00123456789abc").booleanValue());
//        Assert.assertTrue(Code.isITF("00123456789012").booleanValue());
//    }
//
//    @Test
//    public void isRSS14() {
//        Assert.assertTrue(Code.isRSS14("04412345678909").booleanValue());
//        Assert.assertTrue(Code.isRSS14("00821935106427").booleanValue());
//        Assert.assertTrue(Code.isRSS14("00075678164125").booleanValue());
//        Assert.assertTrue(Code.isRSS14("20012345678909").booleanValue());
//        Assert.assertTrue(Code.isRSS14("00034567890125").booleanValue());
//        Assert.assertTrue(Code.isRSS14("00012345678905").booleanValue());
//        Assert.assertTrue(Code.isRSS14("02001234567893").booleanValue());
//        Assert.assertTrue(Code.isRSS14("04412345678909").booleanValue());
//        Assert.assertTrue(Code.isRSS14("00012345678905").booleanValue());
//        Assert.assertTrue(Code.isRSS14("04412345678909").booleanValue());
//        Assert.assertTrue(Code.isRSS14("02001234567893").booleanValue());
//        // TODO
//    }
//
//    @Test
//    public void isRSSExpanded() {
//        Assert.assertTrue(Code.isRSSExpanded("(11)100224(17)110224(3102)000100").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)98898765432106(15)991231(3103)001750(10)12A(422)123(21)123456(423)012345678901").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)98898765432106(15)991231(3103)001750(10)12A(422)123(21)123456").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)98898765432106(3103)001750").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3922)795").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3932)0401234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3102)001750(11)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3202)001750(11)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3102)001750(13)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3102)001750(15)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3103)001750").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3202)001750(15)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3102)001750(17)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)56789(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)567890(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)5678(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098-1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098/1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098.1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)12A").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098*1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098,1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(15)991231(3103)001750(10)12A(422)123(21)123456(423)0123456789012").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)98898765432106(3202)012345(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90614141000015(3202)000150").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)567(01)90012345678908(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)567(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)567(11)010101(13)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)567(3102)123456").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)98898765432106(3103)001750").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3922)795").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3202)001750(11)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3102)001750(13)100312").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)98898765432106(3202)012345(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90614141000015(3202)000150").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3103)012233(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3203)010000").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098 1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A1").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A123").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A1234A").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A123456").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A12345678").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)123456A1234A(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1ABCDEF;:/1234567").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3203)032767").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1ABCDEF;:/ABCDEFG").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1;:/ABCDEFGHIJKLM").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1;:/0123456789012").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1;:/0123").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1;:/0123(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3922)795").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3922)795888888888888888888888888888888888888888888888888888").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3932)0401234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)12345678901231(10)UNIVERSITY-OF-DEUSTO").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)12345678901231(10)PIRAMIDE-PROJECT").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)12345678901231(10)TREELOGIC").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)5678(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)91234567980129(3103)012233(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)5678(11)001010").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)567(11)010101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098-1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098,1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098/1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098.1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098*1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098a1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098!1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)91234567980129(3102)012233(15)991231").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098\"1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098%1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098&1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098'1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098+1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098:1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098;1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098<1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098=1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098>1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)91234567980129(3102)012233(15)000101").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098?1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098_1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1098 1234").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(10)1ABCDEF;:/1234567").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3932)040EUR").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3932)04055GBP").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)90012345678908(3932)04066USD778899").booleanValue());
//        Assert.assertTrue(Code.isRSSExpanded("(01)00012345678905(10)ABC123").booleanValue());
//        // TODO
//    }
//
//    @Test
//    public void isMaxiCode() {
//        Assert.assertTrue(Code.isMaxiCode("[)>\u001E01\u001D96123450000\u001D222\u001D111\u001DMODE2").booleanValue());
//        Assert.assertTrue(Code.isMaxiCode("[)>\u001E01\u001D96123450000\u001D222\u001D111\u001DMODE3").booleanValue());
//        Assert.assertTrue(Code.isMaxiCode("[)>\u001E01\u001D96123450000\u001D222\u001D111\u001DMODE4").booleanValue());
//        Assert.assertTrue(Code.isMaxiCode("[)>\u001E01\u001D96123450000\u001D222\u001D111\u001DMODE5").booleanValue());
//        Assert.assertTrue(Code.isMaxiCode("[)>\u001E01\u001D96123450000\u001D222\u001D111\u001DMODE6").booleanValue());
//    }

    @Test
    public void code_isisbn10() {
        Assert.assertFalse(Code.code_isisbn10("12345-1234567-123456-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("12345 1234567 123456 X").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1-2-3-4").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1 2 3 4").booleanValue());

        Assert.assertTrue(Code.code_isisbn10("1-930110-99-5").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("1 930110 99 5").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("0-201-63385-X").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("0 201 63385 X").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("1-930110-99-5").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("1 930110 99 5").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("1930110995").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("0-201-63385-X").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("0 201 63385 X").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("1930110995").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("020163385X").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("020163385X").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1234567890").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("123456789X").booleanValue());

        Assert.assertFalse(Code.code_isisbn10("").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("   ").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("123456789").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("12345678901").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("12345678X0").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("123456-1234567-123456-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("12345-12345678-123456-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("12345-1234567-1234567-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("12345-1234567-123456-X2").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("--1 930110 99 5").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1 930110 99 5--").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1 930110-99 5-").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1.2.3.4").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1=2=3=4").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1_2_3_4").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("123456789Y").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("dsasdsadsa").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("I love sparrows!").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("068-556-98-45").booleanValue());

        Assert.assertFalse(Code.code_isisbn10("1930110990").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110991").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110992").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110993").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110994").booleanValue());
        Assert.assertTrue(Code.code_isisbn10("1930110995").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110996").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110997").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110998").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("1930110999").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("193011099X").booleanValue());

        Assert.assertFalse(Code.code_isisbn10("9781930110990").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110991").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110992").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110993").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110994").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110995").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110996").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110997").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110998").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("9781930110999").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("978193011099X").booleanValue());

        Assert.assertTrue(Code.code_isisbn10("9781234563").booleanValue());
        Assert.assertFalse(Code.code_isisbn10("123456789").booleanValue());
    }

    @Test
    public void code_isisbn13() {
        Assert.assertTrue(Code.code_isisbn13("978-0-306-40615-7").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-12345-1234567-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("979-12345-1234567-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978 12345 1234567 123456 1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("979 12345 1234567 123456 1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-1-2-3-4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("979-1-2-3-4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978 1 2 3 4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("979 1 2 3 4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781234567890").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9791234567890").booleanValue());

        Assert.assertTrue(Code.code_isisbn13("9781930110991").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978-1-930110-99-1").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978 1 930110 99 1").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("9780201633856").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978-0-201-63385-6").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978 0 201 63385 6").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("9781930110991").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978-1-930110-99-1").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978 1 930110 99 1").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("9780201633856").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978-0-201-63385-6").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("978 0 201 63385 6").booleanValue());

        Assert.assertFalse(Code.code_isisbn13("").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("   ").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978123456789").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("97812345678901").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-123456-1234567-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-12345-12345678-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-12345-1234567-1234567-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-12345-1234567-123456-12").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("--978 1 930110 99 1").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978 1 930110 99 1--").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978 1 930110-99 1-").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("123-4-567890-12-8").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978.1.2.3.4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978=1=2=3=4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978_1_2_3_4").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978123456789X").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978-0-201-63385-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("dsasdsadsadsa").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("I love sparrows!").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("979-1-234-567-89-6").booleanValue());

        Assert.assertFalse(Code.code_isisbn13("9781930110990").booleanValue());
        Assert.assertTrue(Code.code_isisbn13("9781930110991").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110992").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110993").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110994").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110995").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110996").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110997").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110998").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("9781930110999").booleanValue());
        Assert.assertFalse(Code.code_isisbn13("978193011099X").booleanValue());
    }

    @Test
    public void code_isissn() {
        Assert.assertTrue(Code.code_isissn("0317-8471").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 0317-8471").booleanValue());
        Assert.assertFalse(Code.code_isissn("03178471").booleanValue());
        Assert.assertTrue(Code.code_isissn("03178471", true).booleanValue());
        Assert.assertTrue(Code.code_isissn("1063-7710").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1063-7710").booleanValue());
        Assert.assertFalse(Code.code_isissn("10637710").booleanValue());
        Assert.assertTrue(Code.code_isissn("1748-7188").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1748-7188").booleanValue());
        Assert.assertFalse(Code.code_isissn("17487188").booleanValue());
        Assert.assertTrue(Code.code_isissn("0264-2875").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 0264-2875").booleanValue());
        Assert.assertFalse(Code.code_isissn("02642875").booleanValue());
        Assert.assertTrue(Code.code_isissn("1750-0095").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1750-0095").booleanValue());
        Assert.assertFalse(Code.code_isissn("17500095").booleanValue());
        Assert.assertTrue(Code.code_isissn("1188-1534").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1188-1534").booleanValue());
        Assert.assertFalse(Code.code_isissn("11881534").booleanValue());
        Assert.assertTrue(Code.code_isissn("1911-1479").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1911-1479").booleanValue());
        Assert.assertFalse(Code.code_isissn("19111479").booleanValue());
        Assert.assertTrue(Code.code_isissn("1911-1460").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1911-1460").booleanValue());
        Assert.assertFalse(Code.code_isissn("19111460").booleanValue());
        Assert.assertTrue(Code.code_isissn("0001-6772").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 0001-6772").booleanValue());
        Assert.assertFalse(Code.code_isissn("00016772").booleanValue());
        Assert.assertTrue(Code.code_isissn("1365-201X").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1365-201X").booleanValue());
        Assert.assertFalse(Code.code_isissn("1365201X").booleanValue());
        Assert.assertTrue(Code.code_isissn("1562-6865").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1562-6865").booleanValue());
        Assert.assertFalse(Code.code_isissn("15626865").booleanValue());
        Assert.assertTrue(Code.code_isissn("1050-124X").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1050-124X").booleanValue());
        Assert.assertFalse(Code.code_isissn("1050124X").booleanValue());

        Assert.assertFalse(Code.code_isissn("03178472").booleanValue());
        Assert.assertFalse(Code.code_isissn(" 1365201X").booleanValue());
        Assert.assertFalse(Code.code_isissn("1365201X ").booleanValue());
        Assert.assertFalse(Code.code_isissn(" 1365201X ").booleanValue());

        Assert.assertTrue(Code.code_isissn("ISSN 0317-8471").booleanValue());
        Assert.assertTrue(Code.code_isissn("1050-124X").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1562-6865").booleanValue());
        Assert.assertTrue(Code.code_isissn("1063-7710").booleanValue());
        Assert.assertTrue(Code.code_isissn("1748-7188").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 0264-2875").booleanValue());
        Assert.assertTrue(Code.code_isissn("1750-0095").booleanValue());
        Assert.assertTrue(Code.code_isissn("1188-1534").booleanValue());
        Assert.assertTrue(Code.code_isissn("1911-1479").booleanValue());
        Assert.assertTrue(Code.code_isissn("ISSN 1911-1460").booleanValue());
        Assert.assertTrue(Code.code_isissn("0001-6772").booleanValue());
        Assert.assertTrue(Code.code_isissn("1365-201X").booleanValue());
        Assert.assertTrue(Code.code_isissn("0264-3596").booleanValue());
        Assert.assertTrue(Code.code_isissn("1144-875X").booleanValue());

        Assert.assertFalse(Code.code_isissn("").booleanValue());
        Assert.assertFalse(Code.code_isissn("   ").booleanValue());
        Assert.assertFalse(Code.code_isissn("ISBN 0317-8471").booleanValue());
        Assert.assertFalse(Code.code_isissn("'1050-124X").booleanValue());
        Assert.assertFalse(Code.code_isissn("ISSN1562-6865").booleanValue());
        Assert.assertFalse(Code.code_isissn("10637710").booleanValue());
        Assert.assertFalse(Code.code_isissn("1748-7188'").booleanValue());
        Assert.assertFalse(Code.code_isissn("ISSN  0264-2875").booleanValue());
        Assert.assertFalse(Code.code_isissn("1750 0095").booleanValue());
        Assert.assertFalse(Code.code_isissn("1188_1534").booleanValue());
        Assert.assertFalse(Code.code_isissn("1911-1478").booleanValue());

        Assert.assertTrue(Code.code_isissn("1050-124X").booleanValue());
    }

    @Test
    public void code_isisin() {
        Assert.assertTrue(Code.code_isisin("US0378331005").booleanValue());
        Assert.assertTrue(Code.code_isisin("BMG8571G1096").booleanValue());
        Assert.assertTrue(Code.code_isisin("AU0000XVGZA3").booleanValue());
        Assert.assertTrue(Code.code_isisin("GB0002634946").booleanValue());
        Assert.assertTrue(Code.code_isisin("FR0004026250").booleanValue());
        Assert.assertTrue(Code.code_isisin("3133EHHF3").booleanValue());
        Assert.assertTrue(Code.code_isisin("DK0009763344").booleanValue());
        Assert.assertTrue(Code.code_isisin("dk0009763344").booleanValue());
        Assert.assertTrue(Code.code_isisin("AU0000xvgza3").booleanValue());
        Assert.assertTrue(Code.code_isisin("EZ0000000003").booleanValue());
        Assert.assertTrue(Code.code_isisin("XS0000000009").booleanValue());
        Assert.assertTrue(Code.code_isisin("AA0000000006").booleanValue());

        Assert.assertFalse(Code.code_isisin("US037833100O").booleanValue());
        Assert.assertFalse(Code.code_isisin("0378#3100").booleanValue());
        Assert.assertFalse(Code.code_isisin("BMG8571G109D").booleanValue());
        Assert.assertFalse(Code.code_isisin("AU0000XVGZAD").booleanValue());
        Assert.assertFalse(Code.code_isisin("GB000263494I").booleanValue());
        Assert.assertFalse(Code.code_isisin("FR000402625C").booleanValue());
        Assert.assertFalse(Code.code_isisin("DK000976334H").booleanValue());

        Assert.assertTrue(Code.code_isisin("US0378331005").booleanValue());
        Assert.assertTrue(Code.code_isisin("BMG8571G1096").booleanValue());
        Assert.assertTrue(Code.code_isisin("AU0000XVGZA3").booleanValue());
        Assert.assertTrue(Code.code_isisin("GB0002634946").booleanValue());
        Assert.assertTrue(Code.code_isisin("FR0004026250").booleanValue());
        Assert.assertTrue(Code.code_isisin("DK0009763344").booleanValue());
        Assert.assertTrue(Code.code_isisin("GB00B03MLX29").booleanValue());
        Assert.assertTrue(Code.code_isisin("US7562071065").booleanValue());
        Assert.assertTrue(Code.code_isisin("US56845T3059").booleanValue());
        Assert.assertTrue(Code.code_isisin("LU0327357389").booleanValue());
        Assert.assertTrue(Code.code_isisin("US032511BN64").booleanValue());
        Assert.assertTrue(Code.code_isisin("INE112A01023").booleanValue());
        Assert.assertTrue(Code.code_isisin("EZ0000000003").booleanValue());
        Assert.assertTrue(Code.code_isisin("XS0000000009").booleanValue());

        Assert.assertFalse(Code.code_isisin("").booleanValue());
        Assert.assertFalse(Code.code_isisin("   ").booleanValue());
        Assert.assertFalse(Code.code_isisin("US037833100O").booleanValue());
        Assert.assertFalse(Code.code_isisin("BMG8571G109D").booleanValue());
        Assert.assertFalse(Code.code_isisin("AU0000XVGZAD").booleanValue());
        Assert.assertFalse(Code.code_isisin("GB000263494I").booleanValue());
        Assert.assertFalse(Code.code_isisin("FR000402625C").booleanValue());
        Assert.assertFalse(Code.code_isisin("DK000976334H").booleanValue());

//        Assert.assertFalse(Code.code_isisin("3133EHHF3").booleanValue());
//        Assert.assertFalse(Code.code_isisin("AU0000xvgzA3").booleanValue());
//        Assert.assertFalse(Code.code_isisin("gb0002634946").booleanValue());
    }

    @Test
    public void code_isisbn() {
        Assert.assertFalse(Code.code_isisbn("12345-1234567-123456-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("12345 1234567 123456 X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1-2-3-4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1 2 3 4").booleanValue());

        Assert.assertTrue(Code.code_isisbn("1-930110-99-5").booleanValue());
        Assert.assertTrue(Code.code_isisbn("1 930110 99 5").booleanValue());
        Assert.assertTrue(Code.code_isisbn("0-201-63385-X").booleanValue());
        Assert.assertTrue(Code.code_isisbn("0 201 63385 X").booleanValue());
        Assert.assertTrue(Code.code_isisbn("1-930110-99-5").booleanValue());
        Assert.assertTrue(Code.code_isisbn("1 930110 99 5").booleanValue());
        Assert.assertTrue(Code.code_isisbn("1930110995").booleanValue());
        Assert.assertTrue(Code.code_isisbn("0-201-63385-X").booleanValue());
        Assert.assertTrue(Code.code_isisbn("0 201 63385 X").booleanValue());
        Assert.assertTrue(Code.code_isisbn("1930110995").booleanValue());
        Assert.assertTrue(Code.code_isisbn("020163385X").booleanValue());
        Assert.assertTrue(Code.code_isisbn("020163385X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1234567890").booleanValue());
        Assert.assertTrue(Code.code_isisbn("123456789X").booleanValue());

        Assert.assertFalse(Code.code_isisbn("").booleanValue());
        Assert.assertFalse(Code.code_isisbn("   ").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("123456789").booleanValue());
        Assert.assertFalse(Code.code_isisbn("12345678901").booleanValue());
        Assert.assertFalse(Code.code_isisbn("12345678X0").booleanValue());
        Assert.assertFalse(Code.code_isisbn("123456-1234567-123456-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("12345-12345678-123456-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("12345-1234567-1234567-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("12345-1234567-123456-X2").booleanValue());
        Assert.assertFalse(Code.code_isisbn("--1 930110 99 5").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1 930110 99 5--").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1 930110-99 5-").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1.2.3.4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1=2=3=4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1_2_3_4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("123456789Y").booleanValue());
        Assert.assertFalse(Code.code_isisbn("dsasdsadsa").booleanValue());
        Assert.assertFalse(Code.code_isisbn("I love sparrows!").booleanValue());
        Assert.assertFalse(Code.code_isisbn("068-556-98-45").booleanValue());

        Assert.assertFalse(Code.code_isisbn("1930110990").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110991").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110992").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110993").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110994").booleanValue());
        Assert.assertTrue(Code.code_isisbn("1930110995").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110996").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110997").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110998").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1930110999").booleanValue());
        Assert.assertFalse(Code.code_isisbn("193011099X").booleanValue());

        Assert.assertFalse(Code.code_isisbn("9781930110990").booleanValue());
        Assert.assertTrue(Code.code_isisbn("9781930110991").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110992").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110993").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110994").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110995").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110996").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110997").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110998").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781930110999").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978193011099X").booleanValue());

        Assert.assertFalse(Code.code_isisbn("978-12345-1234567-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("979-12345-1234567-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978 12345 1234567 123456 1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("979 12345 1234567 123456 1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978-1-2-3-4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("979-1-2-3-4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978 1 2 3 4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("979 1 2 3 4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9781234567890").booleanValue());
        Assert.assertFalse(Code.code_isisbn("9791234567890").booleanValue());

        Assert.assertTrue(Code.code_isisbn("9781930110991").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978-1-930110-99-1").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978 1 930110 99 1").booleanValue());
        Assert.assertTrue(Code.code_isisbn("9780201633856").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978-0-201-63385-6").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978 0 201 63385 6").booleanValue());
        Assert.assertTrue(Code.code_isisbn("9781930110991").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978-1-930110-99-1").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978 1 930110 99 1").booleanValue());
        Assert.assertTrue(Code.code_isisbn("9780201633856").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978-0-201-63385-6").booleanValue());
        Assert.assertTrue(Code.code_isisbn("978 0 201 63385 6").booleanValue());

        Assert.assertFalse(Code.code_isisbn("").booleanValue());
        Assert.assertFalse(Code.code_isisbn("   ").booleanValue());
        Assert.assertFalse(Code.code_isisbn("1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978123456789").booleanValue());
        Assert.assertFalse(Code.code_isisbn("97812345678901").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978-123456-1234567-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978-12345-12345678-123456-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978-12345-1234567-1234567-1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978-12345-1234567-123456-12").booleanValue());
        Assert.assertFalse(Code.code_isisbn("--978 1 930110 99 1").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978 1 930110 99 1--").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978 1 930110-99 1-").booleanValue());
        Assert.assertFalse(Code.code_isisbn("123-4-567890-12-8").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978.1.2.3.4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978=1=2=3=4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978_1_2_3_4").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978123456789X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("978-0-201-63385-X").booleanValue());
        Assert.assertFalse(Code.code_isisbn("dsasdsadsadsa").booleanValue());
        Assert.assertFalse(Code.code_isisbn("I love sparrows!").booleanValue());
        Assert.assertFalse(Code.code_isisbn("979-1-234-567-89-6").booleanValue());
    }

    @Test
    public void code_isean() {
        Assert.assertTrue(Code.code_isean("9783598215001").booleanValue());
    }

    @Test
    public void code_isin() {
        Assert.assertEquals("US0378331005", Code.code_isin("US0378331005").toString());
        Assert.assertEquals("NL0000000008", Code.code_isin("NL000000000").toString());
        Assert.assertEquals("NL0000000008", Code.code_isin("NL0000000008").toString());
    }

    @Test
    public void code_issn() {
        Assert.assertTrue(Code.code_isissn("1393-8754").booleanValue());
        Assert.assertTrue(Code.code_isissn("13938754", true).booleanValue());
        Assert.assertEquals("1393-8754", Code.code_issn("1393875").toString());
        Assert.assertEquals("1393-8754", Code.code_issn("13938754").toString());

        Assert.assertEquals("1393-8754", Code.code_issn("1393875", true).toString());
        Assert.assertEquals("1393-8754", Code.code_issn("13938754", true).toString());

        Assert.assertEquals("13938754", Code.code_issn("1393875", false).toString());
        Assert.assertEquals("13938754", Code.code_issn("13938754", false).toString());
//        Assert.assertEquals("1393-8754", Code.code_issn("1393-875").toString());
    }

    @Test
    public void code_ean() {
        Assert.assertEquals("9783598215001", Code.code_ean("978359821500").toString());
        Assert.assertEquals("96385074", Code.code_ean("9638507").toString());


        Assert.assertEquals("11111115", Code.code_ean("1111111").toString());
        Assert.assertEquals("11111115", Code.code_ean("11111115").toString());
        Assert.assertEquals("0123456789012", Code.code_ean("012345678901").toString());
        Assert.assertEquals("0123456789012", Code.code_ean("0123456789012").toString());
    }

    @Test
    public void code_ean8() {
        Assert.assertEquals("96385074", Code.code_ean8("9638507").toString());
    }

    @Test
    public void code_ean13() {
        Assert.assertEquals("9783598215001", Code.code_ean13("978359821500").toString());
    }

    @Test
    public void code_isip() {
        Assert.assertTrue(Code.code_isip("1.1.1.1").booleanValue());
        Assert.assertFalse(Code.code_isip("1.1.1.1.1").booleanValue());
        Assert.assertFalse(Code.code_isip("1.1.1").booleanValue());
        Assert.assertTrue(Code.code_isipv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334").booleanValue());
        Assert.assertFalse(Code.code_isip("2001:0db8:85a3:0000:0000:8a2e:0370:7334:4444").booleanValue());
        Assert.assertFalse(Code.code_isip("2001:0db8:85a3:0000:0000:8a2e:0370").booleanValue());
    }

    @Test
    public void code_isipv4() {
        Assert.assertTrue(Code.code_isipv4("1.1.1.1").booleanValue());
        Assert.assertFalse(Code.code_isipv4("1.1.1.1.1").booleanValue());
        Assert.assertFalse(Code.code_isipv4("1.1.1").booleanValue());
        Assert.assertFalse(Code.code_isipv4("2001:0db8:85a3:0000:0000:8a2e:0370:733").booleanValue());
        Assert.assertFalse(Code.code_isipv4("2001:0db8:85a3:0000:0000:8a2e:0370:7334").booleanValue());
    }

    @Test
    public void code_isipv6() {
        Assert.assertTrue(Code.code_isipv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334").booleanValue());
        Assert.assertFalse(Code.code_isipv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334:4444").booleanValue());
        Assert.assertFalse(Code.code_isipv6("2001:0db8:85a3:0000:0000:8a2e:0370").booleanValue());
    }

    @Test
    public void code_isurl() {
        Assert.assertTrue(Code.code_isurl("https://onsense.io").booleanValue());
        Assert.assertFalse(Code.code_isurl("durr/onsense.io").booleanValue());
        Assert.assertFalse(Code.code_isurl("onsense.io").booleanValue());
    }

    @Test
    public void code_isdn() {
        Assert.assertTrue(Code.code_isdn("onsense.io").booleanValue());
        Assert.assertFalse(Code.code_isdn("https://onsense.io").booleanValue());
        Assert.assertFalse(Code.code_isdn("durr/onsense.io").booleanValue());
    }

    @Test
    public void code_istld() {
        Assert.assertTrue(Code.code_istld("io").booleanValue());
        Assert.assertTrue(Code.code_istld("com").booleanValue());
        Assert.assertFalse(Code.code_istld("dummy").booleanValue());
        Assert.assertFalse(Code.code_istld("onsense").booleanValue());
        Assert.assertFalse(Code.code_istld("durr/onsense.io").booleanValue());
    }

    @Test
    public void code_iscreditcard() {
        Assert.assertTrue(Code.code_iscreditcard("4242424242424242").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("4000056655665556").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("5555555555554444").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("2223003122003222").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("5200828282828210").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("5105105105105100").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("378282246310005	").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("371449635398431	").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("6011111111111117").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("6011000990139424").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("30569309025904").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("38520000023237").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("3566002020360505").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("6200000000000005").booleanValue());

        Assert.assertTrue(Code.code_iscreditcard("4242 4242 4242 4242").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("3714 496353 98431").booleanValue());
        Assert.assertTrue(Code.code_iscreditcard("3056 9309 0259 04").booleanValue());

        Assert.assertFalse(Code.code_iscreditcard("4242 4242 4242 4242", false).booleanValue());
        Assert.assertFalse(Code.code_iscreditcard("3714 496353 98431", false).booleanValue());
        Assert.assertFalse(Code.code_iscreditcard("3056 9309 0259 04", false).booleanValue());

        Assert.assertFalse(Code.code_iscreditcard("1111111111111111").booleanValue());
        Assert.assertFalse(Code.code_iscreditcard("1111 1111 1111 1111").booleanValue());

    }

    @Test
    public void code_isin_cd() {
        Assert.assertEquals("5", Code.code_isin_cd("US037833100").toString());
        Assert.assertEquals("2", Code.code_isin_cd("012345678").toString());
        Assert.assertEquals("1", Code.code_isin_cd("0123456787").toString());
        Assert.assertEquals("8", Code.code_isin_cd("NL000000000").toString());
        Assert.assertEquals("1", Code.code_isin_cd("NL0000000008").toString());
    }

    @Test
    public void code_issn_cd() {
        Assert.assertEquals("0", Code.code_issn_cd("2049363").toString());
        Assert.assertEquals("0", Code.code_issn_cd("20493630").toString());
//        Assert.assertEquals("0", Code.code_issn_cd("2049-3630").toString());
    }

    @Test
    public void code_isbn_cd() {
        Assert.assertEquals("X", Code.code_isbn_cd("123456789").toString());
        Assert.assertEquals("1", Code.code_isbn_cd("123456789123").toString());
    }

    @Test
    public void code_isbn10_cd() {
        Assert.assertEquals("X", Code.code_isbn10_cd("123456789").toString());
    }

    @Test
    public void code_isbn13_cd() {
        Assert.assertEquals("1", Code.code_isbn13_cd("123456789123").toString());
    }

    @Test
    public void code_isbn() {
        Assert.assertEquals("123456789X", Code.code_isbn("123456789").toString());
        Assert.assertEquals("9780306406157", Code.code_isbn("978030640615").toString());
    }

    @Test
    public void code_isbn10() {
        Assert.assertEquals("123456789X", Code.code_isbn10("123456789").toString());
        Assert.assertEquals("123456789X", Code.code_isbn10("123456789X").toString());
    }

    @Test
    public void code_isbn13() {
        Assert.assertEquals("9780306406157", Code.code_isbn13("978030640615").toString());
        Assert.assertEquals("9780306406157", Code.code_isbn13("978030640615").toString());

        Assert.assertEquals("9780123456786", Code.code_isbn13("978012345678").toString());
        Assert.assertEquals("9780123456786", Code.code_isbn13("9780123456786").toString());
    }

    @Test
    public void code_ean_cd() {
        Assert.assertEquals("3", Code.code_ean_cd("4851234").toString());
        Assert.assertEquals("1", Code.code_ean_cd("978359821500").toString());
    }

    @Test
    public void code_ean8_cd() {
        Assert.assertEquals("3", Code.code_ean8_cd("4851234").toString());
    }

    @Test
    public void code_ean13_cd() {
        Assert.assertEquals("1", Code.code_ean13_cd("978359821500").toString());
    }

    @Test
    public void code_upca_cd() {
        Assert.assertEquals("7", Code.code_upca_cd("03660230146").toString());
    }

    @Test
    public void code_upce_cd() {
        Assert.assertEquals("5", Code.code_upce_cd("0123456").toString());
    }

    @Test
    public void code_upca() {
        Assert.assertEquals("036602301467", Code.code_upca("03660230146").toString());
    }

    @Test
    public void code_upce() {
        Assert.assertEquals("01234565", Code.code_upce("0123456").toString());
    }

    @Test
    public void code_isemail() {
        Assert.assertTrue(Code.code_isemail("bruh@bruh.com").booleanValue());
        Assert.assertFalse(Code.code_isemail("bruhbruh.com").booleanValue());
        Assert.assertTrue(Code.code_isemail("bruh@bruh.com", true).booleanValue());
        Assert.assertFalse(Code.code_isemail("bruhbruh.com", true).booleanValue());
        Assert.assertTrue(Code.code_isemail("bruh@bruh.com", false).booleanValue());
        Assert.assertFalse(Code.code_isemail("bruhbruh.com", false).booleanValue());
    }

    // TODO
//    @Test
//    public void code_ismod10() {
//    }
//
//    @Test
//    public void code_ismod11() {
//    }
//
//    @Test
//    public void code_iscnpj() {
//    }
//
//    @Test
//    public void code_iscpf() {
//    }
//
//    @Test
//    public void code_istitulo_eleitoral() {
//    }
//
//    @Test
//    public void code_isnip() {
//    }
//
//    @Test
//    public void code_ispesel() {
//    }
//
//    @Test
//    public void code_isregon() {
//    }
//
//    @Test
//    public void code_isjson() {
//    }
//
//    @Test
//    public void code_isxml() {
//    }
//
//    @Test
//    public void code_isyaml() {
//    }

    @Test
    public void code_iban_cd() {
        Assert.assertEquals("98", Code.code_iban_cd("0000000000").toString());
    }

    @Test
    public void code_issafehtml() {
        Assert.assertTrue(Code.code_issafehtml("DUMMY").booleanValue());
        Assert.assertTrue(Code.code_issafehtml("DUMMY", false).booleanValue());
        Assert.assertTrue(Code.code_issafehtml("DUMMY", true).booleanValue());
        Assert.assertTrue(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>My First Heading</h1>\n" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>", false).booleanValue());
        Assert.assertTrue(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "</body>\n" +
                "</html>\n", false).booleanValue());
        Assert.assertFalse(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Italian Trulli</h2>\n" +
                "<img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAASSURBVChTY/iPF4xKYwH//wMA+h4q5Gx8Kc0AAAAASUVORK5CYII=\" alt=\"Italian Trullti\" style=\"width:100%\">\n" +
                "\n" +
                "</body>\n" +
                "</html>\n", false).booleanValue());
        Assert.assertFalse(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAASSURBVChTY/iPF4xKYwH//wMA+h4q5Gx8Kc0AAAAASUVORK5CYII=\" alt=\"Italian Trullti\" style=\"width:100%\">\n" +
                "</body>\n" +
                "</html>\n", false).booleanValue());

        Assert.assertFalse(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Use JavaScript to Change Text</h2>\n" +
                "<p>This example writes \"Hello JavaScript!\" into an HTML element with id=\"demo\":</p>\n" +
                "\n" +
                "<p id=\"demo\"></p>\n" +
                "\n" +
                "<script>\n" +
                "document.getElementById(\"demo\").innerHTML = \"Hello JavaScript!\";\n" +
                "</script> \n" +
                "\n" +
                "</body>\n" +
                "</html>\n", false).booleanValue());

        Assert.assertTrue(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "</body>\n" +
                "</html>\n", true).booleanValue());
        Assert.assertFalse(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Italian Trulli</h2>\n" +
                "<img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAASSURBVChTY/iPF4xKYwH//wMA+h4q5Gx8Kc0AAAAASUVORK5CYII=\" alt=\"Italian Trullti\" style=\"width:100%\">\n" +
                "\n" +
                "</body>\n" +
                "</html>\n", true).booleanValue());

        Assert.assertFalse(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Use JavaScript to Change Text</h2>\n" +
                "<p>This example writes \"Hello JavaScript!\" into an HTML element with id=\"demo\":</p>\n" +
                "\n" +
                "<p id=\"demo\"></p>\n" +
                "\n" +
                "<script>\n" +
                "document.getElementById(\"demo\").innerHTML = \"Hello JavaScript!\";\n" +
                "</script> \n" +
                "\n" +
                "</body>\n" +
                "</html>\n", true).booleanValue());
        Assert.assertFalse(Code.code_issafehtml("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<h1>My First Heading</h1>\n" +
                "<p>My first paragraph.</p>\n" +
                "</body>\n" +
                "</html>", true).booleanValue());
        Assert.assertTrue(Code.code_issafehtml("<p>My First Heading</p>", true).booleanValue());
        Assert.assertTrue(Code.code_issafehtml("<p>Boatz Boatz Boatz</p>", true).booleanValue());
        Assert.assertFalse(Code.code_issafehtml("<script>Boatz Boatz Boatz</script>", true).booleanValue());
    }

    @Test
    public void code_isregex() {
        Assert.assertTrue(Code.code_isregex("abc", "[a-z]+").booleanValue());
        Assert.assertFalse(Code.code_isregex("ABC", "[a-z]+").booleanValue());
        Assert.assertFalse(Code.code_isregex("123", "[a-z]+").booleanValue());
        Assert.assertFalse(Code.code_isregex("abc123", "[a-z]+").booleanValue());
        Assert.assertFalse(Code.code_isregex("ABC123", "[a-z]+").booleanValue());
        Assert.assertFalse(Code.code_isregex("ABCabc", "[a-z]+").booleanValue());

        Assert.assertTrue(Code.code_isregex("abc", "[a-z]+", true).booleanValue());
        Assert.assertFalse(Code.code_isregex("ABC", "[a-z]+", true).booleanValue());
        Assert.assertFalse(Code.code_isregex("123", "[a-z]+", true).booleanValue());
        Assert.assertFalse(Code.code_isregex("abc123", "[a-z]+", true).booleanValue());
        Assert.assertFalse(Code.code_isregex("ABC123", "[a-z]+", true).booleanValue());
        Assert.assertFalse(Code.code_isregex("ABCabc", "[a-z]+", true).booleanValue());

        Assert.assertTrue(Code.code_isregex("abc", "[a-z]+", false).booleanValue());
        Assert.assertTrue(Code.code_isregex("ABC", "[a-z]+", false).booleanValue());
        Assert.assertFalse(Code.code_isregex("123", "[a-z]+", false).booleanValue());
        Assert.assertFalse(Code.code_isregex("abc123", "[a-z]+", false).booleanValue());
        Assert.assertFalse(Code.code_isregex("ABC123", "[a-z]+", false).booleanValue());
        Assert.assertTrue(Code.code_isregex("abcABC", "[a-z]+", false).booleanValue());
    }

    @Test
    public void code_isurn() {
        Assert.assertFalse(Code.code_isurn("dummy").booleanValue());
        Assert.assertFalse(Code.code_isurn("urn:example").booleanValue());
        Assert.assertTrue(Code.code_isurn("urn:example:com:foo").booleanValue());
    }

//    @Test
//    public void code_iban() {
//    }
}