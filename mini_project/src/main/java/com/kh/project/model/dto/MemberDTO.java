package com.kh.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberDTO {
	private int id;
	private String carNumber;
	private String expireDate;
	private String cellphone;
	private String name;
}
