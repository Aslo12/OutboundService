package com.example.OutboundService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OutboundService.entity.GRNRequest;

public interface GRNRequestRepository extends JpaRepository<GRNRequest, Long> {
	

}
