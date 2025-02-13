# (lhind-2) Git and Maven Project Setup Documentation

## Overview
This document details the technical process of setting up a Git repository and configuring a Maven project structure.

## Repository Setup Process

### 1. GitHub Repository Creation
1. Access GitHub platform (github.com)
2. Navigate to repository creation:
    - Select "New Repository" button
    - Enter repository details:
        - Repository name: Select appropriate project identifier
        - Visibility: Set to Public
        - Initialize with README: Yes
    - Complete repository creation

### 2. Local Repository Configuration
Execute the following commands in sequence:

```bash
git init
git add .
git commit -m "Initial commit - Project base files"
git remote add origin https://github.com/KejdiShahu/lhind-2.git
git branch -M main
git push -u origin main
```

### 3. Maven Project Structure Implementation
Establish the standard Maven directory hierarchy:

### 4. Maven Configuration
Create and configure the `pom.xml` file

### 5. Build Verification
Execute the Maven build command:
```bash
mvn clean install
```

### 6. Feature Branch Development Protocol
Standard feature implementation procedure:

1. Branch Creation:
```bash
git checkout -b feature/maven
```

2. Change Implementation and Commit:
```bash
git add .
git commit -m "Set Maven Structure"
```

3. Remote Branch Push:
```bash
git push origin feature/maven
```

### 7. Pull Request Creation Protocol
1. Access repository on GitHub platform
2. Navigate to Pull Requests section
3. Select "New Pull Request"
4. Configure branch comparison:
    - Base: main
    - Compare: feature branch
5. Document changes in pull request description
6. Submit for review
