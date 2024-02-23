
import java.util.*;

public class MainFile {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int choice;
        LinkedList<String> ll = new LinkedList<String>();
        do {
            System.out.print("\n-Menu-\n");
            System.out.println("1. Size");
            System.out.println("2. Print");
            System.out.println("3. Print First");
            System.out.println("4. Print Last");
            System.out.println("5. Get Location");
            System.out.println("6. Remove First");
            System.out.println("7. Remove Last");
            System.out.println("8. Remove X");
            System.out.println("9. Add First");
            System.out.println("10. Add Last");
            System.out.println("11. Insert");
            System.out.println("12. Set X");
            System.out.println("13. Is Empty");
            System.out.println("14. Clear");
            System.out.println("0. Exit");
            System.out.print("Enter selection: ");
            choice = keyboard.nextInt();

            System.out.println();
            if (choice == 1) {
                System.out.println(ll.size());
            }
            if (choice == 2) {
                ll.print();
            }
            if (choice == 3) {
                System.out.println(ll.getFirst());
            }
            if (choice == 4) {
                System.out.println(ll.getLast());
            }
            if (choice == 5) {
                System.out.print("Index to Search");
                int x = keyboard.nextInt();
                System.out.print(ll.get(x));
            }
            if (choice == 6) {
                System.out.print(ll.removeFirst());
            }
            if (choice == 7) {
                System.out.print(ll.removeLast());
            }
            if (choice == 8) {
                System.out.print("Index to Remove");
                int x = keyboard.nextInt();
                System.out.print(ll.remove(x));
            }
            if (choice == 9) {
                System.out.print("Value to add");
                String s = keyboard.next();
                ll.addFirst(s);
            }
            if (choice == 10) {
                System.out.print("Value to add");
                String s = keyboard.next();
                ll.addLast(s);
            }
            if (choice == 11) {
                System.out.print("Value to add");
                String s = keyboard.next();
                System.out.print("At what index?");
                int a = keyboard.nextInt();
                ll.add(a, s);
            }
            if (choice == 12) {
                System.out.print("Index to Set");
                int a = keyboard.nextInt();
                System.out.print("To what Value");
                String s = keyboard.next();
                ll.set(a, s);
            }
            if (choice == 13) {
                System.out.print(ll.isEmpty());
            }
            if (choice == 14) {
                ll.clear();
                System.out.println("List is Empty");
            }
            if (choice == 0)
                break;

        } while (true);

        System.out.print("\nGood Bye!!");

        System.out.println("\n\nEnter \"exit\" to quit");
        keyboard.next();
    }
}
