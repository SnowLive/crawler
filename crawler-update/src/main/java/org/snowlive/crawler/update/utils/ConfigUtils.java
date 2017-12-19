package org.snowlive.crawler.update.utils;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;

/**
 * Class For:
 * DataSource 配置的通用设置
 *
 * @auther: 尹振坤
 * @date: 17-12-15
 */
public class ConfigUtils {

    public static DataSource getDataSource(String url, String userName, String passWord, String driverClass) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }


}
