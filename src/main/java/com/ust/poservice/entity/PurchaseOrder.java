package com.ust.poservice.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
  @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
            name = "custom-id-generator",
            strategy = "com.ust.poservice.Generator.CustomIdGenerator"
    )
    private String id;

    @Column(nullable = false)
    private String projectId;

    @Column(nullable = false)
    private String fundInterval;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountNumber;

    // Getters and Setters

    public PurchaseOrder() {
    }

    public PurchaseOrder(String id, String projectId, String fundInterval,String bankName, String accountNumber) {
        this.id = id;
        this.projectId = projectId;
        this.fundInterval = fundInterval;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    public String getFundInterval() {
        return fundInterval;
    }

    public void setFundInterval(String fundInterval) {
        this.fundInterval = fundInterval;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}