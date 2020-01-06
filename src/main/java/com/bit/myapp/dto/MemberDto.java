package com.bit.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter // lombok library 활용
public class MemberDto {

	private String id;
	private String pwd;
	private String name;
	private String email;
}
