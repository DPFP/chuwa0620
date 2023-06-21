### 1

### 2
```
git commit
git branch
git checkout
git rebase
git merge
git pull 
git push
git stash
git init

```

### 3
First use git init to make it a repo, then do git add . and git commit -m "message", finally git push origin name_of_the_branch.

### 4
Use git clone + the ssh link from the website.

### 5
Use git checkout -b to create new branch.

Use git checkout name_of_the_branch to change to that branch.

### 6
First we need to switch to master branch using git checkout.

Then we need to make sure master branch is the latest by doing git pull origin master.

Now merge the feature branch by doing git merge branch_name.

The next steps is to resolve any conflicts, if there's any.

After resolving conflicts, we need to do git add <the_conflict_files> and do git commit as well.

Finally push the change to the master branch by doing git push origin master.

### 7
First do git stash save "message" on the branch_learn_stash, then checkout to work on other branch. When returning to branch_learn_stash, do git stash pop which will restore the changes. 


### 8
Pull Request is trying to merge the changes you made in one specific branch to the main branch. Therefore, each pull request can have only one corresponding working branch. 

### 9
`maven` functions as a package management tool for java based applications. Its primary usages includes dependency management, build automation, project management, etc.

### 10
The Maven build process follows a predefined lifecycle, which consists of a sequence of phases and goals. Here are the phases:

- validate
- compile
- test
- package
- verify
- install
- deploy

During each phase, Maven executes the associated goals defined by default or added through plugins.

### 11
`Package` phase creates the distributable artifact and stores it within the project's target directory `target/`. The artifact is primarily used for distribution or deployment purposes. Whereas `install` takes the packaged artifact from the `package` phase and installs it into the local Maven repository. 


### 12
In Maven, plugins are extensions that enhance the build process and provide additional functionalities. For example, some core plugins include clean, compiler, and deploy.

### 13
see details in `MavenProject` folder.

### 14
Done
