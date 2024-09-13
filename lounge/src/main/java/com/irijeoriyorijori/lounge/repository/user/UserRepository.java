package com.irijeoriyorijori.lounge.repository.user;

import com.irijeoriyorijori.lounge.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

//    @Query("SELECT u FROM User u WHERE u.userId = :userId AND u.password = :password")
//    User login(@Param("userId") String userId, @Param("password") String password);

    @Query(value="SELECT * FROM TB_USER WHERE USER_ID = :userId AND PASSWORD = :password", nativeQuery = true)
    User login(@Param("userId") String userId, @Param("password") String password);

    User findByUserIdAndPassword(String userId, String password);

}
