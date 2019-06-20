package com.validator.beans;

public enum TextValidateResponseCodes {
	 SUCCESS(0, "VALID_TEXT"),
	  INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR"),
	  BAD_REQUEST(101, "BAD_REQUEST"),
	  OBJECTIONABLE_TEXT_FOUND(102,"OBJECTIONABLE_TEXT_FOUND");

	    int code;
	    private String message;

	    private TextValidateResponseCodes(int code, String message) {
	        this.code = code;
	        this.message = message;
	    }

	    public int getCode() {
	        return code;
	    }

	    public String getMessage() {
	        return message;
	    }
}
