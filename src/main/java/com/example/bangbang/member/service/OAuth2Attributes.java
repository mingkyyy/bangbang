package com.example.bangbang.member.service;

import com.example.bangbang.member.domain.LoginType;
import com.example.bangbang.member.domain.Member;

import com.example.bangbang.member.domain.MemberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class OAuth2Attributes {
    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String name;
    private final String email;
    private final LoginType loginType;
    private final MemberType memberType;



    public static OAuth2Attributes of(String registeredId, String userNameAttributeName, Map<String, Object> attributes) {
        if ("naver".equals(registeredId)) {
            return ofNaver("id", attributes);
        }
        if ("kakao".equals(registeredId)){
            return ofKakao("id",attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }


    private static OAuth2Attributes ofNaver(String id, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuth2Attributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .loginType(LoginType.NAVER)
                .attributes(response)
                .nameAttributeKey(id)
                .build();
    }

    private static OAuth2Attributes ofGoogle(String id, Map<String, Object> attributes) {
        return OAuth2Attributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .loginType(LoginType.GOOGLE)
                .attributes(attributes)
                .nameAttributeKey(id)
                .build();
    }

    private static OAuth2Attributes ofKakao(String id, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return OAuth2Attributes.builder()
                .email((String) kakaoAccount.get("email"))
                .name((String) kakaoProfile.get("nickname"))
                .loginType(LoginType.KAKAO)
                .attributes(attributes)
                .nameAttributeKey(id)
                .build();
    }


    public Member toMember(){
        return Member.builder()
                .email(email)
                .name(name)
                .loginType(loginType)
                .memberType(MemberType.GENERAL)
                .build();
    }
}
