package com.kartik.curd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdApplication.class, args);
	}

}


//	ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//	A a = context.getBean(A.class);
//	B b = context.getBean(B.class);
//    a.setB(b);
//			a.b; //returns b
