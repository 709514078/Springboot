package com.example.demo2.entity;

public class Bgm {
    private String id;
    private String author;
    private String name;
    private String path;

    public static final String CONTENT_TYPE_FROMED = "application/x-www-form-urlencoded";
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Bgm{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
