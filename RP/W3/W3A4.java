package RP.W3;

import java.util.Scanner;

public class W3A4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i<10; i++){
            System.out.println("Geben Sie eine Zahl zwischen 1 und 10 ein");
            int input = scanner.nextInt();
            

            String ausgabe = switch(input) {

                case 1: yield("ungerade");
                case 2: yield("gerade");
                case 3: yield("ungerade");
                case 4: yield("gerade");
                case 5: yield("ungerade");
                case 6: yield("gerade");
                case 7: yield("ungerade");
                case 8: yield("gerade");
                case 9: yield("ungerade");
                case 10: yield("gerade");
                default: yield("flascher Input");
            };

            String ausgabe2 = ""; 
            switch (input) {

                case 1:
                    ausgabe2 = "ungerade";
                    break;
                case 2:
                    ausgabe2 = "gerade";
                    break;
                case 3:
                    ausgabe2 = "ungerade";
                    break;
                case 4:
                    ausgabe2 = "gerade";
                    break;
                case 5:
                    ausgabe2 = "ungerade";
                    break;
                case 6:
                    ausgabe2 = "gerade";
                    break;
                case 7:
                    ausgabe2 = "ungerade";
                    break;
                case 8:
                    ausgabe2 = "gerade";
                    break;
                case 9:
                    ausgabe2 = "ungerade";
                    break;
                case 10:
                    ausgabe2 = "gerade";
                    break;
                default:
                    ausgabe2 = "falscher Input";
            };
            System.out.println(ausgabe2);
            

            switch(input){

                case 1 -> System.out.println("ungerade");
                case 2 -> System.out.println("gerade");
                case 3 -> System.out.println("ungerade");
                case 4 -> System.out.println("gerade");
                case 5 -> System.out.println("ungerade");
                case 6 -> System.out.println("gerade");
                case 7 -> System.out.println("ungerade");
                case 8 -> System.out.println("gerade");
                case 9 -> System.out.println("ungerade");
                case 10 -> System.out.println("gerade");
                default -> System.out.println("flascher InputA");

            };
        
            System.out.println(ausgabe);
            
            if (input%2 == 1){
                System.out.println("ungerade");
            }else{
                System.out.println("gerade");
            }
        }
        scanner.close();
    }
}
