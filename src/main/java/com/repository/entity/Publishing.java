package com.repository.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishing")
public class Publishing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_publishing")
    private String namePublishing;

    @ManyToMany(mappedBy = "publishing")
    private List<Books> booksList;

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePublishing() {
        return namePublishing;
    }

    public void setNamePublishing(String namePublishing) {
        this.namePublishing = namePublishing;
    }

    @Override
    public String toString() {
        return "Publishing{" +
                "id=" + id +
                ", namePublishing='" + namePublishing + '\'' +
                '}';
    }
}
