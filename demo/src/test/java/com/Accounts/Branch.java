package com.Accounts;
import java.util.ArrayList;


public class Branch {
	private String BranchName;
	private int StaffQuota;
	private int NumOfStaffs;
	private ArrayList<StaffAccount> StaffList;

	Branch(){}

	Branch(String name,int Quota){
		this.BranchName = name;
		this.StaffQuota = Quota;
		this.NumOfStaffs = 0;
		this.StaffList = new ArrayList<>();
	}

	public void addStaff(StaffAccount Acc) {
		StaffList.add(Acc);
		NumOfStaffs++;
	}

	public void removeStaff(StaffAccount Acc){
		StaffList.remove(Acc);
		NumOfStaffs--;
	}

	public void displayStaffList(){
		System.out.println("Branch: " + BranchName);
		System.out.println("Staff Quota: " + StaffQuota);
		System.out.println("Number of Staffs: " + NumOfStaffs);
		for(StaffAccount account : StaffList ){
			System.out.println(account.getPersInfo().getName()+ " " + account.getPersInfo().getAge() + " " + account.getPersInfo().getGender());
		}
	}

	public int getStaffQuota() {
        return StaffQuota;
    }

    public void setStaffQuota(int StaffQuota) {
        this.StaffQuota = StaffQuota;
    }

    public int getNumOfStaffs() {
        return NumOfStaffs;
    }

    public void setNumOfStaffs(int NumOfStaffs) {
        this.NumOfStaffs = NumOfStaffs;
    }

	public ArrayList<StaffAccount> getStaffList() {
        return StaffList;
    }

	public String getBranchName(){
		return this.BranchName;
	}

	public boolean verifyBranchName(String  BranchName){
		if(this.BranchName.equals(BranchName)){
			return true;
		}
		return false;
	}
}