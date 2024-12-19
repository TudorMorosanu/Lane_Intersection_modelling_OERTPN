package LanesIntersection;

import Components.*;
import DataObjects.DataFloat;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class TestClass {

    public static void addNodes(PetriNet pn){
        DataFloat p1 = new DataFloat();
        p1.SetName("p1");
        p1.SetValue(30.0f);
        pn.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("p2");
        pn.PlaceList.add(p2);
    }

    public static void addT1(PetriNet pn){

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("p1");

        Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.Move, "p2"));
        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);

    }

    public static void main(String[] args) {
        System.out.println("Lanes Intersection!");

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Lanes Intersection";
        pn.NetworkPort = 1080;

        addNodes(pn);
        addT1(pn);

        pn.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
