package com.beyond.kkwoborrow.alarm.repository;

import com.beyond.kkwoborrow.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
