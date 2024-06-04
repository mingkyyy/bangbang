package com.example.bangbang.room.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="roomBasic")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoomBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Room room; //방

    private int roomSize; //방 평수

    private int roomCount; //방 개수

    private int bathroomCount; // 화장실 개수

    private boolean parking; // 주차 여부

    private int floor; // 층수

    private String structure; //집 종류(아파트, 빌라, 오피스텔)

    private LocalDate yearBuilt; // 건축 년도

}
