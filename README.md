# ENPM613ULMSRepo
This repository will contain all the changes for the ULMS project. 

To perform git commands on Windows/MAC download the git command. This will be commandline based in Windows and MAC. The Windows version will contain a special CLI simulating linux command line commands.
https://git-scm.com/

To clone git repository locally execute command that will create ENPM613UMLSRepo directory:
git clone https://github.com/Palak-Chourasiya/ENPM613ULMSRepo.git

To determine the status of your local git repository against the remote git repository perform in the root folder of your project:
git status

When you create new artifacts or modify existing artifacts (files/directories) you will need to perform this command to reindex your local git repository against the remote git repository in the root folder of your project.  You can add a single file or add everything in current directory:
git add <file>
git add .

In order to identify yourself when committing to the repository you need to perform the below commands for setting your email address and name. Note, that omitting the -global option will only set it for the current session you are performing in the CLI.
git config --global user.email "you@example.com"
git config --global user.name "Your Name"

When you have new/modified artifacts ready to commit perform this command to push to remote git repository in the root folder of your project:
git commit 
