package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.component.AnotherWorldService;
import com.example.demo.component.HelloWorldService;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.model.Employees;

@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	HelloWorldService helloWorldService;
	@Autowired
	EmployeeDao empDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(helloWorldService.getMessage());
//		System.out.println(helloWorldService.getMessage("Hello World from Application to HelloWorldService"));
//		
//		System.out.println(helloWorldService.getAnotherWorld("Hello Another World"));
//		System.out.println(helloWorldService.getWorldService());
//		System.out.println(anotherWorldService.getMessage("Hello World from Application to AnotherWorldService"));
		
		List<Employees> result = empDao.getAll();
		
		for(Employees data:result) {
			System.out.println(data.getEmployeeId()+"."+data.getFirstName()+" "+data.getLastName());
		}
		
	}
}
