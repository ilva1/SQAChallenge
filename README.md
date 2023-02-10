# SQAChallenge

Why?
Installation
Git Integration

Why?
I had a SQA challenge and i wanted to choose the working environment that:
1. has multiple editions
2. supports a wide range of programming languages and frameworks
3. has better plugin and extension support
4. is a proprietary software licensed under the Apache License2.0
5. has a great autocomplete feature that makes writing code so much easier.
6. is definitely the winner in performance
So i chose IntelliJ ---> Download steps (Method 1):
1. Download installer: https://www.jetbrains.com/idea/download/#section=windows
2. Run the installer and follow the wizard steps
3. On the Installation Options step, you can configure the following:
-Create a desktop shortcut for launching IntelliJ IDEA.
-Add the directory with IntelliJ IDEA command-line launchers to the PATH environment variable to be able to run them from any working directory in the Command Prompt.
-Add the Open Folder as Project action to the system context menu (when you right-click a folder).
-Associate specific file extensions with IntelliJ IDEA to open them with a double-click.
4. To run IntelliJ IDEA, find it in the Windows Start menu or use the desktop shortcut.
So i chose IntelliJ ---> Download steps (Method 2):
1. Download the disk image .dmg from the Toolbox App web page.
2. There are separate disk images for Intel and Apple Silicon processors.
3. Mount the image and drag the JetBrains Toolbox app to the Applications folder.
4. After you run the Toolbox App, click its icon in the main menu and select which product you want to install.
5. To install a specific version, click App actions more and select Available versions.
6. Log in to your JetBrains Account from the Toolbox App, and it will automatically activate the available licenses for any IDE that you install.

I wanted also to chose a framework that:
1 that supports behavior-driven development and
2. allows you to write features and scenarios in a human-readable language.
So i chose cucumber + Seelenium
Steps to use it: (Enable plugins)
1. Press Ctrl+Alt+S to open the IDE settings and select Plugins.
2. Switch to the Installed tab and make sure that the following plugins are enabled (the plugins must be enabled in the specified order):
- Gherkin
- Cucumber for Java
-Cucumber for Groovy (optional: install this plugin if you want to create step definitions in Groovy)
3. If the plugins are not installed, switch to the Marketplace tab, type their names in the search field in the specified order, and click Install next to each of them.
4. Apply the changes and close the dialog. Restart the IDE if prompted.
Add the Cucumber library
1. From the main menu, select File | Project Structure (Ctrl+Alt+Shift+S) or click the Project Structure button on the toolbar.
2. Under Project Settings, select Libraries and click the New Project Library button | From Maven.
3. In the dialog that opens, specify the artifact of the library version that you want to use in your project, for example: io.cucumber:cucumber-java:jar:6.1.1 or io.cucumber:cucumber-java8:jar:6.1.1 (if you want to use lambda expressions in step definitions).
4 Click OK.
5. Apply the changes and close the Project Structure dialog.

I have Prepared folder structure
1. Test Sources Root: a Test Sources Root icon folder that stores your test code
2. Test Resources Root: a Test Resources Root folder that stores files associated with your test sources

I have already created the features file and step definition in Java programming language
1. Click Run Test in the gutter next to the scenario that you want to run and select Run 'Scenario: <name>'.
2. Click Run Test in the gutter next to the feature that you want to run and select Run 'Feature: <name>'.
3. In the Project tool window (Alt+1), right-click the features folder and select Run all Features in: <directory name>.

When the tests finish running, the results are displayed on the Test Runner tab of the Run tool window. 

The only dependencies on Maven project :      
       <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>4.3.0</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-picocontainer</artifactId>
            <version>4.3.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-picocontainer</artifactId>
            <version>6.10.1</version>
            <scope>test</scope>
        </dependency>

Git command line:
    $ git add .
    $ git commit -m "Project name"
    $ git push origin master
    

