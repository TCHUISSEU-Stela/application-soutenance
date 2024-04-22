package com.credixs.subscription.repository;

import com.credixs.subscription.model.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByPhoneNumber(String phoneNumber);
}
