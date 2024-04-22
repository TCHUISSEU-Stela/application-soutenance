package com.credixs.subscription.service.interfaces;

import com.credixs.subscription.model.dto.SubscriptionDto;
import com.credixs.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {

    String subscribe(String phoneNumber,Long parentId, Long eleveId);
    boolean isEleveSubscribed(String phoneNumber);
}
