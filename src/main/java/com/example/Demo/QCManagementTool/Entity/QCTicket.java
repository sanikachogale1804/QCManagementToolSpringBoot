package com.example.Demo.QCManagementTool.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;
	
	@ManyToOne
	@JoinColumn(name = "camera_id")
	private Camera camera;
	
	@OneToMany(mappedBy = "qcTicket",cascade = CascadeType.ALL)
	private List<Validation> validations;

}
