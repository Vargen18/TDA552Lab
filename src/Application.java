import com.company.*;
import controllers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    // The delay (ms) corresponds to 59 updates a sec (hz)
    private final int delay = 17;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    private VehicleModel vModel = new VehicleModel();

    //Creating a VehicleController
    private static VehicleController vc; //TODO How to make controller not static in this scenario?
    // The frame that represents this instance View of the MVC pattern
    private static VehicleView frame; //TODO: SHOULD NOT BE LIKE THIS MAN AND NOT STATIC.

    public static void main(String[] args) {
        // Instance of this class
        Application application = new Application();
        //Creating a VehicleView
        VehicleModel vModel = new VehicleModel();
        vc = new VehicleController(vModel);
        frame = new VehicleView("CarSim 1.0", vc, vModel);


        //cc.addVehicle(new Volvo240(0, 0, CardinalDirections.cardinalDirection.NORTH));
        //cc.addVehicle(new Saab95(100, 0, CardinalDirections.cardinalDirection.NORTH));
        //cc.addVehicle(new Scania(200, 0, cardinalDirection.NORTH));

        vc.createAndAddVolvo(0, 0, CardinalDirections.cardinalDirection.NORTH);
        vc.createAndAddSaab(100, 0, CardinalDirections.cardinalDirection.NORTH);
        vc.createAndAddScania(200, 0, CardinalDirections.cardinalDirection.NORTH);

        // Start the timer
        application.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vc.moveAllVehicles();
            frame.repaint();

        }
    }
}