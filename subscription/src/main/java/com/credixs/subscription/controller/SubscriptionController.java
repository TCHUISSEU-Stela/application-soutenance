package com.credixs.subscription.controller;

import com.credixs.subscription.model.entity.Subscription;
import com.credixs.subscription.service.interfaces.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditscolaire/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribeStudent(@RequestBody Subscription request) {
        String result = subscriptionService.subscribe(request.getPhoneNumber(), request.getId_parent(), request.getId_eleve());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/checkSubscription/{phoneNumber}")
    public ResponseEntity<String> checkStudentSubscription(@PathVariable String phoneNumber) {
        boolean isSubscribed = subscriptionService.isEleveSubscribed(phoneNumber);
        if (isSubscribed) {
            return ResponseEntity.ok("L'étudiant est déjà abonné !");
        } else {
            return ResponseEntity.ok("L'étudiant n'est pas encore abonné.");
        }
    }
}