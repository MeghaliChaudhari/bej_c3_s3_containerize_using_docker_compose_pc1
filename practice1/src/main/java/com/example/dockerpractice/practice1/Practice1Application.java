package com.example.dockerpractice.practice1;

import com.example.dockerpractice.practice1.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice1Application.class, args);
	}

	@Bean
	public FilterRegistrationBean filterBeand(){
		FilterRegistrationBean filterreg = new FilterRegistrationBean();
		filterreg.setFilter(new JwtFilter());
		filterreg.addUrlPatterns("/userdata/v1/fetch");
		return filterreg;
	}
}
