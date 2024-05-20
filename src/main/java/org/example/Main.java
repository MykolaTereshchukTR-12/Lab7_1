package org.example;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> phoneBookMap = new HashMap<>();
        PhoneBook phoneBook = new PhoneBook();

        //Start the program:
        System.out.println("Hello, It's project 7, please enter a mode you want to use here!");
        System.out.println(main.help());

        //Initialization of the eternal cycle
        while(true) {
            //Switch() declarations for different application modes for Task_1
            switch (main.controlSYS()) {
                //Exit the loop and the program as a whole
                case ("0"): {
                    System.out.println("Before meeting!");
                    System.exit(0);
                }

                //Task 1.
                case ("1"): {
                    System.out.println("Enter the integer number of persons:");
                    boolean i = true;
                    int numbers = 0;
                    while (i) {
                        try {
                            numbers = scanner.nextInt();
                            i = false;
                        } catch (NumberFormatException e) {
                            i = true;
                            System.out.println("Invalid input. Please enter a valid mode number.");
                        }
                    }
                    scanner.nextLine();
                    for(int num = 0; num != numbers; num++) {
                        phoneBook.inputData(phoneBookMap, scanner);
                    }
                    System.out.println("Do you want to continue? Enter \"help\" for help or 0 to exit the program.");
                    break;
                }

                //Task 2.
                case ("2"): {
                    String surname = phoneBook.getData(scanner);
                    Integer number = phoneBookMap.get(surname);
                    phoneBook.hereAreYourPeople(phoneBookMap, surname, number);
                    System.out.println("Do you want to continue? Enter \"help\" for help or 0 to exit the program.");
                    break;
                }

                //Task 4.
                case ("3"): {
                    String surname = phoneBook.getData(scanner);
                    phoneBook.banPerson(phoneBookMap, surname);
                    System.out.println("Do you want to continue? Enter \"help\" for help or 0 to exit the program.");
                    break;
                }

                //Help.
                case ("help"): {
                    System.out.println("The essence of the program:");
                    System.out.println(main.help());
                    break;
                }

                //In case of error or unforeseen situations.
                default: {
                    System.out.println("Please follow the instructions and be careful when working with this program.");
                    System.out.println(main.help());
                    break;
                }
            }
        }
    }

    //A block that controls and accompanies the program.
    public String controlSYS() {
        String _control = "0";
        try {
            _control = scanner.nextLine();
        } catch(InputMismatchException e) {
            System.out.println("Please follow the instructions and be careful when working with this program!!!");
            _control = "5";
        }
        return _control;
    }

    public String help() {
        return """
                Enter 1 to display the result of task 1;\s
                Enter 2 to display the result of task 2;\s
                Enter 3 to display the result of task 3;\s
                Enter 4 to display the result of task 4;\s
                Enter 0 to exit the program.""";
    }
}