#!/bin/bash

# Compile script for University Management System
# This script compiles all Java files in the project

echo "====================================="
echo "Compiling University Management System"
echo "====================================="

# Create bin directory if it doesn't exist
if [ ! -d "bin" ]; then
    echo "Creating bin directory..."
    mkdir bin
fi

# Compile all Java files
echo "Compiling Java files..."
javac -d bin src/com/university/**/*.java src/com/university/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo ""
    echo "To run the application, use:"
    echo "  ./run.sh"
    echo "Or manually:"
    echo "  java -cp bin com.university.Main"
else
    echo "✗ Compilation failed! Please check the error messages above."
    exit 1
fi
