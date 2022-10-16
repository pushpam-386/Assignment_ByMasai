package com.push.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private Boolean status;
	private enum priority {
        High,
        Medium,
        Low;
    }
	private int assigned_employee_id;
	private Date startDate;
	private Date deadline;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;

}
