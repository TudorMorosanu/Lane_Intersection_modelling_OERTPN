package LanesIntersection;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class RebreanuIntersection {
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
        p1.SetName("iRbr_Pa1");
        pn.PlaceList.add(p1);

        DataCarQueue p2 = new DataCarQueue();
        p2.Value.Size = 10;
        p2.SetName("iRbr_Px1");
        pn.PlaceList.add(p2);

        DataCar p3 = new DataCar();
        p3.SetName("iRbr_OP1");
        pn.PlaceList.add(p3);

        DataCar p4 = new DataCar();
        p4.SetName("iRbr_Usrreq1");
        pn.PlaceList.add(p4);

        DataCar p5 = new DataCar();
        p5.SetName("iRbr_PPTL1");
        pn.PlaceList.add(p5);

        DataCar p6 = new DataCar();
        p6.SetName("iRbr_OPreq1");
        pn.PlaceList.add(p6);

        DataCar p7 = new DataCar();
        p7.SetName("iRbr_Pb1");
        pn.PlaceList.add(p7);

        DataCar p8 = new DataCar();
        p8.SetName("iRbr_PTL1");
        pn.PlaceList.add(p8);

        DataCar p9 = new DataCar();
        p9.SetName("iRbr_Pa2");
        pn.PlaceList.add(p9);

        DataCarQueue p10 = new DataCarQueue();
        p10.Value.Size = 10;
        p10.SetName("iRbr_Px2");
        pn.PlaceList.add(p10);

        DataCar p11 = new DataCar();
        p11.SetName("iRbr_OP2");
        pn.PlaceList.add(p11);

        DataCar p12 = new DataCar();
        p12.SetName("iRbr_Usrreq2");
        pn.PlaceList.add(p12);

        DataCar p13 = new DataCar();
        p13.SetName("iRbr_PPTL2");
        pn.PlaceList.add(p13);

        DataCar p14 = new DataCar();
        p14.SetName("iRbr_OPreq2");
        pn.PlaceList.add(p14);

        DataCar p15 = new DataCar();
        p15.SetName("iRbr_Pb2");
        pn.PlaceList.add(p15);

        DataCar p16 = new DataCar();
        p16.SetName("iRbr_PTL2");
        pn.PlaceList.add(p16);

        DataCar p17 = new DataCar();
        p17.SetName("iRbr_Pa3");
        pn.PlaceList.add(p17);

        DataCarQueue p18 = new DataCarQueue();
        p18.Value.Size = 10;
        p18.SetName("iRbr_Px3");
        pn.PlaceList.add(p18);

        DataCar p19 = new DataCar();
        p19.SetName("iRbr_OP3");
        pn.PlaceList.add(p19);

        DataCar p20 = new DataCar();
        p20.SetName("iRbr_Usrreq3");
        pn.PlaceList.add(p20);

        DataCar p21 = new DataCar();
        p21.SetName("iRbr_PPTL3");
        pn.PlaceList.add(p21);

        DataCar p22 = new DataCar();
        p22.SetName("iRbr_OPreq3");
        pn.PlaceList.add(p22);

        DataCar p23 = new DataCar();
        p23.SetName("iRbr_Pb3");
        pn.PlaceList.add(p23);

        DataCar p24 = new DataCar();
        p24.SetName("iRbr_PTL3");
        pn.PlaceList.add(p24);

        DataCar p25 = new DataCar();
        p25.SetName("iRbr_Pa4");
        pn.PlaceList.add(p25);

        DataCarQueue p26 = new DataCarQueue();
        p26.Value.Size = 10;
        p26.SetName("iRbr_Px4");
        pn.PlaceList.add(p26);

        DataCar p27 = new DataCar();
        p27.SetName("iRbr_OP4");
        pn.PlaceList.add(p27);

        DataCar p28 = new DataCar();
        p28.SetName("iRbr_Usrreq4");
        pn.PlaceList.add(p28);

        DataCar p29 = new DataCar();
        p29.SetName("iRbr_PPTL4");
        pn.PlaceList.add(p29);

        DataCar p30 = new DataCar();
        p30.SetName("iRbr_OPreq4");
        pn.PlaceList.add(p30);

        DataCar p31 = new DataCar();
        p31.SetName("iRbr_Pb4");
        pn.PlaceList.add(p31);

        DataCar p32 = new DataCar();
        p32.SetName("iRbr_PTL4");
        pn.PlaceList.add(p32);

        DataCarQueue p33 = new DataCarQueue();
        p33.Value.Size = 10;
        p33.SetName("iRbr_Po1");
        pn.PlaceList.add(p33);

        DataCar p34 = new DataCar();
        p34.SetName("iRbr_Poe1");
        pn.PlaceList.add(p34);

        DataCarQueue p35 = new DataCarQueue();
        p35.Value.Size = 10;
        p35.SetName("iRbr_Po2");
        pn.PlaceList.add(p35);

        DataCar p36 = new DataCar();
        p36.SetName("iRbr_Poe2");
        pn.PlaceList.add(p36);

        DataCarQueue p37 = new DataCarQueue();
        p37.Value.Size = 10;
        p37.SetName("iRbr_Po3");
        pn.PlaceList.add(p37);

        DataCar p38 = new DataCar();
        p38.SetName("iRbr_Poe3");
        pn.PlaceList.add(p38);

        DataCarQueue p39 = new DataCarQueue();
        p39.Value.Size = 10;
        p39.SetName("iRbr_Po4");
        pn.PlaceList.add(p39);

        DataCarQueue p41 = new DataCarQueue();
        p41.Value.Size = 10;
        p41.SetName("iRbr_PI");
        pn.PlaceList.add(p41);
    }

    public static void addT1 (PetriNet pn){

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "iRbr_Tu1";
        t1.InputPlaceName.add("iRbr_Pa1");
        t1.InputPlaceName.add("iRbr_Px1");

        Condition T1Ct1 = new Condition(t1, "iRbr_Pa1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "iRbr_Px1", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "iRbr_Pa1", TransitionOperation.AddElement, "iRbr_Px1"));
        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);
    }

    public static void addT2 (PetriNet pn){

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "iRbr_Tout1";
        t2.InputPlaceName.add("iRbr_Pa1");
        t2.InputPlaceName.add("iRbr_Px1");

        Condition T2Ct1 = new Condition(t2, "iRbr_Pa1", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "iRbr_Px1", TransitionCondition.CanNotAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;

        grdT2.Activations.add(new Activation(t2, "full", TransitionOperation.SendOverNetwork, "iRbr_OP1"));
        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

    }

    public static void addT3 (PetriNet pn){

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "iRbr_Te1";
        t3.InputPlaceName.add("iRbr_Px1");
        t3.InputPlaceName.add("iRbr_Usrreq1");
        t3.InputPlaceName.add("iRbr_PPTL1");
        t3.InputPlaceName.add("iRbr_PTL1");

        // First guard
        Condition T3Ct1_1 = new Condition(t3, "iRbr_Px1", TransitionCondition.HaveCar);
        Condition T3Ct1_2 = new Condition(t3, "iRbr_PTL1", TransitionCondition.Equal, "green");
        T3Ct1_1.SetNextCondition(LogicConnector.AND, T3Ct1_2);

        GuardMapping grdT3_1 = new GuardMapping();
        grdT3_1.condition = T3Ct1_1;

        grdT3_1.Activations.add(new Activation(t3, "iRbr_Px1", TransitionOperation.PopElementWithoutTarget, "iRbr_Pb1"));
        grdT3_1.Activations.add(new Activation(t3, "iRbr_PPTL1", TransitionOperation.Move, "iRbr_PPTL1"));
        grdT3_1.Activations.add(new Activation(t3, "iRbr_PTL1", TransitionOperation.Move, "iRbr_PTL1"));
        t3.GuardMappingList.add(grdT3_1);

        // Second guard
        Condition T3Ct2_1 = new Condition(t3, "iRbr_Usrreq1", TransitionCondition.NotNull);

        GuardMapping grdT3_2 = new GuardMapping();
        grdT3_2.condition = T3Ct2_1;

        grdT3_2.Activations.add(new Activation(t3, "iRbr_Usrreq1", TransitionOperation.SendOverNetwork, "iRbr_OPreq1"));
        grdT3_2.Activations.add(new Activation(t3, "iRbr_PPTL1", TransitionOperation.Move, "iRbr_PPTL1"));
        grdT3_2.Activations.add(new Activation(t3, "iRbr_PTL1", TransitionOperation.Move, "iRbr_PTL1"));
        t3.GuardMappingList.add(grdT3_2);

        t3.Delay = 1;
        pn.Transitions.add(t3);

    }

    public static void addT4 (PetriNet pn){

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "iRbr_Ti1";
        t4.InputPlaceName.add("iRbr_Pb1");
        t4.InputPlaceName.add("iRbr_PI");

        Condition T4Ct1 = new Condition(t4, "iRbr_Pb1", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "iRbr_PI", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;

        grdT4.Activations.add(new Activation(t4, "iRbr_Pb1", TransitionOperation.AddElement, "iRbr_PI"));
        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        pn.Transitions.add(t4);

    }

    public static void addT5 (PetriNet pn){

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "iRbr_Tg1";
        t5.InputPlaceName.add("iRbr_Po1");
        t5.InputPlaceName.add("iRbr_PI");

        Condition T5Ct1 = new Condition(t5, "iRbr_PI", TransitionCondition.HaveCarForMe);
        Condition T5Ct2 = new Condition(t5, "iRbr_Po1", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;

        grdT5.Activations.add(new Activation(t5, "iRbr_PI", TransitionOperation.PopElementWithTargetToQueue, "iRbr_Po1"));
        t5.GuardMappingList.add(grdT5);
        t5.Delay = 1;
        pn.Transitions.add(t5);

    }

    public static void addT6 (PetriNet pn){

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "iRbr_Tge1";
        t6.InputPlaceName.add("iRbr_Po1");

        Condition T6Ct1 = new Condition(t6, "iRbr_Po1", TransitionCondition.HaveCar);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;

        grdT6.Activations.add(new Activation(t6, "iRbr_Po1", TransitionOperation.PopElementWithoutTarget, "iRbr_Poe1"));
        t6.GuardMappingList.add(grdT6);
        t6.Delay = 0;
        pn.Transitions.add(t6);

    }

    public static void addT7 (PetriNet pn){

        // T7 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "iRbr_Tu2";
        t7.InputPlaceName.add("iRbr_Pa2");
        t7.InputPlaceName.add("iRbr_Px2");

        Condition T7Ct1 = new Condition(t7, "iRbr_Pa2", TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t7, "iRbr_Px2", TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;

        grdT7.Activations.add(new Activation(t7, "iRbr_Pa2", TransitionOperation.AddElement, "iRbr_Px2"));
        t7.GuardMappingList.add(grdT7);
        t7.Delay = 0;
        pn.Transitions.add(t7);
    }

    public static void addT8 (PetriNet pn){

        // T8 ------------------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "iRbr_Tout2";
        t8.InputPlaceName.add("iRbr_Pa2");
        t8.InputPlaceName.add("iRbr_Px2");

        Condition T8Ct1 = new Condition(t8, "iRbr_Pa2", TransitionCondition.NotNull);
        Condition T8Ct2 = new Condition(t8, "iRbr_Px2", TransitionCondition.CanNotAddCars);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;

        grdT8.Activations.add(new Activation(t8, "full", TransitionOperation.SendOverNetwork, "iRbr_OP2"));
        t8.GuardMappingList.add(grdT8);
        t8.Delay = 0;
        pn.Transitions.add(t8);
    }

    public static void addT9 (PetriNet pn){

        // T9 ------------------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "iRbr_Te2";
        t9.InputPlaceName.add("iRbr_Px2");
        t9.InputPlaceName.add("iRbr_Usrreq2");
        t9.InputPlaceName.add("iRbr_PPTL2");
        t9.InputPlaceName.add("iRbr_PTL2");

        // First guard
        Condition T9Ct1_1 = new Condition(t9, "iRbr_Px2", TransitionCondition.HaveCar);
        Condition T9Ct1_2 = new Condition(t9, "iRbr_PTL2", TransitionCondition.Equal, "green");
        T9Ct1_1.SetNextCondition(LogicConnector.AND, T9Ct1_2);

        GuardMapping grdT9_1 = new GuardMapping();
        grdT9_1.condition = T9Ct1_1;

        grdT9_1.Activations.add(new Activation(t9, "iRbr_Px2", TransitionOperation.PopElementWithoutTarget, "iRbr_Pb2"));
        grdT9_1.Activations.add(new Activation(t9, "iRbr_PPTL2", TransitionOperation.Move, "iRbr_PPTL2"));
        grdT9_1.Activations.add(new Activation(t9, "iRbr_PTL2", TransitionOperation.Move, "iRbr_PTL2"));
        t9.GuardMappingList.add(grdT9_1);

        // Second guard
        Condition T9Ct2_1 = new Condition(t9, "iRbr_Usrreq2", TransitionCondition.NotNull);

        GuardMapping grdT9_2 = new GuardMapping();
        grdT9_2.condition = T9Ct2_1;

        grdT9_2.Activations.add(new Activation(t9, "iRbr_Usrreq2", TransitionOperation.SendOverNetwork, "iRbr_OPreq2"));
        grdT9_2.Activations.add(new Activation(t9, "iRbr_PPTL2", TransitionOperation.Move, "iRbr_PPTL2"));
        grdT9_2.Activations.add(new Activation(t9, "iRbr_PTL2", TransitionOperation.Move, "iRbr_PTL2"));
        t9.GuardMappingList.add(grdT9_2);

        t9.Delay = 1;
        pn.Transitions.add(t9);
    }

    public static void addT10 (PetriNet pn){

        // T10 ------------------------------------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "iRbr_Ti2";
        t10.InputPlaceName.add("iRbr_Pb2");
        t10.InputPlaceName.add("iRbr_PI");

        Condition T10Ct1 = new Condition(t10, "iRbr_Pb2", TransitionCondition.NotNull);
        Condition T10Ct2 = new Condition(t10, "iRbr_PI", TransitionCondition.CanAddCars);
        T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;

        grdT10.Activations.add(new Activation(t10, "iRbr_Pb2", TransitionOperation.AddElement, "iRbr_PI"));
        t10.GuardMappingList.add(grdT10);
        t10.Delay = 0;
        pn.Transitions.add(t10);
    }

    public static void addT11 (PetriNet pn){

        // T11 ------------------------------------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "iRbr_Tg2";
        t11.InputPlaceName.add("iRbr_Po2");
        t11.InputPlaceName.add("iRbr_PI");

        Condition T11Ct1 = new Condition(t11, "iRbr_PI", TransitionCondition.HaveCarForMe);
        Condition T11Ct2 = new Condition(t11, "iRbr_Po2", TransitionCondition.CanAddCars);
        T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;

        grdT11.Activations.add(new Activation(t11, "iRbr_PI", TransitionOperation.PopElementWithTargetToQueue, "iRbr_Po2"));
        t11.GuardMappingList.add(grdT11);
        t11.Delay = 1;
        pn.Transitions.add(t11);
    }

    public static void addT12 (PetriNet pn){

        // T12 ------------------------------------------------
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "iRbr_Tge2";
        t12.InputPlaceName.add("iRbr_Po2");

        Condition T12Ct1 = new Condition(t12, "iRbr_Po2", TransitionCondition.HaveCar);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;

        grdT12.Activations.add(new Activation(t12, "iRbr_Po2", TransitionOperation.PopElementWithoutTarget, "iRbr_Poe2"));
        t12.GuardMappingList.add(grdT12);
        t12.Delay = 0;
        pn.Transitions.add(t12);
    }

    public static void addT13 (PetriNet pn){

        // T13 ------------------------------------------------
        PetriTransition t13 = new PetriTransition(pn);
        t13.TransitionName = "iRbr_Tu3";
        t13.InputPlaceName.add("iRbr_Pa3");
        t13.InputPlaceName.add("iRbr_Px3");

        Condition T13Ct1 = new Condition(t13, "iRbr_Pa3", TransitionCondition.NotNull);
        Condition T13Ct2 = new Condition(t13, "iRbr_Px3", TransitionCondition.CanAddCars);
        T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;

        grdT13.Activations.add(new Activation(t13, "iRbr_Pa3", TransitionOperation.AddElement, "iRbr_Px3"));
        t13.GuardMappingList.add(grdT13);
        t13.Delay = 0;
        pn.Transitions.add(t13);
    }

    public static void addT14 (PetriNet pn){

        // T14 ------------------------------------------------
        PetriTransition t14 = new PetriTransition(pn);
        t14.TransitionName = "iRbr_Tout3";
        t14.InputPlaceName.add("iRbr_Pa3");
        t14.InputPlaceName.add("iRbr_Px3");

        Condition T14Ct1 = new Condition(t14, "iRbr_Pa3", TransitionCondition.NotNull);
        Condition T14Ct2 = new Condition(t14, "iRbr_Px3", TransitionCondition.CanNotAddCars);
        T14Ct1.SetNextCondition(LogicConnector.AND, T14Ct2);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;

        grdT14.Activations.add(new Activation(t14, "full", TransitionOperation.SendOverNetwork, "iRbr_OP3"));
        t14.GuardMappingList.add(grdT14);
        t14.Delay = 0;
        pn.Transitions.add(t14);
    }

    public static void addT15 (PetriNet pn){

        // T15 ------------------------------------------------
        PetriTransition t15 = new PetriTransition(pn);
        t15.TransitionName = "iRbr_Te3";
        t15.InputPlaceName.add("iRbr_Px3");
        t15.InputPlaceName.add("iRbr_Usrreq3");
        t15.InputPlaceName.add("iRbr_PPTL3");
        t15.InputPlaceName.add("iRbr_PTL3");

        // First guard
        Condition T15Ct1_1 = new Condition(t15, "iRbr_Px3", TransitionCondition.HaveCar);
        Condition T15Ct1_2 = new Condition(t15, "iRbr_PTL3", TransitionCondition.Equal, "green");
        T15Ct1_1.SetNextCondition(LogicConnector.AND, T15Ct1_2);

        GuardMapping grdT15_1 = new GuardMapping();
        grdT15_1.condition = T15Ct1_1;

        grdT15_1.Activations.add(new Activation(t15, "iRbr_Px3", TransitionOperation.PopElementWithoutTarget, "iRbr_Pb3"));
        grdT15_1.Activations.add(new Activation(t15, "iRbr_PPTL3", TransitionOperation.Move, "iRbr_PPTL3"));
        grdT15_1.Activations.add(new Activation(t15, "iRbr_PTL3", TransitionOperation.Move, "iRbr_PTL3"));
        t15.GuardMappingList.add(grdT15_1);

        // Second guard
        Condition T15Ct2_1 = new Condition(t15, "iRbr_Usrreq3", TransitionCondition.NotNull);

        GuardMapping grdT15_2 = new GuardMapping();
        grdT15_2.condition = T15Ct2_1;

        grdT15_2.Activations.add(new Activation(t15, "iRbr_Usrreq3", TransitionOperation.SendOverNetwork, "iRbr_OPreq3"));
        grdT15_2.Activations.add(new Activation(t15, "iRbr_PPTL3", TransitionOperation.Move, "iRbr_PPTL3"));
        grdT15_2.Activations.add(new Activation(t15, "iRbr_PTL3", TransitionOperation.Move, "iRbr_PTL3"));
        t15.GuardMappingList.add(grdT15_2);

        t15.Delay = 1;
        pn.Transitions.add(t15);
    }

    public static void addT16 (PetriNet pn){

        // T16 ------------------------------------------------
        PetriTransition t16 = new PetriTransition(pn);
        t16.TransitionName = "iRbr_Ti3";
        t16.InputPlaceName.add("iRbr_Pb3");
        t16.InputPlaceName.add("iRbr_PI");

        Condition T16Ct1 = new Condition(t16, "iRbr_Pb3", TransitionCondition.NotNull);
        Condition T16Ct2 = new Condition(t16, "iRbr_PI", TransitionCondition.CanAddCars);
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;

        grdT16.Activations.add(new Activation(t16, "iRbr_Pb3", TransitionOperation.AddElement, "iRbr_PI"));
        t16.GuardMappingList.add(grdT16);
        t16.Delay = 0;
        pn.Transitions.add(t16);
    }

    public static void addT17 (PetriNet pn){

        // T17 ------------------------------------------------
        PetriTransition t17 = new PetriTransition(pn);
        t17.TransitionName = "iRbr_Tg3";
        t17.InputPlaceName.add("iRbr_Po3");
        t17.InputPlaceName.add("iRbr_PI");

        Condition T17Ct1 = new Condition(t17, "iRbr_PI", TransitionCondition.HaveCarForMe);
        Condition T17Ct2 = new Condition(t17, "iRbr_Po3", TransitionCondition.CanAddCars);
        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;

        grdT17.Activations.add(new Activation(t17, "iRbr_PI", TransitionOperation.PopElementWithTargetToQueue, "iRbr_Po3"));
        t17.GuardMappingList.add(grdT17);
        t17.Delay = 1;
        pn.Transitions.add(t17);
    }

    public static void addT18 (PetriNet pn){

        // T18 ------------------------------------------------
        PetriTransition t18 = new PetriTransition(pn);
        t18.TransitionName = "iRbr_Tge3";
        t18.InputPlaceName.add("iRbr_Po3");

        Condition T18Ct1 = new Condition(t18, "iRbr_Po3", TransitionCondition.HaveCar);

        GuardMapping grdT18 = new GuardMapping();
        grdT18.condition = T18Ct1;

        grdT18.Activations.add(new Activation(t18, "iRbr_Po3", TransitionOperation.PopElementWithoutTarget, "iRbr_Poe3"));
        t18.GuardMappingList.add(grdT18);
        t18.Delay = 0;
        pn.Transitions.add(t18);
    }

    public static void addT19 (PetriNet pn){

        // T19 ------------------------------------------------
        PetriTransition t19 = new PetriTransition(pn);
        t19.TransitionName = "iRbr_Tu4";
        t19.InputPlaceName.add("iRbr_Pa4");
        t19.InputPlaceName.add("iRbr_Px4");

        Condition T19Ct1 = new Condition(t19, "iRbr_Pa4", TransitionCondition.NotNull);
        Condition T19Ct2 = new Condition(t19, "iRbr_Px4", TransitionCondition.CanAddCars);
        T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);

        GuardMapping grdT19 = new GuardMapping();
        grdT19.condition = T19Ct1;

        grdT19.Activations.add(new Activation(t19, "iRbr_Pa4", TransitionOperation.AddElement, "iRbr_Px4"));
        t19.GuardMappingList.add(grdT19);
        t19.Delay = 0;
        pn.Transitions.add(t19);
    }

    public static void addT20 (PetriNet pn){

        // T20 ------------------------------------------------
        PetriTransition t20 = new PetriTransition(pn);
        t20.TransitionName = "iRbr_Tout4";
        t20.InputPlaceName.add("iRbr_Pa4");
        t20.InputPlaceName.add("iRbr_Px4");

        Condition T20Ct1 = new Condition(t20, "iRbr_Pa4", TransitionCondition.NotNull);
        Condition T20Ct2 = new Condition(t20, "iRbr_Px4", TransitionCondition.CanNotAddCars);
        T20Ct1.SetNextCondition(LogicConnector.AND, T20Ct2);

        GuardMapping grdT20 = new GuardMapping();
        grdT20.condition = T20Ct1;

        grdT20.Activations.add(new Activation(t20, "full", TransitionOperation.SendOverNetwork, "iRbr_OP4"));
        t20.GuardMappingList.add(grdT20);
        t20.Delay = 0;
        pn.Transitions.add(t20);
    }

    public static void addT21 (PetriNet pn){

        // T21 ------------------------------------------------
        PetriTransition t21 = new PetriTransition(pn);
        t21.TransitionName = "iRbr_Te4";
        t21.InputPlaceName.add("iRbr_Px4");
        t21.InputPlaceName.add("iRbr_Usrreq4");
        t21.InputPlaceName.add("iRbr_PPTL4");
        t21.InputPlaceName.add("iRbr_PTL4");

        // First guard
        Condition T21Ct1_1 = new Condition(t21, "iRbr_Px4", TransitionCondition.HaveCar);
        Condition T21Ct1_2 = new Condition(t21, "iRbr_PTL4", TransitionCondition.Equal, "green");
        T21Ct1_1.SetNextCondition(LogicConnector.AND, T21Ct1_2);

        GuardMapping grdT21_1 = new GuardMapping();
        grdT21_1.condition = T21Ct1_1;

        grdT21_1.Activations.add(new Activation(t21, "iRbr_Px4", TransitionOperation.PopElementWithoutTarget, "iRbr_Pb4"));
        grdT21_1.Activations.add(new Activation(t21, "iRbr_PPTL4", TransitionOperation.Move, "iRbr_PPTL4"));
        grdT21_1.Activations.add(new Activation(t21, "iRbr_PTL4", TransitionOperation.Move, "iRbr_PTL4"));
        t21.GuardMappingList.add(grdT21_1);

        // Second guard
        Condition T21Ct2_1 = new Condition(t21, "iRbr_Usrreq4", TransitionCondition.NotNull);

        GuardMapping grdT21_2 = new GuardMapping();
        grdT21_2.condition = T21Ct2_1;

        grdT21_2.Activations.add(new Activation(t21, "iRbr_Usrreq4", TransitionOperation.SendOverNetwork, "iRbr_OPreq4"));
        grdT21_2.Activations.add(new Activation(t21, "iRbr_PPTL4", TransitionOperation.Move, "iRbr_PPTL4"));
        grdT21_2.Activations.add(new Activation(t21, "iRbr_PTL4", TransitionOperation.Move, "iRbr_PTL4"));
        t21.GuardMappingList.add(grdT21_2);

        t21.Delay = 1;
        pn.Transitions.add(t21);
    }

    public static void addT22 (PetriNet pn){

        // T22 ------------------------------------------------
        PetriTransition t22 = new PetriTransition(pn);
        t22.TransitionName = "iRbr_Ti4";
        t22.InputPlaceName.add("iRbr_Pb4");
        t22.InputPlaceName.add("iRbr_PI");

        Condition T22Ct1 = new Condition(t22, "iRbr_Pb4", TransitionCondition.NotNull);
        Condition T22Ct2 = new Condition(t22, "iRbr_PI", TransitionCondition.CanAddCars);
        T22Ct1.SetNextCondition(LogicConnector.AND, T22Ct2);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T22Ct1;

        grdT22.Activations.add(new Activation(t22, "iRbr_Pb4", TransitionOperation.AddElement, "iRbr_PI"));
        t22.GuardMappingList.add(grdT22);
        t22.Delay = 0;
        pn.Transitions.add(t22);
    }

    public static void addT23 (PetriNet pn){

        // T23 ------------------------------------------------
        PetriTransition t23 = new PetriTransition(pn);
        t23.TransitionName = "iRbr_Tg4";
        t23.InputPlaceName.add("iRbr_Po4");
        t23.InputPlaceName.add("iRbr_PI");

        Condition T23Ct1 = new Condition(t23, "iRbr_PI", TransitionCondition.HaveCarForMe);
        Condition T23Ct2 = new Condition(t23, "iRbr_Po4", TransitionCondition.CanAddCars);
        T23Ct1.SetNextCondition(LogicConnector.AND, T23Ct2);

        GuardMapping grdT23 = new GuardMapping();
        grdT23.condition = T23Ct1;

        grdT23.Activations.add(new Activation(t23, "iRbr_PI", TransitionOperation.PopElementWithTargetToQueue, "iRbr_Po4"));
        t23.GuardMappingList.add(grdT23);
        t23.Delay = 1;
        pn.Transitions.add(t23);
    }

    public static void addT24 (PetriNet pn){

        // T24 ------------------------------------------------
        PetriTransition t24 = new PetriTransition(pn);
        t24.TransitionName = "iRbr_Tge4";
        t24.InputPlaceName.add("iRbr_Po4");

        Condition T24Ct1 = new Condition(t24, "iRbr_Po4", TransitionCondition.HaveCar);

        GuardMapping grdT24 = new GuardMapping();
        grdT24.condition = T24Ct1;

        grdT24.Activations.add(new Activation(t24, "iRbr_Po4", TransitionOperation.PopElementWithoutTarget, "iVuia_Pa2"));
        t24.GuardMappingList.add(grdT24);
        t24.Delay = 0;
        pn.Transitions.add(t24);
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
        addT19(pn);
        addT20(pn);
        addT21(pn);
        addT22(pn);
        addT23(pn);
        addT24(pn);
    }
}
