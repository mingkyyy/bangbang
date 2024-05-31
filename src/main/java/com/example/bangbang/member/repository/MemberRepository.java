package com.example.bangbang.member.repository;

import com.example.bangbang.member.domain.LoginType;
import com.example.bangbang.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, LoginType> {
}
