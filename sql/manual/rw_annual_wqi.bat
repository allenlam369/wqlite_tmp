@echo off
echo Importing view rw_annual_wqi to PostgreSQL

rem --------------------------------------------------------------

"C:\\Program Files\\PostgreSQL\\13\\bin\psql.exe" -h localhost -U postgres -p 5432 -d wqplis_lite --file rw_annual_wqi.sql >> rw_annual_wqi.log


rem --------------------------------------------------------------
echo Finishing rw_annual_wqi view import with exit code %errorlevel%


rem End script
