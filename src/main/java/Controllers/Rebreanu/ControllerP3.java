package Controllers.Rebreanu;

import Components.*;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class ControllerP3 {

    public static void start() {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "ControllerP1";
        pn.NetworkPort = 1094;

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

        DataString Userreq = new DataString();
        Userreq.SetName("Userreq");
        pn.PlaceList.add(Userreq);

        DataString yr = new DataString();
        yr.SetName("yr");
        pn.PlaceList.add(yr);

        DataString rg = new DataString();
        rg.SetName("rg");
        pn.PlaceList.add(rg);

        DataString ry = new DataString();
        ry.SetName("ry");
        pn.PlaceList.add(ry);

        DataString gr = new DataString();
        gr.SetName("gr");
        gr.SetValue("1");
        pn.PlaceList.add(gr);

        DataString wait = new DataString();
        wait.SetName("wait");
        pn.PlaceList.add(wait);

        DataString P_ini = new DataString();
        P_ini.SetName("P_ini");
        P_ini.SetValue("1");
        pn.PlaceList.add(P_ini);

        DataTransfer P_TL = new DataTransfer();
        P_TL.SetName("P_TL");
        P_TL.Value = new TransferOperation("localhost", "1080", "iRbr_CPTL3");
        pn.PlaceList.add(P_TL);

        DataTransfer P_PTL = new DataTransfer();
        P_PTL.SetName("P_PTL");
        P_PTL.Value = new TransferOperation("localhost", "1080", "iRbr_PPTL3");
        pn.PlaceList.add(P_PTL);

        // iniT ------------------------------------------------
        PetriTransition iniT = new PetriTransition(pn);
        iniT.TransitionName = "iniT";
        iniT.InputPlaceName.add("P_ini");

        Condition TiniCt1 = new Condition(iniT, "P_ini", TransitionCondition.NotNull);

        GuardMapping grdTini = new GuardMapping();
        grdTini.condition = TiniCt1;
        grdTini.Activations.add(new Activation(iniT, "green", TransitionOperation.SendOverNetwork, "P_TL"));
        grdTini.Activations.add(new Activation(iniT, "red", TransitionOperation.SendOverNetwork, "P_PTL"));
        iniT.GuardMappingList.add(grdTini);

        iniT.Delay = 0;
        pn.Transitions.add(iniT);

        // t1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("Userreq");
        t1.InputPlaceName.add("wait");

        Condition T1Ct1 = new Condition(t1, "Userreq", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "wait", TransitionCondition.NotNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "wait", TransitionOperation.Move, "yr"));
        grdT1.Activations.add(new Activation(t1, "yellow", TransitionOperation.SendOverNetwork, "P_TL"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // t2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("yr");

        Condition T2Ct1 = new Condition(t2, "yr", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "yr", TransitionOperation.Move, "rg"));
        grdT2.Activations.add(new Activation(t2, "red", TransitionOperation.SendOverNetwork, "P_TL"));
        grdT2.Activations.add(new Activation(t2, "green", TransitionOperation.SendOverNetwork, "P_PTL"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 5;
        pn.Transitions.add(t2);

        // t3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("rg");

        Condition T3Ct1 = new Condition(t3, "rg", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "rg", TransitionOperation.Move, "ry"));
        grdT3.Activations.add(new Activation(t3, "yellow", TransitionOperation.SendOverNetwork, "P_PTL"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);

        // t4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("ry");

        Condition T4Ct1 = new Condition(t4, "ry", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "ry", TransitionOperation.Move, "gr"));
        grdT4.Activations.add(new Activation(t4, "red", TransitionOperation.SendOverNetwork, "P_PTL"));
        grdT4.Activations.add(new Activation(t4, "green", TransitionOperation.SendOverNetwork, "P_TL"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 2;
        pn.Transitions.add(t4);

        // t5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("gr");

        Condition T5Ct1 = new Condition(t5, "gr", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "gr", TransitionOperation.Move, "wait"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 5;
        pn.Transitions.add(t5);

        PetriNetWindow frame = new PetriNetWindow(true);
        frame.petriNet = pn;
        pn.Delay = 2000;
        frame.setVisible(true);
    }

}

