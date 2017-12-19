package org.snowlive.crawler.update.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.snowlive.crawler.update.utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Class For:
 * 自配置数据库链接扫描器
 *
 * @auther: 尹振坤
 * @date: 17-12-14
 */
@Configuration
@MapperScan(basePackages = CrawlerMapperConfig.PACKAGE, sqlSessionFactoryRef = "crawlerSqlSessionFactory")
public class CrawlerMapperConfig {
    final static String PACKAGE = "org.snowlive.crawler.update.mapper.crawler";
    public final static String MAPPER_LOCATION = "classpath:mapper/crawler/*.xml";

    @Value("${dao.crawler.datasource.url}")
    private String url;
    @Value("${dao.crawler.datasource.username}")
    protected String userName;
    @Value("${dao.crawler.datasource.password}")
    protected String passWord;
    @Value("${dao.crawler.datasource.driver-class-name}")
    protected String driverClass;



    @Bean(name = "crawlerDataSource")
    public DataSource getDataSource() {

        return ConfigUtils.getDataSource(url, userName, passWord, driverClass);
    }

    @Bean("crawlerTransactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean("crawlerSqlSessionFactory")
    public SqlSessionFactory crawlerSqlSessionFactory(@Qualifier("crawlerDataSource") DataSource masterDataSource)
            throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(masterDataSource);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(CrawlerMapperConfig.MAPPER_LOCATION));
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(false);
        factory.setConfiguration(config);
        return factory.getObject();
    }
}
