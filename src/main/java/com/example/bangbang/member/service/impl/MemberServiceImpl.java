package com.example.bangbang.member.service.impl;

import com.example.bangbang.member.domain.Member;
import com.example.bangbang.member.service.MemberService;
import com.example.bangbang.member.service.MemberUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    public void login(Member member) {
        MemberUser user = new MemberUser(member);

        // 유저 정보를 담은 인증 토큰 생성
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        user,
                        user.getAuthorities()
                );

        // 인증 토큰을 SecurityContext 에 저장. <~ 로그인 되었다!
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(token);
    }
}
