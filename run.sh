#!/bin/bash

# Run script for University Management System

echo "====================================="
echo "Running University Management System"
echo "====================================="
echo ""

# Check if bin directory exists
if [ ! -d "bin" ]; then
    echo "Error: bin directory not found!"
    echo "Please compile first using: ./compile.sh"
    exit 1
fi

# Check if Main.class exists
if [ ! -f "bin/com/university/Main.class" ]; then
    echo "Error: Main.class not found!"
    echo "Please compile first using: ./compile.sh"
    exit 1
fi

# Run the application
java -cp bin com.university.Main
