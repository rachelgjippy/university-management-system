@echo off
REM Run script for University Management System (Windows)

echo =====================================
echo Running University Management System
echo =====================================
echo.

REM Check if bin directory exists
if not exist "bin" (
    echo Error: bin directory not found!
    echo Please compile first using: compile.bat
    pause
    exit /b 1
)

REM Check if Main.class exists
if not exist "bin\com\university\Main.class" (
    echo Error: Main.class not found!
    echo Please compile first using: compile.bat
    pause
    exit /b 1
)

REM Run the application
java -cp bin com.university.Main

pause
