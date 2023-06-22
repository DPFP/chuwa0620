# HW1

#### **1. Learn MarkDown and show all of basic usage in the ShortQuestions / README.md**

##### **Headings**

```markdown
# A first-level heading
## A second-level heading
### A third-level heading
```

![image-20230622101119343](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230622101119343.png)



##### **Nested Lists**

```markdown
 - First nested list item
    - Second nested list item
```

- First nested list item
  - Second nested list item



| Style         | Syntax             | Keyboard shortcut                         | Example                      | Output                     |
| :------------ | :----------------- | :---------------------------------------- | :--------------------------- | :------------------------- |
| Bold          | `** **` or `__ __` | Command+B (Mac) or Ctrl+B (Windows/Linux) | `**This is bold text**`      | **This is bold text**      |
| Italic        | `* *` or `_ _`     | Command+I (Mac) or Ctrl+I (Windows/Linux) | `_This text is italicized_`  | *This text is italicized*  |
| Strikethrough | `~~ ~~`            | None                                      | `~~This was mistaken text~~` | ~~This was mistaken text~~ |



##### **Links**

 [GitHub Pages](https://pages.github.com/)



##### **Relative** **links**

```
[Contribution guidelines for this project](docs/CONTRIBUTING.md)
```



##### **Images**

![image-20230622100950928](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230622100950928.png)

![image-20230622100922016](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230622100922016.png)



#### **2. practice git using the platform. list the git commands you learned**



```
git clone
git checkout xxx/xxx
git commit -m "xxx"
git branch xxx/xxx
git init
git status
git push origin xxx
git add .
```



#### **3. What is the basic steps to init a git repo in you local ?**

`git init`



#### **4. How to clone a repo from Github ?**

`git clone `



#### **5. How to create a new branch and checkout to that branch ?**

`git branch <firstname_lastname/notes>` 

`git checkout <firstname_lastname/notes>`



#### **6. How to merge the branch_test to master branch in command ? show me the commands**

1. First, you want to make sure your local repository is up to date with the most recent code in the `master` branch. To do this, check out to the `master` branch:

   ```
   git checkout master
   ```

   

2. After you've switched to the `master` branch, you can merge the `branch_test` into `master` with the following command:

   ```
   git merge branch_test
   ```

3.  Commit those changes:

   ```
   git commit -m "Merged branch_test into master"
   ```

4. Push:

   ```
   git push origin master
   ```

   

#### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.

```
git stash
git stash pop
```



#### 8. How do you understand PR is based on Branch?

A Pull Request (PR) is essentially a proposal to merge one branch's changes into another. When you create a PR, you're asking for the code in a specific branch (usually a feature or bugfix branch) to be merged into another branch (usually the main or development branch). This means the PR is based on the branch with the proposed changes and is targeting the branch that those changes should be merged into.

#### 9. What is maven role ? what it be used to do ?

Maven is a powerful project management tool primarily used in Java projects. Its core functionalities include dependency management, automatic project builds, and standardization of project setup. Essentially, it simplifies the build process by managing dependencies, compiling source code, packaging it into deployable formats, and even deploying it to certain environments.

#### 10. What is the lifecycle of maven? could you tell me the details ?

mvn Clean -> prepare-resources -> validate -> package -> install

![image-20230622111727253](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230622111727253.png)



#### 11. What is the difference between package and install in maven lifecycle ?

Package phase will execute all phases prior to that & it will stop with packaging the project as a jar. Similarly install phase will execute all prior phases & finally install the project locally for other dependent projects.



#### 12. What is plugins in maven, list some plugins.

- Plugins are the core of Maven's functionality. 
- They are used to perform specific tasks and provide certain behaviors or capabilities. 
- Maven has numerous plugins that can perform functions ranging from compiling code to creating documentation. 
- Plugins have goals, which are the specific tasks they can perform.

Here are some examples of common Maven plugins:

1. `maven-compiler-plugin`: Compiles Java sources.
2. `maven-jar-plugin`: Builds a JAR file from the current project.
3. `maven-war-plugin`: Builds a WAR file from the current project.
4. `maven-surefire-plugin`: Runs unit tests in the project.
5. `maven-failsafe-plugin`: Runs integration tests in the project.
6. `maven-javadoc-plugin`: Generates Javadoc for the project.
7. `maven-clean-plugin`: Cleans the project, removing files generated at build-time.
8. `maven-install-plugin`: Installs the project artifacts to the local repository.
9. `maven-deploy-plugin`: Deploys the final package to a remote repository.
10. `maven-site-plugin`: Generates a site for the documentation of the project.


