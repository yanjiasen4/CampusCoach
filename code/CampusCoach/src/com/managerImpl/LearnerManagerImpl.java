package com.managerImpl;

import java.util.List;

import com.dao.LearnerDAO;
import com.entity.Learner;
import com.entity.Page;
import com.manager.LearnerManager;

public class LearnerManagerImpl implements LearnerManager{
	
	private LearnerDAO learnerDao;

	public LearnerDAO getLearnerDao() {
		return learnerDao;
	}

	public void setLearnerDao(LearnerDAO learnerDao) {
		this.learnerDao = learnerDao;
	}

	public boolean regCheck(String username) {
		if(learnerDao.getLearnerByUsername(username)==null)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public int login(Learner learner) { // 0: learner; 1: coach; 2: not exist; 3: wrong password 4:other error 
		// TODO Auto-generated method stub
		if(learnerDao.getLearnerByUsername(learner.getUsername())==null){
			return 2;
		}
		else {
			Learner dlearner = learnerDao.getLearnerByUsername(learner.getUsername());
			if(dlearner.getPassword().equals(learner.getPassword())){
				if(dlearner.getIsCoach()==0){
					return 0;
				}
				else if(dlearner.getIsCoach()==1){
					return 1;
				}
			}
			else {
				return 3;
			}
		}
		return 4;
	}

	public boolean register(Learner learner) {
		if(regCheck(learner.getUsername())==false){
			return false;
		}
		else {
			learner.setIsCoach(0);
			learnerDao.insertLearner(learner);
			return true;
		}
	}

	public boolean setLearner2Coach(String username) {
		System.out.println("!@");
		Learner learner = learnerDao.getLearnerByUsername(username);
		System.out.println(learner.getLearnerID());
		if(learner.getIsCoach()==1){
			return false;
		}
		else {
			learner.setIsCoach(1);
			learnerDao.setLearner(learner);
			return true;
		}
	}

	public Learner getLearnerByLearnerID(int learnerID) {
		Learner learner = learnerDao.getLearnerByLearnerID(learnerID);
		return learner;
	}

	public Learner getLearnerByUsername(String username) {
		Learner learner = learnerDao.getLearnerByUsername(username);
		return learner;
	}

	public void updateAvatar(int learnerID, String fileFileName) {
		Learner learner = learnerDao.getLearnerByLearnerID(learnerID);
		learner.setAvatar(fileFileName);
		learnerDao.setLearner(learner);
	}

	public boolean updateInfo(int learnerID, String phoneNumber, String realName) {
		Learner learner = learnerDao.getLearnerByLearnerID(learnerID);
		if(learner != null) {
			learner.setPhoneNumber(phoneNumber);
			learner.setRealName(realName);
			learnerDao.setLearner(learner);
			return true;
		}
		else {
			return false;
		}
	}

	public List<Learner> getAllLearners() {
		return learnerDao.getLearners();
	}

	public Page getRankPage(int pageSize, int page) {
		int offset = page*pageSize;
		int length = pageSize;
		int allRow = learnerDao.getAllRows();
		System.out.println("!");
		System.out.println(allRow);
		int allPage = Page.countTotalPage(pageSize, allRow);
		System.out.println(allPage);
		final int currentPage = Page.countCurrentPage(page);
		List<Learner> list = learnerDao.queryLearnerByPage(offset, length);
		int i = 0;
		for(Learner tmp:list) {
			tmp.setRank(currentPage*pageSize+i-1);
			i++;
		}
		Page pg = new Page();
		pg.setPageSize(pageSize);
		pg.setCurrentPage(currentPage);
		pg.setAllRow(allRow);
		pg.setAllPage(allPage);
		pg.setList(list);
		pg.init();
		return pg;	
	}

}
