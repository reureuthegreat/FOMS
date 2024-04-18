package com.Accounts;
import java.util.ArrayList;
import java.util.Scanner;



public class StaffAccManagement {

	private ArrayList<StaffAccount> AccList;
	
	StaffAccManagement(){
		this.AccList = new ArrayList<>();
	};

	public void addAcc(StaffAccount Acc) {
		AccList.add(Acc);
	}

	public void editAcc() {
		Scanner sc = new Scanner(System.in);
		String oldStaffID, newStaffID, newPassword, newbranch;
		System.out.println("Please select what you would like to do:");
		System.out.println("1: Change Staff ID");
		System.out.println("2: Change password");
		System.out.println("3: Change Branch");
		System.out.println("4: Quit");;
		int choice = sc.nextInt();
		do{
		switch(choice){
			case 1:
				System.out.println("Please input the staff ID you would like to change:");
				oldStaffID = sc.nextLine();
				System.out.println("Please input the new staff ID:");
				newStaffID = sc.nextLine();
				for(StaffAccount account : AccList){
					if(account.getID().equals(oldStaffID)){
						account.setID(newStaffID);
						System.out.println("Successfully changed Staff ID.");
						break;
					}
				}
				break;
			case 2:
				System.out.println("Please input the staff ID you would like to change the password of:");
				oldStaffID = sc.nextLine();
				System.out.println("Please enter your new password:");
				newPassword = sc.nextLine();
				for(StaffAccount account : AccList){
					if(account.getID().equals(oldStaffID)){
						account.setPassword(newPassword);
						System.out.println("Successfully changed password.");
						break;
					}
				}
				break;
			case 3:
				System.out.println("Please inpute the staff ID you would like to transfer:");
				oldStaffID = sc.nextLine();
				System.out.println("Please input the new branch:");
				newbranch = sc.nextLine();
				for(StaffAccount account: AccList){
					if(account.getID().equals(oldStaffID)){
						account.setBranch(newbranch);
					}
				}
				break;
			case 4:
				System.out.println("Quitting...");
				break;	
			default:
				System.out.println("Invalid choice. Input Choice again:");
				choice = sc.nextInt();
		}
		}while(choice!=4);

		sc.close();
	}

	public void removeAcc(StaffAccount Acc) {
		AccList.remove(Acc);
	}

	public ArrayList<StaffAccount> getStaffAccounts(){
		return this.AccList;
	}

	public StaffAccount findStaffAccount(String ID){
		for(StaffAccount Acc : AccList){
			if (Acc.verifyID(ID)) {
				return Acc;				
			}
		}
		return null;
	}

}