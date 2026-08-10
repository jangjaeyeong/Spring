package com.kh.community.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.community.member.model.dto.MemberDTO;

@Controller
public class MemberController {

	@GetMapping("/member/join")
	public String joinForm() {
		
		return "member/join";
	}
	
	@PostMapping("/join") 
	public String join(@ModelAttribute MemberDTO member, MultipartFile profileImage) {
		System.out.println(member);
		System.out.println(profileImage);
		return "redirect:/member/join";
	}
}
