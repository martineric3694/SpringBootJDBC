package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employees;

@Repository
public interface EmployeeDao {

	public List<Employees> getAll();
}
