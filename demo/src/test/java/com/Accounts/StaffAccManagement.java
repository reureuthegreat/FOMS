package com.Accounts;
import com.Branch.Branch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Manages staff accounts including login, creation, editing, and removal.
 */
public class StaffAccManagement {

	/**
	 * The list of staff accounts managed by this class.
	 */
	private ArrayList<Account> AccList;
	int choice;

	/**
	 * Scanner object for user input.
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * Constructs a new StaffAccManagement object with an empty list of accounts.
	 */
	StaffAccManagement() {
		this.AccList = new ArrayList<>();
	}

	/**
	 * Logs in a user by verifying their ID and password against the stored accounts.
	 *
	 * @return The logged-in account or null if login fails.
	 */
	public Account Login() {
		System.out.println("Please enter your ID:");
		String ID = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		for (Account Acc : AccList) {
			if (Acc.verifyID(ID)) {
				if (Acc.verifyPassword(password)) {
					return Acc;
				}
			}
		}
		System.out.println("Wrong username or password!");
		return null;
	}

	/**
	 * Adds a new staff account to the system.
	 *
	 * @return true if the account was successfully added, false otherwise.
	 */
	public boolean addAcc(BranchManagement branchManagement) {
		Role role = null;
		boolean isValidSelection = false;
		do {
			try {
				System.out.println("==========Account Type===========");
				System.out.println("1. Staff");
				System.out.println("2. Manager");
				System.out.println("3. Admin");
				System.out.println("4. Cancel Account Creation");
				System.out.println("==========================");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
					case 1:
						role = Role.STAFF;
						isValidSelection = true;
						break;
					case 2:
						role = Role.MANAGER;
						isValidSelection = true;
						break;
					case 3:
						role = Role.ADMIN;
						isValidSelection = true;
						break;
					case 4:
						return false; // Exit without adding
					default:
						System.out.println("Please select only 1, 2, 3, or 4.");
						break;
				}
				if (isValidSelection) {
					System.out.println("Please enter Staff Name: ");
					String name = sc.nextLine();
					System.out.println("Please enter Staff ID:");
					String ID = sc.nextLine();
					System.out.println("Please enter Staff Age: ");
					int age = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter the Staff's Gender");
					String gender = sc.nextLine();
					switch (choice) {
						case 1:
							System.out.println("Please enter the Staff's Branch");
							String Branchname = sc.nextLine();
							StaffAccount staff = new StaffAccount(ID, name, age, gender, role, Branchname);
							Branch branch = branchManagement.getBranchByName(Branchname);
							branch.incrementStaffNum();
							addToAccListSortedByAge(staff);
							return true;
						case 2:
							System.out.println("Please enter the Staff's Branch");
							Branchname = sc.nextLine();
							StaffAccount Manager = new StaffAccount(ID, name, age, gender, role, Branchname);
							branch = branchManagement.getBranchByName(Branchname);
							branch.incrementManagerNum();
							addToAccListSortedByAge(Manager);
							return true;
						case 3:
							AdminAccount Admin = new AdminAccount(ID, name, age, role, gender);
							addToAccListSortedByAge(Admin);
							return true;
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("Invalid input. Please enter valid data.");
				sc.nextLine(); // Clear the input buffer
			}
		} while (!isValidSelection);
		return false;
	}

	/**
	 * Adds a specified staff account to the system sorted by age. Default for all add accounts.
	 */
	private void addToAccListSortedByAge(Account account) {
		int index = 0;
		for (Account acc : AccList) {
			if (account.getAge() > acc.getAge()) {
				break;
			}
			index++;
		}
		AccList.add(index, account);
	}

	/**
	 * Edits an existing staff account's details such as ID and password.
	 */
	public void editAcc() {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		String oldStaffID, newStaffID, newPassword, newbranch;
		do {
			System.out.println("Please select what you would like to do:");
			System.out.println("1: Change Staff ID");
			System.out.println("2: Change password");
			System.out.println("3: Quit");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					System.out.println("Please input the staff ID you would like to change:");
					oldStaffID = sc.nextLine();
					System.out.println("Please input the new staff ID:");
					newStaffID = sc.nextLine();
					boolean change = false;
					for (Account account : AccList) {
						if (account.getID().equals(oldStaffID)) {
							account.setID(newStaffID);
							System.out.println("Successfully changed Staff ID.");
							change = true;
							break;
						}
					}
					if (change == false) {
						System.out.println("ID does not exist! Try again.");
					}
					break;
				case 2:
					System.out.println("Please input the staff ID you would like to change the password of:");
					oldStaffID = sc.nextLine();
					System.out.println("Please enter your new password:");
					newPassword = sc.nextLine();
					for (Account account : AccList) {
						if (account.getID().equals(oldStaffID)) {
							account.setPassword(newPassword);
							System.out.println("Successfully changed password.");
							break;
						}
					}
					break;
				case 3:
					System.out.println("Quitting...");
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Input Choice again:");
					choice = sc.nextInt();
					break;
			}
		} while (!exit);
	}

	/**
	 * Removes an existing staff account from the system.
	 *
	 * @return true if the account was successfully removed, false otherwise.
	 */
	public boolean removeAcc(BranchManagement branchManagement) {
		System.out.println("Enter staff ID you would like to remove:");
		String ID = sc.nextLine();
		for (Account Acc : AccList) {
			if (Acc.verifyID(ID)) {
				Branch branch = branchManagement.getBranchByName(Acc.getBranchName());
				if(Acc.getRole()==Role.STAFF){
					branch.decrementStaffNum();
				}
				else{
					branch.decrementManagerNum();
				}
				AccList.remove(Acc);
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves the list of staff accounts managed by this class.
	 *
	 * @return The list of staff accounts.
	 */
	public ArrayList<Account> getStaffAccounts() {
		return this.AccList;
	}

	/**
	 * Finds a staff account by ID.
	 *
	 * @param ID The ID of the account to find.
	 * @return The found account or null if not found.
	 */
	public Account findStaffAccount(String ID) {
		for (Account Acc : AccList) {
			if (Acc.verifyID(ID)) {
				return Acc;
			}
		}
		return null;
	}

	/**
	 * Sets the list of staff accounts to the given list.
	 *
	 * @param AL The list of accounts to set.
	 */
	public void setAccList(ArrayList<Account> AL) {
		this.AccList = AL;
	}
}
