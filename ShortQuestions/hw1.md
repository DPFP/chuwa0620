
# Homework1
#Chingpo Lin

-----

## Q2

- git commit
- git branch
- git checkout
- git merge
- git rebase
- git branch -f
- git reset
- git revert

---

## Q3: What is the basic steps to init a git repo in you local ?
1. open terminal
2. cd to target repo  
3. git init to create .git directory

---

## Q4: How to clone a repo from Github ?
git clone URL where url is the link of the code of repository

---

## Q5: How to create a new branch and checkout to that branch ?

git checkout -b branchName
or 
git branch branchName
git checkout branchName

---
## Q6: how to merge the branch_test to master branch in command ? show me the commands
1. git checkout master
2. git merge branch_test
3. git push origin master

---

## Q7: How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way
1. git stash
2. git checkout another_branch
3. git checkout branch_learn_stash
4. git stash pop (will retrieve back the stashed change)

For intelliJ method:  
Git-VCS Operations->Stash Changes->switch to another branch->switch back->apply stash in local change tab

--- 

## Q8: How do you understand PR is based on Branch?
pull request is to merge source branch into target branch, and the target branch is the main branch that you want to incorporate these changes

---

## Q9: What is maven role ? what it be used to do ?
maven is used for easy build and dependency management.  

Usage of maven:
- include everything inside pom.xml
- build automation
- build lifecycle  
- manage dependency
- plugins

## Q10: What is the lifecycle of maven? could you tell me the details ?

1. clean lifecycle `mvn clean` 
   1. delete the target directory
2. default lifecycle: 
    1. validate: validate structure and check errors
    2. compile: compile source code
    3. test: run unit tests against compiled source code
    4. package: package compiled code into JAR or WAR or similar file
    5. integration-test: run integration tests against packaged code
    6. verify: additional checks to ensure package quality
    7. install: installs the packaged artifact into maven repository
    8. deploy: copies artifact to remote repository
    
## Q11: what is the difference between package and install in maven lifecycle ?

1. package phase is to create a package of the compiled code and resources of your projects and it would
generate an output artifact whose type depends on the configuration in pom.xml file (JAR, WAR, ZIP, or so on)
   
2. the install phase will go a step further than package phase. After creating the artifact, the install phase will copies the generated artifact to local Maven repository.