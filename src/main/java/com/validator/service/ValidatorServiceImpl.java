package com.validator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Service
public class ValidatorServiceImpl implements ValidatorService{

	@Autowired
    private Environment environment;
	@Override
	public boolean validateText(String text) {
		String wordsString = environment.getProperty("objectionable.words");
		String[] objectionalWords = wordsString.split(",");
		
		for(String s:objectionalWords) {
			if(text.contains(s)) {
				return false;
			}
		}
		return true;
	}

}
