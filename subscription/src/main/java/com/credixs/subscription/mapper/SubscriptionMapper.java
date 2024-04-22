package com.credixs.subscription.mapper;

import com.credixs.subscription.model.dto.SubscriptionDto;
import com.credixs.subscription.model.entity.Subscription;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubscriptionMapper {

    public SubscriptionDto toDto(Subscription subscription) {
        SubscriptionDto dto = new SubscriptionDto();
        dto.setId(subscription.getId());
        dto.setDate(subscription.getDate());
        dto.setId_eleve(subscription.getId_eleve()); // Récupération de l'ID de l'eleve
        dto.setId_parent(subscription.getId_parent()); // Récupération de l'ID du parent
        return dto;
    }

    public Subscription toEntity(SubscriptionDto dto) {
        Subscription subscription = new Subscription();
        subscription.setId(dto.getId());
        subscription.setDate(dto.getDate());
        subscription.setId_eleve(dto.getId_eleve());
        subscription.setId_parent(dto.getId_parent());
        // Dans cette méthode, vous devrez probablement ignorer les attributs id_ecole et id_parent car vous ne pouvez pas créer des entités Ecole et Parent à partir de simples identifiants.
        return subscription;
    }


    public void updateFromDto(SubscriptionDto dto, Subscription entity) {
        // Mise à jour des propriétés de l'entité à partir du DTO
        entity.setId(dto.getId());
        entity.setId_eleve(dto.getId_eleve());
        entity.setId_parent(dto.getId_parent());
        // Autres propriétés à mettre à jour si nécessaire
    }

    public List<SubscriptionDto> toDtoList(List<Subscription> Subscriptions) {
        return Subscriptions.stream().map(this::toDto).collect(Collectors.toList());
    }
}
