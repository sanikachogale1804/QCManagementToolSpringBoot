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

}
