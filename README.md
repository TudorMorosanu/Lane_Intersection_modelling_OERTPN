# Lane_Intersection_modelling_OERTPN

Project for Distributed Control Systems to model the traffic in intersections

# Setup the project

Open the project in IntelliJ.

Click on the Maven *m* on the vertical right bar.

Go to *Lifecycle* and double click on *Install*

# How to contribute

Create the branch with the name *Name-What_you_are_implementing*.

All classes shall be implemented in the *LanesIntersection* directory.

In order to ease debugging, each intersection will have a specialized class for it.

The main model class will call all the intersection classes to construct the Petri net.

The class ModelRunner will start the model and all controllers.

Each action during the creation of the model and the controller should have a specific function for it:

initializeLocations(PetriNet pn);
createT1(PetriNet pn);
etc.

and call each of these functions in the *main* of their component.

An example implementation is defined in *LanesIntersection/TestClass*.

# How to see the Petri models

Models are stored in the *doc/* directory as *xml* files and can be viewed using PetriPipe

Install PetriPipe from Teams *RTS_LAB -> Tools ->pipe25_rc5.rar* using the installation instructions
in *RTS_LAB -> Tools*
