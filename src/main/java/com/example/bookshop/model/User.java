package com.example.bookshop.model;

import com.example.bookshop.entities.CartEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    // Add a field for role (String for simplicity)
    // Getters and setters for role


    @OneToOne
    private CartEntity cartEntity;
    @Getter
    private String role; // For simplicity, we're using a String, not a collection

    public void setRole(String role) {
        this.role = role;
    }
}
