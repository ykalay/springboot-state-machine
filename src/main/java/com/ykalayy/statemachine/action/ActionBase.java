package com.ykalayy.statemachine.action;

import org.springframework.statemachine.action.Action;

import com.ykalayy.statemachine.resources.Events;
import com.ykalayy.statemachine.resources.States;


public interface ActionBase extends Action<States,Events>{

}
