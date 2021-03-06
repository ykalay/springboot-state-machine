package com.ykalayy.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Service;

import com.ykalayy.statemachine.resources.Events;
import com.ykalayy.statemachine.resources.States;

@Service
public class ActionB implements ActionBase{

	@Override
	public void execute(StateContext<States, Events> context) {
		System.out.println("Action-B is called for machine-" + context.getStateMachine().getId());
		
	}

}
