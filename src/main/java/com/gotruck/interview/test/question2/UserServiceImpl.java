package com.gotruck.interview.test.question2;

import com.gotruck.interview.test.models.domains.User;
import com.gotruck.interview.test.models.domains.UserImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new UserImpl();
    }
}
