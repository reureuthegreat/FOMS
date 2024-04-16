package com.Accounts;

import java.util.ArrayList;
import java.util.Scanner;

public class BranchManagement {

	private ArrayList<Branch> BranchList;

	BranchManagement(){
		this.BranchList = new ArrayList<>();
	}

	public void AddBranch() {
		System.out.println("Please Enter Branch Name: ");
		Scanner sc = new Scanner(System.in);
		String BranchName = sc.nextLine();
		System.out.println("Please enter Staff Quota for the " + BranchName + " branch.");
		int Quota = sc.nextInt();
		Branch branch = new Branch(BranchName,Quota);
		BranchList.add(branch);
		System.out.println("Branch added succesfully");
		sc.close();
	}

	public void RemoveBranch() {
		System.out.println("Please enter the name of the Branch you would like to remove: ");
		Scanner sc = new Scanner(System.in);
		String BranchName = sc.nextLine();
		for(Branch branch : BranchList){
			if(branch.getBranchName().equals(BranchName)){
				BranchList.remove(branch);
				System.out.println("Branch removed and closed successfully.");
				sc.close();
				return;
			}
		}
		System.out.println("Failed to remove Branch.");
		sc.close();
	}

	public Branch getBranchByName(String BranchName){
		for(Branch branch: BranchList){
			if(branch.verifyBranchName(BranchName)){
				return branch;
			}
		}
		System.out.println("Branch does not exist!");
		return null;
	}

	public ArrayList<Branch> getBranchs(){
		return this.BranchList;
	}

}