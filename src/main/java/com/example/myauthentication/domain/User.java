package com.example.myauthentication.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Users")
public class User {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String company;
    @Column
    private String position;



}
