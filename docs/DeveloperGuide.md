# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}




### Logic component

1. Logic uses the `Parser` class the user input obtained from the `TextUi` class.
2. This results in a specific `Command` object to be returned from the `Parser'.   
3. Depending on the type of the `Command` object, its corresponding command execution will be called.
4. The result of the command execution is encapsulated as a `CommandOutput` object which is passed back to the `TextUi`.
5. In addition, the `CommandOutput` object can also instruct the `TextUi` to perform certain actions, such as formatting the list to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for {to be inserted when doing sequence diagram}.

### UI component

The UI consists of `TextUi` class. It acts as a middleware between users' input 
and `Parser` class under **Logic Component**. 

The `ui` component,

* Reads user commands using `Scanner` class. 
* Pass raw user commands into `Parser` class under **Logic Component**.
* After the **Logic Component** has executed the function, it will then return `CommandOutput` object
which contains the outcome of the execution, fail or succeed. 

### Model component

**API** : [`seedu.duke.person`](https://github.com/AY2021S2-CS2113T-T09-1/tp/tree/master/src/main/java/seedu/duke/person) package

The Model component,

* contains a `TrackingList` class to keep track of all the `Person` objects.
* contains a `Person` class which represents a person who checks in or out.

A `Person` object contains:
* an `Id` object
* a `Name` object
* a `Phone` object

### Storage component
**API** : [`seedu.duke.storage`](https://github.com/AY2021S2-CS2113T-T09-1/tp/tree/master/src/main/java/seedu/duke/storage) package

The `Storage` component,
* saves and encodes `Person` objects in `Tracking List` into a `.txt` file.
* reads a `.txt` file of valid encoding and populates a `TrackingList`.
* defaults to `TrackingList.txt` but can be saved at a custom specified location.
* loads on program startup automatically saves after each command.

### Common classes

Classes used by multiple components are in the `seedu.Duke.commons` package. 


## Product scope [WIP]
### Target user profile
* User that requires more control over crowd level management in a building.
* Can type fast
* Prefers a simple desktop application over the more complicated systems
* Is reasonably comfortable with CLI apps
* Requires real time monitoring and tracking capability of people in the building
* Wants a cheaper alternative to crowd tracking systems

{Describe the target user profile}

### Value proposition

A fast and versatile software solution that enables mall management to crowd control 
in the most efficient way possible.

## User Stories [WIP]

|Priority| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|*****|mall staff|be able to review the personal particulars of the customer|be aware of who he is|
|*****|new user|be able to use the program without much training| use the program as soon as possible and easily implement it|
|****|mall staff|key in personal particulars easily into the application| check in visitors quickly without holding up a line of customers|
|****|mall staff|be able to easily key in a unique personal identifier| check in and find a visitor|

## Non-Functional Requirements [WIP]

{Give non-functional requirements}

## Glossary [WIP]

* *glossary item* - Definition

## Instructions for manual testing [WIP]

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
