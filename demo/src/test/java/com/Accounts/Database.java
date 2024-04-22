package com.Accounts;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * Class of Database that stores data related to Guest, Reservation, Room and RoomService
 * @author User
 *
 */
public class Database {
    public static final String SEPARATOR = "|";

    // an example of reading
    public static ArrayList<Account> readAccounts(String filename) throws IOException {
        // read String from text file
        ArrayList<String> stringArray = (ArrayList<String>) read(filename);
        ArrayList<Account> alr = new ArrayList();// to store Professors data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);    // pass in the string to the string tokenizer using delimiter ","

            String name = star.nextToken().trim(); // name
            String ID = star.nextToken().trim(); // ID
            String RoleString = star.nextToken().trim(); // Role in string
            String GenderString = star.nextToken().trim(); // Gender in string
            int Age = Integer.parseInt(star.nextToken().trim()); // Age in int
            String Branch = star.nextToken().trim();// Branch as a string
            Role role;
            if (RoleString.compareTo("STAFF") == 0) {
                role = Role.STAFF;
                StaffAccount Acc = new StaffAccount(ID, name, Age, GenderString, role, Branch);
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
                ManagerAccount Acc = new ManagerAccount(ID, name, Age, GenderString, role, Branch);
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
                AdminAccount Acc = new AdminAccount(ID, name, Age, role, GenderString);
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

    // an example of saving
    public static void saveAccounts(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store Professors data

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
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    /**
     * Write fixed content to the given file.
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
     * Read the contents of the given file.
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
}