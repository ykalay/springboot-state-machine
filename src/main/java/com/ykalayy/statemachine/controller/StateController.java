package com.ykalayy.statemachine.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykalayy.statemachine.resources.EventModel;
import com.ykalayy.statemachine.resources.Events;
import com.ykalayy.statemachine.resources.Machine;
import com.ykalayy.statemachine.resources.ResponseBase;
import com.ykalayy.statemachine.resources.States;
import com.ykalayy.statemachine.service.MachineService;

@RestController
@RequestMapping("/api/v1")
public class StateController {

	@Autowired
	MachineService machineService;
	
	@GetMapping("/create")
	public ResponseEntity<Machine> createMachine(){
		String id = String.valueOf(ThreadLocalRandom.current().nextLong(Integer.MAX_VALUE));
		Machine machine = new Machine();
		machine.setId(machineService.build(id).getId());
		return ResponseEntity.ok(machine);
	}
	
	@PostMapping("/doEvent/{id}")
	public ResponseEntity<ResponseBase> doEvent(@PathVariable(value = "id")String id,@RequestBody EventModel event){
		
		Machine machine = machineService.doEvent(id, event.getEvent());
		return ResponseEntity.ok(new ResponseBase(event.getEvent() + " is done for machine " + machine.getId(),machine.getId(),machine.getState().toString()));
	}
	
	@GetMapping("/machine/{id}")
	public ResponseEntity<ResponseBase> getCurrentState(@PathVariable(value= "id")String id){
		StateMachine<States,Events> stateMachine = machineService.getMachine(id);
		Machine machine = Machine.builder(stateMachine);
		return ResponseEntity.ok(new ResponseBase("Current state is "+ machine.getState().toString() +"for machine " + machine.getId(),machine.getId(),machine.getState().toString()));
	}
}
