package com.ecom.ecomMongo.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "database_sequences")
public class DataBaseSequence {

    @Id
    private String id;

    private long seq;

  
}