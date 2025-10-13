package com.application.TicketingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.TicketingApp.entity.PhoneNumber;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

}
