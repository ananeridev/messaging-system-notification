package com.anabneri.messagingsystem.notfication.repository;

import com.anabneri.messagingsystem.notfication.model.HistoryEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryEventRepository extends JpaRepository<HistoryEvent, Integer> {
}
