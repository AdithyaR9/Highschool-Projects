
import java.util.Scanner;

public class MainFile
{
	public static void main(String[]args)
	{
		Scanner keyboard= new Scanner(System.in);
		
		int choice;
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		do
		{
			System.out.print("\n-Menu-\n");
			System.out.println("1. Print");
			System.out.println("2. Size");
			System.out.println("3. Clear");
			System.out.println("4. Empty");
			System.out.println("5. Insert");
			System.out.println("6. Remove");
			System.out.println("7. Contains");
			System.out.println("8. Min Value");
			System.out.println("9. Max Value");
			System.out.println("10. Max Depth");
			System.out.println("0. Exit");
			System.out.print("Enter selection: ");
			choice= keyboard.nextInt();
			
			System.out.println();
			if(choice==1)
			{
				if(tree.isEmpty())
					System.out.println("The tree is empty.");
				else
				{
					System.out.print("\n-Menu-\n");
					System.out.println("1. Pre Order");
					System.out.println("2. In Order");
					System.out.println("3. Post Order");
					System.out.println("0. Cancel");
					System.out.print("Enter selection: ");
					int choice2= keyboard.nextInt();
					if(choice2==1)
						System.out.println("Pre order: "+tree.preOrder());
					else if(choice2==2)
						System.out.println("In order: "+tree.inOrder());
					else
						System.out.println("Post order: "+tree.postOrder());	
					
				}
			}
			else if(choice==2)
			{
				System.out.println("The tree has "+tree.size()+" items");
			}
			else if(choice==3)
			{
				tree.clear();
				System.out.println("The tree has been emptied.");
			}
			else if(choice==4)
			{
				if(tree.isEmpty())
					System.out.println("The tree is empty.");
				else
					System.out.println("The tree is not empty.");
			}
			else if(choice==5)
			{
				System.out.print("Enter the number you want to add: ");
				Integer number = keyboard.nextInt();
				boolean added = tree.add(number);
				if(added == true)
					System.out.println(number + " was added.");
				else
					System.out.println(number + " was not added.");
			}
			else if(choice==6)
			{
				System.out.print("Enter the number you want to remove: ");
				Integer number = keyboard.nextInt();
				boolean removed = tree.remove(number);
				if(removed == true)
					System.out.println(number + " was removed.");
				else
					System.out.println(number + " was not removed.");
			}
			else if(choice==7)
			{
				System.out.print("Enter the number you to check for: ");
				Integer number = keyboard.nextInt();
				boolean found = tree.contains(number);
				if(found == true)
					System.out.println(number + " was found in the tree.");
				else
					System.out.println(number + " was not found in the tree.");
			}
			else if(choice==8)
			{
				if(tree.isEmpty())
					System.out.println("The tree is empty.");
				else
					System.out.println("The smallest value in the tree is "+tree.minValue()+".");
			}
			else if(choice==9)
			{
				if(tree.isEmpty())
					System.out.println("The tree is empty.");
				else
					System.out.println("The largest value in the tree is "+tree.maxValue()+".");
			}
			else if(choice==10)
			{
				if(tree.isEmpty())
					System.out.println("The tree is empty.");
				else
					System.out.println("The deepest value is at depth "+tree.maxDepth()+".");
			}
			if(choice==0)
				break;
	
		}while(true);
	
		System.out.print("\nGood Bye!!");

		System.out.println("\n\nEnter \"exit\" to quit");
		keyboard.next();
	}
}