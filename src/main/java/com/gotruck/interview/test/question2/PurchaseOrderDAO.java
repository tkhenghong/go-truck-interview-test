package com.gotruck.interview.test.question2;

import com.gotruck.interview.test.models.domains.PurchaseOrder;

public interface PurchaseOrderDAO {
    PurchaseOrder getPurchaseOrder(String id);

    void cancelPurchaseOrder(String id);
}
