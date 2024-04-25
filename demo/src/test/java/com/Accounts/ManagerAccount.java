package com.Accounts;


import com.Branch.Branch;

public class ManagerAccount extends StaffAccount {
	ManagerAccount(){
	}

	ManagerAccount(String ID, String name, int age, String gender,Role role, String branch){
        super(ID,name,age,gender,role,branch);
    }
	ManagerAccount(String ID, String name, int age, String gender,Role role, String branch,String password){
		super(ID,name,age,gender,role,branch,password);
	}


}