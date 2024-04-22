package com.credixs.subscription.service.implementation;

import com.credixs.subscription.mapper.SubscriptionMapper;
import com.credixs.subscription.model.dto.SubscriptionDto;
import com.credixs.subscription.model.entity.Subscription;
import com.credixs.subscription.repository.SubscriptionRepository;
import com.credixs.subscription.service.interfaces.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscriptionImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public String subscribe(String phoneNumber, Long parentId, Long studentId) {
        // Vérifier si l'étudiant est déjà inscrit
        boolean isSubscribed = isEleveSubscribed(phoneNumber);
        if (isSubscribed) {
            return "Vous êtes déjà inscrit !";
        }

        // Récupérer l'étudiant existant
        Subscription existingEleve = subscriptionRepository.findByPhoneNumber(phoneNumber);
        if (existingEleve != null) {
            // Mapper les informations pour l'abonnement
            SubscriptionDto subscriptionDTO = subscriptionMapper.toDto(existingEleve);
            subscriptionDTO.setId_parent(parentId);
            subscriptionDTO.setId_eleve(studentId);

            // Enregistrer l'abonnement dans la base de données (supposons que vous avez une méthode saveSubscription dans SubscriptionRepository)
            subscriptionRepository.save(subscriptionMapper.toEntity(subscriptionDTO));

            return "Inscription réussie !";
        } else {
            return "L'étudiant n'existe pas dans la base de données.";
        }
    }


    @Override
    public boolean isEleveSubscribed(String phoneNumber) {
        Subscription existingSubscription = subscriptionRepository.findByPhoneNumber(phoneNumber);
        return existingSubscription != null && existingSubscription.isSubscribed();
    }
}
