package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employees;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Employees> getAll() {
		List<Employees> result = new ArrayList<Employees>();

		try {
			DataSource ds = jdbc.getDataSource();
			Connection conn = ds.getConnection();
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

	@Override
	public int insertData(Employees data) {
		// TODO Auto-generated method stub
		int result = 0;
		System.out.println(data.getEmployeeId());
		try {
			DataSource ds = jdbc.getDataSource();
			Connection conn = ds.getConnection();
			String query = "INSERT INTO copy_emp VALUES(?,?,?)";
			System.out.println(query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, data.getEmployeeId());
			ps.setString(2, data.getFirstName());
			ps.setString(3, data.getLastName());
			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
