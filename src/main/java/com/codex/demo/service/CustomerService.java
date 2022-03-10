package com.codex.demo.service;

import com.codex.demo.dto.CustomerDTO;
import com.codex.demo.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    ResponseEntity<Map<String,Boolean>> save(CustomerDTO customerDto);

    List<Customer> getAllCustomer();

    ResponseEntity<Map<String, Boolean>> login(String email, String password);
}
