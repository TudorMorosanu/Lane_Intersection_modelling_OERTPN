package LanesIntersection;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Vuia2Intersection {
    public static void addNodes(PetriNet pn) {
        DataString green= new DataString();
        green.SetName("green");
        green.SetValue("green");
        green.Printable= false;
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);

        DataCar p1 = new DataCar();
        p1.SetName("iVuia_Pa2");
        pn.PlaceList.add(p1);

        DataCarQueue p2 = new DataCarQueue();
        p2.Value.Size = 10;
        p2.SetName("iVuia_Px2");
        pn.PlaceList.add(p2);

        DataCar p3 = new DataCar();
        p3.SetName("iVuia_OP2");
        pn.PlaceList.add(p3);

        DataString p4 = new DataString();
        p4.SetName("iVuia_Usrreq2");
        pn.PlaceList.add(p4);

        DataString p5 = new DataString();
        p5.SetName("iVuia_PPTL2");
        pn.PlaceList.add(p5);

        DataTransfer p6 = new DataTransfer();
        p6.SetName("iVuia_OPreq2");
        p6.Value = new TransferOperation("localhost", "1100", "Userreq");
        pn.PlaceList.add(p6);

        DataCar p7 = new DataCar();
        p7.SetName("iVuia_Pb2");
        pn.PlaceList.add(p7);

        DataString p8 = new DataString();
        p8.SetName("iVuia_PTL2");
        pn.PlaceList.add(p8);

        DataString p22 = new DataString();
        p22.SetName("iVuia_CPTL2");
        pn.PlaceList.add(p22);

        DataCar p9 = new DataCar();
        p9.SetName("iVuia_Pa3");
        pn.PlaceList.add(p9);

        DataCarQueue p10 = new DataCarQueue();
        p10.Value.Size = 10;
        p10.SetName("iVuia_Px3");
        pn.PlaceList.add(p10);

        DataCar p11 = new DataCar();
        p11.SetName("iVuia_OP3");
        pn.PlaceList.add(p11);

        DataString p12 = new DataString();
        p12.SetName("iVuia_Usrreq3");
        pn.PlaceList.add(p12);

        DataString p13 = new DataString();
        p13.SetName("iVuia_PPTL3");
        pn.PlaceList.add(p13);

        DataTransfer p14 = new DataTransfer();
        p14.SetName("iVuia_OPreq3");
        p14.Value = new TransferOperation("localhost", "1101", "Userreq");
        pn.PlaceList.add(p14);

        DataCar p15 = new DataCar();
        p15.SetName("iVuia_Pb3");
        pn.PlaceList.add(p15);

        DataString p16 = new DataString();
        p16.SetName("iVuia_PTL3");
        pn.PlaceList.add(p16);

        DataString p23 = new DataString();
        p23.SetName("iVuia_CPTL3");
        pn.PlaceList.add(p23);

        DataCarQueue p17 = new DataCarQueue();
        p17.Value.Size = 10;
        p17.SetName("iVuia_Po4");
        pn.PlaceList.add(p17);

        DataCarQueue p21 = new DataCarQueue();
        p21.Value.Size = 10;
        p21.SetName("iVuia_PI2");
        pn.PlaceList.add(p21);
    }


    public static void addT1 (PetriNet pn){

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "iVuia_Tu2";
        t1.InputPlaceName.add("iVuia_Pa2");
        t1.InputPlaceName.add("iVuia_Px2");

        Condition T1Ct1 = new Condition(t1, "iVuia_Pa2", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "iVuia_Px2", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "iVuia_Pa2", TransitionOperation.AddElement, "iVuia_Px2"));
        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);
    }

    public static void addT2 (PetriNet pn){

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "iVuia_Tout2";
        t2.InputPlaceName.add("iVuia_Pa2");
        t2.InputPlaceName.add("iVuia_Px2");

        Condition T2Ct1 = new Condition(t2, "iVuia_Pa2", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "iVuia_Px2", TransitionCondition.CanNotAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;

        grdT2.Activations.add(new Activation(t2, "full", TransitionOperation.SendOverNetwork, "iVuia_OP2"));
        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

    }

    public static void addT3 (PetriNet pn){

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "iVuia_Te2";
        t3.InputPlaceName.add("iVuia_Px2");
        t3.InputPlaceName.add("iVuia_Usrreq2");
        t3.InputPlaceName.add("iVuia_PPTL2");
        t3.InputPlaceName.add("iVuia_PTL2");

        // First guard
        Condition T3Ct1_1 = new Condition(t3, "iVuia_Px2", TransitionCondition.HaveCar);
        Condition T3Ct1_2 = new Condition(t3, "iVuia_PTL2", TransitionCondition.Equal, "green");
        Condition T3Ct1_3 = new Condition(t3, "iVuia_CPTL2", TransitionCondition.Equal, "green");
        T3Ct1_1.SetNextCondition(LogicConnector.AND, T3Ct1_2);
        T3Ct1_2.SetNextCondition(LogicConnector.AND, T3Ct1_3);

        GuardMapping grdT3_1 = new GuardMapping();
        grdT3_1.condition = T3Ct1_1;

        grdT3_1.Activations.add(new Activation(t3, "iVuia_Px2", TransitionOperation.PopElementWithoutTarget, "iVuia_Pb2"));
        grdT3_1.Activations.add(new Activation(t3, "iVuia_PPTL2", TransitionOperation.Move, "iVuia_PPTL2"));
        grdT3_1.Activations.add(new Activation(t3, "iVuia_PTL2", TransitionOperation.Move, "iVuia_PTL2"));
        t3.GuardMappingList.add(grdT3_1);

        // Second guard
        Condition T3Ct2_1 = new Condition(t3, "iVuia_Usrreq2", TransitionCondition.NotNull);

        GuardMapping grdT3_2 = new GuardMapping();
        grdT3_2.condition = T3Ct2_1;

        grdT3_2.Activations.add(new Activation(t3, "iVuia_Usrreq2", TransitionOperation.SendOverNetwork, "iVuia_OPreq2"));
        grdT3_2.Activations.add(new Activation(t3, "iVuia_PPTL2", TransitionOperation.Move, "iVuia_PPTL2"));
        grdT3_2.Activations.add(new Activation(t3, "iVuia_PTL2", TransitionOperation.Move, "iVuia_PTL2"));
        t3.GuardMappingList.add(grdT3_2);

        // Third guard
        Condition T3Ct3_1 = new Condition(t3, "iVuia_Px2", TransitionCondition.HavePriorityCar);

        GuardMapping grdT3_3 = new GuardMapping();
        grdT3_3.condition = T3Ct3_1;

        grdT3_3.Activations.add(new Activation(t3, "iVuia_Px2", TransitionOperation.PopElementWithoutTarget, "iVuia_Pb2"));
        grdT3_3.Activations.add(new Activation(t3, "iVuia_PPTL2", TransitionOperation.Move, "iVuia_PPTL2"));
        grdT3_3.Activations.add(new Activation(t3, "iVuia_PTL2", TransitionOperation.Move, "iVuia_PTL2"));
        t3.GuardMappingList.add(grdT3_3);

        t3.Delay = 1;
        pn.Transitions.add(t3);

    }

    public static void addT4 (PetriNet pn){

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "iVuia_Ti2";
        t4.InputPlaceName.add("iVuia_Pb2");
        t4.InputPlaceName.add("iVuia_PI2");

        Condition T4Ct1 = new Condition(t4, "iVuia_Pb2", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "iVuia_PI2", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;

        grdT4.Activations.add(new Activation(t4, "iVuia_Pb2", TransitionOperation.AddElement, "iVuia_PI2"));
        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        pn.Transitions.add(t4);

    }

    public static void addT5 (PetriNet pn){

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "iVuia_Tg4";
        t5.InputPlaceName.add("iVuia_Po4");
        t5.InputPlaceName.add("iVuia_PI2");

        Condition T5Ct1 = new Condition(t5, "iVuia_PI2", TransitionCondition.HaveCarForMe);
        Condition T5Ct2 = new Condition(t5, "iVuia_Po4", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;

        grdT5.Activations.add(new Activation(t5, "iVuia_PI2", TransitionOperation.PopElementWithTargetToQueue, "iVuia_Po4"));
        t5.GuardMappingList.add(grdT5);
        t5.Delay = 1;
        pn.Transitions.add(t5);

    }

    public static void addT6 (PetriNet pn) {

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "iVuia_Tge4";
        t6.InputPlaceName.add("iVuia_Po4");

        Condition T6Ct1_1 = new Condition(t6, "iVuia_Po4", TransitionCondition.HaveCar);
        Condition T6Ct1_2 = new Condition(t6, "iVuia_CPTL4", TransitionCondition.Equal, "green");
        T6Ct1_1.SetNextCondition(LogicConnector.AND, T6Ct1_2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1_1;

        grdT6.Activations.add(new Activation(t6, "iVuia_Po4", TransitionOperation.PopElementWithoutTarget, "iUlp_Pa2"));
        t6.GuardMappingList.add(grdT6);
        t6.Delay = 0;
        pn.Transitions.add(t6);

    }

    public static void addT7 (PetriNet pn){

        // T7 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "iVuia_Tu3";
        t7.InputPlaceName.add("iVuia_Pa3");
        t7.InputPlaceName.add("iVuia_Px3");

        Condition T7Ct1 = new Condition(t7, "iVuia_Pa3", TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t7, "iVuia_Px3", TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;

        grdT7.Activations.add(new Activation(t7, "iVuia_Pa3", TransitionOperation.AddElement, "iVuia_Px3"));
        t7.GuardMappingList.add(grdT7);
        t7.Delay = 0;
        pn.Transitions.add(t7);
    }

    public static void addT8 (PetriNet pn){

        // T8 ------------------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "iVuia_Tout3";
        t8.InputPlaceName.add("iVuia_Pa3");
        t8.InputPlaceName.add("iVuia_Px3");

        Condition T8Ct1 = new Condition(t8, "iVuia_Pa3", TransitionCondition.NotNull);
        Condition T8Ct2 = new Condition(t8, "iVuia_Px3", TransitionCondition.CanNotAddCars);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;

        grdT8.Activations.add(new Activation(t8, "full", TransitionOperation.SendOverNetwork, "iVuia_OP3"));
        t8.GuardMappingList.add(grdT8);
        t8.Delay = 0;
        pn.Transitions.add(t8);
    }

    public static void addT9 (PetriNet pn){

        // T9 ------------------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "iVuia_Te3";
        t9.InputPlaceName.add("iVuia_Px3");
        t9.InputPlaceName.add("iVuia_Usrreq3");
        t9.InputPlaceName.add("iVuia_PPTL3");
        t9.InputPlaceName.add("iVuia_PTL3");

        // First guard
        Condition T9Ct1_1 = new Condition(t9, "iVuia_Px3", TransitionCondition.HaveCar);
        Condition T9Ct1_2 = new Condition(t9, "iVuia_PTL3", TransitionCondition.Equal, "green");
        Condition T9Ct1_3 = new Condition(t9, "iVuia_CPTL3", TransitionCondition.Equal, "green");
        T9Ct1_1.SetNextCondition(LogicConnector.AND, T9Ct1_2);
        T9Ct1_2.SetNextCondition(LogicConnector.AND, T9Ct1_3);

        GuardMapping grdT9_1 = new GuardMapping();
        grdT9_1.condition = T9Ct1_1;

        grdT9_1.Activations.add(new Activation(t9, "iVuia_Px3", TransitionOperation.PopElementWithoutTarget, "iVuia_Pb3"));
        grdT9_1.Activations.add(new Activation(t9, "iVuia_PPTL3", TransitionOperation.Move, "iVuia_PPTL3"));
        grdT9_1.Activations.add(new Activation(t9, "iVuia_PTL3", TransitionOperation.Move, "iVuia_PTL3"));
        t9.GuardMappingList.add(grdT9_1);

        // Second guard
        Condition T9Ct2_1 = new Condition(t9, "iVuia_Usrreq3", TransitionCondition.NotNull);

        GuardMapping grdT9_2 = new GuardMapping();
        grdT9_2.condition = T9Ct2_1;

        grdT9_2.Activations.add(new Activation(t9, "iVuia_Usrreq3", TransitionOperation.SendOverNetwork, "iVuia_OPreq3"));
        grdT9_2.Activations.add(new Activation(t9, "iVuia_PPTL3", TransitionOperation.Move, "iVuia_PPTL3"));
        grdT9_2.Activations.add(new Activation(t9, "iVuia_PTL3", TransitionOperation.Move, "iVuia_PTL3"));
        t9.GuardMappingList.add(grdT9_2);

        // Third guard
        Condition T9Ct3_1 = new Condition(t9, "iVuia_Px3", TransitionCondition.HaveCar);

        GuardMapping grdT9_3 = new GuardMapping();
        grdT9_3.condition = T9Ct3_1;

        grdT9_3.Activations.add(new Activation(t9, "iVuia_Px3", TransitionOperation.PopElementWithoutTarget, "iVuia_Pb3"));
        grdT9_3.Activations.add(new Activation(t9, "iVuia_PPTL3", TransitionOperation.Move, "iVuia_PPTL3"));
        grdT9_3.Activations.add(new Activation(t9, "iVuia_PTL3", TransitionOperation.Move, "iVuia_PTL3"));
        t9.GuardMappingList.add(grdT9_3);

        t9.Delay = 1;
        pn.Transitions.add(t9);
    }

    public static void addT10 (PetriNet pn){

        // T10 ------------------------------------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "iVuia_Ti3";
        t10.InputPlaceName.add("iVuia_Pb3");
        t10.InputPlaceName.add("iVuia_PI2");

        Condition T10Ct1 = new Condition(t10, "iVuia_Pb3", TransitionCondition.NotNull);
        Condition T10Ct2 = new Condition(t10, "iVuia_PI2", TransitionCondition.CanAddCars);
        T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;

        grdT10.Activations.add(new Activation(t10, "iVuia_Pb3", TransitionOperation.AddElement, "iVuia_PI2"));
        t10.GuardMappingList.add(grdT10);
        t10.Delay = 0;
        pn.Transitions.add(t10);
    }

    public static void generatePetriNet(PetriNet pn) {
        addNodes(pn);
        addT1(pn);
        addT2(pn);
        addT3(pn);
        addT4(pn);
        addT5(pn);
        addT6(pn);
        addT7(pn);
        addT8(pn);
        addT9(pn);
        addT10(pn);
    }

}
