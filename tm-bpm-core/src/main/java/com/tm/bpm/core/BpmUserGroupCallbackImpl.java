package com.tm.bpm.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.kie.internal.task.api.UserGroupCallback;

import com.tm.util.exceptions.BpmException;

public class BpmUserGroupCallbackImpl implements UserGroupCallback {

	private Map<String, List<String>> groupStore = new HashMap<String, List<String>>();
	private Set<String> allGroups = new HashSet<String>();
	
	public BpmUserGroupCallbackImpl(Map<String, String> userGroups) throws BpmException {
		init(userGroups);
	}
	
	protected void init(Map<String, String> userGroups) throws BpmException {
		if (userGroups == null) {
			throw new BpmException("Did not recieve user list");
		}

		Iterator<Entry<String, String>> iter = userGroups.entrySet().iterator();
		
		while (iter.hasNext()) {
			String userId = iter.next().getKey();
			String groupId = iter.next().getValue();
			allGroups.add(groupId);
			List<String> temp;
			if(groupStore.containsKey(groupId)) {
				temp = groupStore.get(groupId);
			} else {
				temp = new ArrayList<String>();
			}
			temp.add(userId);
			groupStore.put(groupId, temp);
		}
		
		if (!groupStore.containsKey("Administrator")) {
			groupStore.put("Administrator", Collections.singletonList("Administrators"));
			allGroups.add("Administrators");
		}
	}
	
	@Override
	public boolean existsUser(String userId) {
		return groupStore.containsKey(userId);
	}

	@Override
	public boolean existsGroup(String groupId) {
		return allGroups.contains(groupId);
	}

	@Override
	public List<String> getGroupsForUser(String userId, List<String> groupIds,
			List<String> allExistingGroupIds) {
		List<String> groups = groupStore.get(userId);
		if( groups == null ) { 
		    groups = new ArrayList<String>(0);
		}
		return groups;
	}
}
