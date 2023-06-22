## 2. practice git using the platform. list the git commands you learned
```
git commit
git checkout
git branch
git rebase
git merge
git clone
```

## 3. What is the basic steps to init a git repo in you local ?
```
git init
```

## 4. How to clone a repo from Github ?
```
git clone <repo_URL>
```

## 5. How to create a new branch and checkout to that branch ?
```
git checkout -b <new branch name>
```

## 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git merge branch_test
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
```
git stash
git checkout <other branch name>
git checkout branch_learn_stash
git stash pop
```

operations in Intellij: 
- git
  - uncommited changes
      - stash changes

switch to other branch and then switch back
- git
  - uncommited changes
    - unstash changes

## 8. How do you understand PR is based on Branch?
Usually I need to create a new branch and make changes when I want to contribute something to main branch. Then after committing the changes in the new branch, I can create a pull request to be merged into the target branch.

## 9. What is maven role ? what it be used to do ?
Maven is a build automation and dependency management tool for Java project. 

It can be used to compile and build java projects, manage dependencies, run tests, generate reports, package projects into distributable formats, and so on.

## 10. What is the lifecycle of maven? could you tell me the details ?
The lifecycle of Maven consists of several phases, and each phase represents a specific stage of the build process. The standard Maven lifecycle consists of the following phases:
- Validate: Validates the project structure and configuration.
- Compile: Compiles the source code of the project.
- Test: Runs tests against compiled source code.
- Package: Packages the compiled code into a distributable format, such as JAR or WAR.
- Verify: Performs checks on the package to ensure its validity.
- Install: Installs the package into the local Maven repository for use in other projects.
- Deploy: Copies the package to a remote repository for sharing with other developers or projects.

## 11. what is the difference between package and install in maven lifecycle ?

"package" focuses on creating the package, while "install" includes packaging and installing it in the local repository.

## 12. What is plugins in maven, list some plugins.
- maven-compiler-plugin: Compiles Java source code.
- maven-surefire-plugin: Runs tests during the build process.
- maven-jar-plugin: Creates a JAR file from the compiled classes.
- maven-war-plugin: Creates a WAR file from the web application project.
- maven-dependency-plugin: Manages project dependencies.
- maven-release-plugin: Facilitates the release of a project.
- maven-site-plugin: Generates project documentation and reports.
- maven-assembly-plugin: Assembles an application from an assembly descriptor.
- maven-clean-plugin: Cleans the build directory and removes generated files.





