package com.ust.poservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.poservice.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,String> {
    List<PurchaseOrder> findByProjectId(String projectId);
    //List<PurchaseOrder> findByEmployeeId(String employeeId);
}
