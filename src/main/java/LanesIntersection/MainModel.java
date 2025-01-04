package LanesIntersection;

import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import com.sun.tools.javac.Main;

public class MainModel {

    public static void start(){

        PetriNet pn = new PetriNet();
        System.out.println("Lanes Intersection!");

        pn.PetriNetName = "Lanes Intersection";
        pn.NetworkPort = 1080;

        RebreanuIntersection.generatePetriNet(pn);
        MacedonskiIntersection.generatePetriNet(pn);
        Vuia1Intersection.generatePetriNet(pn);
        Vuia2Intersection.generatePetriNet(pn);
        UlpiaIntersection.generatePetriNet(pn);
        DrubetaIntersection.generatePetriNet(pn);

        pn.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(true);
        frame.petriNet = pn;
        frame.setVisible(true);
    }

}
