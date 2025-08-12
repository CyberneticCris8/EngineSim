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
  static Long engStart, engStop, engTime;

  public static Scanner input = new Scanner(System.in);

  public synchronized static void engine() {
    igitionStatus = true; 
    double maxThrottle = 100, maxFuel = 100, maxEngTemp = 248, maxOilPress = 80;
    double minThrottle = 0, minFuel = 0, minEngTemp = 65, minOilPress = 25;
    float minRPM = 600, maxRPM = 8000;

    NavigableMap<Double, String> weatherCond = new TreeMap<>();
    weatherCond.put(-30.0, "Cold");
    weatherCond.put(55.0, "Cool");
    weatherCond.put(80.0, "Warm");
    weatherCond.put(120.0, "Hot");

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

    if (engineRunning) {
      idle();
    }
  }

  public static void idle() {
    engStart = System.nanoTime();

    while (engineRunning) {
      engTime = System.nanoTime();
      long timeElapsed = engTime - engStart;
      long milSecs = TimeUnit.NANOSECONDS.toMillis(timeElapsed);
      System.out.print("\rEngine running: " + milSecs + " ms");
    }
      int userInput; 
      do {
      System.out.println("---------------------");
      System.out.println("1. View Current Sepcs");
      System.out.println("2. Rev Engine");
      System.out.println("3. Run Engine");
      System.out.println("4. Stop Engine");
      userInput = input.nextInt(); 
        if (0 > userInput || userInput > 4) {
          System.out.print("[Enter Correct Value] ");
        }
      } while (0 > userInput || userInput > 3); 

      switch (userInput) {
        case 1:
        System.out.println("Weather Condition : " + temp + "°F");
        System.out.println("Engine Temp : " + engineTemp + "°F");
        System.out.println("RPM : " + rpm + "°F");
        System.out.println("Oil Pressure: " + oilPressure);
        System.out.println("Fuel Levels: " + fuelLevel);
        break;

        case 2: 
        rev();
          break; 

        case 3: 
        consumeFuel(); 
          break; 

        case 4: 
        stop();
          break; 

        default:
          break;
      }
  }

  public static void rev() {
  }

  public static void consumeFuel() {
  }

  public static void stop() {
    engineRunning = false;
    igitionStatus = false;

    if (!engineRunning && igitionStatus) {
      System.out.println("Ending Car Engine Specs: [Fuel Levels: " + fuelLevel + " ] [Engine Temp: " + engineTemp + " ] [Oil Pressure: " + oilPressure + " ]");
    } else {
      System.out.println("Engine is still running.");
    }
  }

  public static void main(String args[]) {
    try {
      System.out.println("----------------------------");
      Thread.sleep(1000);
      engine();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    input.nextLine();
    System.out.println("Press [Enter] to Start Engine: ");
    String kbInput = input.nextLine();

    if (!kbInput.isEmpty()) {
      start();
    }
    input.close();
  }
}
