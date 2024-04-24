package com.Accounts;


import com.Branch.Branch;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayStaffList {
    public DisplayStaffList(){}
    int choice;
	int index;
    Scanner sc = new Scanner(System.in);
    
    public void displaystafflist(StaffAccManagement staffAccManagement,BranchManagement branchManagement){ //TODO
		boolean isValidInput = false;
		do {
			try {
				System.out.println("Please choose which filter you would like to display staff list:");
				System.out.println("1. Branch");
				System.out.println("2. Gender");
				System.out.println("3. Role");
				System.out.println("4. Age");
				System.out.println("5. Back");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				isValidInput = true;
					switch (choice) {
						case 1: // Branch
							index = 1;
							ArrayList<Branch> branchlist = branchManagement.getBranchList();
							ArrayList<Account> Staffs = staffAccManagement.getStaffAccounts();
							ArrayList<AdminAccount> Admins = new ArrayList<>();
							for (Branch branch : branchlist) {
								String CurrentBranch = branch.getBranchName();
								System.out.println("Branch: " + CurrentBranch);
								for (Account acc : Staffs) {
									if (acc.getRole() == Role.STAFF) {
										StaffAccount AccS = (StaffAccount) acc;
										if (AccS.getBranchName().compareTo(CurrentBranch) == 0) {
											System.out.println(index + ".	Staff Name: " + AccS.getName());
											System.out.println("	Staff Type: STAFF");
											index++;
										}
									} else if (acc.getRole() == Role.MANAGER) {
										ManagerAccount Accs = (ManagerAccount) acc;
										if (Accs.getBranchName().compareTo(CurrentBranch) == 0) {
											System.out.println(index + ".	Staff Name: " + Accs.getName());
											System.out.println("	Staff Type: MANAGER");
											index++;
										}
									} else {
										if (Admins.contains(acc)) {
											continue;
										} else {
											Admins.add((AdminAccount) acc);
										}
									}
								}
							}
							System.out.println("No Branch Tagged:");
							for (Account Acc : Admins) {
								System.out.println(index + ".	Staff Name: " + Acc.getName());
								System.out.println("	Staff Type: ADMIN");
							}
							break;
						case 2:
							//Gender
							index = 1;
							Staffs = staffAccManagement.getStaffAccounts();
							ArrayList<Account> Males = new ArrayList<>();
							System.out.println("Females:");
							for (Account account : Staffs) {
								if (account.getGender() == "F") {
									System.out.println(index + ".	Staff Name: " + account.getName());
									System.out.println("	Staff Type: " + account.getRole());
									index++;
								} else {
									Males.add(account);
								}
							}
							System.out.println("Males:");
							for (Account account : Males) {
								System.out.println(index + ".	Staff Name: " + account.getName());
								System.out.println("	Staff Type: " + account.getRole());
								index++;
							}
							Males.clear();
							Males = null;
							break;
						case 3:
							Staffs = staffAccManagement.getStaffAccounts();
							ArrayList<Account> Managers = new ArrayList<>();
							Admins = new ArrayList<>();
							index = 1;
							System.out.println("STAFFS:");
							for (Account account : Staffs) {
								if (account.getRole() == Role.STAFF) {
									System.out.println(index + ".	Staff Name: " + account.getName());
									System.out.println("	Staff Age: " + account.getAge());
									index++;
								} else if (account.getRole() == Role.MANAGER) {
									Managers.add(account);
								} else {
									Admins.add((AdminAccount) account);
								}
							}
							System.out.println("MANAGERS:");
							for (Account account : Managers) {
								System.out.println(index + ".	Staff Name: " + account.getName());
								System.out.println("	Staff Age: " + account.getAge());
								index++;
							}
							System.out.println("Admin:");
							for (Account account : Admins) {
								System.out.println(index + ".	Staff Name: " + account.getName());
								System.out.println("	Staff Age: " + account.getAge());
								index++;
							}
							Managers.clear();
							Admins.clear();
							Managers = null;
							Admins = null;
							break;
						case 4:
							//Age
							Staffs = staffAccManagement.getStaffAccounts();
							for (Account acc : Staffs) {
								System.out.println("Staff Name: " + acc.getName());
								System.out.println("Staff Age: " + acc.getAge());
							}
							break;
						case 5:
							break;
						default:
							System.out.println("Invalid Choice.");
							isValidInput = false;
							break;
					}
			}catch(InputMismatchException e){
				System.out.println("Invalid input. Enter numbers only.");
				sc.nextLine();
				choice = sc.nextInt();
			}
		}while(!isValidInput);
    }

    public void displaystafflist(Branch branch,StaffAccManagement staffAccManagement){
		System.out.println("Branch: " + branch.getBranchName());
		ArrayList<Account> AccList= staffAccManagement.getStaffAccounts();
		index = 1;
		for(Account Acc : AccList){
			if(Acc.getBranchName().compareTo(branch.getBranchName()) == 0){
				System.out.println(index+ ".	Staff Name: " + Acc.getName());
				Role role = Acc.getRole();
				switch(role){
					case STAFF:
						System.out.println("	Staff Type: STAFF");
						break;
					case MANAGER:
						System.out.println("	Staff Type: Manager");
						break;
				}
				index++;
			}
		}

    }
}
