package com.koroupware.message.domain;

public class MessageVO {
	private int message_no;
	private int message_sender_no;
	private int message_receiver_no;
	private String message_contents;
	private String message_senddate;
	private String message_deldate;
	private String message_sender_name;
	private String message_receiver_name;
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public int getMessage_sender_no() {
		return message_sender_no;
	}
	public void setMessage_sender_no(int message_sender_no) {
		this.message_sender_no = message_sender_no;
	}
	public int getMessage_receiver_no() {
		return message_receiver_no;
	}
	public void setMessage_receiver_no(int message_receiver_no) {
		this.message_receiver_no = message_receiver_no;
	}
	public String getMessage_contents() {
		return message_contents;
	}
	public void setMessage_contents(String message_contents) {
		this.message_contents = message_contents;
	}
	
	public String getMessage_senddate() {
		return message_senddate;
	}
	public void setMessage_senddate(String message_senddate) {
		this.message_senddate = message_senddate;
	}
	public String getMessage_deldate() {
		return message_deldate;
	}
	public void setMessage_deldate(String message_deldate) {
		this.message_deldate = message_deldate;
	}
	
	
	public String getMessage_sender_name() {
		return message_sender_name;
	}
	public void setMessage_sender_name(String message_sender_name) {
		this.message_sender_name = message_sender_name;
	}
	public String getMessage_receiver_name() {
		return message_receiver_name;
	}
	public void setMessage_receiver_name(String message_receiver_name) {
		this.message_receiver_name = message_receiver_name;
	}
	@Override
	public String toString() {
		return "MessageVO [message_no=" + message_no + ", message_sender_no=" + message_sender_no
				+ ", message_receiver_no=" + message_receiver_no + ", message_contents=" + message_contents
				+ ", message_senddate=" + message_senddate + ", message_deldate=" + message_deldate
				+ ", message_sender_name=" + message_sender_name + ", message_receiver_name=" + message_receiver_name
				+ "]";
	}
	
	
	
}
