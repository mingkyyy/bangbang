package com.example.bangbang.member.service;

import com.example.bangbang.member.domain.Member;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class MemberUser extends User {
    private final Member member;

    public MemberUser(Member member){
        super(member.getEmail(),
                member.getName(),
                List.of(new SimpleGrantedAuthority(member.getMemberType().name()))
        );

        this.member = member;
    }

    @Override
    public String getUsername() {
        return member.getName();
    }
}
