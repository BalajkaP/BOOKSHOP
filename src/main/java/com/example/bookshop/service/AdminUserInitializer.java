package com.example.bookshop.service;

import com.example.bookshop.entities.CartEntity;
import com.example.bookshop.model.User;
import com.example.bookshop.repository.CartRepository;
import com.example.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// POZOR: Zde si vytvořím prvního admin usera s rolí ROLE_ADMIN. Aby po přihlášení na index bylo možno přejít na stránku
// admin přes link Manage Roles . User= admin, Heslo = adminPassword  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Jsou i jiné způsoby vytvoření prvního ADMIN. Např.  zadat do DB tabulky.
@Component
public class AdminUserInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            CartEntity cartEntity = new CartEntity();
            CartEntity cartEntitySaved = cartRepository.save(cartEntity);

            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setCartEntity(cartEntitySaved);
            cartEntitySaved.setUser(adminUser);
            adminUser.setPassword(passwordEncoder.encode("adminPassword"));
            adminUser.setRole("ADMIN"); // Ensure this matches your role naming convention
            userRepository.save(adminUser);
            cartRepository.save(cartEntitySaved);
        }
    }
}
