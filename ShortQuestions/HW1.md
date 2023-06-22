# HW1
**1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md**
- headings
- quoting code
`quoting code`
```
how
to
quoting codes
```
- bold
**bold example**

**2. practice git using the platform. list the git commands you learned**
- git init
- git pull
- git push
- git commit
- git branch
- git checkout
- git merge
- git add
- git status

**3. What is the basic steps to init a git repo in you local ?**
- enter the directory you would like to crete a repo in command window `mkdir <repo>`, `cd <repo>`
- run `git init`

**4.  How to clone a repo from Github ?**
- navigate to the directory where you want to clone the repo
- Visit Github and copy the URL
- `git clone <repo_url>`

**5.  How to create a new branch and checkout to that branch ?**
`git checkout -b new_branch`

**6.  How to merge the branch_test to master branch in command ? show me the commands**
- switch to master. `git checkout master`
- merge branch_test to master. `git merge branch_test`

**7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way**
commands way:
- stash changes. `git stash save "save changes"`
- switch to another branch. `git checkout <another_branch>`
- switch back to branch_learn_stash. `git checkout branch_learn_stash`
- pop your stash. `git stash pop`

IntelliJ:
- click "Local Changes" tab
- select changes and right click, choose "Git" then "Stash Changes"
- switch to another branch in Git Branches
- switch back to branch_learn_stash
- click "Local Changes" tab and right click on the stash you want to pop

**8.  How do you understand PR is based on Branch ?**
In Git, branches allow developers to work on seperate features and keep their changes isolated until tehy are ready for review and integration.
- developers make changes then commit changes to the branch
- developers push their local branch to remote repo to make the branch accessible to others. 
- then developer creates a PR and specify base branch. The PR contains information about commited changes. 
- collaborators can review the PR and comment on it.
- Once the changes are approved, the Pull Request can be merged in to the main branch.

**9.  What is maven role ? what it be used to do ?**
Maven is a build automation and project management tool. Maven is used to manage project dependencies, build processes and project lifecycle management

**10. What is the lifecycle of maven? could you tell me the details ?**
- Validate: Maven validates the project structure and ensures all necessary information is ready 
- Compile: Maven compiles source code and generates bytecode files
- Test: Maven executes unit tests.
- Package: Maven packages compiled code into a distributable format.
- Verify: Maven checks packaged code to ensure its integrity and quality.
- Install: This phase installs packaged artifact into local Maven repository.
- Deploy: Maven deploys the pachaged artifact to a remote repository or server.

**11. what is the difference between package and install in maven lifecycle ?**
Package phase is responsible for packaging compiled source code into a distributable format. It can be used when you want to generate an artifact that can be used by other projects. You don't necessarily want to install it.

Install phase is responsible for installing packages to the local repository, other projects can reference and use it as dependency locally.
Install phase goes one step forward, not only creates the artifact, but also installs the artifact to local maven repository.

**12. What is plugins in maven, list some plugins.**
Plugins are components that provide addtional functionality to the build process. Some commonly used plugins: 
- maven dependency plugin
- maven compiler plugin
- maven install plugin
- maven clean plugin