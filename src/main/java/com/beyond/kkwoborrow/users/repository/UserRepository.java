package com.beyond.kkwoborrow.users.repository;

import com.beyond.kkwoborrow.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
