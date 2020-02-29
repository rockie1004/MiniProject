package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class ListBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")	
	private int id;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) 
 	@JoinColumn(name="AUTHOR_ID")
	private ListAuthor author;
	@Column(name="TITLE")
	private String title;
	@Column(name="LAST_READ")
	private LocalDate lastRead;

public ListBook() {}


/**
 * @param author
 * @param title
 */
public ListBook(ListAuthor author, String title) {
	this.author = author;
	this.title = title;
}

/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the author
 */
public ListAuthor getAuthor() {
	return author;
}
/**
 * @param author the author to set
 */
public void setAuthor(ListAuthor author) {
	this.author = author;
}
/**
 * @return the title
 */
public String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}

/**
 * @return the lastRead
 */
public LocalDate getLastRead() {
	return lastRead;
}

/**
 * @param lastRead the lastRead to set
 */
public void setLastRead(LocalDate lastRead) {
	this.lastRead = lastRead;
}


public String toString() {
	return title + " by " + author.getAuthorName();
}




}
