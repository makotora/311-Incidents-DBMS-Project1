package com.incidents.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ForeignKey;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.easynotes.enumerations.TypeOfServiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ALLEY_LIGHTS_OUT")
public class AlleyLightsOut implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName="srn")
    private Complaint complaint;

	public AlleyLightsOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlleyLightsOut(int id, Complaint complaint) {
		super();
		this.id = id;
		this.complaint = complaint;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AlleyLightsOut [id=" + id + ", complaint=" + complaint + "]";
	}
	
	
}
