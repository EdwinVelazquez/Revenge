# This is a readme for the ControllerTest folder

This is just a test for the bare bones of managing controls of the inputs (keyboard, controls(ps3), etc)
If you want to use the PS3Controller class you need to setup jinput
Which can be found here - [http://goo.gl/kOWfCw](http://goo.gl/kOWfCw)

######Things Done
- the class is suppose to manage controllers by making all of them have the same super class
- they all share basic controls (up, down, left, right, start, select, action 1, action 2, action 3, and action 4)


######Things to be done (this can be added after everything else is done, if there is time, for now this part is done)
- avoid having more duplicate instance (avoid having 2 player with the same remote)
- add exceptions (maybe)
  - when remote does't exist
  - when player # doesn't exist (i think this should be handled by the main program)
- ability to configure controls
- maybe add mouse as a controller or include that in the keyboard
- make another class to have all the controllers and manage all exceptions (maybe)
