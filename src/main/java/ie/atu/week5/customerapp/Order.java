package ie.atu.week5.customerapp;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private int orderCode;
    private String orderDetails;
    private String orderDate;
    private String customerId; // Reference to the associated customer
}
