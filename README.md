# BirthdayPartyRefactory
Refactoring exercise

## Instructions
The purpose of this exercise is to improve the code so it is easier to work with. 
There are a few problems in there, find and fix what you can. Don't add any additional
functionality (unless you consider tests additional functionality), we're just checking to see how you can improve existing code.
 
## Getting Started

Running the application: `gradle build test run`

All output is written to the console.

## Design Patterns
As part of refactoring, I added few design pattern to better design this app. 
1) Builder of Builders. All the items Balloon and Cake provides there own builders. To provide ease for the client. Client can simply say, I need a balloon and its builder will be provided to it. Once done building the balloon, the handle is shifting back to the order builder to add any further items. 

Access to all the items classes are hidden. Only class instantiation can happen via Builders. Only access to accessors(getters) is provided.

2) To display better, both order and items are following composite pattern where order is asking its children to provide their display which is appended to the invoice of the order itself.
