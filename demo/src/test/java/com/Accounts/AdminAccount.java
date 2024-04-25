package com.Accounts;
import com.Branch.Branch;
import java.util.Scanner;

/**
 * Represents an Admin Account in the system.
 * Inherits from the Account class.
 */
public class AdminAccount extends Account{

	/**
	 * Constructs an AdminAccount object with the specified parameters.
	 * @param ID The ID of the Admin Account.
	 * @param name The name of the Admin.
	 * @param age The age of the Admin.
	 * @param role The role of the Admin (Admin in this case).
	 * @param gender The gender of the Admin (M/F).
	 */
	AdminAccount(String ID, String name, int age,Role role, String gender){
		super(ID,name,age,role,gender);
	}

	/**
	 * Constructs an AdminAccount object with the specified parameters including password.
	 * @param ID The ID of the Admin Account.
	 * @param name The name of the Admin.
	 * @param age The age of the Admin.
	 * @param role The role of the Admin (Admin in this case).
	 * @param gender The gender of the Admin (M/F).
	 * @param password The password of the Admin.
	 */
	AdminAccount(String ID, String name, int age,Role role, String gender,String password){
		super(ID,name,age,role,gender,password);
	}

	/**
	 * Assigns a Manager to a specified Branch.
	 * @param Acc1 The ManagerAccount object representing the Manager to be assigned.
	 * @param branch The Branch to which the Manager will be assigned.
	 * @return true if Manager is assigned successfully, false otherwise.
	 */
	public boolean assignManager(StaffAccount Acc1,Branch branch) {
		try {
			if ((Acc1.getRole() == Role.MANAGER) && (Acc1 != null)) {
				Acc1.setBranch(branch.getBranchName());
				System.out.println("Manager Assigned to " + branch.getBranchName() + " branch successfully.");
				return true;
			}else {
				System.out.println("Staff is not a Manager. Promote first.");
			}
		}catch(NullPointerException e){
			System.out.println("Account does not exist. Did you input the ID wrongly?");
		}
		return false;
	}

	/**
	 * Promotes a Staff member to Manager.
	 * @param staffaccmanagement The StaffAccManagement object for managing Staff accounts.
	 */
	public void Promote(StaffAccManagement staffaccmanagement) {
		Scanner sc=  new Scanner(System.in);
		System.out.println("Please input the ID of the staff you would like to promote: ");
		String ID = sc.nextLine();
		StaffAccount Acc = (StaffAccount) staffaccmanagement.findStaffAccount(ID);
		try {
			if ((Acc != null) && (Acc.getRole() == Role.STAFF)) {
				Acc.setRole(Role.MANAGER);
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

	/**
	 * Transfers a Staff member to a different Branch.
	 * @param staffaccmanagement The StaffAccManagement object for managing Staff accounts.
	 * @param branchManagement The BranchManagement object for managing Branches.
	 * @return true if Staff is transferred successfully, false otherwise.
	 */
	public boolean transferStaff(StaffAccManagement staffaccmanagement, BranchManagement branchManagement) {
		System.out.println("Please enter the Staff ID you want to transfer: ");
		Scanner sc=  new Scanner(System.in);
		String StaffID = sc.nextLine();
		System.out.println("Please enter the name of the branch you are transferring them to: ");
		String BranchName = sc.nextLine();
		Branch branch = branchManagement.getBranchByName(BranchName);
		if(!branch.verifyBranchQuota()){
			System.out.println("Branch is full!");
			return false;
		}
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

	/**
	 * Verifies if the Manager quota is met for a given Branch.
	 * @param branch The Branch for which to verify the Manager quota.
	 * @return true if Manager quota is met, false otherwise.
	 */
	public boolean VerifyManagerQuota(Branch branch){
		int currentnumber = branch.getNumberofStaffs();
		int managers = branch.getNumofManagers();

		if(currentnumber<=4){
			if(managers<1){
				return true;
			}
			return false;
		}
		else if(currentnumber>=5 && currentnumber<=8){
			if(managers<2){
				return true;
			}
			return false;
		}
		else if(currentnumber>=9 && currentnumber<=15){
			if(managers<3){
				return true;
			}
			return false;
		}
		else{
			return false;
		}
	}

	/**
	 * Returns the Branch name associated with the Admin Account.
	 * @return 'None' for Admin.
	 */
	public String getBranchName(){
		return "None";
	}
}

