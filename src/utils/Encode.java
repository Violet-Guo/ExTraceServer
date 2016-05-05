package utils;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by violet on 2016/5/5.
 */
public class Encode {

    public static String createUniqueId(String tel) {
        String unid = "GLS"+tel.substring(0, 5)+"ZT"+tel.substring(5, 11)+"521";
        return encodeStr(unid);
    }

    /**
     * base64加密
     * @param str 要加密的字符串
     * @return  加密的字符串
     */
    public static String encodeStr(String str){
        byte[] b = new Base64().encode(str.getBytes());
        return new String(b);
    }

    /**
     * base64解密
     * @param str 要解密的字符串
     * @return  解密的字符串
     */
    public static String decodeStr(String str){
        byte[] b = new Base64().decode(str.getBytes());
        return new String(b);
    }

    /**
     * 返回一个加密过的token
     * @param tel  手机号
     * @return 加密过的token
     */
    public String getToken(String tel){
        String token = createUniqueId(tel);
        return token;
    }

    public String decode(String token){
        String str = decodeStr(token);
        String tel = str.substring(3, 8)+str.substring(10, 16);
        return tel;
    }
}
