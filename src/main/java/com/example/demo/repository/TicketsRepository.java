package com.example.demo.repository;

import com.example.demo.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, UUID> {
}
