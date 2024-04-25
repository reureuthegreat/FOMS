package com.Accounts;
import com.Branch.Branch;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Manages branches in the system, including adding, removing, and retrieving branches.
 */
public class BranchManagement {
	int Quota;
	static ArrayList<Branch> BranchList;

	/**
	 * Constructs a BranchManagement object and initializes the BranchList.
	 */
	BranchManagement(){
		BranchList = new ArrayList<>();
	}

	/**
	 * Adds a new branch to the system.
	 * @return True if the branch is successfully added, false otherwise.
	 */
	public boolean AddBranch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Branch Name: ");
		String branchName = sc.nextLine();
		System.out.println("Plesae enter Location of Branch:");
		String Location = sc.nextLine();
		System.out.println("Please enter Staff Quota for the " + branchName + " branch.");

		boolean validInput = false;
		do {
			try {
				Quota = sc.nextInt();
				validInput = true;
			} catch (InputMismatchException ex) {
				System.out.println("Please enter numbers only for Staff Quota.");
				sc.nextLine(); // Clear the input buffer
			}
		} while (!validInput);

		Branch branch = new Branch(branchName, Quota,Location);

		// Find the correct position to insert the new branch in ascending order of branchName
		int index = 0;
		for (Branch existingBranch : BranchList) {
			if (branchName.compareToIgnoreCase(existingBranch.getBranchName()) < 0) {
				break; // Found the correct position
			}
			index++;
		}

		BranchList.add(index, branch); // Insert the new branch at the correct position
		return true;
	}

	/**
	 * Removes a branch from the system.
	 * @return True if the branch is successfully removed, false otherwise.
	 */
	public boolean RemoveBranch() {
		System.out.println("Please enter the name of the Branch you would like to remove: ");
		Scanner sc = new Scanner(System.in);
		String BranchName = sc.nextLine();
		for(Branch branch : BranchList){
			if(branch.getBranchName().equals(BranchName)){
				BranchList.remove(branch);
				System.out.println("Branch removed and closed successfully.");

				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves the list of branches.
	 * @return The list of branches.
	 */
	public static ArrayList<Branch> getBranchList() {
		return BranchList;
	}

	/**
	 * Retrieves a branch by its name.
	 * @param BranchName The name of the branch to retrieve.
	 * @return The Branch object if found, null otherwise.
	 */
	public Branch getBranchByName(String BranchName){ // pass string branch name
		for(Branch branch: BranchList){//iterate thru list of branches to find the branch object.
			if(branch.verifyBranchName(BranchName)){ // verify branch name.
				return branch;
			}
		}
		System.out.println("Branch does not exist!");
		return null;
	}

	/**
	 * Sets the list of branches.
	 * @param branchList The list of branches to set.
	 */
	public static void setBranchList(ArrayList<Branch> branchList) {
		BranchList = branchList;
	}

}