package com.kartik.curd.config;

import com.kartik.curd.entity.bank.Account;
import com.kartik.curd.entity.bank.Bank;
import com.kartik.curd.entity.bank.CompanyBusiness;
import com.kartik.curd.entity.bank.User;
import com.kartik.curd.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class CustomCommandLine implements CommandLineRunner {

    @Autowired
    private DemoConfig demoConfig;

    @Autowired
    private CurdConfig curdConfig;

    private static final Logger logger = LoggerFactory.getLogger(CustomCommandLine.class);

    @Value("${api.key: not found}")
    private String name;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------------------------");
        logger.info(demoConfig.toString());
        logger.info(curdConfig.toString());
        logger.info(name);


        System.out.println("---------------------------------------");

        User user = new User();
        user.setUsername("Kartik1");
        Account account = new Account();
        account.setNumber("123456");
        user.setAccount(account);

        CompanyBusiness company=new CompanyBusiness();
        company.setName("company1");

        CompanyBusiness company2=new CompanyBusiness();
        company2.setName("company2");

        CompanyBusiness company3=new CompanyBusiness();
        company3.setName("company3");

        Bank bank = new Bank();
        bank.setName("b1");
        bank.setCompanies(Arrays.asList(company,company2));

        Bank bank1 = new Bank();
        bank1.setName("b2");
        bank1.setCompanies(Arrays.asList(company2,company3));

        account.setBanks(Arrays.asList(bank1, bank));
        userRepository.save(user);

        System.out.println("---------------------------------------");


    }
}
