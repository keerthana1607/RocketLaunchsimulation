package ei;
import java.util.Scanner;

public class MissionControl {
    
    public static void main(String[] args) {
        Rocket rocket = new Rocket();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Pre-launch checks
        System.out.println("Pre-Launch Checks: \"All systems are 'Go' for launch.\"");
        System.out.print("Type start_checks to initiate system checks: ");
        userInput = scanner.nextLine();
        if (userInput.equals("start_checks")) {
            System.out.println("System checks initiated...");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds to simulate system checks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Display initial rocket status again
            System.out.println("Rocket - Stage: " + rocket.getStage() + ", Fuel: " + rocket.getFuel() + "%, Altitude: " + rocket.getAltitude() + " km, Speed: " + rocket.getSpeed() + " km/h");

            System.out.println("System checks complete.");
        } else {
            System.out.println("Invalid input. Aborting mission.");
            return;
        }

        // Launch
        System.out.print("Type launch to begin the mission: ");
        userInput = scanner.nextLine();
        if (userInput.equals("launch")) {
            System.out.println("Launching");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                
            }
            rocket.launchSequence();
        } else {
            System.out.println("Invalid input. Aborting mission.");
            return;
        }

        // Simulate the mission and display real-time updates
        while (true) {
            System.out.print("Type fast_forward X to advance the simulation by X seconds: ");
            userInput = scanner.nextLine();

            if (userInput.startsWith("fast_forward")) {
                String[] inputParts = userInput.split(" ");
                int seconds = Integer.parseInt(inputParts[1]);

                // Simulate the mission for the specified number of seconds
                for (int i = 0; i < seconds; i++) {
                    if (rocket.getFuel() < 10) {
                        System.out.println("Mission Failed due to insufficient fuel.");
                        return;
                    }

                    rocket.setAltitude(rocket.getAltitude() + rocket.getSpeed());
                    rocket.setFuel(rocket.getFuel() - 10);
                    rocket.setSpeed(rocket.getSpeed() + 100);

                    // Display real-time updates
                    System.out.println("Rocket - Stage: " + rocket.getStage() + ", Fuel: " + rocket.getFuel() + "%, Altitude: " + rocket.getAltitude() + " km, Speed: " + rocket.getSpeed() + " km/h");

                    // Check for stage separation
                    if (rocket.getAltitude() >= 100 && rocket.getStage().equals("Stage 1")) {
                        rocket.setStage("Stage 2");
                        System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
                    }

                    System.out.println();
                    try {
                        Thread.sleep(2000); // Sleep for 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Display real-time update
                System.out.println("Rocket - Stage: " + rocket.getStage() + ", Fuel: " + rocket.getFuel() + "%, Altitude: " + rocket.getAltitude() + " km, Speed: " + rocket.getSpeed() + " km/h");
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
