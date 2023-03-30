package com.ismt.cybersecurity.register.repository;

import com.ismt.cybersecurity.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("From User u where u.username=:username and u.password=:password")
    List<User> getLogin(@Param("username") String username, @Param("password") String password);

    List<User> findByUsername(String username);
}
