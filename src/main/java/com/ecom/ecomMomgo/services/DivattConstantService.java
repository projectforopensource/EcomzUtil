package com.ecom.ecomMomgo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.ecom.ecomMomgo.constants.DivattConstants;
import com.ecom.ecomMongo.repository.DivattConstantRepository;

@Service
public class DivattConstantService {

	@Autowired
	DivattConstantRepository constsntRepo;
	
	@Autowired
	SequenceGeneratorService generatorService;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void createConstants(DivattConstants cons)
	{
		
		List<DivattConstants> divCon=constsntRepo.findByConstId(cons.getConstId());
		if(divCon.isEmpty())
		{
			cons.setConstId((int) generatorService.generateSequence(DivattConstants.CONSTANT_SEQ_GENERATOR));
		constsntRepo.save(cons);
		}
		else {
			DivattConstants existingConstant=divCon.get(0);
			existingConstant.setConstType(cons.getConstType());
			existingConstant.setConstValue(cons.getConstValue());
			existingConstant.setCreatedBy(cons.getCreatedBy());
			existingConstant.setStatus(cons.getStatus());
			mongoTemplate.save(existingConstant);
		}
	}

	public List<DivattConstants> getAllConstants() {
		return constsntRepo.findAll();
	}

	public List<DivattConstants> getAllConstantsByType(String type) {
		
		List<DivattConstants> list=constsntRepo.findByConstType(type);
		return list.stream().filter(c->c.getStatus()==true).collect(Collectors.toList());
	}
	
	public void deleteConstant(DivattConstants con)
	{
	DivattConstants div=constsntRepo.findById(con.getConstId()).get();
		div.setStatus(false);
		constsntRepo.save(div);
		
	}
}
