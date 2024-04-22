package com.credixs.subscription.model.entity;

import com.credix.creditscolaire.model.entity.Eleve;
import com.credix.creditscolaire.model.entity.Parent;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;
    private String phoneNumber;

    private Long id_parent;
    private Long id_eleve;
    private boolean isSubscribed;

//    private double amount;
//    private String status;

    @ManyToOne
    private Parent parent;

    @OneToOne
    private Eleve eleve;
}
