package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class ListAuthor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Column(name="AUTHOR_ID")
	private int id;
	@Column(name="AUTHOR_NAME")
	private String authorName;

public ListAuthor() {}
/**
 * @param authorName
 */
public ListAuthor(String authorName) {
	this.authorName = authorName;
}
/**
 * @param authorId
 * @param authorName
 */
public ListAuthor(int id, String authorName) {
	this.id = id;
	this.authorName = authorName;
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
 * @return the authorName
 */
public String getAuthorName() {
	return authorName;
}
/**
 * @param authorName the authorName to set
 */
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}

public String toString() {
	return authorName;
}





}
