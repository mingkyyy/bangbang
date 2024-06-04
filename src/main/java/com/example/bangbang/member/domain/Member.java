package com.example.bangbang.member.domain;

import com.example.bangbang.common.domain.BaseTimeEntity;
import com.example.bangbang.room.domain.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

    @OneToMany(mappedBy= "createMember", cascade = CascadeType.ALL)
    private List<Room> RoomList = new ArrayList<>();

    public void findName(String name){
        this.name = name;
    }
}
