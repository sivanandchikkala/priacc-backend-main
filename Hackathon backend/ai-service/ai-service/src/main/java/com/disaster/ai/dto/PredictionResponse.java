package com.disaster.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PredictionResponse {
    private Double riskScore;
    public PredictionResponse(Double riskScore2, String string) {
		// TODO Auto-generated constructor stub
	}
	public Double getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(Double riskScore) {
		this.riskScore = riskScore;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
}
