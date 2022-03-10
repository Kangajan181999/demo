package com.codex.demo.controller;

import com.codex.demo.dto.CustomerDTO;
import com.codex.demo.model.Customer;
import com.codex.demo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Map<String,Boolean>> save(@RequestBody CustomerDTO customerDto){
        return customerService.save(customerDto);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String,Boolean>> login(@RequestParam String email,@RequestParam String password){
        return customerService.login(email,password);
    }
}
