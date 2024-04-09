package Management;

import java.util.*;

public class AdminAccount extends Account {

	Collection<StaffAccount> staff;
	Collection<ManagerAccount> Manager;

	/**
	 * 
	 * @param ID
	 * @param Branch
	 */
	public boolean assignManager(String ID, String Branch) {

	}

	/**
	 * 
	 * @param ID
	 */
	public void Promote(String ID) {

	}

	/**
	 * 
	 * @param ID
	 * @param Branch
	 */
	public boolean transferStaff(String ID, String Branch) {

	}

	/**
	 * 
	 * @param BranchManagement
	 */
	public void ManageBranch(BranchManagement BranchManagement) {

	}

	/**
	 * 
	 * @param StaffAccManagement
	 */
	public void ManagesStaff(StaffAccManagement StaffAccManagement) {
		// TODO - implement Admin.ManagesStaff
		throw new UnsupportedOperationException();
	}

}