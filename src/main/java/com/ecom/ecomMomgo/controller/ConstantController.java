package com.ecom.ecomMomgo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecomMomgo.constants.DivattConstants;
import com.ecom.ecomMomgo.services.DivattConstantService;

@RestController
@RequestMapping("/v1")
public class ConstantController {

	@Autowired
	DivattConstantService constantService;
	
	@PostMapping("/addConstant")
	public void addConstant(@RequestBody DivattConstants con)
	{
		constantService.createConstants(con);
	}
	
	@GetMapping("/getAllConstant")
	public List<DivattConstants> getAllConstant()
	{
		return constantService.getAllConstants();
		
	}
	
	@GetMapping("/getAllConstantByType/{type}")
	public List<DivattConstants> getAllConstantByType(@PathVariable String type)
	{
		return constantService.getAllConstantsByType(type);
		
	}
}
