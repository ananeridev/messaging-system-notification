package com.anabneri.messagingsystem.notfication.repository;

import com.anabneri.messagingsystem.notfication.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {
}
