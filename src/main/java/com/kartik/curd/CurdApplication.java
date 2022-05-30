package com.kartik.curd;

import com.kartik.curd.entity.Company;
import com.kartik.curd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CurdApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CurdApplication.class, args);
    }

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------------------------");
        System.out.println("CurdApplication.run");
        System.out.println("when server is start it execute");
        System.out.println("---------------------------------------");
//        companyRepository.save(new Company("Xab","a","d",10));
//        companyRepository.save(new Company("Plm","a","d",6));
//        companyRepository.save(new Company("Plm","a","d",50));
//        companyRepository.save(new Company("Mab","b","e",1));
//        companyRepository.save(new Company("Axz","b","e",96));
//        companyRepository.save(new Company("Abc","b","e",7));
//        companyRepository.save(new Company("Amn","c","f",12));
//        companyRepository.save(new Company("Xbc","c","f",86));

    }
}


//	ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//	A a = context.getBean(A.class);
//	B b = context.getBean(B.class);
//    a.setB(b);
//			a.b; //returns b
