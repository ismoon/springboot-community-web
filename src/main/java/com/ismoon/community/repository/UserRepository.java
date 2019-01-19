package com.ismoon.community.repository;

import com.ismoon.community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ismoon on 2019-01-19
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
