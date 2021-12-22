package com.gotruck.interview.test.models.domains;

import com.gotruck.interview.test.models.enums.PurchaseOrderStatus;

import java.util.Date;

public class PurchaseOrderImpl implements PurchaseOrder {
    private String orderID;
    private Date orderDate;
    private PurchaseOrderStatus orderStatus;
    private User buyer;

    public PurchaseOrderImpl() {
    }

    public PurchaseOrderImpl(String orderID, Date orderDate, PurchaseOrderStatus orderStatus, User buyer) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.buyer = buyer;
    }

    public static PurchaseOrderImplBuilder builder() {
        return new PurchaseOrderImplBuilder();
    }

    @Override
    public String getOrderID() {
        return this.orderID;
    }

    @Override
    public Date getOrderDate() {
        return this.orderDate;
    }

    @Override
    public PurchaseOrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    @Override
    public User getBuyer() {
        return this.buyer;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(PurchaseOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public static class PurchaseOrderImplBuilder {
        private String orderID;
        private Date orderDate;
        private PurchaseOrderStatus orderStatus;
        private User buyer;

        PurchaseOrderImplBuilder() {
        }

        public PurchaseOrderImpl build() {
            return new PurchaseOrderImpl();
        }

        public String toString() {
            return "PurchaseOrderImpl.PurchaseOrderImplBuilder()";
        }

        public PurchaseOrderImplBuilder orderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public PurchaseOrderImplBuilder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public PurchaseOrderImplBuilder orderStatus(PurchaseOrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public PurchaseOrderImplBuilder buyer(User buyer) {
            this.buyer = buyer;
            return this;
        }
    }
}
