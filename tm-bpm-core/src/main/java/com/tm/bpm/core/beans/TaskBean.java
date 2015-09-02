package com.tm.bpm.core.beans;

import java.sql.Timestamp;

public class TaskBean {

	private long taskId;
	private String taskName;
	private String taskDescription;
	private String taskStatus;
	private long processInstanceId;
	private String processName;
	private int taskPriority;
	private String taskOwner;
	private String taskCreatedBy;
	private Timestamp taskCreatedOn;
	private Timestamp taskCompletedOn;
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public long getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public int getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(int taskPriority) {
		this.taskPriority = taskPriority;
	}
	public String getTaskOwner() {
		return taskOwner;
	}
	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}
	public String getTaskCreatedBy() {
		return taskCreatedBy;
	}
	public void setTaskCreatedBy(String taskCreatedBy) {
		this.taskCreatedBy = taskCreatedBy;
	}
	public Timestamp getTaskCreatedOn() {
		return taskCreatedOn;
	}
	public void setTaskCreatedOn(Timestamp taskCreatedOn) {
		this.taskCreatedOn = taskCreatedOn;
	}
	public Timestamp getTaskCompletedOn() {
		return taskCompletedOn;
	}
	public void setTaskCompletedOn(Timestamp taskCompletedOn) {
		this.taskCompletedOn = taskCompletedOn;
	}
}
