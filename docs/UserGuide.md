#User Guide for Control Your Crowd

## Introduction

Control Your Crowd (CYC) is a Command Line Interface (CLI) application for the venue management team to manage crowd
levels in real time. It allows efficient tracking and accessing of visitor's profiles with ease. You can easily checkin
and checkout a visitor, get current crowd level, limit the venue capacity, save the data for future references and much
more. If you can type fast, CYC can enable you to manage the crowd faster than traditional Graphical User Interface 
(GUI) applications.

* [Quick Start](UserGuide.md#quick-start)
* [Features](UserGuide.md#features)
    * [Viewing help](): `help`
    * [Check-in a person](): `checkin`
    * [Listing all persons](): `listall`
    * [Listing checked-in persons only](): `list`
    * [Finding a person by ID](): `find`
    * [Checkout a person](): `checkout`
    * [Clearing all entries](): `clear`
    * [Edit venue capacity](): `editmax`
    * [Exiting the program](): `exit`
    * [Visitor Log (WIP) - Register once only]()
    * [Saving data (WIP)]()
    * [Changing save location (WIP)]()
    * [History]()
* [FAQ](UserGuide.md#faq)
* [Command summary](UserGuide.md#command-summary)

## Quick Start

1. Ensure that you have Java 11 or above installed in your Computer.
2. Download the latest version of `ControlYourCrowd.jar` from [here](https://github.com/AY2021S2-CS2113T-T09-1/tp/releases).
3. Copy the file to the folder you want to use as the home folder for your CYC.
4. Open up a command window to the location where your `ControlYourCrowd.jar` is located.
5. Run the command `java -jar [venue name] [venue maximum capacity] ControlYourCrowd.jar`. For example, 
   `java -jar NUS 1000 ControlYourCrowd.jar`.
6. If the setup is correct, you should see CYC being loaded as shown below.
    ```
   =========================================================
   Welcome to Safest Entry Tracker - Version v1.0
   Data successfully loaded from storage file path.
   =========================================================
   ```
7. Input the command in the command window and press Enter to execute it. Refer to [Features](UserGuide.md#features)
   for details of each command.

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
