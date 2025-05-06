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
public class Site {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
	
	@Column(nullable = false)
	private Long siteId;

    @Column(nullable = false)
    private String iasspName;

    @Column(nullable = false)
    private String location;
    
    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private List<Camera> cameras;
    
    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private List<QCTicket> qcTickets;

}
