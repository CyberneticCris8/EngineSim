import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
  Scanner input = new Scanner(System.in); 

  try {
      System.out.println("----------------------------");
      Thread.sleep(1000);
      Engine.engine();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    Engine.start();

  input.close();
  }
}