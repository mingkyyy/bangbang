package com.example.bangbang.member.service;

import com.example.bangbang.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    public void login(Member member);
}
