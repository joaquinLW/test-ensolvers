package com.joaquinlw.testensolvers.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "items")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	private String name;

	private boolean done;

	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="folder_id", referencedColumnName = "id", nullable=false)
	 @JsonBackReference
	 private Folder folder;

	@Column(name = "createdAt")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdAt;

//	@Column(name="folder_id")
//	private long folderId;

	public Item() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public long getFolderId() { return folderId; }
	 * 
	 * public void setFolderId(long folderId) { this.folderId = folderId; }
	 */

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	  public Folder getFolder() { return folder; }
	  
	  public void setFolder(Folder folder) { this.folder = folder; }
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
		done = false;
	}

}
