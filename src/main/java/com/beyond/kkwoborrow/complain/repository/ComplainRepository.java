package com.beyond.kkwoborrow.complain.repository;

import com.beyond.kkwoborrow.complain.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends JpaRepository<Complain, Long> {
}
