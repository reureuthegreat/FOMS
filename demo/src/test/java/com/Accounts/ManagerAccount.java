package com.Accounts;



public class ManagerAccount extends StaffAccount {
	ManagerAccount(){
	}

	ManagerAccount(String ID, String name, int age, String gender,Role role, String branch){
        super(ID,name,age,gender,role,branch);
    }

	public void ManageMenu(){}
	
	public Branch getBranch(BranchManagement branchManagement){
		String BranchName = this.getBranchName();
		return branchManagement.getBranchByName(BranchName);
	}


	public void MenuManagement(){

	}
}