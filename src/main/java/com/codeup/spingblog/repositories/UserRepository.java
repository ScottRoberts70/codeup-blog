package com.codeup.spingblog.repositories;

import com.codeup.spingblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);;
}
