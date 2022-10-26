package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.RealmModel;
import org.hibernate.cache.spi.CacheTransactionSynchronization;

import java.util.List;

public interface RealmProvider {

    List<RealmModel> getAllBy();

    public RealmModel getRealmModelById(String Id);

    RealmModel getRealmModelByApplicationId(String applicationId);

    RealmModel getRealmModelByApplicationName(String applicationName);

    RealmModel save(RealmModel realmModel);

    void update(RealmModel realmModel);
}
