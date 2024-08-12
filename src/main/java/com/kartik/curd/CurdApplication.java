package com.kartik.curd;

import com.kartik.curd.controller.BookController;
import com.kartik.curd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
public class CurdApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CurdApplication.class, args);
    }

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    BookController bookController;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Instant.now()); //utc
        System.out.println(new Date());
        System.out.println(LocalDateTime.now()); //zoned time
        System.out.println(OffsetDateTime.now()); //current time with offset
        System.out.println(ZonedDateTime.now()); //current time with offset and zoned

//        Optional<Company> company = companyRepository.findById(1l);
//        if (!company.isPresent()) {
//            Company company1 = new Company();
//            company1.setCompanyName("Kartik Org");
//            company1.setAddress(new Address("Dahod", "Gujarat"));
//            company1.setEmployees(Arrays.asList(new Employee("Emp1"), new Employee("Emp2"), new Employee("Emp3")));
//            companyRepository.save(company1);
//        }

    }
}


//	ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//	A a = context.getBean(A.class);
//	B b = context.getBean(B.class);
//    a.setB(b);
//			a.b; //returns b
