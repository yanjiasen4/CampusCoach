package com.manager;

import java.util.List;

import com.entity.Learner;
import com.entity.Page;

public interface LearnerManager {
	
	public boolean regCheck(String username); // return 1: new user; return 2: old user 
	public int login(Learner learner); // return 0: success; 1 username not exist; 2 error password
	public boolean register(Learner learner);
	public boolean setLearner2Coach(String username);
	public List<Learner> getAllLearners();
	public Page getRankPage(int pageSize, int page);
	public Learner getLearnerByLearnerID(int learnerID);
	public Learner getLearnerByUsername(String username);
	public void updateAvatar(int learnerID, String fileFileName);
	public boolean updateInfo(int learnerID, String phoneNumber, String realName);

}
	