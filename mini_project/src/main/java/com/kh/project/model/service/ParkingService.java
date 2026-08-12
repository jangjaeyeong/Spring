package com.kh.project.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.project.model.dto.ExitDTO;
import com.kh.project.model.dto.InsertMemberDTO;
import com.kh.project.model.dto.ListDTO;
import com.kh.project.model.dto.MemberDTO;
import com.kh.project.model.mapper.ParkingMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ParkingService {
	private final ParkingMapper mapper;
	
	public List<ListDTO> parkingList() {
		
		List<ListDTO> getList = mapper.getList(); 
		return getList;
	}
	
	public List<ListDTO> parkingHistory() {
		List<ListDTO> getHistory = mapper.history();
		System.out.println(getHistory);
		return getHistory;
	}
	
 	public List<MemberDTO> getMemberList() {
 		
 		List<MemberDTO> memberList = mapper.getMemberList();
 		return memberList;
 	}
 	
 	public String deleteMember(int id) {
 		int result = mapper.delMember(id);
 		if(result == 1) {
 			return "회원이 삭제되었습니다.";
 		}
 		return "회원 삭제에 실패했습니다.";
 	}
 	
 	public String insertMember(InsertMemberDTO dto) {
 		int result = 0;
 		try {
 			result = mapper.insMember(dto);
 		}catch(Exception e) {
 			e.printStackTrace();
 			return "이미 존재하는 차량 번호입니다.";
 		}
 		
 		
 		if(result == 1) {
 			return "월 회원으로 등록되었습니다.";
 		}
 		return "월 회원 등록에 실패했습니다.";
 	}
 	
 	public List<MemberDTO> findBy(int id) {
 		List<MemberDTO> member = mapper.findBy(id);
 		return member;
 	}
 	
 	public String updateMember(MemberDTO member) {
 		int result = 0;
 		try {
 			result = mapper.modifyMember(member);
 		}catch(Exception e) {
 			return "회원으로 존재하는 차량 번호입니다.";
 		}
 		
 		
 		if(result == 1) {
 			return "회원 정보가 수정되었습니다.";
 		}
 		return "회원 정보 수정에 실패했습니다.";
 	
 	}
 	
 	public String exitCar(String carNumber) {
 		boolean isTrue = false;
 		List<ListDTO> list = mapper.getList();
 		for(ListDTO li : list) {
 			if(carNumber.equals(li.getCarNumber())) {
 				isTrue = true;
 				break;
 			}else {
 				isTrue = false;
 			}
 		}
 		if(isTrue == false) {
 			return "출차 처리가 완료된 차량입니다. 관리자에게 문의해주세요";
 		}
 		
 		LocalDateTime enterTime = mapper.exitEnterTime(carNumber);
 		FeeCalculator feeCal = new FeeCalculator();
 		int fee = 0;
 		int result = 0;
 		String check = mapper.memberCheck(carNumber);
 		if(check == null) {
 			if(enterTime == null) {
 				return "입차 기록이 없습니다.";
 			}
 			fee = feeCal.calculatorFee(enterTime);
 		}
 		
 		ExitDTO exitDto = new ExitDTO(fee, carNumber);
 		
 			mapper.updateExitTime(exitDto);
 	 		result++;
 	 		mapper.delVehicle(carNumber);
 	 		result++;
 		
 		if(result == 2) {
 			return "안녕히 가십시오. 주차요금: " + fee;
 		}else {
 			return "입차 기록이 없습니다.";
 		}
 	}
 	
 	public String insertCar(String carNumber) {
 		int result = 0;
 		String check = null;
 		try {
 			mapper.insVehicle(carNumber);
 	 		result++;
 	 		mapper.insRecord(carNumber);
 	 		result ++;
 		}catch(Exception e) {
 			return "입차 처리가 완료된 차량입니다. 관리자에게 문의해주세요";
 		}
 		try {
 			check = mapper.memberCheck(carNumber);
 		}catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
		}
 		
 		System.out.println("check:: ======= " + check);
 		
 		if(result == 2) {
 			if(check != null) {
 				return "(등록차량) 환영합니다.";
 			}else {
 				return "(방문차량) 환영합니다.";
 			}
 		}else {
 			return "입차가 불가합니다. 관리자에게 문의해주세요.";
 		}
 	}
 }
