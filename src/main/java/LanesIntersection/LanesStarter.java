package LanesIntersection;

import Controllers.Drubeta.*;
import Controllers.Macedonski.*;
import Controllers.Rebreanu.*;
import Controllers.Ulpia.*;
import Controllers.Vuia.*;

public class LanesStarter {

    public static void main(String[] args) {

        // create and start intersection
        MainModel.start();

        // create and start controllers
        ControllerRebreanu.start();
        ControllerMacedonski.start();
        ControllerVuia1.start();
        ControllerVuia2.start();
        ControllerUlpia.start();
        ControllerDrubeta.start();

    }

}
