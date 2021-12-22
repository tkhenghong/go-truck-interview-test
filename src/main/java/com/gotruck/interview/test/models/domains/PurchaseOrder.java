package com.gotruck.interview.test.models.domains;

import com.gotruck.interview.test.models.enums.PurchaseOrderStatus;

import java.util.Date;

public interface PurchaseOrder {
    String orderID = null;
    Date orderDate = new Date();
    PurchaseOrderStatus orderStatus = null;
    User buyer = null;

    public String getOrderID();
    public Date getOrderDate();
    public PurchaseOrderStatus getOrderStatus();
    public User getBuyer();
}
