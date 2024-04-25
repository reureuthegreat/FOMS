package com.Accounts;
import java.util.Scanner;

public class AdminAccount extends Account{

	AdminAccount(){}

	AdminAccount(String ID, String name, int age,Role role, String gender){
		super(ID,name,age,role,gender);
	}
	AdminAccount(String ID, String name, int age,Role role, String gender,String password){
		super(ID,name,age,role,gender,password);
	}

	public boolean assignManager(StaffAccManagement staffaccmanagement, BranchManagement branchManagement) {
		System.out.println("Please enter the Manager you want to assign: ");
		Scanner sc=  new Scanner(System.in);
		String ManagerID = sc.nextLine();
		System.out.println("Please enter the name of the branch you are assigning them to: ");
		String BranchName = sc.nextLine();
		Account Acc = staffaccmanagement.findStaffAccount(ManagerID);
		StaffAccount Acc1 = (StaffAccount) Acc;
		try {
			if ((Acc1.getRole() == Role.MANAGER) && (Acc1 != null)) {
				Acc1.setBranch(BranchName);
				System.out.println("Manager Assigned to " + BranchName + " branch successfully.");
				return true;
			}else {
				System.out.println("Staff is not a Manager. Promote first.");
			}
		}catch(NullPointerException e){
			System.out.println("Account does not exist. Did you input the ID wrongly?");
		}
		return false;
	}

	public void Promote(StaffAccManagement staffaccmanagement) {
		Scanner sc=  new Scanner(System.in);
		System.out.println("Please input the ID of the staff you would like to promote: ");
		String ID = sc.nextLine();
		StaffAccount Acc = (StaffAccount) staffaccmanagement.findStaffAccount(ID);
		try {
			if ((Acc != null) && (Acc.getRole() == Role.STAFF)) {
				String name = Acc.getName();
				int Age = Acc.getAge();
				String gender = Acc.getGender();
				String branch = Acc.getBranchName();
				String password = Acc.getPassword();
				Role role = Role.MANAGER;
				ManagerAccount Manager = new ManagerAccount(ID, name, Age, gender, role, branch);
				Manager.setPassword(password);
				staffaccmanagement.removeAcc(Acc);
				staffaccmanagement.addAcc(Manager);
				System.out.println("Staff promoted successfully!");
			}
			else{
				System.out.println("Not a staff! Can't be promoted to Manager.");
			}
		}catch(NullPointerException e){
			System.out.println("Account doesn't exist! Did you input the ID correctly?");
		}
		return;
	}

	public boolean transferStaff(StaffAccManagement staffaccmanagement, BranchManagement branchManagement) {
		String OldBranch;
		System.out.println("Please enter the Staff ID you want to transfer: ");
		Scanner sc=  new Scanner(System.in);
		String StaffID = sc.nextLine();
		System.out.println("Please enter the name of the branch you are transferring them to: ");
		String BranchName = sc.nextLine();
		StaffAccount Acc = (StaffAccount) staffaccmanagement.findStaffAccount(StaffID);
		if(Acc!=null){
			Acc.setBranch(BranchName);
			System.out.println("Staff Assigned to " + BranchName + " branch successfully.");
		}
		else{
			System.out.println("Staff not found!");
		}
		return false;
	}

	public String getBranchName(){
		return "None";
	}
}

