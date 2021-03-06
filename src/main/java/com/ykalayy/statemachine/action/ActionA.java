package com.ykalayy.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Service;

import com.ykalayy.statemachine.resources.Events;
import com.ykalayy.statemachine.resources.States;

@Service
public class ActionA implements ActionBase{

	@Override
	public void execute(StateContext<States, Events> context) {
		System.out.println("Action-A is called for machine-" + context.getStateMachine().getId());
		
	}

}
