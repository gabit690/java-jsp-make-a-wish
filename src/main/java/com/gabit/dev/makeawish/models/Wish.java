package com.gabit.dev.makeawish.models;

public class Wish {

    private int id;

    private String username;

    private String title;

    private String content;

    private int score;

    private boolean deleted;

    public Wish(int id, String username, String title, String content, int score, boolean deleted) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.score = score;
        this.deleted = deleted;
    }

    public Wish(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", deleted=" + deleted +
                '}';
    }
}
