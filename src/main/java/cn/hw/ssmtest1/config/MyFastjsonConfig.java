package cn.hw.ssmtest1.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Configuration
public class MyFastjsonConfig {
    /**
     * fastjson配置bean
     * @return fastjson配置bean
     */
    @Bean
    public FastJsonConfig fastJsonConfig(){
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 配置json解析utf-8
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        return fastJsonConfig;
    }

    /**
     * fastjson 视图解析配置
     * @return fastjson 视图解析配置
     */
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 视图解析默认字符格式utf-8
        fastJsonHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        // 使用fastjson配置（上面定义的bean）
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig());
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        // 给前端的视图类型 application/json
        mediaTypes.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return fastJsonHttpMessageConverter;
    }
}
