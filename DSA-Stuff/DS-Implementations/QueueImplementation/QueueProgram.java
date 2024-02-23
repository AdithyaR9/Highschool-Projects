

import java.util.Scanner;

public class QueueProgram {

    static boolean running = true;

    public static void main(String[] args) {
        QueueClass<Integer> list = new QueueClass<>();
        while (running == true) {
            Scanner bobi = new Scanner(System.in);
            System.out.println(" To Add Value Press 1 \n To Remove value Press 2 \n To Get Value Press 3 \n To Peek Press 4 \n To Get Size Press 5 \n To Print Press 6 \n To Check if Empty Press 7 \n To Exit 8 \n");
            int selections = bobi.nextInt();

            //------------------------------------------------------------

            if (selections == 1) {
                Scanner bobia = new Scanner(System.in);
                System.out.println(" Enter the value you want to add");
                int x = bobia.nextInt();

                list.add(x);
            }

            if (selections == 2) {
                if (list.empty()) {
                    System.out.println("Queue is Empty");
                } else {
                    System.out.println(list.remove());
                }
            }

            if (selections == 3) {
                Scanner bobic = new Scanner(System.in);
                System.out.println("Enter the Index of the Value you want to receive.");
                int x3 = bobic.nextInt();

                if (x3 <= (list.size() - 1)) {
                    System.out.print(list.get(x3));
                } else {
                    System.out.println("That index does not exist");
                }
            }

            if (selections == 4) {
                if (list.size() > 0) {
                    System.out.println(list.peek());
                } else {
                    System.out.println("Queue is Empty");
                }
            }

            if (selections == 5) {
                System.out.println(list.size());
            }

            if (selections == 6) {
                if (list.empty()) {
                    System.out.println("Queue is Empty");
                } else {
                    System.out.println(list.print());
                }
            }

            if (selections == 7) {
                System.out.println(list.empty());
            }

            if (selections == 8) {
                System.out.println("Program Ended/Exited");
                running = false;
            }
        }


    }

}
