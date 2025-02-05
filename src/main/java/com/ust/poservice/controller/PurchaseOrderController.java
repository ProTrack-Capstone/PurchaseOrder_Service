package com.ust.poservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.poservice.entity.PurchaseOrder;
import com.ust.poservice.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/po")
public class PurchaseOrderController {
    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder savedPO = service.addPurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(savedPO);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = service.getAllPurchaseOrders();
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/{poId}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable String poId) {
        PurchaseOrder purchaseOrder = service.getPurchaseOrderById(poId);
        return ResponseEntity.ok(purchaseOrder);
    }


    @DeleteMapping("/{poId}")
    public ResponseEntity<String> deletePurchaseOrder(@PathVariable String poId) {
        service.deletePurchaseOrder(poId);
        return ResponseEntity.ok("Purchase Order deleted successfully!");
    }

    @GetMapping("/project/{projectId}")
        public ResponseEntity<Map<String, Object>> getProjectWithEmployees(@PathVariable String projectId) {
            Map<String, Object> response = service.getProjectDetailsWithEmployees(projectId);
            return ResponseEntity.ok(response);
        }
    
}
