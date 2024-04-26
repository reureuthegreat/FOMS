package com.Accounts;
import java.util.*;
import com.BranchPackage.Branch;
import com.BranchPackage.BranchSystem;
import java.util.Scanner;

/**
 * Manages customer ordering at a specific branch of Kentucky Fried Children (KFC).
 */
public class CustomerOrderingSystem {

	/**
	 * Manages customer ordering at a specific branch of Kentucky Fried Children (KFC).
	 * @param branchManagement The BranchManagement object containing the list of branches.
	 */
	public void COS(BranchManagement branchManagement) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		Branch branch;

		System.out.println("Which KFC would you like to go to?");
		for (Branch br : branchManagement.getBranchList()) {
			System.out.println(br.getBranchName());
		}
		
        do {
        	String name = scanner.nextLine();
            branch = branchManagement.getBranchByName(name);
            if (branch == null) {
                System.out.println("Branch does not exist!");
                name = scanner.nextLine();
            }
        }while(branch==null);

        /*
         *  Setting
         */

        //1. Connect to branchSystem
        BranchSystem branchSystem = branch.branchSystem;

			try {
				Boolean IsValid = true;
				do {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");

			System.out.println("Welcome to Kentucky Fried Children @" + branch.getBranchName() + "!");
			System.out.println("+--------------------------------------+");
			System.out.println("| I'm NOT lovin it...                  |");
			System.out.println("|                                      |");
			System.out.println("| Go to:                               |");
			System.out.println("|  1. Self-Ordering Kiosk              |");
			System.out.println("|  2. Order Collection Site            |");
			System.out.println("+--------------------------------------+");
					System.out.print("Enter your choice (1 or 2): ");
					choice = scanner.nextInt();
					// Process user's choice
					switch (choice) {
						case 1:
							System.out.println("Going to Self-Ordering Kiosk...");
							branch.kiosk_machine.ordering(branchSystem);
							break;
						case 2:
							System.out.println("Going to Order Collection Site...");
							branch.collection_Site.Display_Orders(branchSystem);
							try{
									System.out.println("Collect Order now?");
									System.out.println("+-----------+");
									System.out.println("|  1. Yes   |");
									System.out.println("|  2. No    |");
									System.out.println("+-----------+");
									choice = scanner.nextInt();
									if (choice == 1) {
										branch.collection_Site.collect_order(branchSystem);
									}
							}catch(InputMismatchException e){
								System.out.println("Not a valid option.");
								scanner.nextLine();
							}
							break;
						default:
							IsValid = false;
							System.out.println("Fun fact: KFC tastes better than BURGER QUEEN...");
							break;
					}
				}while(IsValid);
			}catch(InputMismatchException e){
				System.out.println("numbers only");
				scanner.nextLine();
		}
		

	}
	
}
