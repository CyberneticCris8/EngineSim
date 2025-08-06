import java.time.Instant;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Gaslione {
  static String car = "2025 Ford Mustang Dark Horse";
  static double temp; 
  static float fuelLevel, rpm;
  static boolean igitionStatus; 
  static double throttlePostion, oilPressure;

  static Long engStart, engStop, engTime; 

public static Scanner input = new Scanner(System.in);

public synchronized static void engineCond() {
  NavigableMap <Integer, String> weatherCond = new TreeMap<>(); 
  weatherCond.put(-30, "Cold");
  weatherCond.put(55, "Cool");
  weatherCond.put(80, "Warm");
  weatherCond.put(120, "Hot");
  Map.Entry<Integer, String> userEntry = weatherCond.floorEntry((int)temp); 

    try {
  System.out.println("--------------------");
  System.out.println("Enter Oustide Tempture (°F): ");
  temp = input.nextInt(); 
  
 do {
    if (userEntry != null) {
      System.out.println("The Weather Conditions Will Be: " + temp + " " + "[" + userEntry.getValue() + "]");
        } else { 
          System.out.println("Tempture is Out of Range.");
    }
  } while (temp != 0); 

  do {
    throttlePostion = (double) (Math.random() * (6 - 4 + 1) + 4);
    Map.Entry<Integer, String> throttleEntry = weatherCond.floorEntry((int)throttlePostion); 
      if (throttleEntry != null) {
        System.out.println("Engine's Throttle Is: " + throttlePostion + "% [Based on " + userEntry.getValue() + " weather]");
} else {
  System.out.println("Throttle Failure");
} 
while (throttlePostion != 0);
    
  System.out.println("Enter Fuel Level: ");
  fuelLevel = input.nextFloat(); 
  do {
    if ((fuelLevel > 100) || (fuelLevel <= 0)) {
      System.out.println("Please Enter Appropriate Fuel Level (0.0 - 100.0): ");
    }
  }  while (fuelLevel != 0); 

  Thread.sleep(1000);
  System.out.println("------------------");
  Thread.sleep(500);

  do {
      System.out.println("Enter Oil Pressure (17 PSI - 28 PSI): ");
      oilPressure = input.nextDouble(); 
      if (!(oilPressure < 17) || !(oilPressure > 28)) {
        System.out.println("Please enter a valid oil pressure.");
    }
  } while (oilPressure < 17 || oilPressure > 28);

  Thread.sleep(1000);

  System.out.println("Starting Fuel Level: " + fuelLevel + " %");
  System.out.println("Starting Oil Pressure: " + oilPressure + " PSI");

   catch (InterruptedException e) {
  Thread.currentThread().interrupt();
      }
    }
  }
}

public static void start() {
  igitionStatus = true; 
  rpm = 800; 
  long maxStart = 1000;
  long minStart = 2000; 

  System.out.println("Engine Starting...");

  long randomStart = (long) (Math.random() * (maxStart - minStart + 1) + minStart);

  try {
    Thread.sleep(randomStart);
  } catch (InterruptedException e) {
    System.out.println("Engine Failed to Start.. Reigniting...");
    Thread.currentThread().interrupt();
    }

  double startTime = (double) randomStart / 1000; 
  System.out.println("Engine start time: " + startTime);

  
do {
  idle();
  } while (igitionStatus);
}

public static void idle() {
  engStart = System.nanoTime();
  while (igitionStatus) {
    engTime = System.nanoTime(); 
    long timeElapsed = engTime - engStart; 
    System.out.println("\rEngine running: " + timeElapsed + " ms");
  } 



}

public static void rev() {

}

public static void consumeFuel() {

}

public static void stop() {
  
}

public static void main(String args[]) {
  try {
    System.out.println("----------------------------");
    Thread.sleep(500);

    System.out.println(car);
    Thread.sleep(1000);

    System.out.println("----------------------------");
    Thread.sleep(500);

    System.out.println("500 HP at ~7,250 RPM | 5.0L Gen-4 Coyote V8");
    Thread.sleep(1000);

    System.out.println("----------------------------");
    Thread.sleep(500);

   engineCond(); 

  } catch (InterruptedException e) {
    Thread.currentThread().interrupt();
  }

  System.out.println("Press [Enter] to Start Engine: ");
  String kbInput = input.nextLine(); 
  
  if (!kbInput.isEmpty()) {
    start();
  }
  input.close();
  }  
}
