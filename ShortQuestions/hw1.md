### HW1

**1. practice git using the platform. list the git commands you learned**

- git clone
- git init
- git add
- git commit
- git push
- git pull
- git reset
- git stash
- git stash pop
- git log
- git checkout
- git tag
- git branch
- git remote

**2. What is the basic steps to init a git repo in you local?**
First use command `mkdir` to create a folder. Then run `git init` to initialize a git repo.

**3. How to clone a repo from Github ?**
`git clone` + SSH link or Https link.

**4. How to create a new branch and checkout to that branch ?**
`git checkout -b new-branch`

**5. How to merge the branch_test to master branch in command ? show me the commands**
First run `git checkout master` to ensure we are on master branch.
Then run `git merge branch_test` to do merge.

**6.How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to \*\*branch_learn_stash ? try commands way and intellij way.**
`git stash save "my work"`
`git checkout other_branch_name`
`git checkout branch_learn_stash`
`git stash pop`

**7. How do you understand PR is based on Branch?**
A PR (Pull Request) is a change commit based on a branch that presents changes by comparing the differences between the source and target branches. After a PR is created on the code hosting platform, team members can review, discuss, and suggest changes. Eventually, the reviewed and approved PRs are merged into the target branch, applying the changes to the main code.

**8. What is maven role ? what it be used to do ?**
Maven is a build automation and dependency management tool. It is used to streamline and simplify the software build process, including compiling, testing, packaging, and distributing applications.

**9. What is the lifecycle of maven? could you tell me the details ?**

**Validate**: Validates the project structure and configuration.
**Compile**: Compiles the source code of the project.
**Test**: Runs unit tests against compiled source code.
**Package**: Packages the compiled code into a distributable format, such as JAR or WAR.
**Verify**: Performs integration tests on the packaged code.
**Install**: Installs the packaged code into the local **Maven** repository, making it available for other projects.
**Deploy**: Copies the packaged code to a remote repository for sharing with other developers or deployment to a production environment.

**10. what is the difference between package and install in maven lifecycle ?**
Package is to compile code into a distributable foramt like JAR. While install is to package code into local Maven repo so it could be used by other projects.
**11. What is plugins in maven, list some plugins**
Plugins in Maven are extensions that provide additional functionality and goals to the build process. They allow you to customize and automate various tasks during the build lifecycle. Maven plugins are configured in the project's pom.xml file.

- maven-compiler-plugin
- maven-jar-plugin
