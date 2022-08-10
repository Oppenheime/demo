package com.example.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Book{

    private int id;
    private String name;
    private String author;
    private String intro;
    private double price;
    private String bookimg;

    public Book(){

    }

  public Book(int id, String name, String author, String intro, double price, String bookimg) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.intro = intro;
    this.price = price;
    this.bookimg = bookimg;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBookimg() {
    return bookimg;
  }

  public void setBookimg(String bookimg) {
    this.bookimg = bookimg;
  }
}
