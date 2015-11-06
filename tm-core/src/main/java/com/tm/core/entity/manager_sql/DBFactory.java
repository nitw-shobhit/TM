package com.tm.core.entity.manager_sql;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import liquibase.exception.LiquibaseException;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

import com.tm.util.db.LiquibaseUtils;

public class DBFactory {

	private static final List<String> DB_SCRIPTS = Arrays.asList("/db-bps_core/bps_user_info.xml",
										"/db-bps_core/bps_logs.xml", "/db-bps_core/bps_process.xml", "/db-bps_core/bps_organization.xml",
										"/db-bps_core/bps_process_ver.xml", "/db-bps_core/bps_org_proc.xml", "/db-bps_core/bps_proc_templ.xml");
	
	public static void generateOrUpdateDB() throws LiquibaseException {
		LiquibaseUtils.runScripts(getConnection(), DB_SCRIPTS);
	}
	
	private static Connection getConnection() {
		SessionImpl hibernateSession = (SessionImpl)EntityManagerFactory.createEntityManager().unwrap(Session.class);
		return hibernateSession.connection();
	}
}
