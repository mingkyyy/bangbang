package com.example.bangbang.member.domain;

import com.example.bangbang.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(name="member")
@Getter
public class Member  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(unique = true)
    private String email;

    @NonNull
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @NonNull
    @Enumerated(EnumType.STRING)
    private MemberType memberType;


}
