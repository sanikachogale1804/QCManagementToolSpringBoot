package com.example.Demo.QCManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.Demo.QCManagementTool.Entity.QCTicket;

@RestResource(path = "qcTickets")
public interface QCTicketRepository extends JpaRepository<QCTicket, Long>{

}
