package com.Accounts;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.Branch.Branch;
import com.FoodItem.FoodItem;
import com.Category.Category;

/**
 * Class that manages the database operations for accounts, branches and menu items..
 * It provides methods for reading and writing data related to accounts, branches, and menu items.
 * @author User
 */
public class Database {
    public static final String SEPARATOR = "|";

    /**
     * Reads account data from the given file and returns it as a list of Account objects.
     * @param filename The name of the file to read from.
     * @return An ArrayList containing Account objects read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    // an example of reading
    public static ArrayList<Account> readAccounts(String filename) throws IOException {
        // read String from text file
        ArrayList<String> stringArray = (ArrayList<String>) read(filename);
        ArrayList<Account> alr = new ArrayList();// to store Accounts data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);    // pass in the string to the string tokenizer using delimiter ","
            String name = star.nextToken().trim(); // name
            String ID = star.nextToken().trim(); // ID
            String RoleString = star.nextToken().trim(); // Role in string
            String GenderString = star.nextToken().trim(); // Gender in string
            int Age = Integer.parseInt(star.nextToken().trim()); // Age in int
            String Branch = star.nextToken().trim();// Branch as a string
            String password = star.nextToken().trim();//Password as string
            Role role;
            if (RoleString.compareTo("STAFF") == 0) {
                role = Role.STAFF;
                StaffAccount Acc = new StaffAccount(ID, name, Age, GenderString, role, Branch,password);
                int index =0;
                for(Account acc:alr){
                    if(Acc.getAge()>acc.getAge()){
                        break;
                    }
                    index++;
                }
                alr.add(index,Acc);
            } else if (RoleString.compareTo("MANAGER") == 0) {
                role = Role.MANAGER;
                StaffAccount Acc = new StaffAccount(ID, name, Age, GenderString, role, Branch,password);
                int index =0;
                for(Account acc:alr){
                    if(Acc.getAge()>acc.getAge()){
                        break;
                    }
                    index++;
                }
                alr.add(index,Acc);
            } else if (RoleString.compareTo("ADMIN") == 0) {
                role = Role.ADMIN;
                AdminAccount Acc = new AdminAccount(ID, name, Age, role, GenderString,password);
                int index =0;
                for(Account acc:alr){
                    if(Acc.getAge()>acc.getAge()){
                        break;
                    }
                    index++;
                }
                alr.add(index,Acc);
            } else {
                System.out.println("Role is unknown!");
            }
        }
        return alr;
    }

    /**
     * Saves the list of accounts to the given file.
     * @param filename The name of the file to save to.
     * @param al The list of accounts to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveAccounts(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store Accounts data

        for (int i = 0; i < al.size(); i++) {
            Account Acc = (Account) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(Acc.getName().trim());
            st.append(SEPARATOR);
            st.append(Acc.getID().trim());
            st.append(SEPARATOR);
            st.append(Acc.getRole());
            st.append(SEPARATOR);
            st.append(Acc.getGender().trim());
            st.append(SEPARATOR);
            st.append(Acc.getAge());
            st.append(SEPARATOR);
            st.append(Acc.getBranchName().trim());
            st.append(SEPARATOR);
            st.append(Acc.getPassword().trim());
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    /**
     * Writes the given data to the specified file.
     * @param fileName The name of the file to write to.
     * @param data The data to write to the file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void write(String fileName, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        try {
            for (int i = 0; i < data.size(); i++) {
                out.println((String) data.get(i));
            }
        } finally {
            out.close();
        }
    }

    /**
     * Reads the contents of the given file and returns them as a list of strings.
     * @param fileName The name of the file to read from.
     * @return An ArrayList containing the lines read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return data;
    }

    /**
     * Reads branch data from the given file and returns it as a list of Branch objects.
     * @param filename The name of the file to read from.
     * @return An ArrayList containing Branch objects read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static ArrayList<Branch> readBranch(String filename) throws IOException {
        // read String from text file
        ArrayList<String> stringArray = (ArrayList<String>) read(filename);
        ArrayList<Branch> alr = new ArrayList();// to store Professors data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);    // pass in the string to the string tokenizer using delimiter ","

            String name = star.nextToken().trim(); // Branch name
            String Location = star.nextToken().trim(); // Branch Location
            int Quota = Integer.parseInt(star.nextToken().trim()); // Staff Quota
            int NumofStaffs = Integer.parseInt(star.nextToken().trim());
            int NumofManagers = Integer.parseInt(star.nextToken().trim());
            Branch branch = new Branch(name,Quota,Location,NumofStaffs,NumofManagers);
            alr.add(branch);
        }
        return alr;
    }

    /**
     * Saves the list of branches to the given file.
     * @param filename The name of the file to save to.
     * @param al The list of branches to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveBranchs(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store Branch data

        for (int i = 0; i < al.size(); i++) {
            Branch BR = (Branch) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(BR.getBranchName().trim());
            st.append(SEPARATOR);
            st.append(BR.getLocation().trim());
            st.append(SEPARATOR);
            st.append(BR.getStaffQuota());
            st.append(SEPARATOR);
            st.append(BR.getNumberofStaffs());
            st.append(SEPARATOR);
            st.append(BR.getNumofManagers());
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    /**
     * Reads menu data from the given file and returns it as a list of FoodItem objects.
     * @param filename The name of the file to read from.
     * @return An ArrayList containing FoodItem objects read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static ArrayList<FoodItem> readMenu(String filename) throws IOException {
        // read String from text file
        ArrayList<String> stringArray = (ArrayList<String>) read(filename);
        ArrayList<FoodItem> alr = new ArrayList();// to store Professors data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);    // pass in the string to the string tokenizer using delimiter ","
            String name = star.nextToken().trim(); // Item name
            double price = Double.parseDouble(star.nextToken().trim()); // Item Price
            String desc = star.nextToken().trim(); // Item desc
            String category = star.nextToken().trim(); // Item Category
            String avail = star.nextToken().trim(); // Item availability
            String Loc = star.nextToken().trim();
            boolean availability;
            if(avail.compareTo("true")==0){
                availability = true;
            }else{
                availability = false;
            }
            Category cat;
            FoodItem food = null;
            if (category.compareTo("BURGER") == 0) {
                cat = Category.BURGER;
                food = new FoodItem(name,price,desc,cat,availability,Loc);
                alr.add(food);
            } else if (category.compareTo("DRINK") == 0) {
                cat = Category.DRINK;
                food = new FoodItem(name,price,desc,cat,availability,Loc);
                alr.add(food);
            } else if (category.compareTo("SIDEDISH") == 0) {
                cat = Category.SIDEDISH;
                food = new FoodItem(name,price,desc,cat,availability,Loc);
                alr.add(food);
            } else if(category.compareTo("SETMEAL") == 0) {
                cat = Category.SETMEAL;
                food = new FoodItem(name,price,desc,cat,availability,Loc);
                alr.add(food);
            }
            else {
                System.out.println("Role is unknown!");
            }

        }
        return alr;
    }

    /**
     * Saves the list of menu items to the given file.
     * @param filename The name of the file to save to.
     * @param al The list of menu items to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveMenu(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store Menu data

        for (int i = 0; i < al.size(); i++) {
            FoodItem food = (FoodItem) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(food.getName().trim());
            st.append(SEPARATOR);
            st.append(food.getPrice());
            st.append(SEPARATOR);
            st.append(food.getDescription());
            st.append(SEPARATOR);
            st.append(food.getCategory());
            st.append(SEPARATOR);
            st.append(food.getAvailability());
            st.append(SEPARATOR);
            st.append(food.getLocation());

            alw.add(st.toString());
        }
        write(filename, alw);
    }

}