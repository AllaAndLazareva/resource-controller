package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.RealmModel;

import java.util.List;

public interface RealmProvider {

    List<RealmModel> allRealms();

    RealmModel save(RealmModel realmModel);

    void update(RealmModel realmModel);
}
