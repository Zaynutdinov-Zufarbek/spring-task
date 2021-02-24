package com.task.controllers;

import com.task.models.*;
import com.task.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    private final ApiService service;

    @Autowired
    public ApiController(ApiService service) {
        this.service = service;
    }

    // Category
    @GetMapping("/category/list")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(service.getCategoriesList());
    }

    @GetMapping("/category")
    public ResponseEntity<Category> getCategoryByProductId(@RequestParam("product_id") String product_id){
        return ResponseEntity.ok(service.getCategoryByProductId(product_id));
    }

    // Product
    @GetMapping("/product/list")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(service.getProductsList());
    }

    @GetMapping("/product/details")
    public ResponseEntity<List<Detail>> getDetailsByProductId(@RequestParam("product_id") String product_id){
        return ResponseEntity.ok(service.getProductDetailById(product_id));
    }

    // Order
    @PostMapping("/order")
    public void createOrder(@RequestBody Orders order){
       service.addOrder(order);
    }

    @GetMapping("/order/details")
    public ResponseEntity<Map<String, String>> getOrdersDetailById(@RequestParam("order_id") String order_id){
        Map<String, String> map = new HashMap<>();
        List<Orders> orders = service.getOrdersById(order_id);
        for (Orders order : orders) {
            map.put("order id", order.getId().toString());
            map.put("order date", order.getDate().toString());
            map.put("product name", order.getDetails().get(0).getProduct().getName());
        }
        return ResponseEntity.ok(map);
    }

    // Payment
    @PostMapping(value = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPayment(@RequestBody Payment payment){
        service.addPayment(payment);
    }

    @GetMapping("/payment/details")
    public Payment getPaymentDetailsById(@RequestParam("payment_id") String id){
        return service.getPaymentById(id);
    }
}
