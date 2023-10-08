/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ei;

import java.util.Scanner;

/**
 *
 * @author keerthana
 */
public class Rocket {
    
    
    private String stage;
    private int fuel;
    private int altitude;
    private int speed;

    public Rocket() {
        stage = "Pre-Launch";
        fuel = 100;
        altitude = 0;
        speed = 0;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String launchSequence() {
        if (stage.equals("Pre-Launch")) {
            stage = "Launch";
            System.out.println("Mission launched!");
            try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

        while (altitude < 200 && fuel > 0) {
            altitude += speed;
            fuel -= 10;
            speed += 100;

            System.out.println("Stage: " + stage + ", Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: " + speed + " km/h");
try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (altitude >= 100 && stage.equals("Launch")) {
                stage = "Stage 2";
                System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
            }
            try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

        if (altitude >= 200) {
            System.out.println("Orbit achieved! Mission Successful.");
        } else {
            System.out.println("Mission Failed due to insufficient fuel.");
        }

        return stage;
    }

    public static void main(String[] args) {
        Rocket rocket = new Rocket();
        rocket.launchSequence();
    }
}
