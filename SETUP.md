# Quick Setup Guide

## For the Team Lead

### Step 1: Create GitHub Repository
1. Go to [GitHub](https://github.com) and log in
2. Click "New Repository"
3. Name it: `university-management-system`
4. Make it **Public**
5. **Do NOT** initialize with README (we already have one)
6. Click "Create repository"

### Step 2: Upload Starter Code
```bash
# Navigate to the project directory
cd university-management-system

# Initialize git (if not already done)
git init

# Add all files
git add .

# Make initial commit
git commit -m "Initial project structure with starter code"

# Add remote repository (replace with your GitHub URL)
git remote add origin https://github.com/YOUR_USERNAME/university-management-system.git

# Push to GitHub
git branch -M main
git push -u origin main
```

### Step 3: Add Team Members as Collaborators
1. Go to your repository on GitHub
2. Click "Settings" tab
3. Click "Collaborators" in the left sidebar
4. Click "Add people"
5. Add each team member's GitHub username
6. They will receive an email invitation

---

## For All Team Members

### Step 1: Accept Repository Invitation
1. Check your email for GitHub invitation
2. Click "Accept invitation"
3. You now have access to the repository

### Step 2: Clone the Repository
```bash
# Clone the repository (replace with actual URL)
git clone https://github.com/TEAM_LEAD_USERNAME/university-management-system.git

# Navigate into the directory
cd university-management-system
```

### Step 3: Verify Setup
```bash
# Check the project structure
ls -la

# You should see:
# - src/
# - data/
# - docs/
# - README.md
# - .gitignore
# - TASKS.md
```

---

## Development Workflow

### Before Starting Work
```bash
# Make sure you have the latest code
git pull origin main

# Create a new branch for your feature
git checkout -b feature/your-component-name
```

### While Working
```bash
# Check what files you've changed
git status

# Add files to staging
git add src/com/university/models/Student.java

# Or add all changed files
git add .

# Commit with a meaningful message
git commit -m "Implemented Student class with GPA calculation"
```

### When Ready to Share
```bash
# Push your branch to GitHub
git push origin feature/your-component-name

# Then go to GitHub and create a Pull Request
# Or merge directly to main:
git checkout main
git merge feature/your-component-name
git push origin main
```

---

## Compiling and Running

### Method 1: Command Line (All Platforms)

**Compile:**
```bash
# From project root directory
javac -d bin src/com/university/**/*.java src/com/university/*.java
```

**Run:**
```bash
java -cp bin com.university.Main
```

### Method 2: Using an IDE

**IntelliJ IDEA:**
1. File → Open → Select project folder
2. Right-click `Main.java` → Run 'Main.main()'

**Eclipse:**
1. File → Open Projects from File System → Select project folder
2. Right-click `Main.java` → Run As → Java Application

**VS Code:**
1. File → Open Folder → Select project folder
2. Install "Extension Pack for Java" if not installed
3. Click "Run" button above `main` method

**NetBeans:**
1. File → Open Project → Select project folder
2. Right-click `Main.java` → Run File

---

## Common Git Commands

```bash
# See current status
git status

# See commit history
git log --oneline

# See what branches exist
git branch

# Switch to a different branch
git checkout branch-name

# Pull latest changes
git pull origin main

# Push your changes
git push origin branch-name

# Discard changes to a file
git checkout -- filename

# See who changed what
git blame filename
```

---

## Troubleshooting

### Problem: "javac: command not found"
**Solution:** Install JDK or add it to your PATH
- Windows: Set JAVA_HOME environment variable
- Mac/Linux: Add to .bashrc or .zshrc

### Problem: "Package does not exist"
**Solution:** Make sure you're compiling from the right directory and using the correct classpath

### Problem: Git merge conflicts
**Solution:**
1. Open the conflicting file
2. Look for `<<<<<<<`, `=======`, `>>>>>>>` markers
3. Decide which code to keep
4. Remove the markers
5. `git add` the file
6. `git commit`

### Problem: "Permission denied" on GitHub
**Solution:** Make sure you've been added as a collaborator

### Problem: Changes not showing
**Solution:** Make sure you've committed and pushed:
```bash
git status
git add .
git commit -m "Your message"
git push origin main
```

---

## Team Communication Tips

1. **Use a Group Chat:** WhatsApp, Telegram, Discord, or Slack
2. **Daily Updates:** Each person shares what they did and what they'll do next
3. **Ask for Help:** Don't struggle alone - ask your teammates!
4. **Code Reviews:** Before merging, have someone else look at your code
5. **Document Decisions:** Add notes to TASKS.md when you make important decisions

---

## First Steps Checklist

- [ ] Repository created on GitHub
- [ ] All team members added as collaborators
- [ ] Each team member has cloned the repository
- [ ] Each team member can compile and run Main.java
- [ ] Team has decided on communication channel
- [ ] Team has scheduled first meeting
- [ ] TASKS.md updated with team member names
- [ ] README.md updated with team member names

---

## Need Help?

If you're stuck, try these resources:
1. Check the README.md for detailed documentation
2. Look at the example Student.java implementation
3. Ask your teammates in the group chat
4. Search on Stack Overflow
5. Review Java documentation
6. Ask the instructor or TA

---

**Good luck with your project! Remember: Start early, communicate often, and help each other!**
