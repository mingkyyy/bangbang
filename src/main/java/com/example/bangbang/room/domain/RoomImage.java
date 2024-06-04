package com.example.bangbang.room.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="roomImage")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoomImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String imageName;

    @NonNull
    private String imagePath;

    @ManyToOne
    private Room imageToRoom;
}
