# Jonathan Khoo - Project Portfolio Page

## Project: Control Your Crowd


## Overview
Control Your Crowd (CYC) is a desktop application used for managing crowd levels at any location or events.
The user interacts with it using a Command Line Interface (CLI). It is written in Java using the
Object-oriented programming (OOP) paradigm, and has about xxx LoC.

Given below are my contributions to the project.


### Summary of Contributions

* **New Feature**: Parsing for checkin functionality in CYC
    * What it does: Processes and parses user input, to identify if user is entering
    correct details, and to separate the information required by the checkin functionality 
      from the unimportant information.
    
    * Justification: This feature is crucial to the product since it is the first layer of filtering
    that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.
    
    * Highlights: This enhancement affects the ability of the checkin functionality to work. The implementation was challenging 
    as it required a thorough consideration of all alternative user inputs which may be intepreted as errors, and the alternative 
      user inputs which may be considered as valid. An important feature is it allows users who have 
      previously checked in, to leave out either their phone number or their name. This dynamic input was 
      challenging to implement as collaboration with the checkin functionality side had to be done consistently 
      to ensure syncing.
      
    
* **New Feature**: Parsing for checkout functionality in CYC.
    * What it does: Processes and parses user input, to identify if user is entering
  correct details, and to separate the information required by the checkout functionality
  from the unimportant information.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.

    * Highlights: This enhancement affects the ability of the checkout functionality to work. The implementation was challenging
      as it required a thorough consideration of all alternative user inputs which may be intepreted as errors, and the alternative
      user inputs which may be considered as valid.

* **New Feature**: Parsing for listing functionality.
    * What it does: Processes and parses user input, to identify if user is entering
      correct details, and to separate the information required by the listing functionalities
      from the unimportant information.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.

    * Highlights: There are 2 listing functionalities in CYC, and the parser allows for identification
      of either listing functionality: listing only checked in users, or listing all checked in and checked out 
      users.
      The implementation was challenging as it required a thorough consideration of all alternative user inputs which may be intepreted as errors, and the alternative
      user inputs which may be considered as valid.

* **New Feature**: Parsing for search functionality.

    * What it does: Processes and parses user input, to identify if user is entering
    correct details, and to separate the information required by the search functionality
    from the unimportant information.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.

    * Highlights: This search functionality allows for users to pull up the status of the user. Checks has to be
    made, to ensure that the ID entered by the user is a valid ID.
      
* **New Feature**: Parsing for clearing of log entries.

    * What it does: Processes and parses user input, to identify if user is entering
      correct details.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
    that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
    of usable information, and those that are not.   

* **New Feature**: Parsing for editing of maximum venue capacity.

    * What it does: Processes and parses user input, to set the maximum venue capacity determined by user.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.


* **New Feature**: Parsing for help functionality.

    * What it does: Processes and parses user input, to display the help menu for user.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.

* **New Feature**: Parsing for storage moving functionality.

    * What it does: Processes and parses user input, to set the local log storage address.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.

* **New Feature**: Parsing for functionality to exit CYC.

    * What it does: Processes and parses user input, to allow for shutdown and exit of CYC in a safe manner
    that prevents data loss.

    * Justification: This feature is crucial to the product since it is the first layer of filtering
      that the user's input goes through. Invalid commands must be able to be filtered out, as well as separation
      of usable information, and those that are not.

* **Code contributed**:

    [Reposense link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=JonathanKhooTY&tabRepo=AY2021S2-CS2113T-T09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

* **Project management**:

    * Collaborated with the team to manage releases of V1.0, V2.0, as well as the final V2.1.

* **Documentation**:
    * User Guide:
        * Added documentation for `checkin` command. (#102)
        * Made functionality tweak descriptions to `checkin` command in V2.0. (#131, #137, #139)
        * Added documentation for 'find' command. (#102)
        * Added documentation for 'checkout' command. (#102)
        * Tweaked command summary. (#102) 
    
    * Developer Guide:
        * Added architecture diagram together with description. (#182, #265)
        * Added target user profile to documentation. (#85)
        * Added our product's value proposition. (#85)
        * Added user stories to Appendix B of developer guide. (#85)
        * Added glossary to Appendix E of developer guide. (#258)
        * Added non functional requirements to developer guide. (#258)
    
* **Community**:
    *
    
* **Tools**:
    * 
