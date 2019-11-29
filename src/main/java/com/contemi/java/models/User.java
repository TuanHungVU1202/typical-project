package com.contemi.java.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class User {
	@Id
    @Column(name="id")
    private Long employeeId;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;

}
