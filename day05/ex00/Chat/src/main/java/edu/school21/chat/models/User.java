package edu.school21.chat.models;

import java.util.List;

public class User {

    private Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> chatRooms;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setChatRooms(List<Chatroom> chatRooms) {
        this.chatRooms = chatRooms;
    }

    public List<Chatroom> getChatRooms() {
        return chatRooms;
    }

}
