package com.task.services;

import com.task.models.*;
import com.task.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final InvoiceRepository invoiceRepository;
    private final OrdersRepository ordersRepository;
    private final CustomersRepository customersRepository;
    private final DetailsRepository detailsRepository;
    private final ProductsRepository productsRepository;

    @Autowired
    public Service(InvoiceRepository invoiceRepository, OrdersRepository ordersRepository, CustomersRepository customersRepository, DetailsRepository detailsRepository, ProductsRepository productsRepository) {
        this.invoiceRepository = invoiceRepository;
        this.ordersRepository = ordersRepository;
        this.customersRepository = customersRepository;
        this.detailsRepository = detailsRepository;
        this.productsRepository = productsRepository;
    }

    public List<Invoice> expiredInvoices(){
        return invoiceRepository.getExpiredInvoices();
    }

    public List<Invoice> wrongDateInvoices(){
        return invoiceRepository.getWrongDateInvoices();
    }

    public List<Invoice> overpaidInvoices() {
        return invoiceRepository.getOverpaidInvoice();
    }

    public List<Orders> ordersWithoutDetail(){
        return ordersRepository.getOrdersWithoutDetail();
    }

    public List<Customer> customersWithoutOrders(){
        return customersRepository.getCustomersWithoutOrders();
    }

    public List<Customer> customersLastOrders(){
        return customersRepository.getCustomersLastOrder();
    }

    public List<Detail> highDemandProducts() {
        return detailsRepository.getHighDemandProducts();
    }

    public List<Product> bulkProducts(){
        return productsRepository.bulkProducts();
    }

    public List<Orders> ordersWithoutInvoices() {
        return ordersRepository.getOrdersWithoutInvoices();
    }
}
