package com.kh.community.member.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

	private String memberId;
	private String memberPwd;
	private String memberName;
	private String nickname;
	private String email;
	private String profile;
	private LocalDateTime createAt;
	
	private String createAtStr;
}
