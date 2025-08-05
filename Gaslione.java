import java.util.Scanner;

public class Gaslione {
  static String car = "2025 Ford Mustang Dark Horse";
  static int temp;
  static float fuelLevel, rpm;
  static boolean igitionStatus; 
  static double throttlePostion, oilPressure;

  public static void start() {
    System.out.println("Engine starting...");
    
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("Engine failed to start");
      Thread.currentThread().interrupt();
    }
    igitionStatus = true; 
    while (igitionStatus) {
      
    }
  }

  public static void stop() {
  
  }

  public static void rev() {

  }

  public static void idle() {

  }

  public static void consumeFuel() {

  }

public static void main(String args[]) {
  Scanner input = new Scanner(System.in);
  
  System.out.println("----------------------------");
  System.out.println(car);
  System.out.println("----------------------------");
  System.out.println("500 HP at ~7,250 RPM | 5.0L Gen-4 Coyote V8");
  try {
    Thread.sleep(2000);
  } catch (InterruptedException e) {
    System.out.println("Engine failed to start");
    Thread.currentThread().interrupt();
  }
  System.out.println("----------------------------");
  System.out.println("Press [Enter] To Start Engine: ");
String kbInput = input.nextLine(); 



  start();
idle(); 
  }  
}
