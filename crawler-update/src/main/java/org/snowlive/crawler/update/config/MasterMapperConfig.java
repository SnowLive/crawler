package org.snowlive.crawler.update.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.snowlive.crawler.update.utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Class For:
 *  自配置数据库链接扫描器
 * @auther: 尹振坤
 * @date: 17-12-14
 */
@Configuration
@MapperScan(basePackages = MasterMapperConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterMapperConfig {
    final static String PACKAGE = "org.snowlive.crawler.update.mapper.master";
    public final static String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    @Value("${dao.master.datasource.url}")
    private String url;

    @Value("${dao.master.datasource.username}")
    protected String userName;
    @Value("${dao.master.datasource.password}")
    protected String passWord;
    @Value("${dao.master.datasource.driver-class-name}")
    protected String driverClass;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource getDataSource() {
        return ConfigUtils.getDataSource(url, userName,
                passWord, driverClass);
    }

    @Bean("masterTransactionManager")
    @Primary
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean("masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(masterDataSource);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterMapperConfig.MAPPER_LOCATION));
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(false);
        factory.setConfiguration(config);
        return factory.getObject();
    }
}
