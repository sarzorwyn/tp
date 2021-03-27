# User Guide for Control Your Crowd (CYC)

## Introduction

Control Your Crowd (CYC) is a Command Line Interface (CLI) application for the venue management team to manage crowd
levels in real time. It allows efficient tracking and accessing of visitor's profiles with ease. You can easily checkin
and checkout a visitor, get current crowd level, limit the venue capacity, save the data for future references and much
more. If you can type fast, CYC can enable you to manage the crowd faster than traditional Graphical User Interface 
(GUI) applications.

* [Quick Start](UserGuide.md#quick-start)
* [Features](UserGuide.md#features)
    * [Viewing help](UserGuide.md#viewing-help-help): `help`
    * [Check-in a person](UserGuide.md#check-in-a-person-checkin): `checkin`
    * [Listing all persons](UserGuide.md#listing-all-persons-listall): `listall`
    * [Listing checked-in persons only](UserGuide.md#listing-checked-in-persons-only-list): `list`
    * [Finding a person by ID](UserGuide.md#finding-a-person-by-id-number-find): `find`
    * [Checkout a person](UserGuide.md#checkout-a-person-checkout): `checkout`
    * [Clearing all entries](UserGuide.md#clearing-all-entries-clear): `clear`
    * [Edit venue capacity](UserGuide.md#edit-venue-capacity-editmax): `editmax`
    * [Exiting the program](UserGuide.md#exiting-cyc-exit): `exit`
    * [Visitor Log (WIP) - Register once only](UserGuide.md#visitor-log-wip---register-once-only)
    * [Saving data (WIP)](UserGuide.md#saving-data-wip)
    * [Changing save location (WIP)](UserGuide.md#changing-save-location-wip)
    * [History](UserGuide.md#history-wip)
* [FAQ](UserGuide.md#faq)
* [Command summary](UserGuide.md#command-summary)

## Quick Start

> Prerequisites:
> * Ensure that you have Java 11 or above installed in your Computer.

1. Download the latest version of `ControlYourCrowd.jar` from [here](https://github.com/AY2021S2-CS2113T-T09-1/tp/releases).
2. Copy the file to the folder you want to use as the home folder for your CYC.
3. Open up a command window to the location where your `ControlYourCrowd.jar` is located.
4. Run the command `java -jar [venue name] [venue maximum capacity] ControlYourCrowd.jar`. For example, 
   `java -jar NUS 1000 ControlYourCrowd.jar`.
5. If the setup is correct, you should see CYC being loaded as shown below.
    ```
   =========================================================
   Welcome to Safest Entry Tracker - Version v1.0
   Data successfully loaded from storage file path.
   =========================================================
   ```
6. Input the command in the command window and press Enter to execute it. Refer to [Features](UserGuide.md#features)
   for details of each command.

## Features 

> Notes about the command format:
> * Commands are in `lower_case`.
> * Items in square brackets `[ ]` are optional.
> * Words in `UPPER_CASE` are the parameters to be supplied by user.
>    * E.g. in `checkin n/NAME i/LAST_4_CHARS_OF_ID`, `NAME` is a parameter that has to be supplied by user. So e.g. `checkin n/John i/123A`.
> * Additional parameters for commands that do not take in parameters (such as `help`, `list`, `exit`, `clear`) will be ignored.
>   * e.g. if the user types `help 123`, it will be interpreted as `help`.
> * `i/LAST_4_CHARS_OF_ID` is unique. (i.e. no two persons will have the same ID)

### Viewing help: `help`

Shows a message explaining how to access the help page.

Format: `help`

*  Additional parameters for commands that do not take in parameters 
    (such as `help`, `list`, `exit`, `clear`) will be ignored. The `TODO_NAME` cannot contain punctuation.  

Example Input: `help`

Example Output:
```
WORK IN PROGRESS
```

### Check-in a person: `checkin`

Check in and add a person to the CYC. Also notifies users on current venue capacity, as well as the maximum.

Format: `checkin n/NAME i/LAST_4_CHARS_OF_ID [p/PHONE_NUMBER]`

Example Input: `checkin n/John i/123A p/91231112`

Example Output:
```
=========================================================
John has been successfully checked in!
Current capacity: 50
Maximum capacity: 500
=========================================================
```
However, expect the following output when the maximum capacity is reached.
```
=========================================================
Unable to check in! Maximum capacity of 500 reached.
=========================================================
```

### Listing all persons: listall

Shows a list of all persons who have checked-in and checked out.

Format: `listall`

Example Input: `listall`

Example Output:
```
=========================================================
|   ||Name           ||Id      ||Phone     ||Checked In |
---------------------------------------------------------
|1  ||John           ||123A    ||91231112  ||Yes        |
---------------------------------------------------------
|2  ||Jack           ||234B    ||--        ||No         |
---------------------------------------------------------
=========================================================
```

### Listing checked-in persons only: `list`

Shows a list of all persons with their details currently checked-in. It also shows the number of people 
remaining to reach the maximum capacity for that venue.

Format: `list`

Example Input: `list`

Example Output:
```
=========================================================
|   ||Name           ||Id      ||Phone                  |
---------------------------------------------------------
|1  ||John           ||123A    ||91231112               |
---------------------------------------------------------
Number of people left for max capacity: 999
=========================================================
```

### Finding a person by ID number: `find`

Given the person's last 4 characters of ID, we can find the details of the person and status (Checked in, or checked out)

Format: `find i/LAST_4_CHARS_OF_ID`

Example input: `find i/123A`

Example Output:
```
=========================================================
|   ||Name           ||Id      ||Phone     ||Checked In |
=========================================================
|1  ||John           ||123A    ||91231112  ||Yes        |
---------------------------------------------------------
=========================================================
```

### Checkout a person: `checkout`

Removes the person’s name and personal details from the checked-in list.

Format: `checkout [n/NAME] i/LAST_4_CHARS_OF_ID`

Example input: `checkout n/John i/123A`

Example output:
```
=========================================================
John has been successfully checked out!
Current capacity: 50 
Maximum capacity: 100
=========================================================
```

### Clearing all entries: `clear`

Clear all entries stored by the program, at the end of the day, or when required.

Format: `clear`

Example Input: `clear`

Example Output:
```
=========================================================
Cleared 1350 entries.
=========================================================
```

### Edit venue capacity: `editmax`

Edits the max capacity of the venue.

Format: `editmax NEW_CAPACITY`

Example Input:
`editmax 100`

Example Output:
```
=========================================================
New max capacity: 100
=========================================================
```

### Change storage location: `movestorage`

Move the location of the storage file to the specified destination.

Format: `movestorage NEW_DESTINATION`

Example Input:
`movestorage /new/test`

Example Output:
```
=========================================================
Moved storage file to /new/test.txt
=========================================================
```

### Exiting CYC: `exit`

Exit the CYC program.

Format: `exit`

Example Input: `exit`

Example Output: 
```
=========================================================
Exiting Control Your Crowd...
=========================================================
```

### Storing the details of previous persons

CYC automatically saves the details of previous persons.
A person who have checked in before, does not have to input all his details again when using the `checkin` command.
The person details are stored in `/LogFile.txt` in the same folder as the program.

### Saving data
The program automatically saves data to a `.txt` file after each command you input.
The program defaults to saving to `/TrackingList.txt` in the same folder as the program.

### Changing save location
To change the save location, you can use the command `movestorage`
### History (WIP)

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

Action | Format | Examples
--- | --- | ---
Help | `help` | `help`
Check-in a person | `checkin n/NAME i/LAST_4_CHARS_OF_ID [p/PHONE_NUMBER]` | `checkin n/John i/123A p/91231112`
List all person | `listall` | `listall`
List checked-in persons only | `list` | `list`
Find person by ID | `find i/LAST_4_CHARS_OF_ID` | `find i/123A`
Checkout a person | `checkout [n/NAME] i/LAST_4_CHARS_OF_ID` | `checkout n/John i/123A`
Clear all entries | `clear` | `clear`
Edit venue capacity | `editmax NEW_CAPACITY` | `editmax 100`
Exit | `exit` | `exit`


