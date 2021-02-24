package com.task.services;

import com.task.models.*;
import com.task.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {
    private final CategoryRepository categoryRepository;
    private final ProductsRepository productsRepository;
    private final DetailsRepository detailsRepository;
    private final OrdersRepository ordersRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public ApiService(CategoryRepository categoryRepository, ProductsRepository productsRepository, DetailsRepository detailsRepository, OrdersRepository ordersRepository, PaymentRepository paymentRepository) {
        this.categoryRepository = categoryRepository;
        this.productsRepository = productsRepository;
        this.detailsRepository = detailsRepository;
        this.ordersRepository = ordersRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<Category> getCategoriesList() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByProductId(String product_id){
        return categoryRepository.getCategoryByProductId(Integer.valueOf(product_id));
    }

    public List<Product> getProductsList(){
        return productsRepository.findAll();
    }

    public List<Detail> getProductDetailById(String id){
        return detailsRepository.getDetailByProductId(Integer.valueOf(id));
    }

    public void addOrder(Orders order) {
        ordersRepository.save(order);
    }

    public List<Orders> getOrdersById(String id){
        return ordersRepository.findOrdersById(Integer.valueOf(id));
    }

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public Payment getPaymentById(String id) {
        return paymentRepository.getPaymentById(Integer.valueOf(id));
    }
}
