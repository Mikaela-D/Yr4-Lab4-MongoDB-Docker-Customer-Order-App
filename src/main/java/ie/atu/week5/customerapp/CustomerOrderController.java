package ie.atu.week5.customerapp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public CustomerOrderController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/customer-with-orders")
    public ResponseEntity<String> createCustomerWithOrders(@RequestBody CustomerOrderRequest customerOrderRequest) {

        // 1. Save the Customer and get the generated customer ID
        Customer customer = customerOrderRequest.getCustomer();
        Customer savedCustomer = customerRepository.save(customer);
        String customerId = savedCustomer.getId();

        // 2. Save the Orders and link them to the customer
        List<Order> orders = customerOrderRequest.getOrders();
        for(Order order : orders) {
            order.setCustomerId(customerId);
            orderRepository.save(order);
        }

        return ResponseEntity.ok("Customer and orders created successfully");
    }
}