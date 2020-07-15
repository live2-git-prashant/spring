package com.live;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.live.service.ProductService;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("SPRING XML CONFIG WITH DI (CONSTRUCTOR BASED)");
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ProductService productService =  context.getBean("productService", ProductService.class);
    	productService.getProducts().forEach(System.out::println);
    	context.close();
    }
}