package com.Branch;


public class Branch {
	public final String BranchName;
	private int StaffQuota;
	private int NumberofStaffs;
	private int NumofManagers;
	private String Location;

	public Self_Ordering_Kiosk kiosk_machine;
	public Order_Collection_Site collection_Site;
	public BranchSystem branchSystem;


	public Branch(String branch_name, int Quota, String loc) {
		this.BranchName = branch_name;
		this.StaffQuota = Quota;
		this.Location = loc;
		this.kiosk_machine = new Self_Ordering_Kiosk();
		this.collection_Site = new Order_Collection_Site();
		this.branchSystem = new BranchSystem();
		this.NumberofStaffs = 0;
		this.NumofManagers = 0;
	}

	public Branch(String branch_name, int Quota, String loc, int Num, int NumofM) {
		this.BranchName = branch_name;
		this.StaffQuota = Quota;
		this.Location = loc;
		this.kiosk_machine = new Self_Ordering_Kiosk();
		this.collection_Site = new Order_Collection_Site();
		this.branchSystem = new BranchSystem();
		this.NumberofStaffs = Num;
		this.NumofManagers = NumofM;
	}

	public int getStaffQuota() {
		return StaffQuota;
	}

	public void setStaffQuota(int StaffQuota) {
		this.StaffQuota = StaffQuota;
	}

	public String getLocation() {
		return this.Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getBranchName() {
		return this.BranchName;
	}

	public boolean verifyBranchName(String BranchName) {
		if (this.BranchName.equals(BranchName)) {
			return true;
		}
		return false;
	}

	public BranchSystem getBranchSystem() {
		return branchSystem;
	}

	public int getNumberofStaffs() {
		return NumberofStaffs;
	}

	public void setNumberofStaffs(int numberofStaffs) {
		NumberofStaffs = numberofStaffs;
	}

	public int getNumofManagers() {
		return NumofManagers;
	}

	public void setNumofManagers(int numofManagers) {
		NumofManagers = numofManagers;
	}

	public void incrementManagerNum(){
		this.NumofManagers++;
	}
	public void decrementManagerNum(){
		this.NumberofStaffs--;
	}

	public boolean verifyBranchQuota(){
		int totalstaffs= (this.NumberofStaffs)+(this.NumofManagers);
		if(totalstaffs< this.StaffQuota){
			return true;
		}
		return false;
	}

	public void incrementStaffNum(){
		this.NumberofStaffs++;
	}
	public void decrementStaffNum(){
		this.NumberofStaffs--;
	}
}
