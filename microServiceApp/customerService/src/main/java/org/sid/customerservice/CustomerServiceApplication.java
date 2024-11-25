package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("elghali").email("elghali.benhida@gmail.com").build(),
                            Customer.builder().name("mehdi").email("mehdi.kheiri@gmail.com").build(),
                            Customer.builder().name("aya").email("aya.dahib89@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
