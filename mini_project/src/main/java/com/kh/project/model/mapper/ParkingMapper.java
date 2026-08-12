package com.kh.project.model.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.project.model.dto.ExitDTO;
import com.kh.project.model.dto.InsertMemberDTO;
import com.kh.project.model.dto.ListDTO;
import com.kh.project.model.dto.MemberDTO;

@Mapper
public interface ParkingMapper {
	List<ListDTO> getList();
	List<ListDTO> history();
	List<MemberDTO> getMemberList();
	List<MemberDTO> findBy(int id);
	 int delMember(int id);
	 int insMember(InsertMemberDTO dto);
	 int modifyMember(MemberDTO dto);
	 
	 String memberCheck(@Param("carNumber")String carNumber);
	 int insVehicle(@Param("carNumber")String carNumber);
	 int insRecord(@Param("carNumber")String carNumber);
	 
	 LocalDateTime exitEnterTime(@Param("carNumber")String carNumber);
	 int updateExitTime(ExitDTO dto);
	 int delVehicle(@Param("carNumber")String carNumber);
}
