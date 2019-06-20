package com.validator.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.validator.beans.TextValidateResponse;
import com.validator.beans.TextValidateResponseCodes;
import com.validator.service.ValidatorService;


@RestController
public class TextValidateController {
	@Autowired
	private ValidatorService validatorService;

	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to Text validator Example.";
	}

	
	
	@RequestMapping(value = "/validateText", method = {RequestMethod.POST})
	public TextValidateResponse<String> addFavorites(@RequestBody Map<String, Object> requestData) {
		System.out.println("BingoLobbyController : addFavouriteRooms : requestData : "+ requestData);
		String text = (String)requestData.get("text");
		TextValidateResponse<String> res = new TextValidateResponse<String>();
		if(StringUtils.isEmpty(text.trim())) {
			res.setResult("Please provide valid String");
			res.setResponseCode(TextValidateResponseCodes.BAD_REQUEST.getCode());
			res.setResponseMessage(TextValidateResponseCodes.BAD_REQUEST.getMessage());
			return res;
		}
		
		if(!validatorService.validateText(text)) {
			res.setResult("Objectionable word are found");
			res.setResponseCode(TextValidateResponseCodes.OBJECTIONABLE_TEXT_FOUND.getCode());
			res.setResponseMessage(TextValidateResponseCodes.OBJECTIONABLE_TEXT_FOUND.getMessage());
			return res;
		}
		
		return res;
	}

	
}
