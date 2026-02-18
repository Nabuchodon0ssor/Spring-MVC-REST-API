package com.dimapasunkov.spring.rest;

import com.dimapasunkov.spring.rest.configuration.MyConfig;
import com.dimapasunkov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

//        Employee empById = communication.getEmployee(10);
//        System.out.println(empById);

        Employee emp = new Employee("Alex", "Smith", "Sales", 900);
        communication.saveEmployee(emp);


//        communication.deleteEmployee(12);
//        communication.deleteEmployee(13);

        allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);
    }
}
