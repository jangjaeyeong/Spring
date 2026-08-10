package com.kh.project.model.service;

import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {
	LocalDateTime enterTime;
	private int baseFee = 3000;
	private int unitTime;
	private int unitFee;
	
	
	public int calculatorFee(LocalDateTime enterTime) {
		this.enterTime = enterTime;
		unitTime = (int)Duration.between(enterTime, LocalDateTime.now().plusHours(2)).toMinutes();
		if(unitTime >= 60) {
			unitFee = (unitTime - 60) / 30;
			return baseFee + (unitFee*500);
			
		}else if(unitTime > 5){
			return baseFee;
			
		}else {
			return 0;
		}
	}
}
