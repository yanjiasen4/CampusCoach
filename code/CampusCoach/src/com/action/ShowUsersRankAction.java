package com.action;

import java.util.List;
import java.util.Map;

import com.entity.Learner;
import com.manager.LearnerManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUsersRankAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1634551265249276841L;
	
	private List<Learner> learners;
	private LearnerManager learnerManager;
	private int pageSize;
	private int page;
	
	public List<Learner> getLearners() {
		return learners;
	}

	public void setLearners(List<Learner> learners) {
		this.learners = learners;
	}

	public LearnerManager getLearnerManager() {
		return learnerManager;
	}

	public void setLearnerManager(LearnerManager learnerManager) {
		this.learnerManager = learnerManager;
	}
	
	public String execute() {
		learners = learnerManager.getRankPage(pageSize, page);
		return SUCCESS;
	}
	
	public String executeMyRank() {
		execute();
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("user");
        for(Learner tmp:learners) {
        	if(tmp.getUsername().equals(username)) {
        		break;
        	} else {
        	}
        }
        learnerManager.getLearnerByUsername(username);
		return SUCCESS;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
