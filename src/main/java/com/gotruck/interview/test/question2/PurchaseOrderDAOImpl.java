package com.gotruck.interview.test.question2;

import com.gotruck.interview.test.models.domains.PurchaseOrder;
import com.gotruck.interview.test.models.domains.PurchaseOrderImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {
    @Override
    public PurchaseOrder getPurchaseOrder(String id) {
        log.info("Purchase Order ID: {}", id);
        return new PurchaseOrderImpl();
    }

    @Override
    public void cancelPurchaseOrder(String id) {
        log.info("Cancel Purchase Order ID: {}", id);
        // Do something...
    }
}
