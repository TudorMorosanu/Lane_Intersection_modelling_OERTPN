# Lane_Intersection_modelling_OERTPN
Project for Distributed Control Systems to model the traffic in intersections

# How to contribute

Create the branch with the name *Name-What_you_are_implementing*

In order to ease debugging, each action during the creation of the model and the controller should have a specific function for it:

initializeLocations(PetriNet pn);
createT1(PetriNet pn);
etc.

and call each of these functions in *main*

An example implementation is defined in *main*, this will be overwritten.
