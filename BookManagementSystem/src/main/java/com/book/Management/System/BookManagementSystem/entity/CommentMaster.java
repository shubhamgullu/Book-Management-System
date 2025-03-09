package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment_master")
@Data
public class CommentMaster extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;

    @Column(name = "ratting")
    private Long rating;

    @Column(name = "comment")
    private String comment;

}
