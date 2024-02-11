package com.example.bookshop.service;

import com.example.bookshop.entities.CartEntity;
import com.example.bookshop.model.User;
import com.example.bookshop.repository.CartRepository;
import com.example.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, CartRepository cartRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        // Vytvorenie nového košíka
        CartEntity cartEntity = new CartEntity();
        CartEntity cartEntitySaved = cartRepository.save(cartEntity);

        // Priradenie košíka k používateľovi
        user.setCartEntity(cartEntitySaved);
        cartEntitySaved.setUser(user);

        // Uloženie používateľa a košíka do databázy
        userRepository.save(user);
        cartRepository.save(cartEntitySaved);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void changeUserRole(Long userId, String newRole) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(newRole);
        userRepository.save(user);
    }

    public String getLoggedInUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getAuthorities().stream()
                    .findFirst()
                    .map(Object::toString)
                    .orElse("USER");
        }
        return "USER";
    }

}
