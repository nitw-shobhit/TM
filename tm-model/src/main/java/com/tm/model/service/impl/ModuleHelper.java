package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.bean.ModuleBean;
import com.tm.core.bean.ModuleStatus;

public class ModuleHelper {

	public static List<ModuleBean> createDefaultModuleEntities(long projectId) {
		ModuleBean module1 = new ModuleBean();
		module1.setProjId(projectId);
		module1.setModName("Unit Testing");
		module1.setModDesc("Auto generated unit testing module. Used by the functional testers to log unit testing issues.");
		module1.setModStatus(ModuleStatus.STARTED.toString());
		
		ModuleBean module2 = new ModuleBean();
		module2.setProjId(projectId);
		module2.setModName("System Integration Testing");
		module2.setModDesc("Auto generated system integration testing module. Used by the functional testers to log system integration testing issues.");
		module2.setModStatus(ModuleStatus.STARTED.toString());
		
		ModuleBean module3 = new ModuleBean();
		module3.setProjId(projectId);
		module3.setModName("User Acceptance Testing");
		module3.setModDesc("Auto generated user acceptance testing module. Used by the functional testers to log user acceptance testing issues.");
		module3.setModStatus(ModuleStatus.STARTED.toString());
		
		List<ModuleBean> defaultModules = new ArrayList<ModuleBean>();
		defaultModules.add(module1);
		defaultModules.add(module2);
		defaultModules.add(module3);
		
		return defaultModules;
	}
}
