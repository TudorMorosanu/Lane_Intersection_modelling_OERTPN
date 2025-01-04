package LanesIntersection;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class UlpiaIntersection {
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
        p1.SetName("iUlp_Pa1");
        pn.PlaceList.add(p1);

        DataCarQueue p2 = new DataCarQueue();
        p2.Value.Size = 10;
        p2.SetName("iUlp_Px1");
        pn.PlaceList.add(p2);

        DataCar p3 = new DataCar();
        p3.SetName("iUlp_OP1");
        pn.PlaceList.add(p3);

        DataCar p4 = new DataCar();
        p4.SetName("iUlp_Usrreq1");
        pn.PlaceList.add(p4);

        DataCar p5 = new DataCar();
        p5.SetName("iUlp_PPTL1");
        pn.PlaceList.add(p5);

        DataCar p6 = new DataCar();
        p6.SetName("iUlp_OPreq1");
        pn.PlaceList.add(p6);

        DataCar p7 = new DataCar();
        p7.SetName("iUlp_Pb1");
        pn.PlaceList.add(p7);

        DataCar p8 = new DataCar();
        p8.SetName("iUlp_PTL1");
        pn.PlaceList.add(p8);

        DataCar p9 = new DataCar();
        p9.SetName("iUlp_Pa2");
        pn.PlaceList.add(p9);

        DataCarQueue p10 = new DataCarQueue();
        p10.Value.Size = 10;
        p10.SetName("iUlp_Px2");
        pn.PlaceList.add(p10);

        DataCar p11 = new DataCar();
        p11.SetName("iUlp_OP2");
        pn.PlaceList.add(p11);

        DataCar p12 = new DataCar();
        p12.SetName("iUlp_Usrreq2");
        pn.PlaceList.add(p12);

        DataCar p13 = new DataCar();
        p13.SetName("iUlp_PPTL2");
        pn.PlaceList.add(p13);

        DataCar p14 = new DataCar();
        p14.SetName("iUlp_OPreq2");
        pn.PlaceList.add(p14);

        DataCar p15 = new DataCar();
        p15.SetName("iUlp_Pb2");
        pn.PlaceList.add(p15);

        DataCar p16 = new DataCar();
        p16.SetName("iUlp_PTL2");
        pn.PlaceList.add(p16);

        DataCar p17 = new DataCar();
        p17.SetName("iUlp_Pa4");
        pn.PlaceList.add(p17);

        DataCarQueue p18 = new DataCarQueue();
        p18.Value.Size = 10;
        p18.SetName("iUlp_Px4");
        pn.PlaceList.add(p18);

        DataCar p19 = new DataCar();
        p19.SetName("iUlp_OP4");
        pn.PlaceList.add(p19);

        DataCar p20 = new DataCar();
        p20.SetName("iUlp_Usrreq4");
        pn.PlaceList.add(p20);

        DataCar p21 = new DataCar();
        p21.SetName("iUlp_PPTL4");
        pn.PlaceList.add(p21);

        DataCar p22 = new DataCar();
        p22.SetName("iUlp_OPreq4");
        pn.PlaceList.add(p22);

        DataCar p23 = new DataCar();
        p23.SetName("iUlp_Pb4");
        pn.PlaceList.add(p23);

        DataCar p24 = new DataCar();
        p24.SetName("iUlp_PTL4");
        pn.PlaceList.add(p24);

        DataCarQueue p25 = new DataCarQueue();
        p25.Value.Size = 10;
        p25.SetName("iUlp_Po2");
        pn.PlaceList.add(p25);

        DataCarQueue p26 = new DataCarQueue();
        p26.Value.Size = 10;
        p26.SetName("iUlp_Po3");
        pn.PlaceList.add(p26);

        DataCar p27 = new DataCar();
        p27.SetName("iUlp_Poe3");
        pn.PlaceList.add(p27);

        DataCarQueue p28 = new DataCarQueue();
        p28.Value.Size = 10;
        p28.SetName("iUlp_Po4");
        pn.PlaceList.add(p28);

        DataCarQueue p29 = new DataCarQueue();
        p29.Value.Size = 10;
        p29.SetName("iUlp_PI");
        pn.PlaceList.add(p29);
    }

    public static void addT1 (PetriNet pn){

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "iUlp_Tu1";
        t1.InputPlaceName.add("iUlp_Pa1");
        t1.InputPlaceName.add("iUlp_Px1");

        Condition T1Ct1 = new Condition(t1, "iUlp_Pa1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "iUlp_Px1", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "iUlp_Pa1", TransitionOperation.AddElement, "iUlp_Px1"));
        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);
    }

    public static void addT2 (PetriNet pn){

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "iUlp_Tout1";
        t2.InputPlaceName.add("iUlp_Pa1");
        t2.InputPlaceName.add("iUlp_Px1");

        Condition T2Ct1 = new Condition(t2, "iUlp_Pa1", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "iUlp_Px1", TransitionCondition.CanNotAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;

        grdT2.Activations.add(new Activation(t2, "full", TransitionOperation.SendOverNetwork, "iUlp_OP1"));
        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

    }

    public static void addT3 (PetriNet pn){

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "iUlp_Te1";
        t3.InputPlaceName.add("iUlp_Px1");
        t3.InputPlaceName.add("iUlp_Usrreq1");
        t3.InputPlaceName.add("iUlp_PPTL1");
        t3.InputPlaceName.add("iUlp_PTL1");

        // First guard
        Condition T3Ct1_1 = new Condition(t3, "iUlp_Px1", TransitionCondition.HaveCar);
        Condition T3Ct1_2 = new Condition(t3, "iUlp_PTL1", TransitionCondition.Equal, "green");
        T3Ct1_1.SetNextCondition(LogicConnector.AND, T3Ct1_2);

        GuardMapping grdT3_1 = new GuardMapping();
        grdT3_1.condition = T3Ct1_1;

        grdT3_1.Activations.add(new Activation(t3, "iUlp_Px1", TransitionOperation.PopElementWithoutTarget, "iUlp_Pb1"));
        grdT3_1.Activations.add(new Activation(t3, "iUlp_PPTL1", TransitionOperation.Move, "iUlp_PPTL1"));
        grdT3_1.Activations.add(new Activation(t3, "iUlp_PTL1", TransitionOperation.Move, "iUlp_PTL1"));
        t3.GuardMappingList.add(grdT3_1);

        // Second guard
        Condition T3Ct2_1 = new Condition(t3, "iUlp_Usrreq1", TransitionCondition.NotNull);

        GuardMapping grdT3_2 = new GuardMapping();
        grdT3_2.condition = T3Ct2_1;

        grdT3_2.Activations.add(new Activation(t3, "iUlp_Usrreq1", TransitionOperation.SendOverNetwork, "iUlp_OPreq1"));
        grdT3_2.Activations.add(new Activation(t3, "iUlp_PPTL1", TransitionOperation.Move, "iUlp_PPTL1"));
        grdT3_2.Activations.add(new Activation(t3, "iUlp_PTL1", TransitionOperation.Move, "iUlp_PTL1"));
        t3.GuardMappingList.add(grdT3_2);

        // Third guard
        Condition T3Ct3_1 = new Condition(t3, "iUlp_Px1", TransitionCondition.HavePriorityCar);

        GuardMapping grdT3_3 = new GuardMapping();
        grdT3_3.condition = T3Ct3_1;

        grdT3_3.Activations.add(new Activation(t3, "iUlp_Px1", TransitionOperation.PopElementWithoutTarget, "iUlp_Pb1"));
        grdT3_3.Activations.add(new Activation(t3, "iUlp_PPTL1", TransitionOperation.Move, "iUlp_PPTL1"));
        grdT3_3.Activations.add(new Activation(t3, "iUlp_PTL1", TransitionOperation.Move, "iUlp_PTL1"));
        t3.GuardMappingList.add(grdT3_3);

        t3.Delay = 1;
        pn.Transitions.add(t3);

    }

    public static void addT4 (PetriNet pn){

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "iUlp_Ti1";
        t4.InputPlaceName.add("iUlp_Pb1");
        t4.InputPlaceName.add("iUlp_PI");

        Condition T4Ct1 = new Condition(t4, "iUlp_Pb1", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "iUlp_PI", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;

        grdT4.Activations.add(new Activation(t4, "iUlp_Pb1", TransitionOperation.AddElement, "iUlp_PI"));
        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        pn.Transitions.add(t4);

    }
    public static void addT5 (PetriNet pn){

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "iUlp_Tu2";
        t5.InputPlaceName.add("iUlp_Pa2");
        t5.InputPlaceName.add("iUlp_Px2");

        Condition T5Ct1 = new Condition(t5, "iUlp_Pa2", TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t5, "iUlp_Px2", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;

        grdT5.Activations.add(new Activation(t5, "iUlp_Pa2", TransitionOperation.AddElement, "iUlp_Px2"));
        t5.GuardMappingList.add(grdT5);
        t5.Delay = 0;
        pn.Transitions.add(t5);
    }

    public static void addT6 (PetriNet pn){

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "iUlp_Tout2";
        t6.InputPlaceName.add("iUlp_Pa2");
        t6.InputPlaceName.add("iUlp_Px2");

        Condition t6Ct1 = new Condition(t6, "iUlp_Pa2", TransitionCondition.NotNull);
        Condition t6Ct2 = new Condition(t6, "iUlp_Px2", TransitionCondition.CanNotAddCars);
        t6Ct1.SetNextCondition(LogicConnector.AND, t6Ct2);

        GuardMapping grdt6 = new GuardMapping();
        grdt6.condition = t6Ct1;

        grdt6.Activations.add(new Activation(t6, "full", TransitionOperation.SendOverNetwork, "iUlp_OP2"));
        t6.GuardMappingList.add(grdt6);
        t6.Delay = 0;
        pn.Transitions.add(t6);
    }

    public static void addT7 (PetriNet pn){

        // t7 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "iUlp_Te2";
        t7.InputPlaceName.add("iUlp_Px2");
        t7.InputPlaceName.add("iUlp_Usrreq2");
        t7.InputPlaceName.add("iUlp_PPTL2");
        t7.InputPlaceName.add("iUlp_PTL2");

        // First guard
        Condition t7Ct1_1 = new Condition(t7, "iUlp_Px2", TransitionCondition.HaveCar);
        Condition t7Ct1_2 = new Condition(t7, "iUlp_PTL2", TransitionCondition.Equal, "green");
        t7Ct1_1.SetNextCondition(LogicConnector.AND, t7Ct1_2);

        GuardMapping grdt7_1 = new GuardMapping();
        grdt7_1.condition = t7Ct1_1;

        grdt7_1.Activations.add(new Activation(t7, "iUlp_Px2", TransitionOperation.PopElementWithoutTarget, "iUlp_Pb2"));
        grdt7_1.Activations.add(new Activation(t7, "iUlp_PPTL2", TransitionOperation.Move, "iUlp_PPTL2"));
        grdt7_1.Activations.add(new Activation(t7, "iUlp_PTL2", TransitionOperation.Move, "iUlp_PTL2"));
        t7.GuardMappingList.add(grdt7_1);

        // Second guard
        Condition t7Ct2_1 = new Condition(t7, "iUlp_Usrreq2", TransitionCondition.NotNull);

        GuardMapping grdt7_2 = new GuardMapping();
        grdt7_2.condition = t7Ct2_1;

        grdt7_2.Activations.add(new Activation(t7, "iUlp_Usrreq2", TransitionOperation.SendOverNetwork, "iUlp_OPreq2"));
        grdt7_2.Activations.add(new Activation(t7, "iUlp_PPTL2", TransitionOperation.Move, "iUlp_PPTL2"));
        grdt7_2.Activations.add(new Activation(t7, "iUlp_PTL2", TransitionOperation.Move, "iUlp_PTL2"));
        t7.GuardMappingList.add(grdt7_2);

        // First guard
        Condition t7Ct3_1 = new Condition(t7, "iUlp_Px2", TransitionCondition.HavePriorityCar);

        GuardMapping grdt7_3 = new GuardMapping();
        grdt7_3.condition = t7Ct3_1;

        grdt7_3.Activations.add(new Activation(t7, "iUlp_Px2", TransitionOperation.PopElementWithoutTarget, "iUlp_Pb2"));
        grdt7_3.Activations.add(new Activation(t7, "iUlp_PPTL2", TransitionOperation.Move, "iUlp_PPTL2"));
        grdt7_3.Activations.add(new Activation(t7, "iUlp_PTL2", TransitionOperation.Move, "iUlp_PTL2"));
        t7.GuardMappingList.add(grdt7_3);

        t7.Delay = 1;
        pn.Transitions.add(t7);
    }

    public static void addT8 (PetriNet pn){

        // T8 ------------------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "iUlp_Ti2";
        t8.InputPlaceName.add("iUlp_Pb2");
        t8.InputPlaceName.add("iUlp_PI");

        Condition t8Ct1 = new Condition(t8, "iUlp_Pb2", TransitionCondition.NotNull);
        Condition t8Ct2 = new Condition(t8, "iUlp_PI", TransitionCondition.CanAddCars);
        t8Ct1.SetNextCondition(LogicConnector.AND, t8Ct2);

        GuardMapping grdt8 = new GuardMapping();
        grdt8.condition = t8Ct1;

        grdt8.Activations.add(new Activation(t8, "iUlp_Pb2", TransitionOperation.AddElement, "iUlp_PI"));
        t8.GuardMappingList.add(grdt8);
        t8.Delay = 0;
        pn.Transitions.add(t8);
    }

    public static void addT9 (PetriNet pn){

        // T9 ------------------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "iUlp_Tg2";
        t9.InputPlaceName.add("iUlp_Po2");
        t9.InputPlaceName.add("iUlp_PI");

        Condition t9Ct1 = new Condition(t9, "iUlp_PI", TransitionCondition.HaveCarForMe);
        Condition t9Ct2 = new Condition(t9, "iUlp_Po2", TransitionCondition.CanAddCars);
        t9Ct1.SetNextCondition(LogicConnector.AND, t9Ct2);

        GuardMapping grdt9 = new GuardMapping();
        grdt9.condition = t9Ct1;

        grdt9.Activations.add(new Activation(t9, "iUlp_PI", TransitionOperation.PopElementWithTargetToQueue, "iUlp_Po2"));
        t9.GuardMappingList.add(grdt9);
        t9.Delay = 1;
        pn.Transitions.add(t9);
    }

    public static void addT10 (PetriNet pn){

        // T10 ------------------------------------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "iUlp_Tge2";
        t10.InputPlaceName.add("iUlp_Po2");

        Condition t10Ct1 = new Condition(t10, "iUlp_Po2", TransitionCondition.HaveCar);

        GuardMapping grdt10 = new GuardMapping();
        grdt10.condition = t10Ct1;

        grdt10.Activations.add(new Activation(t10, "iUlp_Po2", TransitionOperation.PopElementWithoutTarget, "iVuia_Pa4"));
        t10.GuardMappingList.add(grdt10);
        t10.Delay = 0;
        pn.Transitions.add(t10);
    }

    public static void addT11 (PetriNet pn){

        // T11 ------------------------------------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "iUlp_Tg3";
        t11.InputPlaceName.add("iUlp_Po3");
        t11.InputPlaceName.add("iUlp_PI");

        Condition T11Ct1 = new Condition(t11, "iUlp_PI", TransitionCondition.HaveCarForMe);
        Condition T11Ct2 = new Condition(t11, "iUlp_Po3", TransitionCondition.CanAddCars);
        T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;

        grdT11.Activations.add(new Activation(t11, "iUlp_PI", TransitionOperation.PopElementWithTargetToQueue, "iUlp_Po3"));
        t11.GuardMappingList.add(grdT11);
        t11.Delay = 1;
        pn.Transitions.add(t11);
    }

    public static void addT12 (PetriNet pn){

        // T12 ------------------------------------------------
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "iUlp_Tge3";
        t12.InputPlaceName.add("iUlp_Po3");

        Condition T12Ct1 = new Condition(t12, "iUlp_Po3", TransitionCondition.HaveCar);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;

        grdT12.Activations.add(new Activation(t12, "iUlp_Po3", TransitionOperation.PopElementWithoutTarget, "iUlp_Poe3"));
        t12.GuardMappingList.add(grdT12);
        t12.Delay = 0;
        pn.Transitions.add(t12);
    }

    public static void addT13 (PetriNet pn){

        // T13 ------------------------------------------------
        PetriTransition t13 = new PetriTransition(pn);
        t13.TransitionName = "iUlp_Tu4";
        t13.InputPlaceName.add("iUlp_Pa4");
        t13.InputPlaceName.add("iUlp_Px4");

        Condition T13Ct1 = new Condition(t13, "iUlp_Pa4", TransitionCondition.NotNull);
        Condition T13Ct2 = new Condition(t13, "iUlp_Px4", TransitionCondition.CanAddCars);
        T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;

        grdT13.Activations.add(new Activation(t13, "iUlp_Pa4", TransitionOperation.AddElement, "iUlp_Px4"));
        t13.GuardMappingList.add(grdT13);
        t13.Delay = 0;
        pn.Transitions.add(t13);
    }

    public static void addT14 (PetriNet pn){

        // T14 ------------------------------------------------
        PetriTransition t14 = new PetriTransition(pn);
        t14.TransitionName = "iUlp_Tout4";
        t14.InputPlaceName.add("iUlp_Pa4");
        t14.InputPlaceName.add("iUlp_Px4");

        Condition T14Ct1 = new Condition(t14, "iUlp_Pa4", TransitionCondition.NotNull);
        Condition T14Ct2 = new Condition(t14, "iUlp_Px4", TransitionCondition.CanNotAddCars);
        T14Ct1.SetNextCondition(LogicConnector.AND, T14Ct2);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;

        grdT14.Activations.add(new Activation(t14, "full", TransitionOperation.SendOverNetwork, "iUlp_OP4"));
        t14.GuardMappingList.add(grdT14);
        t14.Delay = 0;
        pn.Transitions.add(t14);
    }

    public static void addT15 (PetriNet pn){

        // T15 ------------------------------------------------
        PetriTransition t15 = new PetriTransition(pn);
        t15.TransitionName = "iUlp_Te4";
        t15.InputPlaceName.add("iUlp_Px4");
        t15.InputPlaceName.add("iUlp_Usrreq4");
        t15.InputPlaceName.add("iUlp_PPTL4");
        t15.InputPlaceName.add("iUlp_PTL4");

        // First guard
        Condition T15Ct1_1 = new Condition(t15, "iUlp_Px4", TransitionCondition.HaveCar);
        Condition T15Ct1_2 = new Condition(t15, "iUlp_PTL4", TransitionCondition.Equal, "green");
        T15Ct1_1.SetNextCondition(LogicConnector.AND, T15Ct1_2);

        GuardMapping grdT15_1 = new GuardMapping();
        grdT15_1.condition = T15Ct1_1;

        grdT15_1.Activations.add(new Activation(t15, "iUlp_Px4", TransitionOperation.PopElementWithoutTarget, "iUlp_Pb4"));
        grdT15_1.Activations.add(new Activation(t15, "iUlp_PPTL4", TransitionOperation.Move, "iUlp_PPTL4"));
        grdT15_1.Activations.add(new Activation(t15, "iUlp_PTL4", TransitionOperation.Move, "iUlp_PTL4"));
        t15.GuardMappingList.add(grdT15_1);

        // Second guard
        Condition T15Ct2_1 = new Condition(t15, "iUlp_Usrreq4", TransitionCondition.NotNull);

        GuardMapping grdT15_2 = new GuardMapping();
        grdT15_2.condition = T15Ct2_1;

        grdT15_2.Activations.add(new Activation(t15, "iUlp_Usrreq4", TransitionOperation.SendOverNetwork, "iUlp_OPreq4"));
        grdT15_2.Activations.add(new Activation(t15, "iUlp_PPTL4", TransitionOperation.Move, "iUlp_PPTL4"));
        grdT15_2.Activations.add(new Activation(t15, "iUlp_PTL4", TransitionOperation.Move, "iUlp_PTL4"));
        t15.GuardMappingList.add(grdT15_2);

        // Third guard
        Condition T15Ct3_1 = new Condition(t15, "iUlp_Px4", TransitionCondition.HavePriorityCar);

        GuardMapping grdT15_3 = new GuardMapping();
        grdT15_3.condition = T15Ct3_1;

        grdT15_3.Activations.add(new Activation(t15, "iUlp_Px4", TransitionOperation.PopElementWithoutTarget, "iUlp_Pb4"));
        grdT15_3.Activations.add(new Activation(t15, "iUlp_PPTL4", TransitionOperation.Move, "iUlp_PPTL4"));
        grdT15_3.Activations.add(new Activation(t15, "iUlp_PTL4", TransitionOperation.Move, "iUlp_PTL4"));
        t15.GuardMappingList.add(grdT15_3);

        t15.Delay = 1;
        pn.Transitions.add(t15);
    }

    public static void addT16 (PetriNet pn){

        // T16 ------------------------------------------------
        PetriTransition t16 = new PetriTransition(pn);
        t16.TransitionName = "iUlp_Ti4";
        t16.InputPlaceName.add("iUlp_Pb4");
        t16.InputPlaceName.add("iUlp_PI");

        Condition T16Ct1 = new Condition(t16, "iUlp_Pb4", TransitionCondition.NotNull);
        Condition T16Ct2 = new Condition(t16, "iUlp_PI", TransitionCondition.CanAddCars);
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;

        grdT16.Activations.add(new Activation(t16, "iUlp_Pb4", TransitionOperation.AddElement, "iUlp_PI"));
        t16.GuardMappingList.add(grdT16);
        t16.Delay = 0;
        pn.Transitions.add(t16);
    }

    public static void addT17 (PetriNet pn){

        // T17 ------------------------------------------------
        PetriTransition t17 = new PetriTransition(pn);
        t17.TransitionName = "iUlp_Tg4";
        t17.InputPlaceName.add("iUlp_Po4");
        t17.InputPlaceName.add("iUlp_PI");

        Condition T17Ct1 = new Condition(t17, "iUlp_PI", TransitionCondition.HaveCarForMe);
        Condition T17Ct2 = new Condition(t17, "iUlp_Po4", TransitionCondition.CanAddCars);
        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;

        grdT17.Activations.add(new Activation(t17, "iUlp_PI", TransitionOperation.PopElementWithTargetToQueue, "iUlp_Po4"));
        t17.GuardMappingList.add(grdT17);
        t17.Delay = 1;
        pn.Transitions.add(t17);
    }

    public static void addT18 (PetriNet pn){

        // T18 ------------------------------------------------
        PetriTransition t18 = new PetriTransition(pn);
        t18.TransitionName = "iUlp_Tge4";
        t18.InputPlaceName.add("iUlp_Po4");

        Condition T18Ct1 = new Condition(t18, "iUlp_Po4", TransitionCondition.HaveCar);

        GuardMapping grdT18 = new GuardMapping();
        grdT18.condition = T18Ct1;

        grdT18.Activations.add(new Activation(t18, "iUlp_Po4", TransitionOperation.PopElementWithoutTarget, "iDrub_Pa2"));
        t18.GuardMappingList.add(grdT18);
        t18.Delay = 0;
        pn.Transitions.add(t18);
    }

    public static void generatePetriNet (PetriNet pn) {
        addNodes(pn);
        addT1(pn);
        addT2(pn);
        addT3(pn);
        addT4(pn);
        addT5(pn);
        addT6(pn);
        addT7(pn);
        addT8(pn);
        addT7(pn);
        addT9(pn);
        addT10(pn);
        addT11(pn);
        addT12(pn);
        addT13(pn);
        addT14(pn);
        addT15(pn);
        addT16(pn);
        addT17(pn);
        addT18(pn);
    }
}
