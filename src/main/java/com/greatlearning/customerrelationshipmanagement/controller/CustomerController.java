package com.greatlearning.customerrelationshipmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerrelationshipmanagement.model.Customer;
import com.greatlearning.customerrelationshipmanagement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		// theModel.addAttribute("mode", "Add");
		return "customer-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") long customerId, Model theModel) {
		Customer customer = customerService.findById(customerId);
		theModel.addAttribute("customer", customer);
		// theModel.addAttribute("mode", "Update");
		return "customer-form";

	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("customerId") long customerId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer customer = null;

		if (customerId == 0) {
			customer = new Customer(firstName, lastName, email);
		}

		else {
			customer = customerService.findById(customerId);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}

		customerService.save(customer);
		return "redirect:list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") long customerId) {

		customerService.delete(customerId);
		return "redirect:list";

	}
}
