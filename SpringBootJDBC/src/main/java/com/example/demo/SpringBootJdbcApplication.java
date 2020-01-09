package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employees;

@SpringBootApplication
public class SpringBootJdbcApplication implements ApplicationRunner {

	@Autowired
	EmployeeDao empDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		boolean pilihan = true;
		
		while (pilihan) {
			System.out.println();
			System.out.println("Pilih Menu");
			System.out.println("1. Get All");
			System.out.println("2. Get One");
			System.out.println("3. Insert");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.println("Pilihan :");
			String menu = scan.next();
			
			switch (menu) {
			case "1":
				List<Employees> result = empDao.getAll();
				for (Employees data : result) {
					System.out.println(data.getEmployeeId() + "." + data.getFirstName() + " " + data.getLastName());
				}
				break;
			case "2":
				System.out.println("Masukan ID yang akan diambil :");
				String id = scan.next();
				System.out.println(id);
				break;
			case "3":
				System.out.println("Masukan Data dibawah ini :");
				System.out.println("Employee ID : ");
				String empId = scan.next();
				System.out.println("First Name : ");
				String fName = scan.next();
				System.out.println("Last Name : ");
				String lName = scan.next();
				
				Employees emp = new Employees();
				emp.setEmployeeId(Integer.parseInt(empId));
				emp.setFirstName(fName);
				emp.setLastName(lName);
				
				if(empDao.insertData(emp)>0) {
					System.out.println("Insert Berhasil");
				}
				break;
			default:
				pilihan = false;
				break;
			}
		}

	}

}
