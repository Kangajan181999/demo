package com.codex.demo.service;

import com.codex.demo.dto.CustomerDTO;
import com.codex.demo.model.Customer;
import com.codex.demo.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public ResponseEntity<Map<String, Boolean>> save(CustomerDTO customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
        Map<String,Boolean> map = new TreeMap<>();
        map.put("isSaved:",true);
        return ResponseEntity.ok(map);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


}
