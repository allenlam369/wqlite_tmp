@echo off
set PGPASSWORD=postgres

if %SQLWAYS_CMD_ECHO%==1 (@echo on)
echo.
echo Importing table BM_BEACH to PostgreSQL
rem Generated by (c) Ispirer SQLWays 9.0 Build 6620 64bit Licensed to eCom - William Leung - United States - Ispirer MnMTK 2020 Microsoft SQL Server to PostgreSQL Database Migration Demo License (1 month, 20210626)
rem Timestamp: Thu May 27 10:26:07 2021

rem --------------------------------------------------------------
rem How to use this command file:

rem To create table, constraints, import data and create indexes run:
rem 	bm_beach.bat all

rem To create table and its constraints run:
rem 	bm_beach.bat table

rem To import data into the table run:
rem 	bm_beach.bat import

rem To create indexes for the table run:
rem 	bm_beach.bat idx

rem To execute all DDL statements for the table run:
rem 	bm_beach.bat ddl

rem --------------------------------------------------------------
rem Import status exit code:

SETLOCAL
set /A exit_code=0

rem --------------------------------------------------------------
rem Define a task to perform

if "%1"=="" goto create_table
if %1==all goto create_table
if %1==table goto create_table
if %1==import goto import_data
if %1==idx goto create_idx
if %1==ddl goto create_table
goto end

rem --------------------------------------------------------------
:create_table
echo Creating table and its constraints using the PostgreSQL command line utility

"C:\\Program Files\\PostgreSQL\\13\\bin\psql.exe" -h localhost -U postgres -p 5432 -d wqplis_lite --file bm_beach_ddl.sql >> bm_beach.log

set /A exit_code+=%errorlevel%

if "%1"=="" goto import_data
if %1==all goto import_data
if %1==ddl goto create_idx
goto end

rem --------------------------------------------------------------
:import_data
echo Importing data using the PostgreSQL COPY command

"C:\\Program Files\\PostgreSQL\\13\\bin\psql.exe" -h localhost -U postgres -p 5432 -d wqplis_lite --file bm_beach.ldi

set /A exit_code+=%errorlevel%



if "%1"=="" goto create_idx
if %1==all goto create_idx
goto end

rem --------------------------------------------------------------
:create_idx


rem --------------------------------------------------------------
:end
echo Finishing BM_BEACH table import with exit code %exit_code%


rem End script
