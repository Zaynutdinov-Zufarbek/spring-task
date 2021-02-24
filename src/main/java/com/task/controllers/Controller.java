package com.task.controllers;

import com.task.models.*;
import com.task.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    // Initializing model attributes

    @ModelAttribute("expiredInvoices")
    public List<Invoice> expiredInvoicesList(){
        return new ArrayList<>();
    }

    @ModelAttribute("wrongDateInvoices")
    public List<Invoice> wrongDateInvoicesList(){
        return new ArrayList<>();
    }

    @ModelAttribute("ordersWithoutDetails")
    public List<Orders> ordersWithoutDetailsList(){
        return new ArrayList<>();
    }

    @ModelAttribute("customersWithoutOrders")
    public List<Customer> customersWithoutOrdersList(){
        return new ArrayList<>();
    }

    @ModelAttribute("customersLastOrders")
    public List<Customer> customersLastOrdersList(){
        return new ArrayList<>();
    }

    @ModelAttribute("overpaidInvoices")
    public List<Invoice> overpaidInvoicesList(){
        return new ArrayList<>();
    }

    @ModelAttribute("highDemandProducts")
    public List<Detail> highDemandProductsList(){
        return new ArrayList<>();
    }

    @ModelAttribute("bulkProducts")
    public List<Product> bulkProductsList(){
        return new ArrayList<>();
    }

    @ModelAttribute("ordersWithoutInvoices")
    public List<Orders> ordersWithoutInvoicesList(){
        return new ArrayList<>();
    }

    // Get methods without params

    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/expired_invoices")
    public String getExpiredInvoices(Model model){
        model.addAttribute("expiredInvoices", service.expiredInvoices());
        return "/getMethods/expiredInvoices";
    }

    @GetMapping("/wrong_date_invoices")
    public String getWrongDateInvoices(Model model){
        model.addAttribute("wrongDateInvoices", service.wrongDateInvoices());
        return "/getMethods/wrongDateInvoices";
    }

    @GetMapping("/orders_without_details")
    public String getOrdersWithoutDetails(Model model){
        model.addAttribute("ordersWithoutDetails", service.ordersWithoutDetail());
        return "/getMethods/orderWithoutDetail";
    }

    @GetMapping("/customers_without_orders")
    public String getCustomersWithoutOrders(Model model){
        model.addAttribute("customersWithoutOrders", service.customersWithoutOrders());
        return "/getMethods/customerWithoutOrders";
    }

    @GetMapping("/customers_last_orders")
    public String getCustomersLastOrders(Model model){
        model.addAttribute("customersLastOrders", service.customersLastOrders());
        return "/getMethods/customersLastOrders";
    }

    @GetMapping("/overpaid_invoices")
    public String getOverpaidInvoices(Model model){
        model.addAttribute("overpaidInvoices", service.overpaidInvoices());
        return "/getMethods/overpaidInvoices";
    }

    @GetMapping("/high_demand_products")
    public String getHighDemandProducts(Model model){
        model.addAttribute("highDemandProducts", service.highDemandProducts());
        return "/getMethods/highDemandProducts";
    }

    @GetMapping("/bulk_products")
    public String getBulkProducts(Model model){
        model.addAttribute("bulkProducts", service.bulkProducts());
        return "/getMethods/bulkProducts";
    }

    @GetMapping("/orders_without_invoices")
    public String getOrdersWithoutInvoices(Model model){
       model.addAttribute("ordersWithoutInvoices", service.ordersWithoutInvoices());
       return "/getMethods/ordersWithoutInvoices";
    }
}
