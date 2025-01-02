package LanesIntersection;

import Components.PetriNet;
import Components.PetriTransition;
import Controllers.*;

public class MainModel {

    public static void main(String[] args){

        PetriNet pn = new PetriNet();

        ControllerRebreanu.start();
        ControllerMacedonski.start();
        ControllerVuia1.start();
        ControllerVuia2.start();
        ControllerUlpia.start();
        ControllerDrubeta.start();
    }

}
