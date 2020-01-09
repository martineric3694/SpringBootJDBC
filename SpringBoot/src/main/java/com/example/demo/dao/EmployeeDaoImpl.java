package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employees;
import com.example.demo.util.Connector;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	Connector connector;

	@Override
	public List<Employees> getAll() {
		List<Employees> result = new ArrayList<Employees>();

		try {
			Connection conn = connector.open();
			Statement stmt = conn.createStatement();
			String query = "SELECT employee_id, first_name, last_name FROM copy_emp";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Employees model = new Employees();
				model.setEmployeeId(rs.getInt(1));
				model.setFirstName(rs.getString(2));
				model.setLastName(rs.getString(3));
				result.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
