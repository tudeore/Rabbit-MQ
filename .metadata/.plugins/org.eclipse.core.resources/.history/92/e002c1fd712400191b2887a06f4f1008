package com.moneymoney.zuulmmbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.moneymoney.zuulmmbank.filters.ErrorFilter;
import com.moneymoney.zuulmmbank.filters.PostFilter;
import com.moneymoney.zuulmmbank.filters.PreFilter;
import com.moneymoney.zuulmmbank.filters.RouteFilter;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulMmbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulMmbankApplication.class, args);
	}
	
	
	
	  @Bean public PreFilter preFilter() { return new PreFilter(); }
	  
	  @Bean public PostFilter postFilter() { return new PostFilter(); }
	  
	  @Bean public ErrorFilter errorFilter() { return new ErrorFilter(); }
	  
	  @Bean public RouteFilter routeFilter() { return new RouteFilter(); }
	 
}

