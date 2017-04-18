package com.oppein;

import com.oppein.configuration.dbconfig.MainConfig;
import com.oppein.domain.crm.CrmContractImage;
import com.oppein.repository.crm.CrmContractImageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下   Springboot 1.4 版本之前使用以下的注解
@SpringApplicationConfiguration(classes = MainConfig.class)
//@WebAppConfiguration

//SpringBoot 版本在1.4或者之后使用以下的注解
//@SpringBootTest(classes = MainConfig.class)
public class ClientRepositoryTest {

}
