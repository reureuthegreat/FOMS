package com.Accounts;
import java.util.Scanner;

public class ManagerApp {
    
    public ManagerApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;
    public void managerapp(ManagerAccount Manager){
        do{
            System.out.println("===========Manager===========\n"+
                           "1. Display Order\n"+
                           "2. View Order Details\n"+
                           "3. Process Order\n"+
                           "4. Manage Menu\n"+
                           "5. Display Staff List\n"+
                           "6. Back\n"+
                           "===========================");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Manager.displayOrder();
                    break;
                case 2:
                    Manager.viewOrder();
                    break;
                case 3:
                    Manager.processOrder();
                    break;
                case 4:
                    Manager.ManageMenu();
                    break;
                case 5:
                    DisplayStaffList DSL = new DisplayStaffList();
                    DSL.displaystafflist(Manager.getBranchName());
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please enter 1,2,3,4,5 or 6.");
                    break;
            }

        }while(choice !=4);
    }
}
