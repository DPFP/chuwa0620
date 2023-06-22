# HW 1 
## Q2. List the git commands you learned

```
git add.
git commit -m 'some message'
git push
git status
```

## Q3. What is the basic steps to init a git repo in you local?
```
git init
```

## Q4. How to clone a repo from Github ?
```
git clone [url]
```

## Q5. How to create a new branch and checkout to that branch ?
```
git branch
git checkout
```

## Q6.  How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git merge branch_test
git push origin master
```

## Q7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to **branch_learn_stash ? try commands way and intellij way.
```
Commands:
git stash
git stash pop

Intellij:
Version Control -> Local Changes -> Git Stash -> Stash
Version Control -> right click stash -> Apply Stash / Pop Stash
```

## Q8.  How do you understand PR is based on Branch?
```
The pr is to merge one branch to another or the master
```

## Q9.  What is maven role ? what it be used to do ?
```
Maven's primary goal is to allow a developer to comprehend the complete state of a development effort in the shortest period of time. In order to attain this goal, Maven deals with several areas of concern:

Making the build process easy
Providing a uniform build system
Providing quality project information
Encouraging better development practices
```

## Q10.  What is the lifecycle of maven? could you tell me the details ?
```
Validate: This step validates if the project structure is correct. For example – It checks if all the dependencies have been downloaded and are available in the local repository.
Compile: It compiles the source code, converts the .java files to .class, and stores the classes in the target/classes folder.
Test: It runs unit tests for the project.
Package: This step packages the compiled code in a distributable format like JAR or WAR.
Integration test: It runs the integration tests for the project.
Verify: This step runs checks to verify that the project is valid and meets the quality standards.
Install: This step installs the packaged code to the local Maven repository.
Deploy: It copies the packaged code to the remote repository for sharing it with other developers.
```

## Q11.  what is the difference between package and install in maven lifecycle ?
```
Pakage would pacakage the project to a JAR while the install would install the project
and make is usable as a dependency.
```

## Q12.  What is plugins in maven, list some plugins.
```
build-helper-maven-plugin: The plugin is mainly for adding additional source or resource directories.
maven-shade-plugin: Using the maven-shade-plugin, it is able to create the uber jar.
```