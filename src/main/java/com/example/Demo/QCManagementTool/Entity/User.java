package com.example.Demo.QCManagementTool.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int userId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String userPassword;
	
	@Column(nullable = false)
	private String userEmail;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	private String loginHistory;
	
	public enum UserRole {
	    QC,
	    ADMIN
	}
	
}
