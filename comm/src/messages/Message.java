package messages;

import java.util.Date;

import comm.UserID;

public class Message {
	private int type;
	private String body;
	private UserID author;
	private Date datetime;
	public Message(int type, String body, UserID author)
	{
		this.setType(type);
		this.setBody(body);
		this.setAuthor(author);
		//get current date time with Date()
		this.setDatetime(new Date());
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public UserID getAuthor() {
		return author;
	}
	public void setAuthor(UserID author) {
		this.author = author;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	

}
