package com.ecom.ecomMomgo.services;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.ecom.ecomMongo.model.DataBaseSequence;

@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;
	
	public long generateSequence(String seqName) {
	    DataBaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	      new Update().inc("seq",1), options().returnNew(true).upsert(true),
	      DataBaseSequence.class);
	    return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
}
