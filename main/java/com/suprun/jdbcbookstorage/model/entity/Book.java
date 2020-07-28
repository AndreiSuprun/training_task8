package com.suprun.jdbcbookstorage.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {

     private int id;
     private String name;
     private List<String> authors;
     private String publisher;
     private int publishYear;
     private int pageQuantity;

     public Book(String name, List<String> authors, String publisher, int publishYear, int pageQuantity) {
          this.name = name;
          this.authors = authors;
          this.publisher = publisher;
          this.publishYear = publishYear;
          this.pageQuantity = pageQuantity;
     }

     public Book(int id, String name, List<String> authors, String publisher, int publishYear, int pageQuantity) {
          this(name, authors, publisher, publishYear, pageQuantity);
          this.id = id;
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

     public List<String> getAuthors() {
          return authors;
     }

     public void setAuthors(List<String> authors) {
          this.authors = authors;
     }

     public String getPublisher() {
          return publisher;
     }

     public void setPublisher(String publisher) {
          this.publisher = publisher;
     }

     public int getPublishYear() {
          return publishYear;
     }

     public void setPublishYear(int publishYear) {
          this.publishYear = publishYear;
     }

     public int getPageQuantity() {
          return pageQuantity;
     }

     public void setPageQuantity(int pageQuantity) {
          this.pageQuantity = pageQuantity;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) {
               return true;
          }
          if (o == null || getClass() != o.getClass()) {
               return false;
          }
          Book book = (Book) o;
          if (name != null ? !name.equals(book.name) : book.name != null) {
               return false;
          }
          if (publishYear != book.publishYear) {
               return false;
          }
          if (pageQuantity != book.pageQuantity) {
               return false;
          }
          if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null){
               return false;
          }
          return authors != null ? authors.equals(book.authors) : book.authors == null;
     }

     @Override
     public int hashCode() {
          int result = name != null ? name.hashCode() : 0;
          result = 31 * result + (authors != null ? authors.hashCode() : 0);
          result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
          result = 31 * result + publishYear;
          result = 31 * result + pageQuantity;
          return result;
     }

     @Override
     public String toString() {
          final StringBuilder sb = new StringBuilder("Book{");
          sb.append("id=").append(id);
          sb.append(", name= ").append(name);
          sb.append(", authors= ").append(authors);
          sb.append(", publisher= ").append(publisher);
          sb.append(", publishYear= ").append(publishYear);
          sb.append(", pageQuantity= ").append(pageQuantity);
          sb.append('}');
          return sb.toString();
     }
}