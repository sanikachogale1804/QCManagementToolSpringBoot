package com.example.Demo.QCManagementTool.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	
	private String pingResponseTime;
	
	@Lob
	private String networkImage;

	private String apnConfigImage;
	
	private String apnConfigStatus; // "Correct" or "Incorrect"

	@Lob
    private String liveViewImage;

    private String liveViewQuality;

    @Lob
    private String videoConfigImage;
    
    private String resolution;
    
//  FTP Configuration
    @Lob
    private String ftpSettingsImage;
    
//  NTP Configuration
    private String ntpSettingsImage;
    
    // SD Card Status
    private String sdCardStoragePercentage; 
    
    private String playbackScreenshot;
    
    // ✅ Final Submission
    private String finalStatus; 
    
    @Lob
    private String finalRemarks;
    
    @Lob
    private String additionalImages;
    
}
