package com.beyond.kkwoborrow.complain.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complain_id")
    private long complainID;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userID;
}
