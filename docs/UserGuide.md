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
    * [Move Storage](UserGuide.md#move-storage-movestorage): `movestorage`
    * [Exiting the program](UserGuide.md#exiting-cyc-exit): `exit`
    * [Visitor Log](UserGuide.md#visitor-log)
    * [Saving data](UserGuide.md#saving-data)
    * [Changing save location](UserGuide.md#changing-save-location)
    * [History](UserGuide.md#history)
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
   =============================================================================
   Welcome to Safest Entry Tracker - Version v1.0
   Data successfully loaded from storage file path.
   =============================================================================
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

Example Input: `help`

Example Output:
```
Command Entered: help
=============================================================================
COMMAND SUMMARY:
Check-in visitor: checkin n/NAME i/LAST_4_CHARS_OF_ID [p/PHONE_NUMBER]
List all visitors: listall
List checked-in visitors only: list
Find visitor by ID: find i/LAST_4_CHARS_OF_ID
Checkout visitor: checkout [n/NAME] i/LAST_4_CHARS_OF_ID
Clear all visitor entries: clear
Edit venue capacity: editmax NEW_CAPACITY
Exit Control Your Crowd: exit
Refer to the user guide: https://ay2021s2-cs2113t-t09-1.github.io/tp/UserGuide.html
=============================================================================
```

### Check-in a person: `checkin`

Check in and add a person to the CYC. Also notifies users on current venue capacity, as well as the maximum.

Format: `checkin i/LAST_4_CHARS_OF_ID [n/NAME] [p/PHONE_NUMBER]`

* First 3 characters of `LAST_4_CHARS_OF_ID` should be integers.  Last character of `LAST_4_CHARS_OF_ID` must be in `CAPS`.
* `NAME` is optional. If the user has checked in before, entering the `LAST_4_CHARS_OF_ID` is sufficient to retrieve the user's `NAME` and `PHONE_NUMBER` 
  from previous check in. **If the user has not checked in before, `NAME` must be entered.**
* `NAME` must only contain english alphabet letters and empty spaces with a maximum character limit of 30. Any other characters will not be accepted.
* `PHONE_NUMBER` is optional. `PHONE_NUMBER` must consist of 8 integers, as per local (Singapore) phone number format.


Example Input: `checkin i/123A n/John p/91231112`

Example Output:
```
=============================================================================
John has been successfully checked in!
Current capacity: 50 out of 500
=============================================================================
```
However, expect the following output when the maximum capacity is reached.
```
=============================================================================
Unable to check in! Maximum capacity of 500 reached.
=============================================================================
```

### Listing all persons: listall

Shows a list of all persons who have checked-in and checked out.

Format: `listall`

Example Input: `listall`

Example Output:
```
============================================================================
|   ||Name                               ||Id      ||Phone     ||Checked In|
============================================================================
|1  ||John                               ||123A    ||91231112  ||Yes       |
----------------------------------------------------------------------------
|2  ||Jack                               ||234B    ||--        ||No        |
----------------------------------------------------------------------------
|3  ||Jane                               ||965T    ||--        ||Yes       |
----------------------------------------------------------------------------
============================================================================
```

### Listing checked-in persons only: `list`

Shows a list of all persons with their details currently checked-in. It also shows the number of people 
remaining to reach the maximum capacity for that venue.

Format: `list`

Example Input: `list`

Example Output:
```
============================================================================
|   ||Name                                ||Id          ||Phone            |
============================================================================
|1  ||John                                ||123A        ||91231112         |
----------------------------------------------------------------------------
|2  ||Jane                                ||965T        ||--               |
----------------------------------------------------------------------------
Number of people left for max capacity: 999
============================================================================
```

### Finding a person by ID number: `find`

Given the person's last 4 characters of ID, we can find the details of the person and status (Checked in, or checked out)

Format: `find i/LAST_4_CHARS_OF_ID`

* First 3 characters of `LAST_4_CHARS_OF_ID` should be integers.  Last character of `LAST_4_CHARS_OF_ID` must be in `CAPS`.
    
Example input: `find i/123A`

Example Output:
```
============================================================================
|   ||Name                               ||Id      ||Phone     ||Checked In|
============================================================================
|1  ||John                               ||123A    ||91231112  ||Yes       |
============================================================================
```

### Checkout a person: `checkout`

Removes the person’s name and personal details from the checked-in list.

Format: `checkout [n/NAME] i/LAST_4_CHARS_OF_ID`

* First 3 characters of `LAST_4_CHARS_OF_ID` should be integers.  Last character of `LAST_4_CHARS_OF_ID` must be in `CAPS`.
* `NAME` is optional. `NAME` must be a string. Integers will not be accepted.

Example input: `checkout n/John i/123A`

Example output:
```
============================================================================
John has been successfully checked out!
Current capacity: 50 out of 100
============================================================================
```

### Clearing all entries: `clear`

Clear all entries stored by the program, at the end of the day, or when required.

Format: `clear`

Example Input: `clear`

Example Output:
```
============================================================================
Cleared 1350 entries.
============================================================================
```

### Edit venue capacity: `editmax`

Edits the max capacity of the venue.

Format: `editmax NEW_CAPACITY`

* `NEW_CAPACITY` must be a positive integer.

Example Input:
`editmax 100`

Example Output:
```
============================================================================
New max capacity: 100
============================================================================
```

### Move storage: `movestorage`
COMING SOON

### Change storage location: `movestorage`

Move the location of the storage file to the specified destination.

Format: `movestorage NEW_DESTINATION`

Example Input:
`movestorage /new/test`

Example Output:
```
============================================================================
Moved storage file to /new/test.txt
============================================================================
```

### Exiting CYC: `exit`

Exit the CYC program.

Format: `exit`

Example Input: `exit`

Example Output: 
```
============================================================================
Exiting Control Your Crowd...
============================================================================
```

### Visitor Log

CYC automatically saves the details of previous persons.

A person who have checked in before, does not have to input all his details again when using the `checkin` command.

The person details are stored in `/LogFile.txt` in the same folder as the program.

#### Saving data
The program automatically saves data to a `.txt` file after each command you input.
The program defaults to saving to `/TrackingList.txt` in the same folder as the program.

#### Changing save location
To change the save location, you can use the command `movestorage`

### History

CYC automatically keeps a back up of the checkin and checkout history as CSV, comma separated values.

Users, such as event organiser or mall owners, could therefore study these data for future planning and necessary
upgrade of facilities.

#### Saving history
The program automatically saves the history to 'history.txt' file after each checkin and checkout operation.

#### Clearing history
To clear history, please follow the following steps:
1. Exit CYC.
2. Locate the directory of CYC on the computer.
3. Locate `/History.txt` and delete the file directly. 
   (CYC will start a new History file upon a restart.)

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Please follow these steps:
1. Follow the [Quick Start](UserGuide.md#quick-start) guide and install CYC on the computer
2. Transfer the `/History.txt`,`/LogFile.txt` and `/TrackingList.txt` to the target computer's main CYC folder.
3. Start CYC and it will automatically load the data.

## Command Summary

Action | Format | Examples
--- | --- | ---
Help | `help` | `help`
Check-in a person | `checkin i/LAST_4_CHARS_OF_ID n/NAME [p/PHONE_NUMBER]` | `checkin  i/123A n/John p/91231112`
List all person | `listall` | `listall`
List checked-in persons only | `list` | `list`
Find person by ID | `find i/LAST_4_CHARS_OF_ID` | `find i/123A`
Checkout a person | `checkout [n/NAME] i/LAST_4_CHARS_OF_ID` | `checkout n/John i/123A`
Clear all entries | `clear` | `clear`
Edit venue capacity | `editmax NEW_CAPACITY` | `editmax 100`
Move storage | `movestorage PATH` | `movestorage data/storage`
Exit | `exit` | `exit`


