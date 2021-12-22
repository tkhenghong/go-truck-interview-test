package com.gotruck.interview.test.models.domains;

import com.gotruck.interview.test.models.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public interface User {
    String userID = null;
    String userName = null;
    UserStatus userStatus = null;

    String getUserID();
    String getUserName();
    UserStatus getUserStatus();
}
