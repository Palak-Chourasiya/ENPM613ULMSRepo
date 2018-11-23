# ENPM613ULMSRepo
This repository will contain all the changes for the ULMS project. 

To perform git commands on Windows/MAC download the git command. This will be commandline based in Windows and MAC. The Windows version will contain a special CLI simulating linux command line commands.
https://git-scm.com/

To clone git repository locally execute command that will create ENPM613UMLSRepo directory. This will give you the project files and a local git repository:
git clone https://github.com/Palak-Chourasiya/ENPM613ULMSRepo.git

To determine the status of your local project against your local git repository perform in the root folder of your project:
git status

When you create new artifacts or modify existing artifacts (files/directories) you will need to perform this command to reindex your local project against your local git repository in the root folder of your project.  You can add a single file or add everything in current directory:
git add <file>
git add .

In order to identify yourself when committing to the local repository you need to perform the below commands for setting your email address and name. Note, that omitting the -global option will only set it for the current session you are performing in the CLI.
git config --global user.email "you@example.com"
git config --global user.name "Your Name"

When you have new/modified artifacts ready to commit perform this command to commit to local git repository in the root folder of your project:
git commit 

When you are ready to push the branched local repository to the remote repository perform this command:
git push

If your git push command fails run this command:
git push origin HEAD:master

When you need to pull changes from the remote repository made by team members perform this command:
git pull https://github.com/Palak-Chourasiya/ENPM613ULMSRepo.git


Spring & Angular JS Resources:
http://websystique.com/spring-boot/spring-boot-angularjs-spring-data-jpa-crud-app-example/
https://github.com/jhades/spring-mvc-angularjs-sample-app
https://spring.io/guides/gs/messaging-jms/
https://stackoverflow.com/questions/18171127/messaging-between-users-in-spring-mvc-app
https://github.com/eugenp/tutorials
https://www.baeldung.com/spring-response-entity
https://blog.angular-university.io/developing-a-modern-java-8-web-app-with-spring-mvc-and-angularjs/
https://www.baeldung.com/spring-mvc-form-tutorial
https://docs.angularjs.org/tutorial/step_03

To create a new git branch
- open git bash in the git repository folder
- git checkout -b <your-branch-name>
- git merge <origin-branch-name>
example: git merge master
- git add *
- git commit -m "your commit message"
- git push --set-upstream origin <your-branch-name>

#To switch between branch, use git checkout <branch name>. Before merge with other branches, remember to pull the latest update first before merging to reduce conflicted.
  - git pull
  - get merge <origin-branch-name>

#To build the war file using gradle use the following command in GitBash command line in windows or regular command line in mac at your project root directory:
  - gradle war
  
#The project war file will be located under the root project directory in build/libs/ENPM613ULMSRepo-#.#.#-SNAPSHOT.war