package Controllers;

import Components.*;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class ControllerUlpia {

    public static void start() {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller Ulpia";
        pn.NetworkPort = 1085;

        DataString green = new DataString();
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        DataString red = new DataString();
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString Five = new DataString();
        Five.SetName("Five");
        Five.SetValue(5);
        pn.ConstantPlaceList.add(Five);

        DataString Ten = new DataString();
        Ten.SetName("Ten");
        Ten.SetValue(10);
        pn.ConstantPlaceList.add(Ten);

        DataTransfer op1 = new DataTransfer();
        op1.SetName("op1");
        op1.Value = new TransferOperation("localhost", "1080", "iUlp_PTL1");
        pn.PlaceList.add(op1);

        DataTransfer op2 = new DataTransfer();
        op2.SetName("op2");
        op2.Value = new TransferOperation("localhost", "1080", "iUlp_PTL2");
        pn.PlaceList.add(op2);

        DataTransfer op3 = new DataTransfer();
        op3.SetName("op3");
        op3.Value = new TransferOperation("localhost", "1080", "iUlp_PTL4");
        pn.PlaceList.add(op3);

        DataString ini = new DataString();
        ini.SetName("ini");
        ini.SetValue("1");
        pn.PlaceList.add(ini);

        DataString r1r2r3 = new DataString();
        r1r2r3.SetName("r1r2r3");
        r1r2r3.SetValue("1");
        pn.PlaceList.add(r1r2r3);

        DataString g1r2r3 = new DataString();
        g1r2r3.SetName("g1r2r3");
        pn.PlaceList.add(g1r2r3);

        DataString y1r2r3 = new DataString();
        y1r2r3.SetName("y1r2r3");
        pn.PlaceList.add(y1r2r3);

        DataString r1g2r3 = new DataString();
        r1g2r3.SetName("r1g2r3");
        pn.PlaceList.add(r1g2r3);

        DataString r1y2r3 = new DataString();
        r1y2r3.SetName("r1y2r3");
        pn.PlaceList.add(r1y2r3);

        DataString r1r2g3 = new DataString();
        r1r2g3.SetName("r1r2g3");
        pn.PlaceList.add(r1r2g3);

        DataString r1r2y3 = new DataString();
        r1r2y3.SetName("r1r2y3");
        pn.PlaceList.add(r1r2y3);

        DataString in1 = new DataString();
        in1.SetName("in1");
        pn.PlaceList.add(in1);

        DataString in2 = new DataString();
        in2.SetName("in2");
        pn.PlaceList.add(in2);

        DataString in3 = new DataString();
        in3.SetName("in3");
        pn.PlaceList.add(in3);

        DataString P_f1 = new DataString();
        P_f1.SetName("P_f1");
        pn.PlaceList.add(P_f1);

        DataString P_f2 = new DataString();
        P_f2.SetName("P_f2");
        pn.PlaceList.add(P_f2);

        DataString P_f3 = new DataString();
        P_f3.SetName("P_f3");
        pn.PlaceList.add(P_f3);

        // iniT ------------------------------------------------
        PetriTransition iniT = new PetriTransition(pn);
        iniT.TransitionName = "iniT";
        iniT.InputPlaceName.add("ini");

        Condition TiniCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

        GuardMapping grdTini = new GuardMapping();
        grdTini.condition = TiniCt1;
        grdTini.Activations.add(new Activation(iniT, "red", TransitionOperation.SendOverNetwork, "op1"));
        grdTini.Activations.add(new Activation(iniT, "red", TransitionOperation.SendOverNetwork, "op2"));
        grdTini.Activations.add(new Activation(iniT, "red", TransitionOperation.SendOverNetwork, "op3"));
        iniT.GuardMappingList.add(grdTini);

        iniT.Delay = 0;
        pn.Transitions.add(iniT);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("r1r2r3");

        Condition T1Ct1 = new Condition(t1, "r1r2r3", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2r3", TransitionOperation.Move, "g1r2r3"));
        grdT1.Activations.add(new Activation(t1, "r1r2r3", TransitionOperation.Move, "P_f1"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "op1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 1;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("g1r2r3");

        Condition T2Ct1 = new Condition(t2, "g1r2r3", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "g1r2r3", TransitionOperation.Move, "y1r2r3"));
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "op1"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 1;
        pn.Transitions.add(t2);

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("y1r2r3");

        Condition T3Ct1 = new Condition(t3, "y1r2r3", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "y1r2r3", TransitionOperation.Move, "r1g2r3"));
        grdT3.Activations.add(new Activation(t3, "y1r2r3", TransitionOperation.Move, "P_f2"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "op1"));
        grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "op2"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 1;
        pn.Transitions.add(t3);

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("r1g2r3");

        Condition T4Ct1 = new Condition(t4, "r1g2r3", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "r1g2r3", TransitionOperation.Move, "r1y2r3"));
        grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "op2"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 1;
        pn.Transitions.add(t4);

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("r1y2r3");

        Condition T5Ct1 = new Condition(t5, "r1y2r3", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "r1y2r3", TransitionOperation.Move, "r1r2g3"));
        grdT5.Activations.add(new Activation(t5, "r1y2r3", TransitionOperation.Move, "P_f3"));
        grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "op2"));
        grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "op3"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 1;
        pn.Transitions.add(t5);

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "t6";
        t6.InputPlaceName.add("r1r2g3");

        Condition T6Ct1 = new Condition(t6, "r1r2g3", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "r1r2g3", TransitionOperation.Move, "r1r2y3"));
        grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "op3"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 1;
        pn.Transitions.add(t6);

        // T6 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "t7";
        t7.InputPlaceName.add("r1r2y3");

        Condition T7Ct1 = new Condition(t7, "r1r2y3", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "r1r2y3", TransitionOperation.Move, "r1r2r3"));
        grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "op3"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 1;
        pn.Transitions.add(t7);

        // t_f1

        PetriTransition t_f1 = new PetriTransition(pn);
        t_f1.TransitionName = "t_f1";
        t_f1.InputPlaceName.add("in1");
        t_f1.InputPlaceName.add("P_f1");
        t_f1.IsAsync = true;

        Condition Tf1Ct1 = new Condition(t_f1, "in1", TransitionCondition.IsNull);
        Condition Tf1Ct2 = new Condition(t_f1, "P_f1", TransitionCondition.NotNull);
        Tf1Ct1.SetNextCondition(LogicConnector.AND, Tf1Ct2);
        Condition Tf1Ct3 = new Condition(t_f1, "in1", TransitionCondition.NotNull);
        Condition Tf1Ct4 = new Condition(t_f1, "P_f1", TransitionCondition.NotNull);
        Tf1Ct3.SetNextCondition(LogicConnector.AND, Tf1Ct4);

        GuardMapping grdTf1_1 = new GuardMapping();
        grdTf1_1.condition = Tf1Ct1;
        grdTf1_1.Activations.add(new Activation(t_f1, "Five", TransitionOperation.DynamicDelay, ""));
        t_f1.GuardMappingList.add(grdTf1_1);

        GuardMapping grdTf1_2 = new GuardMapping();
        grdTf1_2.condition = Tf1Ct3;
        grdTf1_2.Activations.add(new Activation(t_f1, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f1.GuardMappingList.add(grdTf1_2);

        t_f1.Delay = 5;
        pn.Transitions.add(t_f1);

        // t_f2

        PetriTransition t_f2 = new PetriTransition(pn);
        t_f2.TransitionName = "t_f2";
        t_f2.InputPlaceName.add("in2");
        t_f2.InputPlaceName.add("P_f2");
        t_f2.IsAsync = true;

        Condition Tf2Ct1 = new Condition(t_f2, "in2", TransitionCondition.IsNull);
        Condition Tf2Ct2 = new Condition(t_f2, "P_f2", TransitionCondition.NotNull);
        Tf2Ct1.SetNextCondition(LogicConnector.AND, Tf2Ct2);
        Condition Tf2Ct3 = new Condition(t_f2, "in2", TransitionCondition.NotNull);
        Condition Tf2Ct4 = new Condition(t_f2, "P_f2", TransitionCondition.NotNull);

        Tf2Ct3.SetNextCondition(LogicConnector.AND, Tf2Ct4);

        GuardMapping grdTf2_1 = new GuardMapping();
        grdTf2_1.condition = Tf2Ct1;
        grdTf2_1.Activations.add(new Activation(t_f2, "Five", TransitionOperation.DynamicDelay, ""));
        t_f1.GuardMappingList.add(grdTf2_1);

        GuardMapping grdTf2_2 = new GuardMapping();
        grdTf2_2.condition = Tf2Ct3;
        grdTf2_2.Activations.add(new Activation(t_f2, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f2.GuardMappingList.add(grdTf2_2);

        t_f2.Delay = 5;
        pn.Transitions.add(t_f2);

        // t_f3

        PetriTransition t_f3 = new PetriTransition(pn);
        t_f3.TransitionName = "t_f3";
        t_f3.InputPlaceName.add("in3");
        t_f3.InputPlaceName.add("P_f3");
        t_f3.IsAsync = true;

        Condition Tf3Ct1 = new Condition(t_f3, "in3", TransitionCondition.IsNull);
        Condition Tf3Ct2 = new Condition(t_f3, "P_f3", TransitionCondition.NotNull);
        Tf3Ct1.SetNextCondition(LogicConnector.AND, Tf3Ct2);
        Condition Tf3Ct3 = new Condition(t_f3, "in3", TransitionCondition.NotNull);
        Condition Tf3Ct4 = new Condition(t_f3, "P_f3", TransitionCondition.NotNull);

        Tf3Ct3.SetNextCondition(LogicConnector.AND, Tf3Ct4);

        GuardMapping grdTf3_1 = new GuardMapping();
        grdTf3_1.condition = Tf3Ct1;
        grdTf3_1.Activations.add(new Activation(t_f3, "Five", TransitionOperation.DynamicDelay, ""));
        t_f3.GuardMappingList.add(grdTf3_1);

        GuardMapping grdTf3_2 = new GuardMapping();
        grdTf3_2.condition = Tf3Ct3;
        grdTf3_2.Activations.add(new Activation(t_f3, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f3.GuardMappingList.add(grdTf3_2);

        t_f3.Delay = 5;
        pn.Transitions.add(t_f3);

        PetriNetWindow frame = new PetriNetWindow(true);
        frame.petriNet = pn;
        pn.Delay = 2000;
        frame.setVisible(true);

    }

}
