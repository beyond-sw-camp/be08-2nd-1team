package com.beyond.kkwoborrow.reservation.entity;

import com.beyond.kkwoborrow.posts.entity.Posts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private long reserveId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts postId;

    public long getReserveID() {
        return reserveId;
    }
}
