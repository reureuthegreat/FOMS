package com.Accounts;

/**
 * A general structure of an account for all the Staff, Manager and Admin Accounts
 */
public abstract class Account {

    /**
     * The Unique Account ID.
     */
    private String ID;

    /**
     * The password of the Account.
     */
    private String Password;

    /**
     * The Name of the User the account belongs to.
     */
    private String Name;

    /**
     * Age of the account user.
     */
    private final int age;

    /**
     * Gender of the account user.
     */
    private final String gender;

    /**
     * The role of the user by enumeration.
     */
    private  Role role;

    /**
     * Creates a new account with the given ID. ID should be unique. First instance of the account where password is set to be 'password'.
     * @param ID This User's ID.
     * @param name This user's name.
     * @param age This User's age.
     * @param role This User's role in enumeration.
     * @param gender This User's Gender in M or F.
     */
    public Account(String ID, String name, int age,Role role, String gender) {
        this.Name = name;
        this.age = age;
        this.gender = gender;
        this.ID = ID;
        this.role = role;
        this.Password = "password";
    }

    /**
     * Creates a new account with the given ID. ID should be unique. When password is no longer default or for reading in from Database.
     * @param ID This User's ID.
     * @param name This user's name.
     * @param age This User's age.
     * @param role This User's role in enumeration.
     * @param gender This User's Gender in M or F.
     * @param password This User's password
     */
    public Account(String ID, String name, int age,Role role, String gender,String password) {
        this.Name = name;
        this.age = age;
        this.gender = gender;
        this.ID = ID;
        this.role = role;
        this.Password = password;
    }

    /**
     * Returns the ID of the Account.
     * @return The ID of the Account.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Sets the ID of the Account.
     * @param ID The new ID of the Account.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Returns the password of the Account.
     * @return The password of the Account.
     */
    public String getPassword() {
        return this.Password;
    }

    /**
     * Sets the password of the Account.
     * @param Password The new password of the Account.
     */

    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Returns the Name of the User.
     * @return The Name of the User.
     */
    public String getName(){
        return this.Name;
    }

    /**
     * Sets the Name of the User.
     * @param name The new Name of the User.
     */
    public void setName(String name){
        this.Name = name;
    }

    /**
     * Returns the Age of the User.
     * @return The Age of the User.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Returns the Gender of the User.
     * @return The Gender of the User.
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * Returns the Role of the User.
     * @return The Role of the User.
     */

    public Role getRole(){
        return this.role;
    }

    /**
     * Sets the Role of the User.
     * @param Role The new Name of the User.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Verifies if the input password matches the Account's password.
     * @param inputPassword The input password to be verified.
     * @return true if the input password matches the Account's password, false otherwise.
     */
    public boolean verifyPassword(String inputPassword) {
        return inputPassword.equals(this.Password);
    }

    /**
     * Verifies if the input ID matches the Account's ID.
     * @param inputID The input ID to be verified.
     * @return true if the input ID matches the Account's ID, false otherwise.
     */
    public boolean verifyID(String inputID) {
        return inputID.equals(this.ID);
    }

    /**
     * Abstract method to get the Branch Name associated with the Account.
     * @return The Branch Name associated with the Account.
     */
    public abstract String getBranchName();
}