package com.task.repository;

import com.task.models.Invoice;
import com.task.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "SELECT * FROM Invoice WHERE issued > due", nativeQuery = true)
    List<Invoice> getExpiredInvoices();

    @Query(value = "SELECT * FROM Invoice i, Orders o WHERE i.ord_id = o.id AND i.issued < o.date", nativeQuery = true)
    List<Invoice> getWrongDateInvoices();

    @Query(value = "SELECT * FROM Invoice i, (SELECT  inv_id FROM Payment GROUP BY inv_id HAVING COUNT(inv_id) <> 1) as wrong_payments WHERE wrong_payments.inv_id = i.id", nativeQuery = true)
    List<Invoice> getOverpaidInvoice();
}
