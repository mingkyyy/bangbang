package com.example.bangbang.member.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.bangbang.member.domain.LoginType;
import com.example.bangbang.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, LoginType> {
    Optional<Member> findByEmail(String email);
}
