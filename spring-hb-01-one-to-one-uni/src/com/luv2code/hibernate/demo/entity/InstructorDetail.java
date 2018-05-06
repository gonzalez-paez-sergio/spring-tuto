package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// annotate the class as an entoty an map to db table
	// define the fields
	// annotate the fields with db columns names
	// create constructor
	// generate getter setter
	// generate toString method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youTubeChannel;

	@Column(name = "hobby")
	private String hobby;

	public InstructorDetail(String youTubeChannel, String hobby) {
		this.youTubeChannel = youTubeChannel;
		this.hobby = hobby;
	}

	public InstructorDetail() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the youTubeChannel
	 */
	public String getYouTubeChannel() {
		return youTubeChannel;
	}

	/**
	 * @param youTubeChannel
	 *            the youTubeChannel to set
	 */
	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}

	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * @param hobby
	 *            the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby + "]";
	}

}
