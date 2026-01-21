@echo off
REM Compile script for University Management System (Windows)

echo =====================================
echo Compiling University Management System
echo =====================================

REM Create bin directory if it doesn't exist
if not exist "bin" (
    echo Creating bin directory...
    mkdir bin
)

REM Compile using explicit paths to handle spaces in directory names
javac -d bin "src\com\university\*.java" "src\com\university\auth\*.java" "src\com\university\models\*.java" "src\com\university\notifications\*.java" "src\com\university\reports\*.java" "src\com\university\repositories\*.java" "src\com\university\services\*.java" "src\com\university\utils\*.java"

REM Check if compilation was successful
if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilation successful!
    echo.
    echo To run the application, use:
    echo   run.bat
    echo Or manually:
    echo   java -cp bin com.university.Main
) else (
    echo.
    echo Compilation failed! Please check the error messages above.
    exit /b 1
)

pause