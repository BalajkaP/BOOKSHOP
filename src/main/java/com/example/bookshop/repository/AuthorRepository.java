package com.example.bookshop.repository;

import com.example.bookshop.entities.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorsEntity, Long> {

    AuthorsEntity findByName(String name);

}
