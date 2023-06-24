## 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

   1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax

## 2. practice git using the platform. list the git commands you learned

   1. https://learngitbranching.js.org/

      ```git
      git checkout
      git branch
      git branch -f HEAD^
      git rebase
      git rebase -i
      git cherry-pick
      git commit
      git commit --amend
      git merge
      git tag
      git describe
      
      ```

      

## 3.  What is the basic steps to init a git repo in you local ?

   ```cd 

   git init
   ```

## 4.   How to clone a repo from Github ?

   ```
   git clone 
   ```

   

## 5.   How to create a new branch and checkout to that branch ?

   ```
   git branch newBranch
   git checkout newBranch
   ----------
   git checkout -b newBranch
   ```

   

## 6.   How to merge the branch_test to master branch in command ? show me the commands

   ```
   git checkout master
   git merge branch_test
   ```

   

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

   ```
   git stash save
   git chechout newBranch
   
   ```

   

## 8. How do you understand PR is based on Branch?

   PR is a pointer to a commit.

## 9. What is maven role ? what it be used to do ?

   Its main role is to simplify the process of building, packaging, and managing Java applications and their dependencies.

## 10. What is the lifecycle of maven? could you tell me the details ?

Validate: Validates that the project is correct and all necessary information is available. 

Compile: Compiles the source code of the project. Test: Runs unit tests against the compiled source code. 

Package: Packages the compiled code into a distributable format, such as JAR, WAR, or EAR. Integration 

Test: Performs integration tests on the packaged code. 

Verify: Performs checks on the results of integration tests to ensure the quality criteria are met. 

Install: Installs the packaged code into the local Maven repository, making it available for other projects. 

## 11. what is the difference between package and install in maven lifecycle ?

The "package" phase creates a distributable package of your project without installing it.

The "install" phase takes the package created in the "package" phase and installs it into the local Maven repository, making it available for other projects on the same machine.

## 12. What is plugins in maven, list some plugins.

Plugins in Maven are extensions that provide additional functionality to the build process. 

Maven Clean Plugin: Cleans the project by deleting the build output directories.

## 13. In chuwa0620, create a MavenProject directory, then create a maven Module using Intellij, named it as 
belows:

1. groupID: com.chuwa.learn
2. artifactID: java-core

## 14. Do Code Review: Go over at least 3 PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it
