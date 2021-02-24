package com.task.repository;


import com.task.models.Customer;
import com.task.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT * FROM Customer c WHERE c.id NOT IN (SELECT o.cust_id FROM Orders o WHERE EXTRACT(YEAR FROM o.date) = 2021)", nativeQuery = true)
    List<Customer> getCustomersWithoutOrders();

    @Query(value = "SELECT * FROM Customer c, (SELECT cust_id, MAX(date) FROM Orders GROUP BY cust_id) AS latest_orders WHERE c.id = latest_orders.cust_id ", nativeQuery = true)
    List<Customer> getCustomersLastOrder();

}
