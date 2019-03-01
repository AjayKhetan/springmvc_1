package com.nisum.mvc;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	private Customer customer;
	
	@Autowired
	private CustomerDAO customerDAO;
	

	/*ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	private Customer customer= context.getBean("customer",Customer.class);
	private CustomerDAO customerDAO= context.getBean("customerDAO",CustomerDAO.class);*/

	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/customer")
	public ModelAndView customer() {
		return new ModelAndView("customer");
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView addCustomer(@RequestParam("id") String id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("balance") String balance,
			@RequestParam("type") String type) {
		
		List<Error> errors = new ArrayList<Error>();

		Integer id1 = 0;
		Integer balance1 = 0;

		if (id.equals(null) || id.equals("")) {
			id1 = 0;
		} else {
			id1 = Integer.parseInt(id);
		}
		if (balance.equals(null) || balance.equals("")) {
			balance1 = 0;
		} else {
			balance1 = Integer.parseInt(balance);
		}

		if (id1.equals(null) || id1.equals(0)) {
			errors.add(new Error(11, "Please fill the ID"));
		}
		if (firstName.equals(null) || firstName.equals("") || firstName.equals(" ")) {
			errors.add(new Error(12, "Please fill the First Name"));
		}
		if (lastName.equals(null) || lastName.equals("") || lastName.equals(" ")) {
			errors.add(new Error(13, "Please fill the Last Name"));
		}
		if (balance1.equals(null) || balance1.equals(0)) {
			errors.add(new Error(14, "Your Balance is null"));
		}
		if (type.equals(null) || type.equals("") || type.equals(" ")) {
			errors.add(new Error(15, "Please fill the type"));
		}

		customer.setErrors(errors);

		if (customer.getErrors().size() != 0) {
			ModelAndView modelAndView = new ModelAndView("error");
			modelAndView.addObject("errors", customer.getErrors());
			return modelAndView;
		}

		id1 = Integer.parseInt(id);
		balance1 = Integer.parseInt(balance);

		customer.setId(id1);
		customer.getProfile().setFirstName(firstName);
		customer.getProfile().setLastName(lastName);
		customer.getWallet().setBalance(balance1);
		customer.getWallet().setType(type);

		String msg = customerDAO.saveCustomer(customer);
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("message", msg);
		return modelAndView;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ModelAndView getListCustomers() {
		List<Customer> customers = customerDAO.getAllCustomers();
		ModelAndView modelAndView = new ModelAndView("customer-list");
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("customer-form");
		Customer customer = customerDAO.getCustomer(id);
		System.out.println(customer.getId() + customer.getProfile().getFirstName());
		modelAndView.addObject("id", customer.getId());
		modelAndView.addObject("firstname", customer.getProfile().getFirstName());
		modelAndView.addObject("lastname", customer.getProfile().getLastName());
		return modelAndView;
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public ModelAndView updatedCUstomer(@RequestParam("id") String id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("balance") String balance,
			@RequestParam("type") String type) {
		
		List<Error> errors = new ArrayList<Error>();

		Integer id1 = 0;
		Integer balance1 = 0;

		if (id.equals(null) || id.equals("")) {
			id1 = 0;
		} else {
			id1 = Integer.parseInt(id);
		}
		if (balance.equals(null) || balance.equals("")) {
			balance1 = 0;
		} else {
			balance1 = Integer.parseInt(balance);
		}

		if (id1.equals(null) || id1.equals(0)) {
			errors.add(new Error(11, "Please fill the ID"));
		}
		if (firstName.equals(null) || firstName.equals("") || firstName.equals(" ")) {
			errors.add(new Error(12, "Please fill the First Name"));
		}
		if (lastName.equals(null) || lastName.equals("") || lastName.equals(" ")) {
			errors.add(new Error(13, "Please fill the Last Name"));
		}
		if (balance1.equals(null) || balance1.equals(0)) {
			errors.add(new Error(14, "Your Balance is null"));
		}
		if (type.equals(null) || type.equals("") || type.equals(" ")) {
			errors.add(new Error(15, "Please fill the type"));
		}

		customer.setErrors(errors);

		if (customer.getErrors().size() != 0) {
			ModelAndView modelAndView = new ModelAndView("error");
			modelAndView.addObject("errors", customer.getErrors());
			return modelAndView;
		}

		id1 = Integer.parseInt(id);
		balance1 = Integer.parseInt(balance);

		customer.setId(id1);
		customer.getProfile().setFirstName(firstName);
		customer.getProfile().setLastName(lastName);
		customer.getWallet().setBalance(balance1);
		customer.getWallet().setType(type);

		String msg = customerDAO.updateCustomer(customer);
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("message", msg);
		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam("id") int id) {
		String msg= customerDAO.deleteCustomer(id);
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("message", msg);
		return modelAndView;
	}
}
