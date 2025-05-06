package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CF_EMPLOYEE")
public class CFEmployeeEntity {

	@Id
	@Column(name = "EMP_NO") // 設定對應的欄位名稱
	private String empNo;

	@Column(name = "EMP_NAME") // 設定對應的欄位名稱
	private String empName;

	@Column(name = "ON_JOB") // 設定對應的欄位名稱
	private String onJob;

	@Column(name = "EMAIL") // 設定對應的欄位名稱
	private String email;

	@Column(name = "L2A_EMPNO") // 設定對應的欄位名稱
	private String l2aEmpno;

	@Column(name = "L2B_EMPNO") // 設定對應的欄位名稱
	private String l2bEmpno;

	@Column(name = "ASSIGN_STOP") // 設定對應的欄位名稱
	private String assignStop;

	@Column(name = "EMP_ID") // 設定對應的欄位名稱
	private String empId;

	@Column(name = "GROUP_LEVEL") // 設定對應的欄位名稱
	private String groupLevel;

	/**
	 * @return the empName
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the onJob
	 */
	public String getOnJob() {
		return onJob;
	}

	/**
	 * @param onJob the onJob to set
	 */
	public void setOnJob(String onJob) {
		this.onJob = onJob;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the l2aEmpno
	 */
	public String getL2aEmpno() {
		return l2aEmpno;
	}

	/**
	 * @param l2aEmpno the l2aEmpno to set
	 */
	public void setL2aEmpno(String l2aEmpno) {
		this.l2aEmpno = l2aEmpno;
	}

	/**
	 * @return the l2bEmpno
	 */
	public String getL2bEmpno() {
		return l2bEmpno;
	}

	/**
	 * @param l2bEmpno the l2bEmpno to set
	 */
	public void setL2bEmpno(String l2bEmpno) {
		this.l2bEmpno = l2bEmpno;
	}

	/**
	 * @return the assignStop
	 */
	public String getAssignStop() {
		return assignStop;
	}

	/**
	 * @param assignStop the assignStop to set
	 */
	public void setAssignStop(String assignStop) {
		this.assignStop = assignStop;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the groupLevel
	 */
	public String getGroupLevel() {
		return groupLevel;
	}

	/**
	 * @param groupLevel the groupLevel to set
	 */
	public void setGroupLevel(String groupLevel) {
		this.groupLevel = groupLevel;
	}

}
