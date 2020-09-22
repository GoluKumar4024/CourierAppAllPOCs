package com.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.data.mongodb.core.query.Update;

import com.example.rest.model.DataBaseSequence;

@Service
public class DataBaseSequenceService {

	private MongoOperations mongoOperations;

	@Autowired
	public DataBaseSequenceService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public long generateSequence(String seqName) {
		DataBaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DataBaseSequence.class);

		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

}
