package utils;

import java.util.Random;

/**
 * 需要手工判断是否重复了。
 * Created by Nvpiao on 2016/4/18 0018.
 */
public class Utils {
    public static String getUUid(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int len = 14;
        while(len-- > 0){
            sb.append(String.valueOf(Math.abs(random.nextInt() % 10)));
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(Utils.getUUid());;
    }
}
