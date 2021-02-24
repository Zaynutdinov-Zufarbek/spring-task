package com.task.repository;

import com.task.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    @Query(value = "SELECT * FROM Product p, (SELECT pr_id, quantity FROM Detail WHERE quantity >= 8) as orders WHERE p.id = orders.pr_id", nativeQuery = true)
    List<Product> bulkProducts();
}
