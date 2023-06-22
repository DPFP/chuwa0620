# HW1

## 1. basic usage of md

1. _Italic Text_
2. **Bold Text**

## 2. basic usage of git

- git init
- git add
- git commit
- git push
- git pull
- git clone
- git checkout
- git branch
- git merge
- git log
- git status
- git reset
- git status
- git rm

## 3. init repo in local

mkdir [repo_name]  
cd [repo_name]  
git init

## 4. How to clone a repo from Github

git clone [repo_url]

## 5. create new branch and checkout

git checkout -b [branch_name]

## 6. merge branch

git checkout master  
git fetch -all  
git merge [branch_test]

## 7. stash branch

git stash  
git stash pop | git stash apply

## 8. PR is based on branch

A pull request is a method to apply commits in one branch(feature) to another branch(main).

## 9. Maven role

Maven is a build automation tool used primarily for Java projects. Maven addresses two aspects of building software: first, it describes how software is built, and second, it describes its dependencies.

## 10. What is the lifecycle of maven?

- validate: Validates the project's structure and dependencies.
- compile: Compiles the project's source code.
- test: Runs tests against the compiled code.
- package: Packages the compiled code into a distributable format (e.g., JAR, WAR).
- install: Installs the package into the local repository for further use in other projects.
- deploy: Deploys the package to a remote repository or server for sharing with others.

## 11. What is the difference between package and install?

- package: package the compiled code into a distributable format (e.g., JAR, WAR).
- install: install the package into the local repository for further use in other projects.

## 12. What is plugins in maven, list some plugins.

A plugin is a collection of one or more goals. A goal is a specific task used in Maven. There are three built-in lifecycle in Maven: default, clean and site.
