-- DDL script for table WPCO_WCZ for PostgreSQL
-- Generated by (c) Ispirer SQLWays 9.0 Build 6620 64bit Licensed to eCom - William Leung - United States - Ispirer MnMTK 2020 Microsoft SQL Server to PostgreSQL Database Migration Demo License (1 month, 20210626)
-- Timestamp: Mon May 31 14:44:28 2021
-- Create table statement


DROP TABLE IF EXISTS WPCO_WCZ CASCADE;


CREATE TABLE WPCO_WCZ
(
   WCZ_ID VARCHAR(2)   NOT NULL,
   ZONE_ID VARCHAR(1),
   WCZ_NAME VARCHAR(100),
   CHINESE_NAME VARCHAR(40),
   WCZ_LABEL VARCHAR(4),
   WCZ_ABBR VARCHAR(10),
   FAD TIMESTAMP,
   WCZ_CODE DECIMAL(2,0),
   VALID_USER VARCHAR(10),
   VALID_DATE TIMESTAMP,
   VALID_CODE DECIMAL(3,0)
);


-- Primary key

ALTER TABLE WPCO_WCZ add CONSTRAINT PK_WPCO_WCZ
PRIMARY KEY(WCZ_ID);


ALTER TABLE WPCO_WCZ add CONSTRAINT FK_WPCO_WCZ_TEN_ZONE
FOREIGN KEY(ZONE_ID)
REFERENCES TEN_ZONE(ZONE_ID)   ON DELETE NO ACTION  ON UPDATE NO ACTION;

