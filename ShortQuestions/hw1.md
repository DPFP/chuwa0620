1. See the basic usages in ShortQuestions/README.md
2. Git command
   1. git init: init a new git repo
   2. git clone: Create a new local copy of a remote repository
   3. git add: Add a file to be included in the next commit
   4. git commit -m "<msg>" Commit the change in the stagin area with current msg
   5. gi status: Show the status of the working directory and staging area
   6. git push: Push the committed change to a repo
   7. git pull: Fetch and merge the change from a remote repo to local repo.
   8. git branch: List a branches in current repo.
   9. git checkout <branch>: switch to different branch
   10. git merge <branch>: Merge a branch into current change
   11. git stash: Store all current uncommited change to stash area.

3. ```bash
   git init
   # Create a readme.md file
   git add -A
   git commit -m "Init a new repo with README.md file"
   git push <branch_name>
   ```

4. ```bash
   git clone <repo_address>
   ```

5. ```bash
   git checkout -b <branch-name>
   ```

6. ```bash
   git checkout master
   git merge branch_test
   git commit
   git push
   ```

7. ```bash
   git stash save "Stashing code"
   git checkout <target_branch_name>
   ```

   ```bash
   git checkout branch_learn_stash
   git stach pop
   ```

8. Pull requests let you tell others about changes you've pushed to a branch in a repository on GitHub. Once a pull request is opened, you can discuss and review the potential changes with collaborators and add follow-up commits before your changes are merged into the base branch.

9. Maven is a popular open-source build tool developed by the Apache Group to build, publish, and deploy several projects at once for better project management. The tool provides allows developers to build and document the lifecycle framework.

10. Normally Maven lifecycle has 8 steps:

    1. **Validate:** This step validates if the project structure is correct. For example – It checks if all the dependencies have been downloaded and are available in the local repository.
    2. **Compile:** It compiles the source code, converts the .java files to .class, and stores the classes in the target/classes folder.
    3. **Test:** It runs unit tests for the project.
    4. **Package:** This step packages the compiled code in a distributable format like JAR or WAR.
    5. **Integration test:** It runs the integration tests for the project.
    6. **Verify:** This step runs checks to verify that the project is valid and meets the quality standards.
    7. **Install:** This step installs the packaged code to the local Maven repository.
    8. **Deploy:** It copies the packaged code to the remote repository for sharing it with other developers.

11. In package step, code will be compiled into a distributable format like JAR or WAR and Install step means to install packaged file to local maven repo.
12. Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects.Here are some common plugins
    1. Clean：Cleans up target after the build. Deletes the target directory.
    2. Compiler: Compiles Java source files.
    3. Surefire: Runs the JUnit unit tests. Creates test reports.
    4. Jar: Builds a JAR file from the current project.
    5. Javadoc: Generates Javadoc for the project.
13. See details in chuwa0620/MavenProject Directory.