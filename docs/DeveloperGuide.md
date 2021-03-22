# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### UI component

The UI consists of `TextUi` class. It acts as a middleware between users' input 
and `Parser` class under **Logic Component**. 

The `ui` component,

* Reads user commands using `Scanner` class. 
* Pass raw user commands into `Parser` class under **Logic Component**.
* After the **Logic Component** has executed the function, it will then return `CommandOutput` object
which contains the outcome of the execution, fail or succeed. 
  
### Common classes

Classes used by multiple components are in the `seedu.Duke.commons` package. 


## Product scope [WIP]
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories [WIP]

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements [WIP]

{Give non-functional requirements}

## Glossary [WIP]

* *glossary item* - Definition

## Instructions for manual testing [WIP]

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
