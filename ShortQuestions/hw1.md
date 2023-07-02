# HW1
## Q2
git init  
git add .  
git commit  
git status  
git rebase
git reset  
git revert  
git log  
git remote  
git fetch  
git pull  
git push  

## Q3 What is the basic steps to init a git repo in you local?

1. open terminal
2. cd to the work dir
3. git init to init a git repo


### Q4 How to clone a repo from Github?

git clone [url] 

### Q5 How to create a new branch and checkout to that branch?

git checkout branchName

### Q6 How to merge the branch_test to master branch in command ? show me the commands

git checkout master
git merge branch_test
git push origin master

### Q7 How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way

#### Commands way
git stash save "stash message"
git checkout other_branch
git checkout branch_learn_stash
git stash pop

#### IntelliJ IDEA way

go to branch_learn_stash branch
save the code
Version Control -> Local Changes -> Git Stash -> Stash

when you want to get back to branch_learn_stash branch, first checkout to this branch, then 
Version Control -> right click stash -> Apply Stash / Pop Stash

### Q8 How do you understand PR is based on Branch?

PR(pull request) is a request to merge changes made in a specific branch into another branch.

### Q9 What is maven role ? what it be used to do ?

Maven is a tool to build and manage dependency for the project.

### Q10 What is the lifecycle of maven? could you tell me the details ?
clean lifecycle:
    pre-clean: execute the works before cleaning
    clean: clean all the files generated from last building process
    post-clean: execute the works after cleaning

default lifecycle:

    validate: validate the project and all the information to be available  
    compile: compile source code
    test: run unit tests(JUnit)
    package: package compiled code into JAR or WAR or similar file
    verify: additional checks to ensure package quality
    install: installs the packaged artifact into maven repository
    deploy: copies artifact to remote repository

### Q11 what is the difference between package and install in maven lifecycle ?

Package would package compiled code into JAR or WAR.

Install would work after package phase, after packaging, it would get the artifact then send it to the Maven repo.

### Q12 What is plugins in maven, list some plugins.

Maven plugins are extensions provide additional functionality to the build process.

eg:  
maven-compiler-plugin: Provides support for compiling Java source code.
maven-jar-plugin: Creates a JAR file from the project's compiled classes and resources.  
maven-dependency-plugin: Manages dependencies, including downloading, copying, and analyzing dependencies.