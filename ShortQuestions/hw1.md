# HW1
## Name: Yuanzhen Lin

### 1. Learn Mark Down and show all of basic usage in the ShortQuestions/README.md:
Shown in the ShortQuestions/README.md

### 2. practice git using the platform. list hte git commands you learned
https://learngitbranching.js.org/
```
git commit -m "message"
git branch branchName
git checkout branchName
git checkout -b branchName
git merge branchName // come to my side
git rebase branchName // move to other side
git checkout specificCommit // detach head from branch, attached to commit
git checkout HEAD^ // ^ move upward one time
git branch -f main HEAD~3 // ~ move upward multiple times
git reset HEAD^3
git revert HEAD
git cherry-pick commit1 commit2 commit3... (specific commit)
git rebase -i HEAD~4 (not specific commit)
git tag v1 C1
git describe branchName
git checkout main^2 (2nd parent)
git clone 
git checkout o/main; git commit
git fetch
git pull
git fakeTeamwork foo 3
git push
git pull --rebase; git push
git pull; git push
git checkout -b foo o/main; git pull
git branch -u o/main foo; git commit; git push
git push origin main
git push origin start:end
git fetch origin foo
git fetch origin start:end
git push origin :foo
```

### 3. What is the basic steps to init a git repo in you local?
1. Create a directory - mkdir [repo name]
2. Go into the directory - cd [repo]
3. Type 'git init' - git init

### 4. How to clone a repo from Github?
git clone [repo_url]

### 5. How to create a new branch and check out to that branch?
git checkout -b new_branch

### 6. How to merge the branch_test to master branch in command? show me the commands
git checkout master
git merge branch_test

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
- Command way

Leaving branch_learn_stash:
```
git stash
```
Back to branch_learn_stash:
```
git checkout branch_learn_stash
git stash pop
```

- Intellij way 
  
Leaving branch_learn_stash:
```
'Git' -> 'Uncommitted Changes' -> 'Stash Changes' -> 'Create Stash'
```

Back to branch_learn_stash:
```
'Git' -> 'Uncommitted Changes' -> 'UnStash Changes'
```


### 8. How do you understand PR is based on Branch?
PR is to merge changes from one branch into another branch


### 9. What is maven role? what it be used to do?
- Maven is a project management tool used by for Java project (primarily). 
- It is used for project building, dependency management, documentation, plugins 

### 10. What is the lifecycle of maven? could you tell me the details ?
- Prepare resources:\   
  Resource copying can be customized in this phase.
  
- Validate:\
  Validate if project is correct and if all necessary information is available

- Compile:\
  Source code compilation is done in this phase
  
- Test:\
  Test the complied source code suitable for testing framework
  
- Package:\
  Compiled the code into distributable format (eg. JAR/WAR)
  
- Install:\
  Install the package in local/remote maven repository
  
- Deploy:\
  Copies the final package to remote repository

### 11. what is the difference between package and install in maven lifecycle ?
- Package:\
  Compiled the code into distributable format (eg. JAR/WAR)
- Install:\
  Install the package in local/remote maven repository for futher use


### 12. What is plugins in maven, list some plugins.
Plugins are collections that provide specific goals. Each goal is a piece of functionality to handle various aspects\
of building, testing and deploying a project. 

Some common used plugins are:
- maven-compiler-plugins
- maven-jar-plugins
- maven-war-plugins
- maven-install-plugins

### 13. In chuwa0620, create a MavenProject directory, then create a maven Module using Intellij, named it as belows:
1. groupID:com.chuwa.learn
2. artifactID:java-core

### 14. Do Code Review: Go over at least 3 PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.