package com.ykalayy.statemachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

import com.ykalayy.statemachine.resources.Events;
import com.ykalayy.statemachine.resources.Machine;
import com.ykalayy.statemachine.resources.ResponseBase;
import com.ykalayy.statemachine.resources.States;

@Service
public class MachineService {

	@Autowired
	StateMachineFactory<States, Events> factory;
	Map<String, StateMachine<States, Events>> stateMachineMap;

	MachineService() {
		stateMachineMap = new HashMap<String, StateMachine<States, Events>>();
	}

	public StateMachine<States, Events> build(String id) {
		StateMachine<States, Events> machine = factory.getStateMachine(id);
		machine.start();
		stateMachineMap.put(id, machine);
		// printMap();
		return machine;
	}

	private void printMap() {
		stateMachineMap.forEach((k, v) -> System.out.println("key :" + k + " value :" + v));

	}

	public Machine doEvent(String id, Events event) {

		// printMap();
		StateMachine<States, Events> machine = getMachine(id);
		machine.sendEvent(event);
		return new Machine(machine.getId(), States.valueOf(machine.getState().getId().name()));

	}

	public StateMachine<States, Events> getMachine(String id) {

		StateMachine<States, Events> machine = stateMachineMap.get(id);

		return machine;

	}
}
