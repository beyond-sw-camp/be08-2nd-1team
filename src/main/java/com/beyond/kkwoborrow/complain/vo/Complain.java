package com.beyond.kkwoborrow.complain.vo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Complain {
    @Id
    @Column(name = "ComplainID")
    private int complainID;

    @NotNull
    private int userID;
}
