package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by violet on 2016/5/5.
 */
public class Authentication {

    private Authentication(){};

    private static Authentication instance = new Authentication();
    private static Map<String, String> map = new HashMap<String, String>();
    private static Encode encode = new Encode();

    public static Authentication getInstance(){
        return instance;
    }

    /**
     * 登陆时在map中增加一个token
     * @param tel 手机号
     */
    public String addToken(String tel){
        String token = encode.getToken(tel);
        map.put(token, tel);
        return token;
    }


    public Boolean verify(String token){
        String tel = encode.decode(token);
        if (map.get(token).equals(tel)){
            return true;
        }
        return false;
    }

    /**
     * 注销登陆时移除token
     * @param token
     */
    public void removeToken(String token){
        map.remove(token);
    }
}
