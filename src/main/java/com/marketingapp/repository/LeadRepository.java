package com.marketingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.entities.lead;


public interface LeadRepository extends JpaRepository<lead , Long> {

}
