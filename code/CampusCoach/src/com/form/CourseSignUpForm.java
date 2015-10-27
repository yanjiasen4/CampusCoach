package com.form;

import com.entity.CourseSignUp;

// Ϊ���ݿ��coursesignup�������ԣ�����ǰ����ҳʹ��
public class CourseSignUpForm {
	
	private CourseSignUp courseSignUp;
	private String realName;    //�û���ʵ����
	private String phoneNumber; //�û���ϵ��ʽ
	private String username;    //�û��˺�����
	
	public CourseSignUpForm(CourseSignUp courseSignUp, String realName, 
			                String phoneNumber, String username) {
		this.courseSignUp = courseSignUp;
		this.realName = realName;
		this.phoneNumber = phoneNumber;
		this.username = username;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CourseSignUp getCourseSignUp() {
		return courseSignUp;
	}
	public void setCourseSignUp(CourseSignUp courseSignUp) {
		this.courseSignUp = courseSignUp;
	}
	
}
