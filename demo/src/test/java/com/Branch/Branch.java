package com.Branch;
import java.util.ArrayList;


public class Branch {
	private String BranchName;
	private int StaffQuota;
	private String Location;
	private BranchSystem branchSystem;

	Branch(){}

	public Branch(String name, int Quota, String loc){
		this.BranchName = name;
		this.StaffQuota = Quota;
		this.Location = loc;
		this.branchSystem = new BranchSystem();
	}



	public int getStaffQuota() {
        return StaffQuota;
    }

    public void setStaffQuota(int StaffQuota) {
        this.StaffQuota = StaffQuota;
    }
	public String getLocation(){
		return this.Location;
	}

	public void setLocation(String location) {
		Location = location;
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

	public BranchSystem getBranchSystem() {
		return branchSystem;
	}
}