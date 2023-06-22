# Hw1

### 1.
Write Hw 1 in MarkDown

### 2.Practice git using the platform. list the git commands you learned
git commit: create a new commit
git branch: create a new branch
git checkout: switch to a certain branch
git merge: merge the sperate branch with the main branch
git rebase: rebase to a certain branch to anther branch
git reset: reverse a local branch
git revert; reverse a remote branch
git cherry-pick: copy multiple commits at the same time
git tag: set a tag to historical point in a branch
git clone: clone all the commits remotely to local
git fetch: clone the rest of commits remotely 
git pull: git fetch + git merge
git fakeTeamwork: plop down a commit on main
git push: push the local change to remote

### 3.What is the basic steps to init a git repo in you local ?
Go to the directory that want to init a repo, 'git init'

### 4.How to clone a repo from Github ?
Copy the URL and 'git clone <URL>'

### 5.How to create a new branch and checkout to that branch ?
'git branch <new branch>' + 'git checkout <new branch>'
or
'git checkout -b <new branch>'

### 6.How to merge the branch_test to master branch in command ? show me the commands
'git checkout master' + 'git merge branch_test'

### 7.How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
commands way: 'git stash' + 'git checkout branch_learn_stash' + 'git stash pop'
intellij way: in git menu and use Stash change + checkout branch_learn_stash + go to git menu and use Unstash changes

### 8.How do you understand PR is based on Branch?
Pull Request is the request to merge the changed code in local branch to the remote main branch

### 9.What is maven role ? what it be used to do?
Maven is a build automation and managing dependency tool primarily used for Java projects. It is used to manage dependency, build automation, maintain project structure and standardization.

### 10.What is the lifecycle of maven? could you tell me the details ?
1. prepare resources: copy recource that can be customized
2. validate: validate if the project is correct with all the necessay information
3. compile: compile all the source code
4. test: test the compile source code and check if it pass the test framework
5. package: creates the JAR/WAR package that mentioned in the packaging of the POM.xml
6. install: install the package in maven repository
7. deploy: copy the final package to the remote repository

### 11.what is the difference between package and install in maven lifecycle ?
package phase create package that mentioned in the POM.xml, install further install the packages in the maven repository

### 12.What is plugins in maven, list some plugins.
Plugins are the feature of Maven that allow the reuse of common build logic across multiple projects.

clean: clean up after the build
compiler: compile java sources
deploy: deploy the built artifact to the remote repository
install: install the built artifact into local repository



