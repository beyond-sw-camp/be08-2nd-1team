package com.beyond.kkwoborrow.reservation.entity;

import com.beyond.kkwoborrow.post.entity.Posts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReserveID")
    private long reserveId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PostID")
    private Posts postId;

    public long getReserveID() {
        return reserveId;
    }
}
