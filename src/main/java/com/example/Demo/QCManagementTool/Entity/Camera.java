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
public class Camera {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
	
	@Column(nullable = false)
	private Long cameraId;
	
	@Column(nullable = false)
	private String ip;
	
	@Column(nullable = false)
	private String simIccid;
	
	@Column(nullable = false)
	private String simStatus;
	
	

}
