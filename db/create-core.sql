Create table TM_USER_INFO (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	USER_ID VARCHAR(15) NOT NULL UNIQUE,
	USER_PASS VARCHAR(15) NOT NULL,
	USER_TYPE VARCHAR(20) NOT NULL,
	USER_NAME VARCHAR(50) NOT NULL,
	USER_EMAIL VARCHAR(100) NOT NULL UNIQUE,
	USER_PHONE VARCHAR(20),
	USER_GROUP_ID VARCHAR(15),
	USER_IMAGE BLOB,
	DT_CREATED TIMESTAMP NOT NULL,
	DT_MODIFIED TIMESTAMP,
	VISIBLE BOOLEAN NOT NULL
);
Create table TM_PROJECT (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	PROJ_NAME VARCHAR(50) NOT NULL,
	PROJ_DESC VARCHAR(1000) NOT NULL,
	PROJ_OWNER BIGINT NOT NULL,
	DT_CREATED TIMESTAMP NOT NULL,
	DT_MODIFIED TIMESTAMP,
	VISIBLE BOOLEAN NOT NULL,
	FOREIGN KEY(PROJ_OWNER) REFERENCES TM_USER_INFO(ID)
);
Create table TM_USER_PROJECT (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	PROJ_ID BIGINT NOT NULL,
	USER_ID BIGINT NOT NULL,
	FOREIGN KEY(USER_ID) REFERENCES TM_USER_INFO(ID),
	FOREIGN KEY(PROJ_ID) REFERENCES TM_PROJECT(ID)
);
Create table TM_MODULE (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	MOD_NAME VARCHAR(50) NOT NULL,
	PROJ_ID BIGINT NOT NULL,
	MOD_DESC VARCHAR(1000) NOT NULL,
	MOD_STATUS VARCHAR(15) NOT NULL,
	DT_CREATED TIMESTAMP NOT NULL,
	DT_MODIFIED TIMESTAMP,
	VISIBLE BOOLEAN NOT NULL,
	FOREIGN KEY(PROJ_ID) REFERENCES TM_PROJECT(ID)
);
Create table TM_ISSUE (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	MOD_ID BIGINT NOT NULL,
	ISS_NAME VARCHAR(50) NOT NULL,
	ISS_DESC VARCHAR(1000) NOT NULL,
	ISS_STATUS VARCHAR(20) NOT NULL,
	ISS_PRIORITY VARCHAR(6) NOT NULL,
	ISS_OWNER BIGINT NOT NULL,
	USER_ID BIGINT NOT NULL,
	DT_CREATED TIMESTAMP NOT NULL,
	DT_MODIFIED TIMESTAMP,
	VISIBLE BOOLEAN NOT NULL,
	FOREIGN KEY(MOD_ID) REFERENCES TM_MODULE(ID),
	FOREIGN KEY(USER_ID) REFERENCES TM_USER_INFO(ID),
	FOREIGN KEY(ISS_OWNER) REFERENCES TM_USER_INFO(ID)
); 
Create table TM_ISSUE_COMMENT (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	ISS_ID BIGINT NOT NULL,
	COM_CONTENT VARCHAR(1000) NOT NULL,
  	USER_ID BIGINT NOT NULL,
  	DT_CREATED TIMESTAMP NOT NULL,
	DT_MODIFIED TIMESTAMP,
	VISIBLE BOOLEAN NOT NULL,
	FOREIGN KEY(ISS_ID) REFERENCES TM_ISSUE(ID),
  	FOREIGN KEY(USER_ID) REFERENCES TM_USER_INFO(ID)
);
Create table TM_ISSUE_ATTACHMENT (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	ISS_ID BIGINT NOT NULL,
	ATT_CONTENT BLOB NOT NULL,
  	USER_ID BIGINT NOT NULL,
  	DT_CREATED TIMESTAMP NOT NULL,
	DT_MODIFIED TIMESTAMP,
	VISIBLE BOOLEAN NOT NULL,
	FOREIGN KEY(ISS_ID) REFERENCES TM_ISSUE(ID),
  	FOREIGN KEY(USER_ID) REFERENCES TM_USER_INFO(ID)
);
Create table TM_ISSUE_HISTORY (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	ISS_ID BIGINT NOT NULL,
	HIS_CONTENT VARCHAR(255) NOT NULL,
	HIS_USER VARCHAR(100) NOT NULL,
  	HIS_CREATED TIMESTAMP NOT NULL,
	FOREIGN KEY(ISS_ID) REFERENCES TM_ISSUE(ID)
);
Create table TM_ISSUE_SUBSCRIBE (
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	ISS_ID BIGINT NOT NULL,
	USER_ID BIGINT NOT NULL,
	SUB_CREATED TIMESTAMP NOT NULL,
	FOREIGN KEY(ISS_ID) REFERENCES TM_ISSUE(ID),
	FOREIGN KEY(USER_ID) REFERENCES TM_USER_INFO(ID)
);