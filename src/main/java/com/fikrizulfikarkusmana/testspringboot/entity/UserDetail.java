package com.fikrizulfikarkusmana.testspringboot.entity;

import com.fikrizulfikarkusmana.testspringboot.converter.StringAttributeConverter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_users")
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200, nullable = false)
    private String username;
    @Column(length = 200, nullable = false)
    private String email;
    @Convert(converter = StringAttributeConverter.class )
    @Column(length = 200, nullable = false)
    private String password;
    @Column(length = 200, nullable = false)
    private String nama;
}
