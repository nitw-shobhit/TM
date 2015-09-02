package com.tm.bpm.core;

import java.util.List;
import java.util.Map;

import javax.persistence.Persistence;

import org.jbpm.runtime.manager.impl.RuntimeEnvironmentBuilder;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.task.TaskService;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.kie.internal.task.api.UserGroupCallback;

import com.tm.util.exceptions.BpmException;

public class BpmConfig {
	
	private static RuntimeManager runtimeManager;
	private static RuntimeEngine runtime;
	private static KieSession ksession;
	
	public static RuntimeManager singletonRuntimeManager(List<String> processList, Map<String, String> userList) throws BpmException {
		UserGroupCallback userGroupCallback = new BpmUserGroupCallbackImpl(userList);
		RuntimeEnvironmentBuilder builder = RuntimeEnvironmentBuilder.getDefault()
	        	.entityManagerFactory(Persistence.createEntityManagerFactory("org.jbpm.domain"))
	            .userGroupCallback(userGroupCallback);
		for(String processName : processList) {
			builder.addAsset(ResourceFactory.newClassPathResource("flows/"+ processName + ".bpmn"), ResourceType.BPMN2);
		}
		RuntimeEnvironment environment = builder.get();
        runtimeManager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);
        return runtimeManager;
	}
	
	public static KieSession getSingletonSession( ){
		runtime = runtimeManager.getRuntimeEngine(EmptyContext.get());  
		ksession = runtime.getKieSession();
		return ksession;
	}
	
	public static TaskService getTaskService(){
		return runtime.getTaskService();
	}
}
