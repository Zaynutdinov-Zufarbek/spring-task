package com.task.repository;

import com.task.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findOrdersById(Integer id);

    @Query(value = "SELECT * FROM Orders o LEFT JOIN  Detail d ON o.id = d.ord_id WHERE d.ord_id IS NULL AND o.date < '2020-09-01'", nativeQuery = true)
    List<Orders> getOrdersWithoutDetail();

    @Query(value = "SELECT * FROM Orders o LEFT JOIN  Invoice i ON o.id = i.ord_id WHERE i.ord_id IS NULL", nativeQuery = true)
    List<Orders> getOrdersWithoutInvoices();
}
