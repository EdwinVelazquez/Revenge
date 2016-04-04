# This is a readme for the PS3RemoteTest Game
*First I am going to change the name later to match what it actually does.

This is just a test for a PS3 remote in java
Before anything if you plan on using these classes you must add the jinput api
Which can be found here - [http://goo.gl/kOWfCw](http://goo.gl/kOWfCw)

######Things Done
- added ability to have more than one remmote 
- easy to use by making an instance with an int parameter indicating the player # (constructor)then calling its functions to get 
  1. isPressed(int button) returns boolean if a button is pressed 
  2. joystick(int axis) returns float value of (L_x,y or R_x,y)


###### Things to be added later
- avoid having more duplicate instance (avoid having 2 player with the same remote)
- add exceptions (maybe)
  - when remote does't exist
  - when player # doesn't exit (i think this should be handled by the main program)
- thinking of renaming joystick function or at least return x and y values together
- (going to clean the code later to remove the unwanted comments)
