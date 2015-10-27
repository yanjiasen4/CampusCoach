package com.managerImpl;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import com.Message.Message;
import com.dao.CoachDAO;
import com.dao.ReservationDAO;
import com.dao.ReservationReceiveDAO;
import com.entity.Coach;
import com.entity.Reservation;
import com.manager.ReservationManager;

public class ReservationManagerImpl implements ReservationManager{
	
	private ReservationDAO reservationDao;
	private CoachDAO coachDao;
	private ReservationReceiveDAO reservationReceiveDao;
	public ReservationDAO getReservationDao() {
		return reservationDao;
	}
	public void setReservationDao(ReservationDAO reservationDao) {
		this.reservationDao = reservationDao;
	}
	public ReservationReceiveDAO getReservationReceiveDao() {
		return reservationReceiveDao;
	}
	public void setReservationReceiveDao(ReservationReceiveDAO reservationReceiveDao) {
		this.reservationReceiveDao = reservationReceiveDao;
	}
	
	public boolean addReservation(Reservation reservation) {
		reservation.setStateFlag(0);
		reservationDao.insertReservation(reservation);
		return true;
	}
	
	public List<Reservation> getAllReservation() {
		return reservationDao.getReservationNow(reservationDao.getReservations());
	}
	
	
	public boolean receive(int reservationID, int coachID, String coachName) {
		if(hasReceived(reservationID)){
			return false;
		}
		if(reservationReceiveDao.insertReservationReceive(reservationID, coachID, coachName)){
			//���Ͷ���֪ͨ
			Reservation re = reservationDao.getReservationByReservationID(reservationID);
			String reservationName = re.getReservationName();
			Coach ch = coachDao.getCoachByCoachID(coachID);
			String chName = ch.getRealname();
			String chPhone = ch.getPhoneNumber();
			String text = "��У԰����ƽ̨���װ����û�����"+reservationName+"�������ѱ�����"+chName+"���ܣ�"+chName+"����ϵ��ʽΪ"+chPhone+"���ش�֪ͨ��";
			String phone = re.getLearnerPhone();
			if (phone == null)
				return true;
			try {
				Message.sendSms(text, phone);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean hasReceived(int reservationID) {
		if(reservationReceiveDao.getReservationReceiveByReservationID(reservationID)==null)
		{
			return false;
		}
		else {
			return true;
		}
	}
	public List<Reservation> getNowReservation(List<Reservation> reservationSet) {
		if(reservationSet != null && !reservationSet.isEmpty()){
			List<Reservation> result = new ArrayList<Reservation>();
			for(Reservation tmp:reservationSet){
				if(tmp.getStateFlag()==1){
					result.add(tmp);
				}
			}
			return result;
		}
		return null;
	}
	public List<Reservation> getUserReservation(int learnerID) {
		return reservationDao.getReservationByLearnerID(learnerID);
	}
	public CoachDAO getCoachDao() {
		return coachDao;
	}
	public void setCoachDao(CoachDAO coachDao) {
		this.coachDao = coachDao;
	}

}
