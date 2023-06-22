## 1
See the basic usages in ShortQuestions/README.md

## 2
git init: Initializes a new Git repository

git clone <repository>: Create a local copy of a remote repository

git add <file>: Add a file to be included in the next commit

git commit -m "\<message>": Commit the changes in the staging area

git status: Show the status of the working directory and staging area

git push: Push the committed changes to a repository

git pull: Fetch and merge changes from a remote repository to the local repository

git branch: List all the branches in the repository

git checkout \<branch>: Switch to a different branch

git merge \<branch>: Merge a branch into the current branch

## 3
1. git init
2. create and write in some files
3. git add .
4. git commit -m "Initial message"
5. git push \<branch_name>

## 4
```
git clone <repo_address>
```

## 5
```
git checkout -b <branch-name>
```

## 6
```
git checkout master
git merge branch_test
git commit
git push
```

## 7
Stash changes:
```
git stash save "Stashing code"
git checkout <branch_name>
```
Restore the changes:
```
git stash pop
```

## 8
Pull Request is a way to propose changes from one branch to another. The PR is created based on the commits made in a specific branch. It allows for collaboration and code review before merging the changes into the target branch.

## 9
Maven is a build automation and dependency management tool primarily used for Java-based projects. 

Developers use it to do project management, build processes, and dependency resolution.

## 10
Maven's life cycle involves following steps:

### Default:
- Validates project structure, dependencies, and configurations.
- Compiles the project's source code
- Packages compiled code
- Runs additional checks on the packaged code
- Installs into the local repository 
- Copies the artifact to a remote repository
### Clean:
- Pre-clean
- Clean
- Post clean
### Site: 
- Pre-site
- Site
- Post-site
- Site-deploy

## 11
Packages is to compile code into a distributable format, such as JAR, WAR, or EAR, for future distribution or deployment usage. While 'Install' installs the packaged artifact into the local repository for use by other projects.

## 12
- Compiler Plugin: Compiles Java source code and generates bytecode.

- Surefire Plugin: Executes unit tests written in frameworks like JUnit.

- Jar Plugin: Packages compiled code and resources into a JAR file.

- Dependency Plugin: Analyzes and manages project dependencies.

## 13
See details in chuwa0620/MavenProject directory.