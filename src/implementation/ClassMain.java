package implementation;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class ClassMain 
{
	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Name to create Account");
		String name = scan.nextLine();
		Random rand = new Random();
		int accNo = rand.nextInt(500000000);
		Account acc = new Account(name, accNo); 
		while(true)
		{
			System.out.println("1. Get Account Details.\n2.Deposit Amount\n3.Withdraw Amount\n4.Delete Account");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				acc.getDetails();
				break;
			case 2:
				System.out.println("Enter the amount to be deposited : ");
				int amount= scan.nextInt();
				acc.depositAmount(amount);
				break;
			case 3:
				System.out.println("Enter the amount to be withdrawn:");
				int amnt = scan.nextInt();
				acc.withdrawAmount(amnt);
				break;
			case 4:
				acc.deleteAccount();
				System.out.println("Account Deleted");
				System.exit(0);
			}
			
		}
	}
	

}
