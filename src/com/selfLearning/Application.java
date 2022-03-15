package com.selfLearning;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application {

        public static void main(String[] args) {

            Guest john = new Guest("John", "Doe", false);
            Guest bob = new Guest("Bob", "Doe", false);
            Guest sonia = new Guest("Sonia", "Doe", true); //loyalty program
            Guest siri = new Guest("Siri", "Doe", true); //loyalty program

            //Queue<Guest> checkinQueue = new ArrayDeque<>();
            //Add guest to the list.if we ADD many elements, ADD METHOD will throws exception
            //because it is bounded queue. to avoid exception use OFFER
           // checkinQueue.offer(john);
           // checkinQueue.offer(bob);
           // checkinQueue.offer(sonia);
           // checkinQueue.offer(siri);
          //  print(checkinQueue);
            //Inserted John 1st and will be removed 1st and bob advances to the top then when
            //we peeked we got the element at the head of the but that element remained at the queue.
            //Guest guest =  checkinQueue.poll();
            //print(checkinQueue);
          //  System.out.println(guest);

            //All guest will be added then John pulled of the queue,
           // Guest guest1 =  checkinQueue.peek();
           // print(checkinQueue);
          //  System.out.println(guest1);
            //Retrieve element at the head of the empty queue
            //Guest guest = checkinQueue.remove();
            //System.out.println(guest); //Print that element to the console. Throws exception.
            //Instead of remove if we use poll it will return null.
            //Guest guest = checkinQueue.poll();

            Comparator<Guest> programComp
                    //Put loyalty program holders a head of non-loyalty program members.
                    = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed(); // Sorts guest in descending order

            Queue<Guest> checkinQueue = new PriorityQueue<>(programComp);
            checkinQueue.add(john);
            checkinQueue.add(bob);
            checkinQueue.add(sonia);
            checkinQueue.add(siri);
            print(checkinQueue);

            Guest guest = checkinQueue.remove();
            print(checkinQueue);
            System.out.println(guest);

            Guest guest1 = checkinQueue.element();
            print(checkinQueue);
            System.out.println(guest1);

        }

        public static void print(Queue<Guest> queue) {

            System.out.format("%n--Queue Contents--%n");

            int x = 0;
            for(Guest guest : queue) {
                System.out.format("%x: %s %s %n", x++, guest.toString(), x == 1 ? "(Head)":"");
            }

            System.out.println("");


            //THE KEY TO WORKING WITH THE QUEUE IS UNDERSTANDING FIFO ORDER
            //AND THE SUBTLE DIFFERENCES IN THE BEHAVIOR OF ITS METHODS. 
        }
    }

