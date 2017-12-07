package org.snowlive.crawler.utils;

import java.sql.Timestamp;

/**
 * Class For:
 *  时间工具
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
public class TimeUtil {

    public static Timestamp toDate(String dataStr){
        return Timestamp.valueOf(dataStr);
    }
}
