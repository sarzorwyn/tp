# H Mohamed Hussain - Project Portfolio

## Project: Control Your Crowd

Control Your Crowd (CYC) is a desktop application used for managing crowd levels at any location or events. 
The user interacts with it using a Command Line Interface (CLI). It is written in Java using the 
Object-oriented programming (OOP) paradigm and has about 5 kLoc.

Given below are my contributions to the project:

* **New Feature**: Added Visitor Log feature in CYC.
  * What it does: Allows user to enter the visitor details, such as Name and Phone number, only once during check-in. 
    Subsequent check-ins can be done using only the visitor's Id.
  * Justification: This feature improves the product significantly as it reduces the time and effort 
    to type all the visitor particulars again. 
  * Highlights: This enhancement affects existing commands and storage components of the project. The implementation was
    challenging as it required changes to the components. Provided methods for commands as an API to abstract away the
    details of handling visitor log. Used existing implementation of StorageFile class to store the data into a file.

* **Code contributed**: [RepoSense link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=hussain1998&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-03-05)
    
* **Project management**:
  * Managed releases `v1.0` - `v2.1` on Github
  
* **Documentation**:
  * Developer Guide:
    * Added documentation for the model component, and the implementation section.
    * Added a model uml diagram, and a sequence diagram for the implementation section. 
  * User Guide:
    * Added FAQ section
    * Added documentation for the Visitor Log feature.
  
* **Community**:
  * Contributed to the user stories
  * Created a logo for the CYC app
  * Incorporated the use of Java Regular Expression(Regex) which was adopted by other teammates.

* **Tools**:
    * Integrated a third party library ([Gson](https://github.com/google/gson)) to the project.
