package com.irijeoriyorijori.lounge;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.repository.user.UserRepository;
import com.irijeoriyorijori.lounge.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 로그인_테스트() {
        String id = "201110444";
        String password = "lee0919hj";

//        User user = userService.login(id, password);
//        User user = userRepository.login(id,password);
        Optional<User> user = userRepository.findById(id);

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$4"+user);

    }
}
