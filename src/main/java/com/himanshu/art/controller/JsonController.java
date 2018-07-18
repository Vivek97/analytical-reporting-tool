package com.himanshu.art.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himanshu.art.service.JsonService;

@Controller
public class JsonController {
	
	@Autowired
	private JsonService jsonService;
	
	@RequestMapping("/features")
	public String features(Model model) {
	    model.addAttribute("element",jsonService.getAllElements());
		return "features";
	}
	
	@RequestMapping("/elements")
	public String elements() {
		return "elements";
	}
	
	@RequestMapping("/steps")
	public String steps() {
		return "steps";
	}

	@RequestMapping("/jsonbuild")
	public String jsonbuild() {
		return "jsonbuild";
	}
	
	@RequestMapping("/jsontest")
	public String jsontest() {
		return "jsontest";
	}

	@RequestMapping("/jsondashboard")
	public String jsondashboard() {
		return "jsondashboard";
	}

}
