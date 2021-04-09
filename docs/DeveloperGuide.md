# Control Your Crowd - Developer Guide

* [Setting up](DeveloperGuide.md#setting-up)
* [Design](DeveloperGuide.md#design)
  * [Architecture](DeveloperGuide.md#architecture)
  * [UI component](DeveloperGuide.md#ui-component)
  * [Logic component](DeveloperGuide.md#logic-component)
  * [Model component](DeveloperGuide.md#model-component)
  * [Storage component](DeveloperGuide.md#storage-component)
  * [Common classes](DeveloperGuide.md#common-classes)
* [Implementation](DeveloperGuide.md#implementation)
* [Documentation](DeveloperGuide.md#documentation)
* [Testing](DeveloperGuide.md#testing)
* [Dev Ops](DeveloperGuide.md#dev-ops)
* [Appendix](DeveloperGuide.md#appendix)
  * [Appendix A: Product Scope](DeveloperGuide.md#appendix-a-product-scope)
    * [Target user profile](DeveloperGuide.md#target-user-profile)
    * [Value proposition](DeveloperGuide.md#value-proposition)
  * [Appendix B: User Stories](DeveloperGuide.md#appendix-b-user-stories)
  * [Appendix C: Use Cases](DeveloperGuide.md#appendix-c-use-cases)
  * [Appendix D: Non Functional Requirements](DeveloperGuide.md#appendix-d-non-functional-requirements)
  * [Appendix E: Glossary](DeveloperGuide.md#appendix-e-glossary)
  * [Appendix F: Instructions for Manual Testing](DeveloperGuide.md#appendix-f-instructions-for-manual-testing)
    * [Launch and Shutdown](DeveloperGuide.md#launch-and-shutdown)
    * [Clearing the list](DeveloperGuide.md#clearing-the-list)
    * [Saving data](DeveloperGuide.md#saving-data)

## Setting up

The instructions for setting up can be [found here](SettingUp.md).

## Design

### Architecture
![Architecture](images/architecture.png)
*Figure #. Architecture Diagram*

The ***Architecture Diagram*** shown above explains the high-level design of Control Your Crowd (CYC) application.
Below is a quick overview of each component.

`Main` is a class that is critical to starting the application proper, as well as exiting it:
* At app launch: Retrieves memory and saved log files (If available), initializes components in correct sequence, 
and connects them with each other.
  
* At shut down: It saves the log file to storage, and shuts down all components.


`Common` consists of a class of messages used by multiple components.
* `Messages` consists of a list of messages that will be displayed to the users, for various reasons such as error handling
and user notification.

The rest of Control-Your-Crowd (CYC) consist of four components.
* `UI`: The user interface of the application, and the entry point from the user.

* `Logic`: The command executor for CYC.

* `Model` : Holds the in-App data, such as the details of the user, and their checked-in/checked-out status.

* `Storage`: Reads and writes data from the hard disk to CYC.

#### How the architecture components interact with each other

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues
the command `clear`.

![](images/ComponentsInteractionsDiagram.png?raw=true "Component interactions for clear command")
*Figure #. Component interactions for `clear` command*

### UI component

![](images/UIComponentStructure.png?raw=true "Logic component Sequence Diagram for clear")
The UI consists of `TextUi` class. It acts as a middleware between users' input
and `Parser` class under **Logic Component**.

The `UI` component,

* Reads user commands using `Scanner` class.
* Pass raw user commands into `Parser` class under **Logic Component**.
* After the **Logic Component** has executed the function, it will then return `CommandOutput` object
  which contains the outcome of the execution, fail or succeed.

### Logic component

![](images/LogicComponentStructure.png?raw=true "Structure of Logic Component")
*Figure #. Structure of the Logic Component*

**API** : [`seedu.duke.logic`](https://github.com/AY2021S2-CS2113T-T09-1/tp/tree/master/src/main/java/seedu/duke/logic) package

The Logic component,
1. Uses the `Parser` class to parse the user input obtained by the `TextUi` class of `UI`.
2. This results in a specific `Command` object to be returned from the `Parser` class.
3. Depending on the type of the `Command` object, its corresponding command execution will be called by `Main` class.
4. Some command execution affects the data in `Model` (e.g. clearing the list). 
5. The result of the command execution is encapsulated as a `CommandOutput` object which is passed back to the `TextUi`.
6. In addition, the `CommandOutput` object can also instruct the `TextUi` to perform certain actions, such as displaying the list to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `parseCommand("clear)"` API call.

![](images/LogicComponentSequenceDiagram.png?raw=true "Logic component Sequence Diagram for clear")
*Figure #. Interactions Inside the Logic Component for the `clear` Command*

### Model component

**API** : [`seedu.cyc.person`](https://github.com/AY2021S2-CS2113T-T09-1/tp/tree/master/src/main/java/seedu/cyc/person) package


<img src="images/ModelComponentStructure.png" width="600" height="600" />

*Figure #. Structure of the Model Component*

The Model component,

* contains a `Person` class which represents a person who checks in/out.
* contains a `TrackingList` class which uses an ArrayList to keep track of all the `Person` objects who have currently checked in/out.
* contains a `PersonLog` class which uses a HashMap to permanently store all the `Person` objects who have checked in before.

A `Person` object contains:
* an `Id` object
* a `Name` object
* a `Phone` object


### Storage component
**API** : [`seedu.cyc.storage`](https://github.com/AY2021S2-CS2113T-T09-1/tp/tree/master/src/main/java/seedu/cyc/storage) package
![](images/storage_module.png?raw=true "Storage Module diagram")

The `Storage` component,
* saves and encodes `Person` objects in `Tracking List` into a `.txt` file.
* reads a `.txt` file of valid encoding and populates a `TrackingList`
* records a log of all historical states of `TrackingList`
* keeps a list of user setting in a `Config.properties` file which is read on launch
* defaults to `TrackingList.txt` but can be saved at a custom specified location
* loads on program startup automatically saves after each command

The storage module uses the `StorageFile` class to store the `TrackingList` class from Model. 
`StorageFile` achieves this by using two helper classes, `TrackingListEncoder` and `TrackingListDecoder`.
`StorageFile` is called by the main class after the execution of any `Command`.

`TrackingListEncoder` takes the currently stored `TrackingList` and converts it to a more storage friendly String.
This String is then written to a file on the disk, known on the diagram as `StoredTrackingList`.
As the name suggests, `TrackingListDecoder` achieves the reverse by taking the file on drive, `StoredTrackingList`,
and interprets the file to be loaded into the memory as a `TrackingList`.

![](images/storage_pathdir.png?raw=true "Storage Module file structure")

`StoredTrackingList` is the `.txt` file stored in the same directory as the program.
The location is determined by the `ConfigFile` class.

`LogFile` takes the `TrackingList` every time the storage is updated
and packages it into `json` formatted string.
`LogFile` communicates with the disk by calling the methods
`loadLogFile` and `saveLogFile` in the `StorageFile` class.

`History` stores a record every time the `Command` `CheckIn` and `CheckOut` are successfully executed.
It includes information about the `Person` details, `Time` the person checked in, and movement 
(whether the person was checked in or checked out)
The data is stored in a `csv` format in `History.txt`.

The program settings for the user is manged by the `ConfigFile` class. 
Another file, `settingsFile` is read by `ConfigFile` when the program is started, 
to load the settings into the program memory. 
When a change is made by the user, `ConfigFile` will update the `settingsFile` through a save function.

### Common classes

Classes used by multiple components are in the `seedu.cyc.commons` package. 

## Implementation

## Documentation

## Testing

## Dev Ops

## Appendix

### Appendix A: Product scope

#### Target user profile
* User that requires more control over crowd level management in a building.
* Can type fast
* Prefers a simple desktop application over the more complicated systems
* Is reasonably comfortable with CLI apps
* Requires real time monitoring and tracking capability of people in the building
* Wants a cheaper alternative to crowd tracking systems

#### Value proposition

A fast and versatile software solution that enables mall management to crowd control 
in the most efficient way possible.

### Appendix B: User Stories 
[WIP]

|Priority| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|*****|mall staff|be able to review the personal particulars of the customer|be aware of who he is|
|*****|new user|be able to use the program without much training| use the program as soon as possible and easily implement it|
|*****|mall staff|be able to view the current capacity of people in the mall|know when to stop letting people in|
|****|mall staff|key in personal particulars easily into the application| check in visitors quickly without holding up a line of customers|
|****|mall staff|be able to easily key in a unique personal identifier| check in and find a visitor|
|****|mall staff|be able to easily key in a unique personal identifier|check out a visitor|


### Appendix C: Use Cases

### Appendix D: Non-Functional Requirements

[WIP]

1. The program works on all major modern operating systems (Windows, macOS, Linux) 
   without any effort by the user, as long as the system has Java 11 or above installed.


2. A user with above average typing speed for regular English text should be able to accomplish most of the 
tasks faster than using the mouse.
   

3. The log files, especially those containing sensitive personal data, are stored locally
and no wireless transfer is allowed.
   

4. The software should be portable. So moving from OS to OS does not create any problem.


5. Maintenance to clear the log files should be smooth and fast with no delay.


### Appendix E: Glossary 
[WIP]

###A:
###B:
**Bug**: *See defect*
###C:
**Change log**: An official document containing the list of all Change Requests submitted.

**Class**: A  class  describes  a set  of  objects  that  share  the  same  specifications  of  features,  
constraints, and semantics. Class is a kind of classifier whose features are attributes and operations.

**Class diagram**: A type of static structure diagram that describes the structure of a system by showing the  
system's  classes,  their  attributes,  operations  (or  methods),  and  the  relationships  among  the classes.

**Customer**: Current  or  potential  buyer  or  user  of  the  products  or  service  of  an  individual  
or organization, called the supplier, seller, or vendor.
###D:
**Defect**: A flaw in a component or system that can cause the component or system to fail to 
perform its required function, e.g. an incorrect  statement or data definition. 
A defect,  if encountered during execution, may cause a failure of the component or system

**Dependency**:  A  reliance  of  some  kind, of  one  set of components  on  
another  set  of components, or one set of requirements or other artifacts on another set

**Deployment diagram**: In UML a diagram that shows the execution architecture of systems
###E:

**Efficiency**: The capability of the software product 
to provide appropriate performance,relative to the amount of resources used under stated conditions [ISO/IEC 25000].

**Error**: A human action that produces an incorrect result [After IEEE 610].

**Exception handling**: Behavior of a component or system in response to erroneous input, 
from either a human user or from another component or system, or to an internal failure.
###F:

**Function**: A description  of“what” a system does. A function has a corresponding implied purpose and  is  a  fundamental  part  of  a  system  description:  a  system  consists  of  function  attributes,
performance  attributes,resource  (cost)  attributes  and  design  attributes.  All  attributes  exist  with respect to defined specified conditions. A function can often be decomposed into a hierarchical set of sub-functions [TGilb].

**Functionality**: The  capability  of  the  software  product  to  provide  functions  which  meet  statedand implied needs when the software is used under specified conditions[ISO/IEC 25000].
###G:
**Goal**: A desired state or result of an undertaken. Goals should be measurable and defined in time so that the progress can be monitored.
###H:

**High-level**: A  position  in  a hierarchy of  defined  system  components, which  is  closer  to  the  top than the bottom, relative to the total defined set of those components [TGilb]
###I:

**Input**: A variable (whether stored within a component or outside) that is read by a component.

**Input value**: An instance of an input. *See also input.*
###J:
###K:
###L:
###M:
**Maintenance**: Modification  of  a  software  product  after  delivery  to  correct  defects,
to  improve performance or other attributes, or to adapt the product to a modified environment [IEEE 1219].

**Milestone**: A  point  in  time  in  a  project  at  which  defined  (intermediate)  deliverables  and  results should be ready.
###N:
###O:
**Object**: In OOAD an instance of a class.

**Object  diagram**: In  UML  a  diagramthat  depicts  objects  and  their
relationships  at  a  point  in  time, typically a special case of either a class diagram or a communication diagram.

**Object-oriented  analysis  and  design**: A  software  engineering  approach  that  models  a  system  as  a group  of  interacting  objects.
Each  object  represents  some  entity  of  interest  in  the  system  being modeled,  and  is  characterized  by  its  class,
its  state  (data  elements),  and  its  behavior.  OOAD encompasses Object-oriented analysis (OOA) and Object-oriented design (OOD).
OOA applies object-modeling  techniques  to  analyze  the  functional  requirements  for  a  system.  OOD  elaborates  the analysis models to produce implementation specifications.


**OOAD**: *see Object-oriented analysis and design.*


**OS**: Windows, Linux, Unix, OS-X

**Output**: A variable (whether stored within a component or outside) that is written by a component.


###P:

**Performance**: The  degree  to  which  a  system  or  component  accomplishes  its  designated functions within
given   constraints  regarding   processing   time   and   through put   rate   [IEEE 610].
See also *efficiency.*


**Personal data**: Private information pertaining to an individual's ID, and phone number,
and is not meant to be publicly shared.


**Portability**: The  ease  with  which  the  software  product  can  be  transferred  from  one  hardwareor software environment to another [ISO/IEC 25000]

**Priority**: The level of (business) importance assigned to an item, e.g. defect.

**Process**: A set of interrelated activities, which transform inputs into outputs [ISO 12207].

**Product**: An output of a process.

**Product requirement**: A requirement related to the product of the development process.
They affect quality of the product.

**Project**: A project is a unique  set of coordinated and controlled activities with start  and finish dates undertaken to achieve an objective conforming to specific requirements,
including the constraints of time, cost and resources [ISO 9000]


###Q:

**Quality**: The degree to which a component, system or process meets specified requirements and/or user/customer
needs and expectations [IEEE 610]


###R:

**Release**: A version of the solution released for installation and use by the customer/end users.

**Requirement**:  (1) A  condition  or  capability  needed  by  a  user  to  solve  a  problem  or  achieve  an objective.
(2)  A  condition  or  capability  that  must  be  met  or  possessed  by  a  system  or  system component to satisfy a contract, standard, specification, or other formally imposed documents.
(3) A documented representation of a condition or capability as in (1) or (2) [IEEE 610].


**Review**: An evaluation of a product or project status to ascertain discrepancies from planned results and to recommend improvements.
Examples include management review, informal review, technical review, inspection, and walkthrough [IEEE 1028].

**Reviewer**: The person involved in the review  that identifies and describes  anomalies  in the product or project under review. Reviewers can be chosen to represent different viewpoints and roles in the review process.


###S:

**Security**: Attributes  of  software  products  that  bear on  its  ability  to  prevent  unauthorized
access, whether accidental or deliberate, to programs and data [ISO/IEC 25000].  See also *Functionality.*

**Sequence  diagram**: In  UML  it  is  a  structured  representation  of  behavior  as  a  series  of  sequential steps  over  time.
Sequence  diagram  is  a  kind  of  interaction  diagram  that  shows  how  processes operate with one another and in what order.

**Software**: Computer   programs,   procedures, and   possibly   associated   documentation   and   data pertaining to the operation of a computer system [IEEE 610].


**Stakeholder**: Any  person  who  has  an  interest  in  an  IT  project.  Project  stakeholders  are individuals and  organizations  that  are  actively  involved  in  the  project,  or whose  interests may  be  affected  as  a result  of  project  execution  or  project  completion.
Stakeholders  can  exercise  control  over  both  the immediate   system   operational   characteristics, as well as   over   long-term   system   lifecycle considerations 
(such     as     portability,     lifecycle     costs,     environmental     considerations,     and decommissioning of the system) [TGilb].


**Standard**: Formal,  possibly  mandatory,  set  of  requirements  developed  and  used  to  prescribe consistent  approaches  to
the  way  of  working  or  to  provide  guidelines  (e.g.,  ISO/IEC  standards,  IEEE standards, and organizational standards) [CMMI].


**State machine**: A behavior model composed of a finite number of states, transitions between those states, and actions, similar to a flow graph.


**State machine diagram**: *see State machine*

**State transition**: A transition between two states of a component or system.

**Structure  diagram**: A  type   of  diagram  that  depicts  the  elements  of  a  specification  that
are irrespective  of  time.This  includes  class,  composite  structure,  component,  deployment,  object,  and package diagrams.

**System**: A  collection  of  components  organized  to  accomplish  a  specific  function  or  set  of  functions [IEEE 610].


###T:

**Testability**: The capability of the software product to enable modified software to be tested [ISO/IEC 25000].
See also *Maintainability.*

**Timing diagram**: In  UML  a  diagram  that  depicts  the  change  in  state  or  condition  of  a  classifier instance or role over time.


###U:

**UML**: see Unified Modeling Language.

**Unified  Modeling  Language**: A  standardized  general-purpose  modeling  language  in  the  field  of software engineering.
UML includes a set of graphic notation techniques to create visual models of software-intensive systems like use case diagrams, activity diagrams,
class diagrams and many more.

**User**: A person who uses a software product.


###V:

**Version**: A specific form or variation of something.


###W:
###X:
###Y:
###Z:




 
   
 

### Appendix F: Instructions for manual testing 
[WIP]

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
#### Launch and Shutdown
#### Clearing the list
#### Saving data
