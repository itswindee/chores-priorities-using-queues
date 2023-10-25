// Name:        Emily Zhu
// Class:       CS 3305/W04/
// Term:        Fall 2023
// Instructor:  Carla McManus
// Assignment:  05-Part-1-Queues

import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList <String> chores = new LinkedList<>(); //a linked list to store chores
        LinkedList <Integer> priorities = new LinkedList<>(); //a linked list to store priorities

        String chore;
        int priority;
        int choice;

        //do this while the choice is not 4 to quit
        do {
            //users can choose to add or remove chores
            //users can also view all their chores they currently have
            System.out.println("Select an option below: ");
            System.out.println("1. Add chore");
            System.out.println("2. Remove chore");
            System.out.println("3. View all chores");
            System.out.println("4. Exit");
            choice = scan.nextInt();
            Scanner scan2 = new Scanner(System.in);


            switch (choice) {
                case 1: //add chore
                    System.out.print("Enter a chore: ");
                    chore = scan2.nextLine();
                    System.out.print("Enter priority: ");
                    priority = scan.nextInt();
                    //if priorities is empty, chores & priorities will be added at the beginning
                    if (priorities.isEmpty()) {
                        chores.add(chore);
                        priorities.add(priority);
                    }
                    //iterates through priorities
                    //this will find the correct spot to insert the chore based on the level of its priority
                    else {
                        for (int i = 0; i < priorities.size(); i++) {
                            if (priority < priorities.get(i)) {
                                chores.add(i, chore);
                                priorities.add(i, priority);
                                break;
                            } else if (i == priorities.size() - 1) {
                                chores.add(chore);
                                priorities.add(priority);
                                break;
                            }
                        }
                    }
                    break;
                case 2: //remove the first chore in the list
                    //if there is no chore, print statement
                    if (chores.isEmpty()) {
                        System.out.println("You currently have no chores.");
                    }
                    else {
                        System.out.println("The chore " + chores.remove() + " has been removed."); //will remove chores
                        priorities.remove(); //will remove priorities
                    }
                    break;
                case 3: //view all chores
                    //if there is no chores, print statement
                    if (chores.isEmpty()) {
                        System.out.println("You have no chores to view.");
                    } else {
                        System.out.println("Chores:");
                        //this loop will grab all the current chores in the linkedlist
                        //it will also grab their priorities
                        for (int i = 0; i < chores.size(); i++) {
                            System.out.println(chores.get(i) + " - Priority: " + priorities.get(i));
                        }
                    }
                    break;
            }
        } while (choice != 4); //4 will exit the program
    }
}