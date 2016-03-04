package com.tm.core.entity;


public class LoggerBean implements BaseBean {

	private long id;
	
	private String log_level;
	
	private String log_logger;
	
	private String log_message;
	
	private String log_signed_user;
	
	private String log_ip_address;
	
	private String dt_created;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLog_level() {
		return log_level;
	}

	public void setLog_level(String log_level) {
		this.log_level = log_level;
	}

	public String getLog_logger() {
		return log_logger;
	}

	public void setLog_logger(String log_logger) {
		this.log_logger = log_logger;
	}

	public String getLog_message() {
		return log_message;
	}

	public void setLog_message(String log_message) {
		this.log_message = log_message;
	}

	public String getLog_signed_user() {
		return log_signed_user;
	}

	public void setLog_signed_user(String log_signed_user) {
		this.log_signed_user = log_signed_user;
	}

	public String getLog_ip_address() {
		return log_ip_address;
	}

	public void setLog_ip_address(String log_ip_address) {
		this.log_ip_address = log_ip_address;
	}

	public String getDt_created() {
		return dt_created;
	}

	public void setDt_created(String dt_created) {
		this.dt_created = dt_created;
	}

	@Override
	public String getEntityName() {
		return "tm_log";
	}

	@Override
	public String getSchemaName() {
		return "tm_internal";
	}
}
