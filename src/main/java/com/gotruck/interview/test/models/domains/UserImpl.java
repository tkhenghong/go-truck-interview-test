package com.gotruck.interview.test.models.domains;

import com.gotruck.interview.test.models.enums.UserStatus;

public class UserImpl implements User {
    private String userID;

    private String userName;

    private UserStatus userStatus;

    public UserImpl() {
    }

    public UserImpl(String userID, String userName, UserStatus userStatus) {
        this.userID = userID;
        this.userName = userName;
        this.userStatus = userStatus;
    }

    public static UserImplBuilder builder() {
        return new UserImplBuilder();
    }

    @Override
    public String getUserID() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public UserStatus getUserStatus() {
        return null;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public static class UserImplBuilder {
        private String userID;
        private String userName;
        private UserStatus userStatus;

        UserImplBuilder() {
        }

        public UserImplBuilder userID(String userID) {
            this.userID = userID;
            return this;
        }

        public UserImplBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserImplBuilder userStatus(UserStatus userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public UserImpl build() {
            return new UserImpl(userID, userName, userStatus);
        }

        public String toString() {
            return "UserImpl.UserImplBuilder(userID=" + this.userID + ", userName=" + this.userName + ", userStatus=" + this.userStatus + ")";
        }
    }
}
