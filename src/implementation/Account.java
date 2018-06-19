package implementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Account 
{
	String accountHolderName;
	private double accountBalance;
	private int accountNo;
	private File info ;
	
	public Account(String accountHolderName, int accountNo) throws IOException
	{
		this.accountBalance=0.0;
		this.accountHolderName = accountHolderName;
		this.accountNo = accountNo;
		this.info = new File("D://"+this.accountNo+"_"+this.accountHolderName+".txt");
		try 
		{
			if(info.createNewFile())
				System.out.println("Account Successfully Created.");
		}
		catch (IOException e) 
		{
			System.out.println("Error in opening Account");
		}
		this.setFields();
	}
	
	public void getDetails()
	{
		System.out.println("Account Holder Name : "+this.accountHolderName);
		System.out.println("Account Number : "+this.accountNo);
		System.out.println("Account Balance : "+this.accountBalance);
	}
	
	public void depositAmount(int amount) throws IOException
	{
		if(amount<0.00)
		{
			System.out.println("Amount should be greater than 0.00");
			return ;
		}
		else
		{
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			this.accountBalance+=amount;
			System.out.println("Amount deposited Successfully..!!!");
			PrintWriter writerCredit = new PrintWriter(new FileWriter(this.info, true));
			writerCredit.write("Credit\t\t\t"+amount + "\t\t\t" + this.accountBalance + "\t\t\t"+ date + "\t\t\t" + time);
			writerCredit.write(System.getProperty("line.separator"));
			writerCredit.flush();
		}
	}
	
	public void withdrawAmount(int amount) throws IOException
	{
		if(amount<0.00||this.accountBalance<1.00||this.accountBalance<amount)
		{
			System.out.println("Withdrawal not Possible....!!! ");
			return ;
		}
		else 
		{
			LocalDate date = LocalDate.now();
			LocalTime time =LocalTime.now();
			PrintWriter writerDebit = new PrintWriter(new FileWriter(this.info, true));
			this.accountBalance-=amount;
			writerDebit.write("Debit\t\t\t"+amount + "\t\t\t" + this.accountBalance + "\t\t"+ date + "\t\t" + time);
			writerDebit.write(System.getProperty("line.separator"));
			writerDebit.flush();
			System.out.println("Congratulations....!!!\nWithdrawal Successful..!!!!");
			System.out.println("Remaning Balance is : " + this.accountBalance);
		}
	}
	public void deleteAccount()
	{
		this.info.delete();
	}
	
	public  void setFields() throws IOException
	{
		PrintWriter setfields = new PrintWriter(new FileWriter(this.info));
		setfields.write("Transaction Type\tTransaction Amount\tBalance\t\t\tDate\t\t\tTime");
		setfields.write(System.getProperty("line.separator"));
		setfields.flush();

	}
}