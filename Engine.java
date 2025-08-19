import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Engine {
  static double temp, engineTemp;
  static float fuelLevel, rpm, idleRpm;
  static boolean igitionStatus, engineRunning;
  static double throttlePostion, oilPressure;
  static Long engStart, engStop, engTime, milSecs;

  public static Scanner input = new Scanner(System.in);

  public static void engine() {
    igitionStatus = true; 
    double maxThrottle = 100, maxFuel = 100, maxEngTemp = 248, maxOilPress = 80;
    double minThrottle = 0, minFuel = 0, minEngTemp = 65, minOilPress = 25;
    float minRPM = 600, maxRPM = 8000;

    NavigableMap<Double, String> weatherCond = new TreeMap<>();
    weatherCond.put(-30.0, "Freezing");
    weatherCond.put(25.0, "Cold");
    weatherCond.put(55.0, "Cool");
    weatherCond.put(70.0, "Warm"); 
    weatherCond.put(80.0, "Hot");
    weatherCond.put(120.0, "Hotest");

      // Get User Input on Weather Condoitions
      do {
        System.out.println("Enter Outside Temperature (°F): ");
        temp = input.nextDouble(); 
      
        if (temp < -30 || temp > 120) {
          System.out.print("[Temperature Is Out of Range] ");
          }
      } while (temp < -30 || temp > 120);

    Map.Entry<Double, String> userEntry = weatherCond.floorEntry(temp);
    System.out.println("Weather Condition: " + temp + "°F [" + userEntry.getValue() + "]");
    
    // Get Engine Temp 
    double minTemp = -30.0; 
    double maxTemp = 120.0; 
    double tempRange = ((temp - minTemp) / (maxTemp - minTemp)); 

    engineTemp = (tempRange * (maxEngTemp - minEngTemp)) + minEngTemp;

    // Get Engine Oil Pressure 
    oilPressure = (tempRange * (maxOilPress - minOilPress)) + minOilPress;
    
    // Get starting RPM 
    rpm = (float) (tempRange * (maxRPM - minRPM)) + minRPM;

    // Get starting throttle 
    throttlePostion = (tempRange * (maxThrottle - minThrottle)) + minThrottle; 

    // Get Fuel Level
      do {
        System.out.println("Enter Fuel Levels: ");
        fuelLevel = input.nextFloat(); 

        if (minFuel > fuelLevel || fuelLevel > maxFuel) {
          System.out.print("[Fuel Is Out of Range] ");
          }
      } while (minFuel > fuelLevel || fuelLevel > maxFuel);

    if (igitionStatus) {
      start();
    }
  } 

  public static void start() {
    long minStart = 1000, maxStart = 2500;
    engineRunning = true;

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

    engStart = System.nanoTime();   
    
    engTime = System.nanoTime();
    long timeElapsed = engTime - engStart;
    milSecs = TimeUnit.NANOSECONDS.toMillis(timeElapsed);

    rev();
  }

  public static void rev() {
    System.out.println("Engine Specs Before Rev");
    System.out.println("Fuel Levels: " + fuelLevel);
    System.out.println("RPM: " + rpm);
    System.out.println("Engine Temp: " + engineTemp);
    System.out.println("Oil Pressure: " + oilPressure);
    System.out.println("Throttle: " + throttlePostion);
  }

  public static void consumeFuel() {

  }

  public static void stop() {
    engineRunning = false;
    igitionStatus = false;
    System.out.println("   Final Test Specs   ");
    System.out.println("----------------------");
    System.out.print("/r Engine Time: " + milSecs);
    System.out.println("Fuel Levels: " + fuelLevel);
    System.out.println("Engine Temp: " + engineTemp);
    System.out.println("Oil Pressure: " + oilPressure);
  }
}
