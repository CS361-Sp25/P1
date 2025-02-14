# Project 1: Deterministic Finite Automata

* Author: Jayce Lowry and Chase Stombaugh
* Class: CS361 Section 1
* Semester: Spring 2025

## Overview

This program models deterministic finite automata using the 5-tuple, and defines
operations for building deterministic finite automations for regular languages.

## Reflection

### Jayce

This project was a good experience. It was interesting to problem-solve and 
think about how and where different elements of the 5-tuple could be represented 
in the code. The more challenging part of the project was the DFA `swap()` method
because of the need to evaluate each transition for the two symbols that needed 
to be swapped. By refactoring parts of the code and representing transitions in
DFAState rather than the DFA, it made implementing `swap()` simpler and made the
code more modular.

The other challenge with `swap()` was ensuring that the DFA copy was a
deep copy. At first, I tried to write a deep copy method in DFAState to be used
in DFA, but that ended up being more complicated and harder to debug, so I
decided to keep that functionality entirely in the DFA. If I had more time, I would
implement this differently by writing a deep copy constructor, and then use it in
`swap()`. That way, the deep copy functionality can be used for other things if
it's necessary.

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
