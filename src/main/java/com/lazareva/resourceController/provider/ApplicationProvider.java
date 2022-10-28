package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.ApplicationModel;

import java.util.List;

public interface ApplicationProvider {

    List<ApplicationModel> getAll();

    List<ApplicationModel> getAllByRealmId(String realmId);

    ApplicationModel save(ApplicationModel model);

    void update(ApplicationModel model);
}
