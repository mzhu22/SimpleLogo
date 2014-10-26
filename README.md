People: Safkat Islam, Chris Bernt, Mike Zhu, Dimeji Abidoye
Frontend: Safkat and Chris
Backend: Mike and Dimeji
Date Started: September 29, 2014
Date Finished: October 26, 2014
Hours worked: 60-70
Resources: class page, project page, stack overflow, java doc
Start project with main
One test to see if backend tree parser works
Resources files it needs to work: Files included in the resources.languages, resources.buttonLanguages, and images packages.
Information about using the program: arrows keys move the turtles – up means forward 50, down means back 50, left means rotate to the left 10 degrees, right means rotate to the right 10 degrees. Files in the resources.buttonLanguages folder sets the language the buttons are in. Files in the resources.languages folder sets the language of the commands inputted. Files in the images folder represent the possible images for the turtle.
Bugs: Wraparound doesn’t work fully. Queries don’t work fully, meaning that it only takes into account the last active turtle’s stats before run is pressed. -User defined functions do not work with dynamic parameters (e.g., can only do "to method [ ] [ rt 90 ]" vs "to method [ :b ] [ rt :b ]"). Queries only return the turtle state BEFORE the command call. These queries do not update in the middle of calls. Doing queries/ask correctly is difficult under current design. Because we pass entire lists of commands rather than one command at a time, queries do not dynamically update within a single command call. Likewise Ask and DoTimes (which take in variables) are "static" rather than "dynamic." For this reason, Ask is functionally identical to Repeat.
Assumptions: GUI buttons only work on active turtles. 
No extra features. 
Suggestions: Instructions need to be specified better/more/clearer, especially with multiple turtles. 
