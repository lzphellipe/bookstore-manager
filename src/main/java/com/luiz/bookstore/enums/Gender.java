package com.luiz.bookstore.enums;

public enum Gender {

	MALE(1, "Male"), FEMALE(2, "Female");

	private Integer code;
	private String description;

	private Gender(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static Gender toEnum(Integer code) {
		if(code == null)
			return null;
		
		for(Gender x : Gender.values()) {
			if(x.getCode().equals(code)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Inválid code" + code);
	}

}
 