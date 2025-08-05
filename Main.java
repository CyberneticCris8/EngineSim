import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
  Scanner input = new Scanner(System.in); 

  int choice = 0; 
  System.out.println("Car Engine Simulator");
  System.out.println("2025");
  System.out.println("--------------------");

  System.out.println("1. Gaslione: 2025 Ford Mustang Dark Horse");
    System.out.println("2. Diesel: 2025 Ford F-250 Super Duty");
    System.out.println("3. Electric: 2025 Ford Supervan 4 2.5");
    System.out.println("Please choice a car to simulate: ");
   
    while (choice >= 0 && choice <= 4) {
        choice = input.nextInt();
      if (choice < 0 || choice > 4) {
        System.out.println("Please enter a correct number: ");
      }
    }
  input.close();
  }
}