package com.yummyrestaurant.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {

	@GetMapping("/gallery")
	public String galleryPage(Model model) {

		String[] imgNames = new File("src/main/resources/static/assets/img/gallery").list();
		model.addAttribute("imgList", imgNames);

		return "gallery";
	}

	@GetMapping("/upload")
	public String uploadImagePage() {
		return "uploadImage";
	}
	
	@PostMapping("/upload")
	public String uploadImage(@RequestParam("image") MultipartFile img, Model model) {
		
		if(!img.isEmpty()) {
			try {
				int min = 1;  
				int max = 99; 
				
				String rename = "gallery-"+(int)(Math.random()*(max-min+1)+min)+".jpg";
//				String rename = img.getOriginalFilename();
				
				Files.copy(img.getInputStream(), Path.of("src/main/resources/static/assets/img/gallery/"+rename), StandardCopyOption.REPLACE_EXISTING);
				model.addAttribute("message", "upload successfully");
				return"uploadImage";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("error", "upload failed!");
		return "uploadImage";
	}

}
