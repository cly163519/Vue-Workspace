package cn.tedu.baking.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动扫描
 */
@Configuration
@MapperScan(value = "cn.tedu.baking")
public class MyBatisConfig {
}
