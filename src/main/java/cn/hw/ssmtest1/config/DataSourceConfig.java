package cn.hw.ssmtest1.config;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfig {
    @Value("${dataSource.driverClassName}")
    private String driverClassName;

    @Value("${dataSource.url}")
    private String url;

    @Value("${dataSource.username}")
    private String username;

    @Value("${dataSource.password}")
    private String password;

    /**
     * 配置数据源bean spring.xml配置文件要用到
     * @return 数据源的bean
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception {
        // 使用阿里巴巴druid数据库连接池
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType(DbType.mysql);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
