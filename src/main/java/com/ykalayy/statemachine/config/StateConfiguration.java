package com.ykalayy.statemachine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.ykalayy.statemachine.action.ActionBase;
import com.ykalayy.statemachine.resources.Events;
import com.ykalayy.statemachine.resources.States;

@Configuration
@EnableStateMachineFactory
public class StateConfiguration extends StateMachineConfigurerAdapter<States, Events> {

	@Autowired
	ActionBase actionA;
	
	@Autowired
	ActionBase actionB;
	
	@Autowired
	ActionBase actionC;
	
	@Override
	public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
		transitions
			.withExternal()
				.source(States.A).target(States.B).event(Events.E1)
			.and()
			.withExternal()
				.source(States.B).target(States.C).event(Events.E2)
			.and()
			.withExternal()
				.source(States.C).target(States.A).event(Events.E3)
			.and()
			.withExternal()
				.source(States.A).target(States.C).event(Events.E4)
			.and()
			.withExternal()
				.source(States.C).target(States.B).event(Events.E5)
			.and()
			.withExternal()
				.source(States.B).target(States.A).event(Events.E6);
	}
	
	public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
		states.withStates()
			.initial(States.A).stateEntry(States.A, actionA)
			.state(States.B).stateEntry(States.B, actionB)
			.state(States.C).stateEntry(States.C, actionC);
	}

}
