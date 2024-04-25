package com.Accounts;

/**
 * Represents a staff account, extending the Account class.
 */
public class StaffAccount extends Account {

    /**
     * The branch associated with this staff account.
     */
    private String branch;

    /**
     * Constructs a new StaffAccount object with the specified details.
     * @param ID The ID of the account.
     * @param name The name of the account holder.
     * @param age The age of the account holder.
     * @param gender The gender of the account holder.
     * @param role The role of the account holder.
     * @param branch The branch associated with the account.
     */
    StaffAccount(String ID, String name, int age, String gender,Role role, String branch){
        super(ID,name,age,role,gender);
        this.branch = branch;
    }

    /**
     * Constructs a new StaffAccount object with the specified details and password.
     * @param ID The ID of the account.
     * @param name The name of the account holder.
     * @param age The age of the account holder.
     * @param gender The gender of the account holder.
     * @param role The role of the account holder.
     * @param branch The branch associated with the account.
     * @param password The password of the account.
     */
    StaffAccount(String ID, String name, int age, String gender,Role role, String branch, String password){
        super(ID,name,age,role,gender,password);
        this.branch = branch;
    }

    /**
     * Sets the branch associated with this staff account.
     * @param branch The branch name to set.
     */
    public void setBranch(String branch){
        this.branch = branch;
    }

    /**
     * Gets the name of the branch associated with this staff account.
     * @return The branch name.
     */
    public String getBranchName(){
        return this.branch;
    }
}