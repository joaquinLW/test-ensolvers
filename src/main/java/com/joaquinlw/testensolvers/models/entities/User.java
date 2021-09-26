package com.joaquinlw.testensolvers.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String username;

	private String password;

	/*
	 * @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) private List<Folder> folders;
	 */

	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	public User() {
		//this.folders = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/*
	 * public List<Folder> getFolders() { return folders; }
	 * 
	 * public void setFolders(List<Folder> folders) { this.folders = folders; }
	 * 
	 * public void addFolder(Folder folder) { this.folders.add(folder); }
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
