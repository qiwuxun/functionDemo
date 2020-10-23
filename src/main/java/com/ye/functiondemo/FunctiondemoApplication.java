package com.ye.functiondemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.ye.functiondemo.dao")
public class FunctiondemoApplication extends SpringBootServletInitializer {

 @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
  // 注意这里要指向原先用main方法执行的Application启动类
  return builder.sources(FunctiondemoApplication.class);
 }

 public static void main(String[] args) {
  SpringApplication.run(FunctiondemoApplication.class, args);
 }

}
