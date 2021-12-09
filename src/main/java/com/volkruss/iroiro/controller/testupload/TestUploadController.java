package com.volkruss.iroiro.controller.testupload;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.volkruss.iroiro.domain.dto.item.Item;
import com.volkruss.iroiro.domain.repository.item.ItemRepository;

@Controller
public class TestUploadController {
	
	@Autowired
	private ItemRepository itemRepository;

	@PostMapping("/upload")
	public ModelAndView testFileUpdate(@RequestParam("file") MultipartFile file) {
		
		Item item = new Item();
		
		item.setName(file.getOriginalFilename());
		try {
			item.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		itemRepository.save(item);

		return new ModelAndView();
	}
	
	
	@GetMapping("/all")
	public String showItems(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items",items);
		return "modules/item/all.html";
	}
	
}