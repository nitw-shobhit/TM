package com.tm.model.service.helper;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.bean.ModuleStatus;
import com.tm.core.entity.TmModule;

public class ModuleHelper {

	public static List<TmModule> createDefaultModuleEntities(long projectId) {
		TmModule module1 = new TmModule();
		module1.setProjId(projectId);
		module1.setModName("Unit Testing");
		module1.setModDesc("Auto generated unit testing module. Used by the functional testers to log unit testing issues.");
		module1.setModStatus(ModuleStatus.STARTED.toString());
		
		TmModule module2 = new TmModule();
		module2.setProjId(projectId);
		module2.setModName("System Integration Testing");
		module2.setModDesc("Auto generated system integration testing module. Used by the functional testers to log system integration testing issues.");
		module2.setModStatus(ModuleStatus.STARTED.toString());
		
		TmModule module3 = new TmModule();
		module3.setProjId(projectId);
		module3.setModName("User Acceptance Testing");
		module3.setModDesc("Auto generated user acceptance testing module. Used by the functional testers to log user acceptance testing issues.");
		module3.setModStatus(ModuleStatus.STARTED.toString());
		
		List<TmModule> defaultModules = new ArrayList<TmModule>();
		defaultModules.add(module1);
		defaultModules.add(module2);
		defaultModules.add(module3);
		
		return defaultModules;
	}
}
