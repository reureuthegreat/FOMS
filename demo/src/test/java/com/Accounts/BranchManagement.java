package com.Accounts;

import java.util.ArrayList;
import java.util.Scanner;

public class BranchManagement {

	static ArrayList<Branch> BranchList;

	BranchManagement(){
		BranchList = new ArrayList<>();
	}

	public boolean AddBranch() {
		System.out.println("Please Enter Branch Name: ");
		Scanner sc = new Scanner(System.in);
		String BranchName = sc.nextLine();
		System.out.println("Please enter Staff Quota for the " + BranchName + " branch.");
		int Quota = sc.nextInt();
		Branch branch = new Branch(BranchName,Quota);
		BranchList.add(branch);
		sc.close();
		return true;
	}

	public boolean RemoveBranch() {
		System.out.println("Please enter the name of the Branch you would like to remove: ");
		Scanner sc = new Scanner(System.in);
		String BranchName = sc.nextLine();
		for(Branch branch : BranchList){
			if(branch.getBranchName().equals(BranchName)){
				BranchList.remove(branch);
				System.out.println("Branch removed and closed successfully.");
				sc.close();
				return true;
			}
		}
		sc.close();
		return false;
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
}