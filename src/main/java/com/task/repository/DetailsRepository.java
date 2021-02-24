package com.task.repository;

import com.task.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<Detail, Integer> {

    List<Detail> getDetailByProductId(Integer id);

    @Query(value = "SELECT * FROM Detail d, (SELECT id, COUNT(cust_id) as num_orders FROM Orders GROUP BY id) as orders WHERE orders.id = d.id ORDER BY orders.num_orders DESC, d.quantity DESC", nativeQuery = true)
    List<Detail> getHighDemandProducts();
}
