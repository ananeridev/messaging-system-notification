package com.anabneri.messagingsystem.notfication.repository;

import com.anabneri.messagingsystem.notfication.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Optional<Status> findByName(String name);
}
