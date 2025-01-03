package LanesIntersection;

import Components.*;
import DataObjects.DataFloat;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class MacedonskiIntersection {

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

        DataFloat p1 = new DataFloat();
        p1.SetName("iMac_Pa1");
        pn.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("iMac_Px1");
        pn.PlaceList.add(p2);

        DataFloat p3 = new DataFloat();
        p3.SetName("iMac_OP1");
        pn.PlaceList.add(p3);

        DataFloat p4 = new DataFloat();
        p4.SetName("iMac_Usrreq1");
        pn.PlaceList.add(p4);

        DataFloat p5 = new DataFloat();
        p5.SetName("iMac_PPTL1");
        pn.PlaceList.add(p5);

        DataFloat p6 = new DataFloat();
        p6.SetName("iMac_OPreq1");
        pn.PlaceList.add(p6);

        DataFloat p7 = new DataFloat();
        p7.SetName("iMac_Pb1");
        pn.PlaceList.add(p7);

        DataFloat p8 = new DataFloat();
        p8.SetName("iMac_PTL1");
        pn.PlaceList.add(p8);

        DataFloat p9 = new DataFloat();
        p9.SetName("iMac_Pa4");
        pn.PlaceList.add(p9);

        DataFloat p10 = new DataFloat();
        p10.SetName("iMac_Px4");
        pn.PlaceList.add(p10);

        DataFloat p11 = new DataFloat();
        p11.SetName("iMac_OP4");
        pn.PlaceList.add(p11);

        DataFloat p12 = new DataFloat();
        p12.SetName("iMac_Usrreq4");
        pn.PlaceList.add(p12);

        DataFloat p13 = new DataFloat();
        p13.SetName("iMac_PPTL4");
        pn.PlaceList.add(p13);

        DataFloat p14 = new DataFloat();
        p14.SetName("iMac_OPreq4");
        pn.PlaceList.add(p14);

        DataFloat p15 = new DataFloat();
        p15.SetName("iMac_Pb4");
        pn.PlaceList.add(p15);

        DataFloat p16 = new DataFloat();
        p16.SetName("iMac_PTL4");
        pn.PlaceList.add(p16);

        DataFloat p17 = new DataFloat();
        p17.SetName("iMac_Po1");
        pn.PlaceList.add(p17);

        DataFloat p18 = new DataFloat();
        p18.SetName("iMac_Poe1");
        pn.PlaceList.add(p18);

        DataFloat p19 = new DataFloat();
        p19.SetName("iMac_Po2");
        pn.PlaceList.add(p19);

        DataFloat p21 = new DataFloat();
        p21.SetName("iMac_PI");
        pn.PlaceList.add(p21);
    }


    public static void addT1 (PetriNet pn){

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "iMac_Tu1";
        t1.InputPlaceName.add("iMac_Pa1");
        t1.InputPlaceName.add("iMac_Px1");

        Condition T1Ct1 = new Condition(t1, "iMac_Pa1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "iMac_Px1", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "iMac_Pa1", TransitionOperation.AddElement, "iMac_Px1"));
        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);
    }

    public static void addT2 (PetriNet pn){

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "iMac_Tout1";
        t2.InputPlaceName.add("iMac_Pa1");
        t2.InputPlaceName.add("iMac_Px1");

        Condition T2Ct1 = new Condition(t2, "iMac_Pa1", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "iMac_Px1", TransitionCondition.CanNotAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;

        grdT2.Activations.add(new Activation(t2, "full", TransitionOperation.SendOverNetwork, "iMac_OP1"));
        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

    }

    public static void addT3 (PetriNet pn){

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "iMac_Te1";
        t3.InputPlaceName.add("iMac_Px1");
        t3.InputPlaceName.add("iMac_Usrreq1");
        t3.InputPlaceName.add("iMac_PPTL1");
        t3.InputPlaceName.add("iMac_PTL1");

        // First guard
        Condition T3Ct1_1 = new Condition(t3, "iMac_Px1", TransitionCondition.HaveCar);
        Condition T3Ct1_2 = new Condition(t3, "iMac_PTL1", TransitionCondition.Equal, "green");
        T3Ct1_1.SetNextCondition(LogicConnector.AND, T3Ct1_2);

        GuardMapping grdT3_1 = new GuardMapping();
        grdT3_1.condition = T3Ct1_1;

        grdT3_1.Activations.add(new Activation(t3, "iMac_Px1", TransitionOperation.PopElementWithoutTarget, "iMac_Pb1"));
        grdT3_1.Activations.add(new Activation(t3, "iMac_PPTL1", TransitionOperation.Move, "iMac_PPTL1"));
        grdT3_1.Activations.add(new Activation(t3, "iMac_PTL1", TransitionOperation.Move, "iMac_PTL1"));
        t3.GuardMappingList.add(grdT3_1);

        // Second guard
        Condition T3Ct2_1 = new Condition(t3, "iMac_Usrreq1", TransitionCondition.NotNull);

        GuardMapping grdT3_2 = new GuardMapping();
        grdT3_2.condition = T3Ct2_1;

        grdT3_2.Activations.add(new Activation(t3, "iMac_Usrreq1", TransitionOperation.SendOverNetwork, "iMac_OPreq1"));
        grdT3_2.Activations.add(new Activation(t3, "iMac_PPTL1", TransitionOperation.Move, "iMac_PPTL1"));
        grdT3_2.Activations.add(new Activation(t3, "iMac_PTL1", TransitionOperation.Move, "iMac_PTL1"));
        t3.GuardMappingList.add(grdT3_2);

        t3.Delay = 1;
        pn.Transitions.add(t3);

    }

    public static void addT4 (PetriNet pn){

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "iMac_Ti1";
        t4.InputPlaceName.add("iMac_Pb1");
        t4.InputPlaceName.add("iMac_PI");

        Condition T4Ct1 = new Condition(t4, "iMac_Pb1", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "iMac_PI", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;

        grdT4.Activations.add(new Activation(t4, "iMac_Pb1", TransitionOperation.AddElement, "iMac_PI"));
        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        pn.Transitions.add(t4);

    }

    public static void addT5 (PetriNet pn){

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "iMac_Tg1";
        t5.InputPlaceName.add("iMac_Po1");
        t5.InputPlaceName.add("iMac_PI");

        Condition T5Ct1 = new Condition(t5, "iMac_PI", TransitionCondition.HaveCarForMe);
        Condition T5Ct2 = new Condition(t5, "iMac_Po1", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;

        grdT5.Activations.add(new Activation(t5, "iMac_PI", TransitionOperation.PopElementWithTargetToQueue, "iMac_Po1"));
        t5.GuardMappingList.add(grdT5);
        t5.Delay = 1;
        pn.Transitions.add(t5);

    }

    public static void addT6 (PetriNet pn) {

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "iMac_Tge1";
        t6.InputPlaceName.add("iMac_Po1");

        Condition T6Ct1 = new Condition(t6, "iMac_Po1", TransitionCondition.HaveCar);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;

        grdT6.Activations.add(new Activation(t6, "iMac_Po1", TransitionOperation.PopElementWithoutTarget, "iMac_Poe1"));
        t6.GuardMappingList.add(grdT6);
        t6.Delay = 0;
        pn.Transitions.add(t6);

    }

    public static void addT7 (PetriNet pn){

        // T7 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "iMac_Tu2";
        t7.InputPlaceName.add("iMac_Pa2");
        t7.InputPlaceName.add("iMac_Px2");

        Condition T7Ct1 = new Condition(t7, "iMac_Pa2", TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t7, "iMac_Px2", TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;

        grdT7.Activations.add(new Activation(t7, "iMac_Pa2", TransitionOperation.AddElement, "iMac_Px2"));
        t7.GuardMappingList.add(grdT7);
        t7.Delay = 0;
        pn.Transitions.add(t7);
    }

    public static void addT8 (PetriNet pn){

        // T8 ------------------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "iMac_Tout2";
        t8.InputPlaceName.add("iMac_Pa2");
        t8.InputPlaceName.add("iMac_Px2");

        Condition T8Ct1 = new Condition(t8, "iMac_Pa2", TransitionCondition.NotNull);
        Condition T8Ct2 = new Condition(t8, "iMac_Px2", TransitionCondition.CanNotAddCars);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;

        grdT8.Activations.add(new Activation(t8, "full", TransitionOperation.SendOverNetwork, "iMac_OP2"));
        t8.GuardMappingList.add(grdT8);
        t8.Delay = 0;
        pn.Transitions.add(t8);
    }

    public static void addT9 (PetriNet pn){

        // T9 ------------------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "iMac_Te2";
        t9.InputPlaceName.add("iMac_Px2");
        t9.InputPlaceName.add("iMac_Usrreq2");
        t9.InputPlaceName.add("iMac_PPTL2");
        t9.InputPlaceName.add("iMac_PTL2");

        // First guard
        Condition T9Ct1_1 = new Condition(t9, "iMac_Px2", TransitionCondition.HaveCar);
        Condition T9Ct1_2 = new Condition(t9, "iMac_PTL2", TransitionCondition.Equal, "green");
        T9Ct1_1.SetNextCondition(LogicConnector.AND, T9Ct1_2);

        GuardMapping grdT9_1 = new GuardMapping();
        grdT9_1.condition = T9Ct1_1;

        grdT9_1.Activations.add(new Activation(t9, "iMac_Px2", TransitionOperation.PopElementWithoutTarget, "iMac_Pb2"));
        grdT9_1.Activations.add(new Activation(t9, "iMac_PPTL2", TransitionOperation.Move, "iMac_PPTL2"));
        grdT9_1.Activations.add(new Activation(t9, "iMac_PTL2", TransitionOperation.Move, "iMac_PTL2"));
        t9.GuardMappingList.add(grdT9_1);

        // Second guard
        Condition T9Ct2_1 = new Condition(t9, "iMac_Usrreq2", TransitionCondition.NotNull);

        GuardMapping grdT9_2 = new GuardMapping();
        grdT9_2.condition = T9Ct2_1;

        grdT9_2.Activations.add(new Activation(t9, "iMac_Usrreq2", TransitionOperation.SendOverNetwork, "iMac_OPreq2"));
        grdT9_2.Activations.add(new Activation(t9, "iMac_PPTL2", TransitionOperation.Move, "iMac_PPTL2"));
        grdT9_2.Activations.add(new Activation(t9, "iMac_PTL2", TransitionOperation.Move, "iMac_PTL2"));
        t9.GuardMappingList.add(grdT9_2);

        t9.Delay = 1;
        pn.Transitions.add(t9);
    }

    public static void addT10 (PetriNet pn){

        // T10 ------------------------------------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "iMac_Ti2";
        t10.InputPlaceName.add("iMac_Pb2");
        t10.InputPlaceName.add("iMac_PI");

        Condition T10Ct1 = new Condition(t10, "iMac_Pb2", TransitionCondition.NotNull);
        Condition T10Ct2 = new Condition(t10, "iMac_PI", TransitionCondition.CanAddCars);
        T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;

        grdT10.Activations.add(new Activation(t10, "iMac_Pb2", TransitionOperation.AddElement, "iMac_PI"));
        t10.GuardMappingList.add(grdT10);
        t10.Delay = 0;
        pn.Transitions.add(t10);
    }

    public static void addT11 (PetriNet pn){

        // T11 ------------------------------------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "iMac_Tg2";
        t11.InputPlaceName.add("iMac_Po2");
        t11.InputPlaceName.add("iMac_PI");

        Condition T11Ct1 = new Condition(t11, "iMac_PI", TransitionCondition.HaveCarForMe);
        Condition T11Ct2 = new Condition(t11, "iMac_Po2", TransitionCondition.CanAddCars);
        T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;

        grdT11.Activations.add(new Activation(t11, "iMac_PI", TransitionOperation.PopElementWithTargetToQueue, "iMac_Po2"));
        t11.GuardMappingList.add(grdT11);
        t11.Delay = 1;
        pn.Transitions.add(t11);
    }

    public static void addT12 (PetriNet pn){

        // T12 ------------------------------------------------
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "iMac_Tge2";
        t12.InputPlaceName.add("iMac_Po2");

        Condition T12Ct1 = new Condition(t12, "iMac_Po2", TransitionCondition.HaveCar);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;

        grdT12.Activations.add(new Activation(t12, "iMac_Po2", TransitionOperation.PopElementWithoutTarget, "iRbr_Pa4"));
        t12.GuardMappingList.add(grdT12);
        t12.Delay = 0;
        pn.Transitions.add(t12);
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
        addT11(pn);
        addT12(pn);

    }
}
