package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService {

    private final OrderRepository orderRepository;

    public CustomerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Customer> getCustomers()
    {
        return orderRepository.findAll();
    }
}
