import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String hall;

        String seat;

        // length of arr
        int oderHall ;

        // moive name
        String moiveName;

        String[][] cinema;

        System.out.println("===Set Up Hall In Cinema=====");

        while (true){
            System.out.print("Enter number of Hall in Cinema: ");

            String hallNumbers = sc.nextLine();

            hall = hallNumbers;
            boolean validHallNumbers = hallNumbers.matches("[1-9]");

            if (validHallNumbers){
                break;
            }else{
                System.out.println(ANSI_RED + "Number of hall is allowed only number and more than 0!" + ANSI_RESET);
            }
        }



        while (true){
            System.out.print("Enter number of seat in each Hall:");
            String amountSeats = sc.nextLine();
            boolean validSeats = amountSeats.matches("5[0-9]|[6-9][0-9]|\\d{3,}/gm");
            seat = amountSeats;
            if (validSeats){
                cinema = new String[Integer.parseInt(hall)][Integer.parseInt(seat)];
                break;
            }else {
                System.out.println(ANSI_RED + "Number of seat is allowed only number and 50 seats up" + ANSI_RESET);
            }
        }
        System.out.println("===================================================================");
        System.out.println(ANSI_GREEN + "\t\t\t\t\tCinema Management System" + ANSI_RESET);
        System.out.println("===================================================================");

        System.out.println(ANSI_BLUE + "1, Insert Movie" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "2, Check & Booking Movie" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "3, Check Ticket" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "4, Reset Hall"  + ANSI_RESET);
        System.out.println(ANSI_BLUE + "5, Set row to show record"  + ANSI_RESET);
        System.out.println(ANSI_BLUE + "6, Exit" + ANSI_RESET);

        System.out.println("---------------------------------------------------------");
        System.out.println();
        outter:
        while (true){
            System.out.print("Please input your choice (1-6): ");
            String option = sc.nextLine();
            boolean validOption = option.matches("[1-6]");
            if (validOption){
                switch (option){
                    case "1":{
                        System.out.println("===================================================================");
                        System.out.println(ANSI_GREEN + "\t\t\t\t\tINSERT INFORMATION OF MOIVE" + ANSI_RESET);
                        System.out.println("===================================================================");

                        // loop for cinema of each hall

                       for(int i = 0; i < cinema.length ; i++){
                           // condition of each hall
                           oderHall = i + 1;
                           while (true){
                               System.out.print("Enter Movie Name : ");
                               moiveName = sc.nextLine();

                               boolean moiveNameValid = moiveName.matches("[a-zA-Z0-9{5} ]+");

                               if (moiveNameValid){
                                   break;
                               }else{
                                   System.out.println(ANSI_RED + "Movie name is allowed to insert only text" + ANSI_RESET);
                               }
                           }

                           while (true){
                               System.out.print("Enter Movie Type: ");
                               String movieType = sc.nextLine();
                               boolean validMovieType = movieType.matches("[a-zA-Z ]+");
                               if (validMovieType){
                                   break;
                               }else {
                                   System.out.println(ANSI_RED + "Movie Type is allowed to insert only text!" + ANSI_RESET);
                               }
                           }


                           while (true){
                               System.out.print("Enter Duration (min) : ");
                               String duration = sc.nextLine();
                               boolean validDuration = duration.matches("6[0-9]|1[0-9]{2}");
                               if (validDuration){

                                   System.out.println("Movie " + ANSI_BLUE + moiveName + ANSI_RESET + " will show in hall #"+ oderHall);
                                   break ;
                               }else {
                                   System.out.println(ANSI_RED + "Duration is allowed to input only number and duration between 60 min - 180min!" + ANSI_RESET);
                               }
                           }
                           outterDoYouWantToExit:
                           while (true){
                               System.out.print("Do you want to continue? (Y/N): ");
                               String yOrn = sc.nextLine();
                               boolean validyOrn = yOrn.matches("[Y|N]$|[y|n]$");
                               if (validyOrn){
                                   if (yOrn.equals("Y") || yOrn.equals("y") ){
                                      if (oderHall < cinema.length){
                                          break;
                                      }else{
                                          System.out.println(ANSI_RED + "Unavailable hall to show" + ANSI_RESET);


                                          while (true){
                                              System.out.print("Press any key to continue!");
                                              sc.nextLine(); // Wait for user to press Enter
                                              break outterDoYouWantToExit; // Exit after the key press
                                          }

//                                          String keyPress = sc.nextLine();
//                                          boolean vlaidKeyPress = keyPress.matches("[\\w]");
//                                          if (vlaidKeyPress){
//                                              sc.nextLine();
//                                          }
                                      }
                                   }

                               }
                           }

                           System.out.println("===================================================================");
                           System.out.println(ANSI_GREEN + "\t\t\t\t\tCinema Management System" + ANSI_RESET);
                           System.out.println("===================================================================");

                           System.out.println(ANSI_BLUE + "1, Insert Movie" + ANSI_RESET);
                           System.out.println(ANSI_BLUE + "2, Check & Booking Movie" + ANSI_RESET);
                           System.out.println(ANSI_BLUE + "3, Check Ticket" + ANSI_RESET);
                           System.out.println(ANSI_BLUE + "4, Reset Hall"  + ANSI_RESET);
                           System.out.println(ANSI_BLUE + "5, Set row to show record"  + ANSI_RESET);
                           System.out.println(ANSI_BLUE + "6, Exit" + ANSI_RESET);

                           System.out.println("---------------------------------------------------------");
                           System.out.println();





                       }







                    }
                    break;
                    case "2":{
                        System.out.println("Option 2");
                    }
                    case "6":
                    break outter;
                }
            }else {
                System.out.println(ANSI_RED + "Invalid Option" + ANSI_RESET);
            }
        }

    }
}