package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.example.demo.examplebeans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig{

	@Value("${my.app.username}")
	String user;
	
	@Value("${my.app.password}")
	String password;
	
	@Value("${my.app.url}")
	String url;
	
	@Bean
	public FakeDataSource customProperties() {
		FakeDataSource customProperties = new FakeDataSource();
		customProperties.setPassword(password);
		customProperties.setUserName(user);
		customProperties.setUrl(url);
		return customProperties;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
