package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="GARBAGE_CARTS")
public class GarbageCarts implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName="srn")
    private Complaint complaint;
	

	@Column(name = "BLACK_CARTS_DELIEVRED")
	private int blackCartsDelivered;

	@Column(name = "CURRENT_ACTIVITY" , length = 200)
	private String currentActivity;
	
	@Column(name = "MOST_RECENT_ACTION" , length = 200)
	private String mostRecentAction;

	@Column(name = "SSA" , length = 200)
	private String ssa;

	public GarbageCarts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GarbageCarts(final int id, final Complaint complaint, final int blackCartsDelivered, final String currentActivity,
			final String mostRecentAction, final String ssa) {
		super();
		this.id = id;
		this.complaint = complaint;
		this.blackCartsDelivered = blackCartsDelivered;
		this.currentActivity = currentActivity;
		this.mostRecentAction = mostRecentAction;
		this.ssa = ssa;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(final Complaint complaint) {
		this.complaint = complaint;
	}

	public int getBlackCartsDelivered() {
		return blackCartsDelivered;
	}

	public void setBlackCartsDelivered(final int blackCartsDelivered) {
		this.blackCartsDelivered = blackCartsDelivered;
	}

	public String getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(final String currentActivity) {
		this.currentActivity = currentActivity;
	}

	public String getMostRecentAction() {
		return mostRecentAction;
	}

	public void setMostRecentAction(final String mostRecentAction) {
		this.mostRecentAction = mostRecentAction;
	}

	public String getSsa() {
		return ssa;
	}

	public void setSsa(final String ssa) {
		this.ssa = ssa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GarbageCarts [id=" + id + ", complaint=" + complaint + ", blackCartsDelivered=" + blackCartsDelivered
				+ ", currentActivity=" + currentActivity + ", mostRecentAction=" + mostRecentAction + ", ssa=" + ssa
				+ "]";
	}
}