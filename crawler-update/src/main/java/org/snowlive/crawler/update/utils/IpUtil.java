package org.snowlive.crawler.update.utils;

import java.util.Random;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
public class IpUtil {

    public static String getRandomIp(){
        return "181" + "." + new Random().nextInt(254) + "." + new Random().nextInt(254) + "." + new Random().nextInt(254);
    }


}
