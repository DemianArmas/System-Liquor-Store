@echo off
cd /d "%~dp0"
chcp 65001 >nul
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 -jar "dist\SystemLiquorStore.jar"
pause
