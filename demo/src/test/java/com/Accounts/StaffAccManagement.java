package com.Accounts;
import java.util.ArrayList;
import java.util.Scanner;



public class StaffAccManagement {

	private ArrayList<Account> AccList;
	int choice;
    Scanner sc = new Scanner(System.in);
	StaffAccManagement(){
		this.AccList = new ArrayList<>();
	};

	public Account Login(){
		System.out.println("Please enter your ID:");
		String ID = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		for(Account Acc : AccList){
			if(Acc.verifyID(ID)){
				if(Acc.verifyPassword(password)){
					return Acc;
				}
				else{
					System.out.println("Wrong password!");
				}
			}
		}
		System.out.println("Wrong username or password!");
		return null;
	}

	public boolean addAcc() {
		Role role = null;
		do{
		System.out.println("===========Account Type===========\n"+
							   "1. Staff\n"+
							   "2. Manager\n"+
							   "3. Admin\n"+
							   "4. Back\n"+
							   "===========================");
		choice = sc.nextInt();
		switch(choice){
			case 1:
				role = Role.STAFF;
				break;
			case 2:
				role = Role.MANAGER;
				break;
			case 3:
				role = Role.ADMIN;
				break;
			case 4:
				role = null;
				break;
			default:
				System.out.println("Plese select only 1,2,3 or 4.");
				break;
			}
		}while(choice != 4);
		if(choice == 4){
			return false;
		}else{
			System.out.println("Please enter Staff Name: ");
			String name = sc.nextLine();
			System.out.println("Please enter Staff ID:");
			String ID = sc.nextLine();
			System.out.println("Please enter Staff Age: ");
			int age = sc.nextInt();
			System.out.println("Please enter the Staff's Gender");
			char gender = sc.nextLine().charAt(0);
			switch(choice){
				case 1:
					System.out.println("Please enter the Staff's Branch");
					String Branchname = sc.nextLine();
					StaffAccount  staff = new StaffAccount(ID,name,age,gender,role,Branchname);
					AccList.add(staff);
					return true;
				case 2:
					System.out.println("Please enter the Staff's Branch");
					Branchname = sc.nextLine();
					ManagerAccount Manager = new ManagerAccount(ID, name, age, gender, role, Branchname);
					AccList.add(Manager);
					return true;
				case 3:
					AdminAccount Admin = new AdminAccount(ID,name, age, role, gender);
					AccList.add(Admin);
					return true;
			}
			return false;
		}
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
				for(Account account : AccList){
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
				for(Account account : AccList){
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
				for(Account account: AccList){
					if(account.getID().equals(oldStaffID)){
						StaffAccount account1 = (StaffAccount) account;
						account1.setBranch(newbranch);
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

	public boolean removeAcc() {
		System.out.println("Enter staff ID you would like to remove:");
		String ID = sc.nextLine();
		for(Account Acc : AccList){
			if (Acc.verifyID(ID))
			AccList.remove(Acc);
			return true;
		}
		return false;
	}

	public ArrayList<Account> getStaffAccounts(){
		return this.AccList;
	}

	public Account findStaffAccount(String ID){
		for(Account Acc : AccList){
			if (Acc.verifyID(ID)) {
				return Acc;				
			}
		}
		return null;
	}

	public void removeAcc(StaffAccount Acc){
		AccList.remove(Acc);
	}
	public void addAcc(StaffAccount Acc){
		AccList.add(Acc);
	}

}