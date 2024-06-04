package com.example.bangbang.room.domain;

import com.example.bangbang.common.domain.BaseTimeEntity;
import com.example.bangbang.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="room")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Room extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title; //제목

    @NonNull
    private String content; // 내용

    @ManyToOne
    private Member createMember; // 작성자

    @OneToOne
    private RoomBasic roomBasic; // 방 기본 정부

    @OneToMany(mappedBy = "imageToRoom", cascade = CascadeType.ALL)
    private List<RoomImage> roomImageList; // 이미지
}
