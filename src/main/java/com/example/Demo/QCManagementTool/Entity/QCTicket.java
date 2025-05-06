package com.example.Demo.QCManagementTool.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QCTicket {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	@Column(nullable = false)
	private String qcAgent;
	
	@Column(nullable = false)
	private String submissionTime;
	
	@Column(nullable = false)
	private String status; 

}
