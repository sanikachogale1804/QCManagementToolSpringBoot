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
public class Validation {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long validationId;
	
	@Column(nullable = false)
	private String pingResult;
	
	@Column(nullable = false)
	private String apnImageUrl;
	
	@Column(nullable = false)
	private String liveViewUrl;
	
}
