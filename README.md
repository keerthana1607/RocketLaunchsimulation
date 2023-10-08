# RocketLaunchsimulation
# MissionControl
-The main function initializes a Rocket object and a Scanner for user input.
- It prompts the user for input to initiate pre-launch checks.
- It checks if the user inputs "start_checks" to initiate system checks.
- Simulates a 2-second delay to mimic system checks.
- Displays initial rocket status (stage, fuel, altitude, speed).
- It prompts the user to input "launch" to begin the mission.
- Simulates a 1-second delay before calling the `launchSequence` method of the Rocket class.
- The code enters an infinite loop to simulate the mission.
- It prompts the user to fast forward the simulation by a specified number of seconds.
- The simulation updates the rocket's altitude, fuel, and speed based on the user input.
- Checks for insufficient fuel and aborts the mission if fuel falls below 10%.
- It checks if the rocket's altitude is above 100 and it's in "Stage 1" to initiate stage separation and switch to "Stage 2".
- The code displays real-time updates of the rocket's stage, fuel, altitude, and speed.
- It includes a 2-second sleep between updates to simulate real-time progression.
- It validates user input to ensure it matches expected commands ("start_checks," "launch," "fast_forward X").
# Rocket 
Fields are
   - stage: Represents the current stage of the rocket.
   - fuel: Represents the amount of fuel remaining in the rocket.
   - altitude: Represents the rocket's current altitude.
   - speed: Represents the rocket's current speed.
- Constructor initializes the rocket with a "Pre-Launch" stage, 100% fuel, 0 altitude, and 0 speed.
- Provides getter and setter methods for each of the fields to access and modify their values.
- Initiates the rocket launch sequence.
   - If the rocket is in the "Pre-Launch" stage, it switches to the "Launch" stage and prints a message indicating the launch.
   - It then enters a loop, simulating the rocket's ascent.
   - In each iteration, it updates the altitude, fuel, and speed of the rocket and prints real-time status.
   - Checks for stage separation when the altitude reaches 100 km and updates the stage to "Stage 2."
   - Determines whether the mission was successful (altitude >= 200) or failed (insufficient fuel).
  

