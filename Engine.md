Engine Program Notes 
--------------------
- Engine Issues
  - Overheating
  - Low Oil Pressure
  - Out of Fuel
  - Stalling at low RPM

- Gaslione Pseudocode
------------------
RPM, Fuel Level, Temp, Oil Pressure, Igition Status, Throttle Postion 

start
 - engine start (between 1000ms - 2000ms)
 - igition is on
 - assign RPM, temp, oil pressure, throttle postion 
 - display engine levels
 - verfiy engine levels are okay
 - call idle() 
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
 - input starting fuel level, oil pressure
 - start engine 
   