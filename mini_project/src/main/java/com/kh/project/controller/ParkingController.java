package com.kh.project.controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.project.model.dto.InsertMemberDTO;
import com.kh.project.model.dto.ListDTO;
import com.kh.project.model.dto.MemberDTO;
import com.kh.project.model.service.ParkingService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequiredArgsConstructor
public class ParkingController {
	private final ParkingService service;
	
	@GetMapping("/")
	public String home() {
		return "home/index";
	}
	
	@GetMapping("/insert/member")
	public String insertMember() {
		return "";
	}
	
	@GetMapping("/parking-list")
	public String parkingList(Model model) {
		List<ListDTO> currentList = service.parkingList();
		model.addAttribute("currentList", currentList);
		return "management/parkingList";
	}
	
	@GetMapping("/member-list")
	public String memberList(Model model) {
		
		List<MemberDTO> memberList = service.getMemberList();
		model.addAttribute("memberList", memberList);
		return "management/memberList";
	}
	
	@GetMapping("/member-delete/{id}")
	public String memberDelete(@PathVariable("id") int id, RedirectAttributes rs) {
		
		String msg = service.deleteMember(id);
		rs.addFlashAttribute("message", msg);
		return "redirect:/member-list";
	}
	
	@GetMapping("/member-find/{id}")
	public String memberUpdate(@PathVariable("id") int id, Model model) {
		List<MemberDTO> memberInfo = service.findBy(id);
		model.addAttribute("memberInfo", memberInfo);
		return "management/findMemberInfo";
	}
	
	@GetMapping("/member-update")
	public String memberUpdate(@ModelAttribute MemberDTO member, RedirectAttributes rs) {
		String msg = service.updateMember(member);
		rs.addFlashAttribute("message", msg);
		return "redirect:/member-list";
	}
	
	@PostMapping("/member-insert")
	public String memberInsert(@ModelAttribute InsertMemberDTO member, RedirectAttributes rs) {
		String msg = service.insertMember(member);
		rs.addFlashAttribute("message", msg);
		return "redirect:/member-list";
	}
	
	@GetMapping("/parking-history")
	public String history(Model model) {
		List<ListDTO> history = service.parkingHistory();
		model.addAttribute("history",history);
		return "management/history";
	}
	
	@PostMapping("/exit")
	public String exit(@RequestParam String carNumber, RedirectAttributes rs) {
		String msg = service.exitCar(carNumber);
		rs.addFlashAttribute("message", msg);
		return "redirect:/parking-history";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam String carNumber, RedirectAttributes rs) {
		System.out.println("==============================" + carNumber);
		String msg = service.insertCar(carNumber);
		rs.addFlashAttribute("message", msg);
		return "redirect:/parking-list";
	}
	
}
