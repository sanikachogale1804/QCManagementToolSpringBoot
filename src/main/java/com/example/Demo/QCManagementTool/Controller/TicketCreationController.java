package com.example.Demo.QCManagementTool.Controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demo.QCManagementTool.Entity.TicketCreation;
import com.example.Demo.QCManagementTool.Repository.TicketCreationRepository;
import com.example.Demo.QCManagementTool.Service.FileService;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;


import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = {
	    "http://localhost:3000"
	})
@RestController
public class TicketCreationController {
	
	@Value("${network.image.path}")
	private String imagePath;
	
	//product/{productId}/image
	//productRepo ka variable add karna hai yaha pe
	@Autowired
	private TicketCreationRepository ticketCreationRepository;
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("ticketCreation/{ticketCreationId}/image")
	   public ResponseEntity<String> uploadUserImage(@RequestParam("networkImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException, java.io.IOException {
	       String imageName = fileService.uploadFile(image, imagePath);
	        TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	        System.out.println("ImageName"+imageName);
	        ticketCreation.setNetworkImage(imageName);
	        ticketCreationRepository.save(ticketCreation);
	       return new ResponseEntity<String>("Successs",HttpStatus.ACCEPTED);
	   }
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/image")
	   public void serveUserImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws  java.io.IOException {
		   TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	       InputStream resource = fileService.getResource(imagePath, ticketCreation.getNetworkImage());
	       response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	       StreamUtils.copy(resource, response.getOutputStream());
	   }
	
	@PostMapping("ticketCreation/{ticketCreationId}/apnConfigImage")
	public ResponseEntity<String> uploadApnConfigImage(@RequestParam("apnConfigImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setApnConfigImage(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/apnConfigImage")
	public void serveApnConfigImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getApnConfigImage());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@PostMapping("ticketCreation/{ticketCreationId}/liveViewImage")
	public ResponseEntity<String> uploadliveViewImage(@RequestParam("liveViewImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setLiveViewImage(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/liveViewImage")
	public void serveLiveViewImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getLiveViewImage());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@PostMapping("ticketCreation/{ticketCreationId}/videoConfigImage")
	public ResponseEntity<String> uploadvideoConfigImage(@RequestParam("videoConfigImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setVideoConfigImage(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "ticketCreation/{ticketCreationId}/videoConfigImage")
	public void serveVideoConfigImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getVideoConfigImage());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@PostMapping("ticketCreation/{ticketCreationId}/ftpSettingsImage")
	public ResponseEntity<String> uploadftpSettingsImage(@RequestParam("ftpSettingsImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setFtpSettingsImage(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/ftpSettingsImage")
	public void serveFtpSettingsImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getFtpSettingsImage());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@PostMapping("ticketCreation/{ticketCreationId}/ntpSettingsImage")
	public ResponseEntity<String> uploadntpSettingsImage(@RequestParam("ntpSettingsImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setNtpSettingsImage(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/ntpSettingsImage")
	public void serveNtpSettingsImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getNtpSettingsImage());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@PostMapping("ticketCreation/{ticketCreationId}/playbackScreenshotImage")
	public ResponseEntity<String> uploadplaybackScreenshotImage(@RequestParam("playbackScreenshotImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setPlaybackScreenshot(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/playbackScreenshotImage")
	public void servePlaybackScreenshotImage(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getPlaybackScreenshot());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@PostMapping("ticketCreation/{ticketCreationId}/additionalImage")
	public ResponseEntity<String> uploadAdditionalImage(@RequestParam("additionalImage") MultipartFile image, @PathVariable Long ticketCreationId) throws IOException {
	    String imageName = fileService.uploadFile(image, imagePath);
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).get();
	    ticketCreation.setAdditionalImages(imageName);
	    ticketCreationRepository.save(ticketCreation);
	    return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "ticketCreation/{ticketCreationId}/additionalImage")
	public void serveAdditionalImages(@PathVariable Long ticketCreationId, HttpServletResponse response) throws IOException {
	    TicketCreation ticketCreation = ticketCreationRepository.findById(ticketCreationId).orElseThrow(() -> new RuntimeException("Ticket not found"));
	    InputStream resource = fileService.getResource(imagePath, ticketCreation.getAdditionalImages());
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    StreamUtils.copy(resource, response.getOutputStream());
	}
	
}
