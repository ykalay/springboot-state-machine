package com.ykalayy.statemachine.resources;

public class ResponseBase {

	private String message;
	
	private String machineId;
	
	private String currentState;
	
	public ResponseBase(){
		
	}
	
	public ResponseBase(String message, String machineId, String curretState){
		this.message = message;
		this.machineId = machineId;
		this.currentState = curretState;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
}
