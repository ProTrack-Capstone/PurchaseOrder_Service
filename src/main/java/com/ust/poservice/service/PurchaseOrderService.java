package com.ust.poservice.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ust.poservice.entity.PurchaseOrder;
import com.ust.poservice.feign.ProjectClient;
import com.ust.poservice.repository.PurchaseOrderRepository;


@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    //private final EmployeeClient employeeClient;
    private final ProjectClient projectClient;

    public PurchaseOrderService(PurchaseOrderRepository repository, ProjectClient projectClient) {
        this.repository = repository;
        //this.employeeClient = employeeClient;
        this.projectClient = projectClient;
    }

    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
        return repository.save(purchaseOrder);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return repository.findAll();
    }

    public PurchaseOrder getPurchaseOrderById(String poId) {
        return repository.findById(poId).orElseThrow(() -> new RuntimeException("Purchase Order not found"));
    }


    public void deletePurchaseOrder(String poId) {
        repository.deleteById(poId);
    }

    public Object getProjectDetails(String projectId) {
        return projectClient.getProjectById(projectId);
    }
    
    public Map<String, Object> getProjectDetailsWithEmployees(String projectId) {
    Map<String, Object> response = new LinkedHashMap<>(); // Ensures insertion order is maintained

    
    
    // Fetch Purchase Order Details
    List<PurchaseOrder> purchaseOrders = repository.findByProjectId(projectId);
    if (purchaseOrders.isEmpty()) {
        throw new RuntimeException("Purchase Order not found");
    }
    PurchaseOrder purchaseOrder = purchaseOrders.get(0);
    response.put("purchaseOrderDetails", purchaseOrder);

    // Fetch Project Details first
    Object projectDetails = projectClient.getProjectById(projectId);
    response.put("projectDetails", projectDetails);

    // Fetch Employees Assigned to Project
    List<Object> employees = projectClient.getEmployeesWithProjectId(projectId);
    response.put("employees", employees);
    
    return response;
    }   
}