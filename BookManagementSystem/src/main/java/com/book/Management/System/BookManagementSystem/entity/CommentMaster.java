package com.book.Management.System.BookManagementSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment_master")
public class CommentMaster extends BaseEntity {
//    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;

    @Column(name = "ratting", nullable = false)
    private Long rating;

    @Column(name = "comment", nullable = false)
    private String comment;

}
