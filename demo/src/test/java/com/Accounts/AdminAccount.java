package com.Accounts;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminAccount extends Account{

	AdminAccount(){}

	AdminAccount(String ID, String name, int age, String gender){
		super(ID,name,age,gender);
	}

	public boolean assignManager(StaffAccManagement staffaccmanagement, BranchManagement branchManagement) {
		String OldBranch;
		System.out.println("Please enter the Manager you want to assign: ");
		Scanner sc=  new Scanner(System.in);
		String ManagerID = sc.nextLine();
		System.out.println("Please enter the name of the branch you are assigning them to: ");
		String BranchName = sc.nextLine();
		StaffAccount Acc = staffaccmanagement.findStaffAccount(ManagerID);
		if(Acc instanceof ManagerAccount && (Acc!=null)){
			OldBranch = Acc.getBranchName();
			Acc.setBranch(BranchName);
			Branch branch = branchManagement.getBranchByName(BranchName);
			branch.addStaff(Acc);
			branch = branchManagement.getBranchByName(OldBranch);
			branch.removeStaff(Acc);
			System.out.println("Manager Assigned to " + BranchName + " branch succesffuly.");
			sc.close();
			return true;
		}
		else if(Acc == null){
			System.out.println("Staff not found!");
		}
		else{
			System.out.println("Staff is not a Manager. Promote first.");
		}
		sc.close();
		return false;
	}

	public void Promote(StaffAccManagement staffaccmanagement) {
		Scanner sc=  new Scanner(System.in);
		System.out.println("Please input the ID of the staff you would like to promote: ");
		String ID = sc.nextLine();
		StaffAccount Acc = staffaccmanagement.findStaffAccount(ID);
		if((Acc!=null) && (Acc instanceof StaffAccount)){
			String name = Acc.getPersInfo().getName();
			int Age = Acc.getPersInfo().getAge();
			String gender = Acc.getPersInfo().getGender();
			String branch = Acc.getBranchName();
			String password = Acc.getPassword();
			ManagerAccount Manager = new ManagerAccount(ID,name,Age,gender,branch);
			Manager.setPassword(password);
			staffaccmanagement.removeAcc(Acc);
			staffaccmanagement.addAcc(Manager);
			System.out.println("Staff promoted successfully!");
		}
		else if(Acc== null){
			System.out.println("Staff not found!");
		}
		else{
			System.out.println("Not a staff! Can't be promoted to Manager.");
		}
		sc.close();
		return;
	}

	public boolean transferStaff(StaffAccManagement staffaccmanagement, BranchManagement branchManagement) {
		String OldBranch;
		System.out.println("Please enter the Manager you want to assign: ");
		Scanner sc=  new Scanner(System.in);
		String ManagerID = sc.nextLine();
		System.out.println("Please enter the name of the branch you are assigning them to: ");
		String BranchName = sc.nextLine();
		StaffAccount Acc = staffaccmanagement.findStaffAccount(ManagerID);
		if(Acc instanceof ManagerAccount && (Acc!=null)){
			OldBranch = Acc.getBranchName();
			Acc.setBranch(BranchName);
			Branch branch = branchManagement.getBranchByName(BranchName);
			branch.addStaff(Acc);
			branch = branchManagement.getBranchByName(OldBranch);
			branch.removeStaff(Acc);
			System.out.println("Manager Assigned to " + BranchName + " branch succesffuly.");
			sc.close();
			return true;
		}
		else if(Acc == null){
			System.out.println("Staff not found!");
		}
		else{
			System.out.println("Staff is not a Manager. Promote first.");
		}
		sc.close();
		return false;
	}

	public void ManageBranch(BranchManagement BranchManagement) {
		System.out.println("---------What would you like to do?-------------");
		System.out.println("1. Open Branch");
		System.out.println("2. Close Branch");
		System.out.println("3. Exit");
		System.out.println("------------------------------------------------");
		Scanner sc=  new Scanner(System.in);
		int choice = sc.nextInt();
		do{
			switch(choice){
				case 1:
					BranchManagement.AddBranch();
					break;
				case 2:
					BranchManagement.RemoveBranch();
					break;
				case 3:
					System.out.println("Quitting...");
					break;
				default:
					System.out.println("Invalid choice! Input choice again!");
					choice = sc.nextInt();
					break;
			}
		}while(choice != 3);
		sc.close();
	}

	public void ManagesStaff(StaffAccManagement StaffAccManagement) {
		System.out.println("---------What would you like to do?-------------");
		System.out.println("1. Create Staff Account");
		System.out.println("2. Delete Staff Account");
		System.out.println("3. Edit Staff Account Details");
		System.out.println("4. Exit");
		System.out.println("------------------------------------------------");
		Scanner sc=  new Scanner(System.in);
		int choice = sc.nextInt();
		do{
			switch(choice){
				case 1:
					System.out.print("Enter the staff's ID: ");
					String ID = sc.nextLine();
					System.out.print("Enter the staff's name: ");
					String name = sc.nextLine();
					System.out.print("Enter the staff's age: ");
					int age = sc.nextInt();
					System.out.print("Enter the staff's gender: ");
					String gender = sc.nextLine();
					System.out.print("Enter the staff's branch: ");
					String branch = sc.nextLine();
					StaffAccount newStaff = new StaffAccount(ID,name,age,gender,branch);
					StaffAccManagement.addAcc(newStaff);
					System.out.println("New Staff Account created.");
					break;
				case 2:
					System.out.print("Enter the staff's ID: ");
					String iD = sc.nextLine();
					StaffAccount staff = StaffAccManagement.findStaffAccount(iD);
					StaffAccManagement.removeAcc(staff);
					System.out.println("Staff Account deleted successfully.");
					break;
				case 3:
					StaffAccManagement.editAcc();
					break;
				case 4:
					System.out.println("Quiting...");
					break;
				default:
					System.out.println("Invalid choice. Please enter choice again:");
					choice = sc.nextInt();
					break;
			}
		}while(choice != 4);
		sc.close();
	}

	public void displayStaffList(BranchManagement branchManagement, StaffAccManagement staffAccManagement) {
		//display with filter based on Age/Branch/ Gender/ Role
		System.out.println("Please choose which filter you would like to display staff list:");
		System.out.println("1. Branch");
		System.out.println("2. Role");
		System.out.println("3. Gender");
		System.out.println("4. Age");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				ArrayList<Branch> list = new ArrayList<>();
				list = branchManagement.getBranchs();
				for(Branch branch : list){
					branch.displayStaffList();
				}
				break;
			case 2:
				//Role
				break;
			case 3:
				//Gender
				break;
			case 4:
				//Age
			default:
				System.out.println("Invalid Choice.");
		}
		sc.close();
	}
}