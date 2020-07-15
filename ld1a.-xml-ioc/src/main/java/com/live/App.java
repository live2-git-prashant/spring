package com.live;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.live.repository.ProductRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //performIOC();
        testSingleton();
    }

	private static void performIOC() {
		//ProductRepository productRepository = new OracleRepository();
        
        //Load the spring container
        //The spring container would use the applicationContext.xml to configure the spring beans
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //access the spring bean from the application
        ProductRepository productRepository = null;
        productRepository=(ProductRepository) context.getBean("OracleRepository");
        productRepository.getProducts().forEach(System.out::println);
        
        ProductRepository mySQLRepository = null;
        mySQLRepository=(ProductRepository) context.getBean("mySQLRepository",ProductRepository.class);
        mySQLRepository.getProducts().forEach(System.out::println);
        
        //testing for singletons
        System.out.println(productRepository);
	}
	
	private static void testSingleton() {
		ProductRepository productRepository = null;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //access the spring bean from the application
        productRepository=(ProductRepository) context.getBean("productRepository");
        System.out.println(productRepository);
        
      //access the spring bean from the application second time
        productRepository=(ProductRepository) context.getBean("productRepository");
        System.out.println(productRepository);
	}
	
}
