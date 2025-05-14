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
public class TicketCreation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	
	private String iasspName;
	
	private String siteId; 
	
	private String cameraId1;
	
	private String cameraId2;
	
	private String ipAddress1;
	
	private String ipAddress2;
	
	private String simIccid;
	
	private String simCarrier;
	
	private String simStatus;

}
