package com.ykalayy.statemachine.resources;

import org.springframework.statemachine.StateMachine;

public class Machine {

	private String id;
	
	private States state;
	
	public Machine() {
		//initial state
		state = state.A;
	}
	
	public static Machine builder(StateMachine<States,Events> stateMachine) {
		return new Machine(stateMachine.getId(),States.valueOf(stateMachine.getState().getId().name()));
	}

	public Machine(String id, States state) {
		super();
		this.id = id;
		this.state = state;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
}
