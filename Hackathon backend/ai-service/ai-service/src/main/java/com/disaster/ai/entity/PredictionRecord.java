package com.disaster.ai.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prediction_records")
public class PredictionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getInputPayload() {
		return inputPayload;
	}
	public void setInputPayload(String inputPayload) {
		this.inputPayload = inputPayload;
	}
	public Double getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(Double riskScore) {
		this.riskScore = riskScore;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	private String model;
    private String inputPayload;
    private Double riskScore;
    private LocalDateTime createdAt = LocalDateTime.now();

//	public static Object builder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
