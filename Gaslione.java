import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Gaslione {
  static String car = "2025 Ford Mustang Dark Horse";
  static int temp; 
  static float fuelLevel, rpm;
  static boolean igitionStatus; 
  static double throttlePostion, oilPressure;

public static Scanner input = new Scanner(System.in);

public synchronized static void engineCond() {
  NavigableMap <Integer, String> weatherCond = new TreeMap<>(); 
  weatherCond.put(-30, "Cold");
  weatherCond.put(55, "Cool");
  weatherCond.put(80, "Warm");
  weatherCond.put(120, "Hot");
  Map.Entry<Integer, String> userEntry = weatherCond.floorEntry(temp); 

    try {
  System.out.println("--------------------");
  System.out.println("Enter Oustide Tempture (°F): ");
  temp = input.nextInt(); 
    
    if (userEntry != null) {
      System.out.println("The Weather Conditions Are: " + temp + " " + "[" + userEntry.getValue() + "]");
        } else { 
          System.out.println("Tempture is Out of Range.");
        }
    
  System.out.println("Enter Fuel Level: ");
  fuelLevel = input.nextFloat(); 
  Thread.sleep(1000);

  System.out.println("------------------");
  Thread.sleep(500);

  System.out.println("Enter Oil Pressure: ");
  oilPressure = input.nextDouble(); 
  Thread.sleep(1000);

  System.out.println("Starting Fuel Level: " + fuelLevel);
  System.out.println("Starting Oil Pressure: " + oilPressure);

  } catch (InterruptedException e) {
  Thread.currentThread().interrupt();
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
}

public static void stop() {
  
}

public static void rev() {

}

public static void idle() {
while (igitionStatus) {

}
}

public static void consumeFuel() {

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
