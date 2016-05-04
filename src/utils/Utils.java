package utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 需要手工判断是否重复了。
 * Created by Nvpiao on 2016/4/18 0018.
 */
public class Utils {
    public static String getUUid() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int len = 14;
        while (len-- > 0) {
            sb.append(String.valueOf(Math.abs(random.nextInt() % 10)));
        }
        return new String(sb);
    }

    public static String dateToString(Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }
}
