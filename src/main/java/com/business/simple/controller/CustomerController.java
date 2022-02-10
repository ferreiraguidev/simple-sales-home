package com.business.simple.controller;

import com.business.simple.model.Customer;
import com.business.simple.model.Servicos;
import com.business.simple.repository.CustomerRepository;
import com.business.simple.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServicosRepository servicosRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/customerRegistration")
    public ModelAndView init() {

        ModelAndView modelAndView = new ModelAndView("customerRegistration");
        modelAndView.addObject("customerObj", new Customer());
        Iterable<Customer> customerIterable = customerRepository.findAll();
        modelAndView.addObject("customers", customerIterable);

        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/sales")
    public ModelAndView sales() {

        ModelAndView modelAndView = new ModelAndView("sales");
        modelAndView.addObject("customerObj", new Customer());
        Iterable<Customer> customerIterable = customerRepository.findAll();
        modelAndView.addObject("customers", customerIterable);

        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveCustomer")
    public ModelAndView save(Customer customer) {
        customerRepository.save(customer);

        ModelAndView modelAndView = new ModelAndView("customerRegistration");
        Iterable<Customer> customerIterable = customerRepository.findAll();
        modelAndView.addObject("customers", customerIterable);
        modelAndView.addObject("customerObj", new Customer());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listCustomers")
    public ModelAndView customers() {

        ModelAndView modelAndView = new ModelAndView("customerRegistration");
        Iterable<Customer> customerIterable = customerRepository.findAll();
        modelAndView.addObject("customers", customerIterable);
        modelAndView.addObject("customerObj", new Customer());

        return modelAndView;

    }

    @GetMapping("/editCustomer/{customerId}")
    public ModelAndView edit(@PathVariable("customerId") Long customerId) {

        ModelAndView modelAndView = new ModelAndView("customerRegistration");
        Optional<Customer> customer = customerRepository.findById(customerId);
        modelAndView.addObject("customerObj", customer.get());

        return modelAndView;

    }

    @GetMapping("/deleteCustomer/{customerId}")
    public ModelAndView delete(@PathVariable("customerId") Long customerId) {

        customerRepository.deleteById(customerId);

        ModelAndView modelAndView = new ModelAndView("customerRegistration");
        modelAndView.addObject("customerObj", customerRepository.findAll());
        modelAndView.addObject("customerObj", new Customer());

        return modelAndView;
    }

    @PostMapping("**/searchCustomer")
    public ModelAndView findByName(@RequestParam("searchByName") String searchByName) {

        ModelAndView modelAndView = new ModelAndView("customerRegistration");
        modelAndView.addObject("customers", customerRepository.findByName(searchByName));
        modelAndView.addObject("customerObj", new Customer());
        return modelAndView;

    }

    @GetMapping("/services/{customerId}")
    public ModelAndView service(@PathVariable("customerId") Long customerId) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        ModelAndView modelAndView = new ModelAndView("services");
        modelAndView.addObject("customerObj", customer.get());
        modelAndView.addObject("servicos",servicosRepository.getServicos(customerId));

        return modelAndView;

    }

    @PostMapping("**/addService/{customerId}")
    public ModelAndView addServices(Servicos servicos,
                                    @PathVariable("customerId") Long customerId) {

        Customer customer = customerRepository.findById(customerId).get();
        servicos.setCustomer(customer);
        servicosRepository.save(servicos);

        ModelAndView modelAndView = new ModelAndView("services");
        modelAndView.addObject("customerObj",customer);
        modelAndView.addObject("servicos",servicosRepository.getServicos(customerId));
        return modelAndView;


    }

}

