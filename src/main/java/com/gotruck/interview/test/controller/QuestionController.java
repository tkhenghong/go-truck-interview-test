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

    // Question 1
    // Generate a random number of digits in the range [1, 10] with uniform distribution (close)
    //
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
        // Assumption: The following logic is done in the business layer.
        // 1. User status MUST be Active
        if (!requestUser.getUserStatus().equals(UserStatus.Active)) {
            return false;
        }

        // 2. Order status MUST be New
        if (!order.getOrderStatus().equals(PurchaseOrderStatus.New)) {
            return false;
        }

        // 3. PurchaseOrder's user must be the same as the request user
        if (!order.getBuyer().getUserID().equals(requestUser.getUserID())) {
            return false;
        }

        purchaseOrderDAO.cancelPurchaseOrder(orderID);
        return true;
    }

    // *** Question 3: Tag the severity of the check as low, medium, or high. explain why you tag it as so. ***
    // Question 3: Answers
    // Check 1: User status MUST be Active
    // Severity: Low
    // Explanation: Suspended/Deleted users should not be able to cancel the orders.
    // This is considered as low severity because the user must be logged in and only active users are able to log in.

    // Check 2: Order status MUST be New
    // Severity: Medium
    // Explanation: As stated in the question, the user is only allowed to cancel his purchase orders if his/her purchase order is still New.
    // If the order is not new, it could affect the merchants has they either already received the payment/shipped the item out.

    // Check 3: PurchaseOrder's user must be the same as the request user
    // Severity: High
    // Explanation: The user can only cancel the orders that they made/own.
    // This is considered as high severity because if this is not checked, other users can cancel the orders anonymously.
}
