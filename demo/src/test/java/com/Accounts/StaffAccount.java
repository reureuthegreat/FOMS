package com.Accounts;


public class StaffAccount extends Account {

    private String branch;

    StaffAccount(){}

    StaffAccount(String ID, String name, int age, String gender,Role role, String branch){
        super(ID,name,age,role,gender);
        this.branch = branch;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public String getBranchName(){
        return this.branch;
    }
}