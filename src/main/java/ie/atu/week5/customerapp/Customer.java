package ie.atu.week5.customerapp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;

    @NotBlank(message = "The name is mandatory")
    @Size(min = 2, max = 40, message = "The name must be between 2 and 40 characters long")
    private String name;

    @NotBlank(message = "The email is mandatory")
    @Email(message = "Please provide a valid email address")
    private String email;
}