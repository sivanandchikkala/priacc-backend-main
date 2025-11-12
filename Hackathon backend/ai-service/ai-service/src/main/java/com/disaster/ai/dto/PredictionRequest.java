package com.disaster.ai.dto;

import lombok.Data;

@Data
public class PredictionRequest {
    private String model;    // "flood", "earthquake", etc.
    public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public Double getRainfall() {
		return rainfall;
	}
	public void setRainfall(Double rainfall) {
		this.rainfall = rainfall;
	}
	private String location;
    private Double temperature;
    private Double humidity;
    private Double rainfall;
}
