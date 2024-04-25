package com.Branch;

/**
 * Represents a branch of the company with staff information, location, and facilities.
 */
public class Branch {

	/** The name of the branch. */
	public final String BranchName;

	/** The quota for staff in the branch. */
	private int StaffQuota;

	/** The number of staff currently in the branch. */
	private int NumberofStaffs;

	/** The number of managers currently in the branch. */
	private int NumofManagers;

	/** The location of the branch. */
	private String Location;

	/** The self-ordering kiosk machine in the branch. */
	public Self_Ordering_Kiosk kiosk_machine;

	/** The order collection site in the branch. */
	public Order_Collection_Site collection_Site;

	/** The branch system managing operations in the branch. */
	public BranchSystem branchSystem;

	/**
	 * Constructs a new branch with the given parameters.
	 *
	 * @param branch_name The name of the branch.
	 * @param Quota The staff quota for the branch.
	 * @param loc The location of the branch.
	 */
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

	/**
	 * Constructs a new branch with the given parameters.
	 *
	 * @param branch_name The name of the branch.
	 * @param Quota The staff quota for the branch.
	 * @param loc The location of the branch.
	 * @param Num The number of staff in the branch.
	 * @param NumofM The number of managers in the branch.
	 */
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

	/**
	 * Gets the staff quota of the branch.
	 *
	 * @return The staff quota of the branch.
	 */
	public int getStaffQuota() {
		return StaffQuota;
	}

	/**
	 * Sets the staff quota of the branch.
	 *
	 * @param StaffQuota The staff quota to set.
	 */
	public void setStaffQuota(int StaffQuota) {
		this.StaffQuota = StaffQuota;
	}

	/**
	 * Gets the location of the branch.
	 *
	 * @return The location of the branch.
	 */
	public String getLocation() {
		return this.Location;
	}

	/**
	 * Sets the location of the branch.
	 *
	 * @param location The new location of the branch.
	 */
	public void setLocation(String location) {
		Location = location;
	}

	/**
	 * Gets the name of the branch.
	 *
	 * @return The name of the branch.
	 */
	public String getBranchName() {
		return this.BranchName;
	}

	/**
	 * Verifies if the given branch name matches the name of this branch.
	 *
	 * @param BranchName The branch name to verify.
	 * @return true if the given branch name matches this branch's name, false otherwise.
	 */
	public boolean verifyBranchName(String BranchName) {
		if (this.BranchName.equals(BranchName)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the branch system managing operations in the branch.
	 *
	 * @return The branch system of the branch.
	 */
	public BranchSystem getBranchSystem() {
		return branchSystem;
	}

	/**
	 * Gets the number of staff currently in the branch.
	 *
	 * @return The number of staff in the branch.
	 */
	public int getNumberofStaffs() {
		return NumberofStaffs;
	}

	/**
	 * Gets the number of managers currently in the branch.
	 *
	 * @return The number of managers in the branch.
	 */
	public int getNumofManagers() {
		return NumofManagers;
	}

	/**
	 * Increments the number of managers in the branch.
	 */
	public void incrementManagerNum(){
		this.NumofManagers++;
	}

	/**
	 * Decrements the number of managers in the branch.
	 */
	public void decrementManagerNum(){
		this.NumberofStaffs--;
	}

	/**
	 * Verifies if the branch has reached its staff quota.
	 *
	 * @return true if the branch has not reached its staff quota, false otherwise.
	 */
	public boolean verifyBranchQuota(){
		int totalstaffs= (this.NumberofStaffs)+(this.NumofManagers);
		if(totalstaffs< this.StaffQuota){
			return true;
		}
		return false;
	}

	/**
	 * Increments the number of staff in the branch.
	 */
	public void incrementStaffNum(){
		this.NumberofStaffs++;
	}

	/**
	 * Decrements the number of staff in the branch.
	 */
	public void decrementStaffNum(){
		this.NumberofStaffs--;
	}
}
