# Project 1: P1 - DFA

* Author: Jayce Lowry and Chase Stombaugh
* Class: CS361 Section 1
* Semester: Spring 2025

## Overview

## Reflection

### Jayce

### Chase
The biggest holdup that both of us had was finding the time to work on the project. We both got
swamped with assignments all at once. I also had a wedding to attend which took a whole weekend
out of my schedule and crammed some assignments into a tight spot. I was very grateful for this 
project being pushed back to the 14th, since it allowed for some wiggle room and also some time
for the both of us to get our work done well and submit a finished product. 

Thankfully, this one wasn't a huge headsore except for the swap() implementation. I was in 
charge of that, and kind of dropped the ball. I chose the wrong data storage at first, which 
really complicated things. Thankfully, when I communicated with Jayce about it, he was able to 
take the time and find out what was going wrong. On his push with the fix, it seemed like it was 
mostly just an oversight on my part in  choosing the wrong storage mechanism. However this led to 
needing to restructure a little bit and I believe a method needed to be added to DFAState as well.

## Compiling and Using

### Compiling 
To complile the DFA implementation and test cases, navigate to the project's root and run the following command:

`javac -cp .:/usr/share/java/junit.jar ./test/dfa/DFATest.java`

This will compile all necessary java files, including the DFA implementation and provided JUnit tests. 

### Running 

To ensure the implementation is correct, run the JUnit test cases using:

`java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/core.jar org.junit.runner.JUnitCore test.dfa.DFATest`

This will execute all test cases that have been implemented, including the ones that were added during the creation of the project. The tests include: state transitions, acceptance conditions, symbol swapping, and DFA instantiation. 

## Sources used

https://docs.oracle.com/javase/8/docs/api/java/util/Set.html - was used for deciding what route to take for the DFA implementation.
