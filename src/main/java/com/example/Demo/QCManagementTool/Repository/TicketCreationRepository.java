package com.example.Demo.QCManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Demo.QCManagementTool.Entity.TicketCreation;

@RestResource(path = "ticketCreation")
@CrossOrigin
public interface TicketCreationRepository extends JpaRepository<TicketCreation, Long>{

}
