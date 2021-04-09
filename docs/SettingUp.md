# Control Your Crowd - Setting up
## Prerequisites
1. JDK `11` or above
2. IntelliJ IDEA IDE

## Setting up the project on your device
1. Fork the github repo at the following [link](https://github.com/AY2021S2-CS2113T-T09-1/tp)
2. Clone the fork onto your device
3. Set up the correct JDK version for Gradle
    * Click `Configure` > `Project Defaults` > `Project Structure`
    * Click `New...` and find the directory of the JDK
        * JDK `11` is recommended for maximum compatibility with the project.
4. Click `Import Project`
5. Locate the `build.gradle` file and select it. Click `OK`
6. `Windows`: Open the console and run the command `gradlew processResources`
   
   `macOS/Linux`: Open the console and run the command `./gradlew processResources`
7. If the task returns `BUILD SUCCESSFUL`, the set up has been successful

## Configuring the coding style
The project follows the following [java coding standards](https://github.com/oss-generic/process/blob/master/docs/CodingStandards.adoc).

## Getting started with coding
Once you are done with the setup, you can return to the [Developer Guide](DeveloperGuide.md) 
to understand the overall design.