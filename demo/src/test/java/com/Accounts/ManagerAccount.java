package com.Accounts;



public class ManagerAccount extends StaffAccount {
	ManagerAccount(){
	}

	ManagerAccount(String ID, String name, int age, char gender,Role role, String branch){
        super(ID,name,age,gender,role,branch);
    }

	public void ManageMenu(){}
	
	public Branch getBranch(BranchManagement branchManagement){
		String BranchName = this.getBranchName();
		return branchManagement.getBranchByName(BranchName);
	}

	public void displayStaffList(BranchManagement branchManagement) {
		Branch branch = this.getBranch(branchManagement);
    	if (branch != null) {
        	branch.displayStaffList();
    	} else {
        	System.out.println("No branch information available.");
    	}
	}

	public void MenuManagement(){

	}
}