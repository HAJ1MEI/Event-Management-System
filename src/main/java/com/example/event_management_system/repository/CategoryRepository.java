package com.example.event_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.event_management_system.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
