Engine Program Notes 
--------------------
- Engine Issues / Different Conditions
  - Overheating
  - Low Oil Pressure
  - Out of Fuel
  - Stalling at low RPM
  - Weather conditions 

Gaslione Pseudocode
------------------
RPM, Fuel Level, Temp, Oil Pressure, Igition Status, Throttle Postion 

engineCond
 - Assign weather condition 
 - assign engine levels i.e. (fuelLevel, Oil Pressure)
 - sysout fuelLevel, oil pressure 

start
 - engine start (between 1000ms - 2000ms)
 - igition is on
 - assign RPM, temp, throttle postion 
 - display engine levels
 - verfiy engine levels are okay

stop 
 - engine end
 - reset RPM, temp, oil pressure, throttle
 - display end sim levels
 - verify no levels are low at end of sim

rev
 - user input throttle
 - calcuate changes to rpm, temp, oil pressure
 - display levels after rev

idle 
 - track time car is in idle
 - option to be able to check levels anytime in idle
   
consumeFuel
 - miles
 - user input amount of miles and how fast 
 - adjust/calucate rpm temp, oil pressure, throttle
 - display results of engine drive

main
 - display car/specs 
 - engineCond() 
 - start engine 


   