package com.gotruck.interview.test.controller;

import com.gotruck.interview.test.models.controllers.response.DigitRandomGeneratorResponse;
import com.gotruck.interview.test.models.domains.PurchaseOrder;
import com.gotruck.interview.test.models.domains.User;
import com.gotruck.interview.test.models.enums.PurchaseOrderStatus;
import com.gotruck.interview.test.models.enums.UserStatus;
import com.gotruck.interview.test.question1.DigitRandomGenerator;
import com.gotruck.interview.test.question2.PurchaseOrderDAO;
import com.gotruck.interview.test.question2.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class QuestionController {
    private final DigitRandomGenerator digitRandomGenerator;

    private final PurchaseOrderDAO purchaseOrderDAO;

    private final UserService userService;

    @Autowired
    QuestionController(DigitRandomGenerator digitRandomGenerator, PurchaseOrderDAO purchaseOrderDAO, UserService userService) {
        this.digitRandomGenerator = digitRandomGenerator;
        this.purchaseOrderDAO = purchaseOrderDAO;
        this.userService = userService;
    }

    @GetMapping("")
    public String test() {
        return "Hi";
    }

    // Generate a random number of digits in the range [1, 10] with uniform distribution (close)
    @GetMapping("question1")
    public DigitRandomGeneratorResponse generateRandomValue() {
        return DigitRandomGeneratorResponse.builder().number(digitRandomGenerator.generateDigit()).build();
    }

    // Make cancellation of an order. Describe the checks needed to be performed before cancellation.
    @GetMapping("question2")
    public boolean question2(HttpRequest httpRequest, String orderID) {
        User requestUser = userService.getUser(); // Returns the user making the cancellation request.
        PurchaseOrder order = purchaseOrderDAO.getPurchaseOrder(orderID); // Assume it will always a non-null object

        // *** Question 2: Describe the checks to be performed here. If any check fails, return false. ***
        // *** Question 3: Tag the severity of the check as low, medium, or high. explain why you tag it as so. ***

        // TODO: Implement the following logic,
        // Assumption: The following logic is done in the business layer.
        // 1. User status MUST be Active
        if (requestUser.getUserStatus() != UserStatus.Active) {
            return false;
        }

        // 2. Order status MUST be New
        if (order.getOrderStatus() != PurchaseOrderStatus.New) {
            return false;
        }

        // 3. PurchaseOrder's user must be the same as the request user
        if (!order.getBuyer().getUserID().equals(requestUser.getUserID())) {
            return false;
        }

        purchaseOrderDAO.cancelPurchaseOrder(orderID);
        return true;
    }
}
