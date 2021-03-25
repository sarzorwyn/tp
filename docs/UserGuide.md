#User Guide for Control Your Crowd (CYC)

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

Notes about the command format:
* Commands are in `lower_case`
* Items in square brackets `[ ]` are optional.
* Words in `UPPER_CASE` are the parameters to be supplied by user.
    * E.g. in `checkin n/NAME i/LAST_4_CHARS_OF_ID`, `NAME` is a parameter that has to be supplied by user. So e.g. `checkin n/John i/123A`
* Additional parameters for commands that do not take in parameters (such as `help`, `list`, `exit`, `clear`) will be ignored.
e.g if the user types `help 123`, it will be intepreted as `help`.
  


### Viewing help: `help`
Shows a message explaining how to access the help page.


Format: `help`

*  Additional parameters for commands that do not take in parameters 
    (such as `help`, `list`, `exit`, `clear`) will be ignored. The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`help`

### Checking in a person: `checkin`

Check in and add a person to the CYC. Also notifies users on current venue capacity, as well as the maximum.

Format: `checkin n/NAME i/LAST_4_CHARS_OF_ID [p/PHONE_NUMBER]`

Example Input:
`checkin n/John i/123a p/91231112`

Example Output:
```
=====================================================================
John has been successfully checked in!
There are currently 50 people in the mall. Maximum capacity is 500.
=====================================================================

However, expect the following output when the maximum capacity is reached.
=====================================================================
Unable to check in! Maximum capacity of 500 has been reached.
=====================================================================
```

### Listing all persons: list

Shows a list of all persons currently in the venue with the total number of people currently in the venue. 
Also shows the number of people left to reach the maximum capacity for the venue.

Format: `list`

Example Input: `list`

Example Output:
```
=====================================================================
John
Jack
Jill
Total: 3
Number people left for max capacity: 97
==================================================================
```

### Locating person by ID number: `find`

Given the person's last 4 characters of ID, we can find the details of the person's visit and status (Checked in, or checked out)

Format: `find i/LAST_4_CHARS_OF_ID`

Example input:
`find i/123A`
Example Output:
```
=====================================================================
John *****123A entered Mall @ 12.30 pm
=====================================================================
```

### Checking out a person: `checkout`

Removes the person’s name and personal details from the checked-in list

Format: `checkout n/NAME  i/LAST_4_CHARS_OF_ID`

Example input:
`checkout n/John i/123A`
Example output:
```
=====================================================================
John *****123A has been successfully checked out!
There are currently 50 people in the mall. Maximum capacity is 100.
=====================================================================
```

### Clearing all entries: `clear`

Clear all entries stored by the program, at the end of the day, or when required.

Format: `clear`

Example Input:
`clear`

Example Output:
```
=====================================================================
Cleared 1350 entries.
==================================================================
```

### Edit venue capacity: `editmax`

Edits the max capacity of the venue.

Format: `editmax NEW_CAPACITY`

Example Input:
`editmax 100`

Example Output:
```
=====================================================================
Changed max capacity of venue to 100
==================================================================
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
