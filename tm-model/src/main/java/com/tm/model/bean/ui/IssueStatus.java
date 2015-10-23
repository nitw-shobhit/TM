package com.tm.model.bean.ui;

import java.util.HashMap;
import java.util.Map;

public enum IssueStatus {

	OPEN(34, 79, 292, 77), ACCEPTED(33, 65, 148, 224), REJECTED(33, 72, 292, 395),
	CANCELLED(0, 0, 0, 0), FIXED(33, 72, 148, 395), REOPENED(33, 80, 220, 597),
	COMPLETED(33, 79, 148, 644);
	
	private IssueStatus(int height, int width, int top, int left) {
		this.height = height;
		this.width = width;
		this.top = top;
		this.left = left;
	}
	
	private int height;
	private int width;
	private int top;
	private int left;
	
	public Map<String, Integer> getCoordinates() {
		Map<String, Integer> coordinatesMap = new HashMap<String, Integer>();
		coordinatesMap.put("height", this.height);
		coordinatesMap.put("width", this.width);
		coordinatesMap.put("top", this.top);
		coordinatesMap.put("left", this.left);
		
		return coordinatesMap;
	}
}
