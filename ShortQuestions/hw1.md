# Chuwa 0620 Assignment 1
### Zhizhou Xu
>**1. practice git using the platform. list the git commands you learned**
>>git init: Initializes a new Git repository in the current directory.  
> 
>>git clone [repository]: Creates a copy of a remote repository on your local machine.  
> 
>>git commit -m "[message]": Commits the changes in the staging area to the repository with a descriptive message.  
> 
>>git pull: Fetches and merges changes from a remote repository into the current branch.
>
>>git push: Pushes your local commits to a remote repository.
>
>>git branch: Lists all local branches and highlights the current branch.
>
>>git checkout [branch]: Switches to the specified branch.

>**2. What is the basic steps to init a git repo in you local?**
>> cd to the desired directory  
>> ```cd Document```
> 
>> init repo  
>> ```git init```

>**3. How to clone a repo from Github?**
>> ```git clone [repository]```

>**4. How to create a new branch and checkout to that branch?**
>> ```git checkout -b branch```

>**5. How to merge the branch_test to master branch in command?**
>> checkout to master branch  
>> ```git checkout master```
> 
>> pull the latest changes
>> ```git pull origin master```
> 
>> merge
>> ```git merge branch_test```
> 
>> commit and push
>> ```
>> git commit -m "commit message" 
>> git push origin master
>> ```

>**6. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to branch_learn_stash?**
>> stash the changes and checkout to another branch
>> ```
>> git stash save "stash message"
>> git checkout other_branch
>> ```
>
>> checkout back to branch_learn_stash and restore changes
>> ```
>> git checkout branch_learn_stash
>> git stash pop
>> ```

>**7. How do you understand PR is based on Branch?**  
> A Pull Request (PR) is a way to propose changes made in one branch (the source branch) to be merged into another branch (the base branch). Once approved, the changes can be merged into the base branch.

>**8. What is maven role? what it be used to do?**  
> Maven is a build automation and dependency management tool primarily used in Java-based projects. Its main role is to simplify and streamline the software development process by automating various tasks and managing project dependencies.  

>**9. What is the lifecycle of maven? could you tell me the details?**   
> **validate**: Validates the project configuration.  
> **compile**: Compiles the source code.  
> **test**: Runs unit tests against the compiled source code.  
> **package**: Packages the compiled code into a distributable format (e.g., JAR, WAR).  
> **verify**: Performs any checks to ensure the quality of the package.  
> **install**: Installs the package into the local Maven repository for use in other projects.  
> **deploy**: Copies the package to a remote repository for sharing with other developers or systems.  

>**10. what is the difference between package and install in maven lifecycle?**  
> In Maven, the 'package' phase creates the project artifact (e.g., JAR, WAR) without installing it. It generates the distributable package in the target directory. On the other hand, the 'install' phase not only creates the artifact but also installs it into the local Maven repository. The installed artifact can be reused by other projects on the same machine.  

>**11. What is plugins in maven, list some plugins.**  
> Maven plugins are extensions that enhance the build process by providing additional functionalities. Here are some commonly used plugins in Maven:
> 1. Compiler Plugin: Compiles Java source code.  
> 2. Surefire Plugin: Runs unit tests.  
> 3. Failsafe Plugin: Runs integration tests.  
> 4. Jar Plugin: Creates JAR files.  
> 5. War Plugin: Creates WAR files for web applications.  
> 6. Site Plugin: Generates project documentation and reports.  
> 7. Dependency Plugin: Manages project dependencies.  
> 8. These plugins, among many others, enable developers to customize and automate various aspects of the Maven build lifecycle.

>**12. n chuwa0620, create a MavenProject directory, then create a maven Module using Intellij.**  
> See in "chuwa0620/Maven Project" directory