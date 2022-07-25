package edu.school21.chat.models;

import java.time.LocalDateTime;

public class Message {

    private Long id;
    private User author;
    private Chatroom chatroom;
    private String text;
    private LocalDateTime dateTime;

    public Message(Long id, User author, Chatroom chatroom, String text, LocalDateTime dateTime) {
        this.id = id;
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
        this.dateTime = dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        return "Message : {\n" +
                "id=" + this.id + ",\n" +
                "author=" + author.toString() + ",\n" +
                "room=" + chatroom.toString() + ",\n" +
                "text=" + text + ",\n" +
                "dateTime=" + dateTime;

    }
}

