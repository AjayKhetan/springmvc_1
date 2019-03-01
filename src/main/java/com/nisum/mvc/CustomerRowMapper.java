package com.nisum.mvc;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>{
	
	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer customer= new Customer();
		customer.setId(rs.getInt("id"));
		Profile profile= new Profile();
		profile.setFirstName(rs.getString("firstname"));
		profile.setLastName(rs.getString("lastname"));
		customer.setProfile(profile);
		return customer;
	}

}
