package com.example.martenique.config;

import com.example.martenique.dao.CustomerRepository;
import com.example.martenique.dao.DivisionRepository;
import com.example.martenique.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {

            if (customerRepository.count() == 1) {

               {

                    Customer customerOne = new Customer();
                    customerOne.setFirstName("Azia");
                    customerOne.setLastName("Carmen");
                    customerOne.setAddress("369 Main St");
                    customerOne.setPostal_code("36987");
                    customerOne.setPhone("9856374529");
                    customerOne.setDivision(divisionRepository.findAll().get(7));
                    customerRepository.save(customerOne);

                    Customer customerTwo = new Customer();
                    customerTwo.setFirstName("Nessa");
                    customerTwo.setLastName("Cole");
                    customerTwo.setAddress("145 Pine Ln");
                    customerTwo.setPostal_code("14598");
                    customerTwo.setPhone("4985475362");
                    customerTwo.setDivision(divisionRepository.findAll().get(4));

                    customerRepository.save(customerTwo);

                   Customer customerThree = new Customer();
                   customerThree.setFirstName("Sam");
                   customerThree.setLastName("Little");
                   customerThree.setAddress("658 Castaway St");
                   customerThree.setPostal_code("19875");
                   customerThree.setPhone("7459852145");
                   customerThree.setDivision(divisionRepository.findAll().get(2));
                   customerRepository.save(customerThree);

                    Customer customerFour = new Customer();
                    customerFour.setFirstName("Night");
                    customerFour.setLastName("Kiddy");
                    customerFour.setAddress("101 Hawthorne Rd");
                    customerFour.setPostal_code("44556");
                    customerFour.setPhone("8569542474");
                    customerFour.setDivision(divisionRepository.findAll().get(6));
                    customerRepository.save(customerFour);

                    Customer customerFive = new Customer();
                    customerFive.setFirstName("Ryan");
                    customerFive.setLastName("Brown");
                    customerFive.setAddress("202 Maplewood Ct");
                    customerFive.setPostal_code("77889");
                    customerFive.setPhone("8569547526");
                    customerFive.setDivision(divisionRepository.findAll().get(10));
                    customerRepository.save(customerFive);
                }
            }
        };
    }
}
