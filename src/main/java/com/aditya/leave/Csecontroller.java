package com.aditya.leave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Csecontroller {
	@Autowired
	CseRepo repo;

	@RequestMapping("/form")
	public String cseform(Model model) {
		CseEntity info = new CseEntity();
		model.addAttribute("cseform", info);
		return "form";
	}
	
	@RequestMapping(path= "/register", method=RequestMethod.POST)
	public String savedata(@ModelAttribute("cseform") CseEntity cseform) {
		repo.save(cseform);
		return "redirect:/cse/display";
	}
	
	@GetMapping("/cse/display")
	public String displaydata(Model model) {
		List<CseEntity> data = (List<CseEntity>) repo.findAll();
		model.addAttribute("info", data);
		return "display";
	}
}
