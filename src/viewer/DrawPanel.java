package viewer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    public class strPointPair<String, Point> { //TODO Is this really a tuple?
        public final String x;
        public Point y;

        public strPointPair(String x, Point y) {
            this.x = x;
            this.y = y;
        }

        public Point getY() {
            return this.y;
        }
    }

    // Just a single image, TODO: Generalize - Big comment: Hur fan generaliserar vi något n'r vi måste ha deras exakta path vilket vi inte vet något om i koden, wtf???? .-.
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    // To keep track of a single cars position
    //Point volvoPoint = new Point();
    //List<Point> pointList = new ArrayList<>();
    HashMap<Integer, strPointPair> modelnameIndexMap = new HashMap<>();

    VehicleView view;

    // TODO: Make this general for all cars
    void moveit(int x, int y, String name, int i) {
        modelnameIndexMap.put(i, new strPointPair<String, Point>(name, new Point(x, y)));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, VehicleView view) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.GREEN);
        this.view = view;

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintAllCars(g);
        //g.drawImage(ImageIO.read(new File("src\\pics\\" + modelnameIndexMap.get(i), modelnameIndexMap.get(), (int) modelnameIndexMap.get(0).getX(), null); // see javadoc for more info on the parameters //TODO Lösning på hårdkodning är typ ge hashmappen en Integer som key, men tuple
        //TODO med (Point, String) (där strängen är vilken sorts bil det är)
        //g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
    }

    private void paintAllCars(Graphics g) {
        int mVehiclesize = view.getvModel().getmVehicles().size();
        for (int i = 0; i < mVehiclesize; i++) {
            //System.out.println("E: " + i);
            String filePath = getFilepath(i);
            int x = getXPos(i);
            int y = getYPos(i);
            paintVehicle(g, filePath, x , y);
    }

    }
    private int getXPos(int i) {
        return (int) view.getvModel().getmVehicles().get(i).getPosition().getX();
    }

    private int getYPos(int i) {
        return (int) view.getvModel().getmVehicles().get(i).getPosition().getY();
    }

    private String getFilepath(int i) {
        String modelName = view.getvModel().getmVehicles().get(i).getModelName();
        String filePath = "src\\pics\\" + modelName + ".jpg";
        return filePath;
    }

    private void paintVehicle(Graphics g, String filePath, int x, int y) {
        try {
            g.drawImage(ImageIO.read(new File((filePath))), x, y, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}