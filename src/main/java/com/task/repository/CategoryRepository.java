package com.task.repository;

import com.task.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAll();

    @Query(value = "SELECT * FROM category c, (SELECT id, category_id FROM product) p WHERE c.id = p.category_id AND p.id =:id", nativeQuery = true)
    Category getCategoryByProductId(Integer id);
}
