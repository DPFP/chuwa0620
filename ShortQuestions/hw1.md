# HW1
1. Learn **MarkDown** and show all of basic usage in the **ShortQuestions/README.md**
    1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
   
    <br/>

2. practice git using the platform. list the git commands you learned
    1. https://learngitbranching.js.org/
        ```
        git commit
        git branch {branchName}
        git merge {branchName}
        git rebase {-i} {branchName}
        git checkout {-b/-f} {branchName} {branchName} {HEAD^/~[nums]}
        git checkout HEAD^/HEAD~{nums}
        git reset
        git revert
        git cherry-pick {head}{branch}
        git tag {naming}{target-node}
        git describe {target}
        git clone
        git fetch
        git pull
        git fakeTeamwork {nums}
        git push
        ```
    
    <br/>
3. What is the basic steps to init a git repo in you local ?
    - `mkdir` create a new directory in local host.
    - `cd` go to the directory.
    - `git init` to initiate the local repository.
      - or use `git clone` command to clone the remote repo to local
    
    <br/>
4. How to clone a repo from Github ?
    - Type command `git clone {repo_url}`
    
    <br/>
5. How to create a new branch and checkout to that branch ?
    - Option 1: Type command `git checkout -b {branch_name}`
    - Option 2: Type command
        ```
        git branch {branch_name}
        git checkout {branch_name}
        ```
    
    <br/>
6. How to merge the branch_test to master branch in command ? show me the commands
    - Commands are
        ```
        git checkout master
        git merge branch_test 
        ```
    
    <br/>
7. How to **stash** your new code before leaving branch **branch_learn_stash** and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
    - Commands
        ```
        git stash // stash current work
        git stash list // list all the saved stashes
        git checkout branch_learn_stash // check out back to branch_learn_stash 
        git stash pop // remove the most recent stash
        ```
    - Intellij
        - Stash new code
            ```
            'Git' -> 'Uncommited Changes' -> 'Stash Changes' -> 'Create Stash'
            ```
        - Pop stash
            ```
            'Git' -> 'Uncommited Changes' -> 'Unstash Changes'
            ```

    <br/>
8. How do you understand **PR is based on Branch**?
    - PR == pull request, which means to make a request for merging the source branch from remote repo.

    <br/>
9. What is **maven** role ? what it be used to do ?
    - Maven is a project management took used for Java project
    - Maven role
        - Manage dependencies
        - Build project
        - Documentation
        - Reporting
        - others
    - Use maven `mvn` commands to download add and remove the dependencies.

    <br/>
10. What is the **lifecycle** of maven? could you tell me the details ?
    - Clean -> Prepare-resources -> Validate -> Package -> Install
        |Phase|Handles|Description|
        |---|----|---|
        prepare-resources| resource copying| Resource copying can be customized in this phase.
        |validate| Validating the information|Validates if the project is correct and if all necessary information is available.|
        |compile| compilation| Source code compilation is done in this phase.|
        |Test| Testing| Tests the compiled source code suitable for testing framework.|
        |package| packaging| This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.|
        |install| installation| This phase installs the package in local/remote maven repository.|
        |Deploy| Deploying| Copies the final package to the remote repository|

    <br/>
11. What is the difference between **package** and **install** in maven lifecycle ?
    - Package: Create and complie the code into distribuatble format (JAR/WAR package)
    - Install: Install the package into local/remote mvn repo.

    <br/>
12. What is **plugins** in maven, list some plugins.
    - Maven plugins provide all the useful functionalities required to execute and manage the project build. 
    - The most common used plugins are:  
        - clean
        - compiler
        - deploy
        
    - See details at [Maven Project Plugins](https://maven.apache.org/plugins/index.html)

    <br/>
13. In **chuwa0620**, **MavenProject** directory, create a maven Module using Intellij, named it as belows:
    1. groupID: com.chuwa.learn
    2. artifactID: java-core

    <br/>
14. Do **Code Review**: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please **don't** merge it.