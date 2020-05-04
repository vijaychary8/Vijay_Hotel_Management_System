package com.capgemini.hotelbookingapp.bean;

public class CustomerBean {

	private String userName;
	private String password;
	private String mailId;
	private long mobileNo;
	private long aadharNo;
	private String address;
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\nCustomerBean [ userName=" + userName + ", password=" + password + ", mailId=" + mailId + ", mobileNo="
				+ mobileNo + ", aadharNo=" + aadharNo + ", address=" + address + ", age=" + age + "]";
	}

}
