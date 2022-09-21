import java.util.Scanner;

public class UI {

    Scanner scanner =new Scanner(System.in);

    public int getScanInt(String errorMessage){
        while(!scanner.hasNextInt()){
            System.out.println(errorMessage);
            scanner.next();
        }
        int readInt = scanner.nextInt();
        scanner.nextLine();
        return readInt;
    }
    public int getScanInt(){
        return this.getScanInt("Indtastet ikke tilladt, skal indtastes et tal: ");
    }
    public String getScanString(){
      return scanner.nextLine();
    }

}
