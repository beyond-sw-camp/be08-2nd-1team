package com.beyond.kkwoborrow.alarm.repository;

import com.beyond.kkwoborrow.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    List<Alarm> findByReservation_ReserveId(Long reserveId);
    void delete(Alarm alarm);
}
