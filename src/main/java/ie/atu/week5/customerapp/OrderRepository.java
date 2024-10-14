package ie.atu.week5.customerapp;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // Custom query to find all orders for a specific customer
    List<Order> findByCustomerId(String customerId);
}
