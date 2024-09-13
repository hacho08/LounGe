package com.irijeoriyorijori.lounge.service.user;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User loginCheck(String userId){
        //바로 연결
        Optional<User> loginedUser = userRepository.findById(userId);  //레포지토리의 기본 기능인 findById
        //예) findById(); -> SELECT * FROM 테이블 WHERE ID = '' 쿼리 실행해줘
        //예) findAll(); -> SELECT * FROM 테이블 쿼리 실행해줘
        return loginedUser.orElse(null);
        //만약 값이 없으면
    }

    public User login(String userId, String password){
        User user = userRepository.login(userId,password);   //user레포지토리에 있는 login을 사용.
        System.out.println(userId);
        return user; //service는 무조건 컨트롤러가 리턴된다. 즉, 이것은 login이 있다면,
    }
}
