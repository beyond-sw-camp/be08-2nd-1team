package com.beyond.kkwoborrow.reservation.entity;

import com.beyond.kkwoborrow.post.entity.Posts;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReserveID")
    private long reserveId;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "PostID")
    @Column(name = "PostID")
    private Posts postId;
}
