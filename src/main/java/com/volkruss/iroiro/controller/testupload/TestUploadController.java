package com.volkruss.iroiro.controller.testupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestUploadController {

	@PostMapping("/upload")
	public ModelAndView testFileUpdate(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		return new ModelAndView();
	}
}