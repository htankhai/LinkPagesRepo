@echo off
setlocal
set FILE=%~dp0
set FILE=%FILE%reload.sql
mysql -D support < %FILE%
endlocal
