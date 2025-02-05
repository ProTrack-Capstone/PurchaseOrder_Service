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
    private String poId;

    @Column(nullable = false)
    private String projectId;

    @Column(nullable=false)
    private String pointOfContact;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String paymentMode;

    @Column(nullable = false)
    private String fundInterval;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountNumber;
    
    public PurchaseOrder() {
    }

    public PurchaseOrder(String projectId, String pointOfContact, String emailId, Long phoneNumber, String paymentMode, String fundInterval, String bankName, String accountNumber) {
        this.projectId = projectId;
        this.pointOfContact = pointOfContact;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.paymentMode = paymentMode;
        this.fundInterval = fundInterval;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPointOfContact() {
        return pointOfContact;
    }

    public void setPointOfContact(String pointOfContact) {
        this.pointOfContact = pointOfContact;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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


    // Getters and Setters

}