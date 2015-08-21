package com.tm.util.db;

import java.sql.Connection;
import java.util.List;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;

public class LiquibaseUtils {

	public static void runScripts(Connection conn, List<String> scripts) throws LiquibaseException {
        Liquibase liquibase = null;
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
        
        for(String script : scripts) {
        	liquibase = new Liquibase(script, new FileSystemResourceAccessor(), database);
        	liquibase.update(new String());
        }
	}
}
