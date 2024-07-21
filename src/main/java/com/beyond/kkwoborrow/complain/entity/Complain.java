package com.beyond.kkwoborrow.complain.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComplainID")
    private long complainID;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users userID;
}
