@echo off
echo Importing view annual_wqi to PostgreSQL

rem --------------------------------------------------------------

"C:\\Program Files\\PostgreSQL\\13\\bin\psql.exe" -h localhost -U postgres -p 5432 -d wqplis_lite --file annual_wqi.sql >> annual_wqi.log


rem --------------------------------------------------------------
echo Finishing annual_wqi view import with exit code %errorlevel%


rem End script
