package com.Accounts;
import java.util.Scanner;

public class AdminAccount extends Account{

	AdminAccount(){}

	AdminAccount(String ID, String name, int age,Role role, char gender){
		super(ID,name,age,role,gender);
	}

	public boolean assignManager(StaffAccManagement staffaccmanagement, BranchManagement branchManagement) {
		String OldBranch;
		System.out.println("Please enter the Manager you want to assign: ");
		Scanner sc=  new Scanner(System.in);
		String ManagerID = sc.nextLine();
		System.out.println("Please enter the name of the branch you are assigning them to: ");
		String BranchName = sc.nextLine();
		Account Acc = staffaccmanagement.findStaffAccount(ManagerID);
		StaffAccount Acc1 = (StaffAccount) Acc;
 		if((Acc1.getRole()== Role.MANAGER) && (Acc1!=null)){
			OldBranch = Acc1.getBranchName();
			Acc1.setBranch(BranchName);
			Branch branch = branchManagement.getBranchByName(BranchName);
			branch.addStaff(Acc1);
			branch = branchManagement.getBranchByName(OldBranch);
			branch.removeStaff(Acc1);
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
		StaffAccount Acc = (StaffAccount) staffaccmanagement.findStaffAccount(ID);
		if((Acc!=null) && (Acc instanceof StaffAccount)){
			String name = Acc.getName();
			int Age = Acc.getAge();
			char gender = Acc.getGender();
			String branch = Acc.getBranchName();
			String password = Acc.getPassword();
			Role role = Role.MANAGER;
			ManagerAccount Manager = new ManagerAccount(ID,name,Age,gender,role,branch);
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
		StaffAccount Acc = (StaffAccount) staffaccmanagement.findStaffAccount(ManagerID);
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
}

