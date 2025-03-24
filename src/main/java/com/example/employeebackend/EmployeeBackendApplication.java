package com.example.employeebackend;

import com.example.employeebackend.entity.Employee;
import com.example.employeebackend.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeService employeeService) {
        return args -> {
            Employee employee1 = Employee.builder()
                    .firstname("adam")
                    .lastname("doe")
                    .email("adamdpe@gmail.com")
                    .build();

            Employee employee2 = Employee.builder()
                    .firstname("sarah")
                    .lastname("jane")
                    .email("sarahjane@gmail.com")
                    .build();

            employeeService.addEmployee(employee1);
            employeeService.addEmployee(employee2);

            System.out.println("Data seeded successfully!");
        };
    }
}