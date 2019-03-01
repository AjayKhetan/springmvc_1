package com.nisum.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CustomerDAO() {

	}

	public CustomerDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String saveCustomer(Customer customer) {
		String sql = "insert into customer(id,firstname,lastname) values(?,?,?)";
		int i = jdbcTemplate.update(sql, customer.getId(), customer.getProfile().getFirstName(),
				customer.getProfile().getLastName());
		if (i != 0) {
			return "SUCCESS !!!";
		} else {
			return null;
		}
	}

	public List<Customer> getAllCustomers() {
		return jdbcTemplate.query("select * from customer", new CustomerRowMapper());
	}

	public Customer getCustomer(int id) {
		String SQL = "select * from customer where id = ?";
		Customer customer = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new CustomerRowMapper());
		return customer;
	}

	public String updateCustomer(Customer customer) {
		String sql = "update customer set firstname = ?, lastname = ? where id = ?";
		int i = jdbcTemplate.update(sql, new Object[] { customer.getProfile().getFirstName(),
				customer.getProfile().getLastName(), customer.getId() });
		if (i != 0) {
			System.out.println("GJK");
			return "SUCCESS";
		} else {
			return null;
		}
	}

	public String deleteCustomer(int id) {
		String sql = "delete from customer where id = ?";
		int i = jdbcTemplate.update(sql, new Object[] { id });
		if (i != 0) {
			return "SUCCESS";
		} else {
			return null;
		}
	}
}
