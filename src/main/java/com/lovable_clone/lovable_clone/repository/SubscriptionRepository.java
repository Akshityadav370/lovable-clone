package com.lovable_clone.lovable_clone.repository;

import com.lovable_clone.lovable_clone.dto.subscription.SubscriptionResponse;
import com.lovable_clone.lovable_clone.entity.Subscription;
import com.lovable_clone.lovable_clone.entity.type.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    /*
    *
    * Get the current active subscription
     */
    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> statusSet);

    boolean existsByStripeSubscriptionId(String subscriptionId);

    Optional<Subscription> findByStripeSubscriptionId(String gatewaySubscriptionId);
}