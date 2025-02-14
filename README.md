# Project 1: Deterministic Finite Automata

* Author: Jayce Lowry
* Class: CS361 Section 1
* Semester: Spring 2025

## Overview

This program models deterministic finite automata using the 5-tuple, and defines
operations for building deterministic finite automations for regular languages.

## Reflection

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

## Compiling and Using



This section should tell the user how to compile your code.  It is
also appropriate to instruct the user how to use your code. Does your
program require user input? If so, what does your user need to know
about it to use it as quickly as possible?

## Sources used

If you used any sources outside of the lecture notes, class lab files,
or text book you need to list them here. If you looked something up on
stackoverflow.com and fail to cite it in this section it will be
considered plagiarism and be dealt with accordingly. So be safe CITE!

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).