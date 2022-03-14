package bankapp;

import java.util.Scanner;

public class bankapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bankAccount bacc= new bankAccount("xyz","0222102");
		bacc.showMenu();

	}

}

class bankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	bankAccount(String cname, String cid){
		customerName=cname;
		customerID=cid;
	}
	
	void Deposit(int amount) {
		if(amount!=0) {
			balance+=amount;
			previousTransaction=amount;
		}
	}
	
	void Withdraw(int amount) {
		if(amount!=0) {
			balance-=amount;
			previousTransaction=amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Deposited:"+previousTransaction);
		}
		else if(previousTransaction<0) {
			System.out.println("Withdrew:"+Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction occured");
		}
	}
	
	void showMenu() {
		char option='\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome"+customerName);
		System.out.println("Your ID is"+customerID);
		System.out.println();
		System.out.println("A: Check Balance");
		System.out.println("B: Deposit");
		System.out.println("C: Withdraw");
		System.out.println("D: Previous Transaction");
		System.out.println("E: Exit");
		
		do {
			System.out.println("Enter an Option:");
			System.out.println("--------------------------------------");
			option=sc.next().charAt(0);
			
			switch(option) {
			
			case 'A': 
				System.out.println("Balance"+balance);
				System.out.println();
				break;
				
			case 'B': 
				System.out.println("Enter an amount to deposite");
				int amount=sc.nextInt();
				Deposit(amount);
				System.out.println();
				break;	
				
			case 'C': 
				System.out.println("Enter an amount to Withdrew");
				int amount2=sc.nextInt();
				Deposit(amount2);
				System.out.println();
				break;	
				
			case 'D': 
				getPreviousTransaction();
				System.out.println();
				break;	
				
			case 'E':
			System.out.println("Thank You");
			break;
			default:
				System.out.println("Invalid");
				break;
			}
		}while( option!='E');
		System.out.println("**********************************");
	}
	
	
}