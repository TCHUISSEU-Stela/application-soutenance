package com.credixs.subscription.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {
    private Long id;
    private Date date;
    private String phoneNumber;
    private Long id_parent;
    private Long id_eleve;
    private boolean isSubscribed;
//    private double amount;
//    private String status;

}
