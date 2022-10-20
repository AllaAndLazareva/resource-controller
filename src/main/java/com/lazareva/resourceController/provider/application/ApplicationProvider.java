package com.lazareva.resourceController.provider.application;

import com.lazareva.resourceController.model.ApplicationModel;

import java.util.List;

public interface ApplicationProvider
{
    List<ApplicationModel> getAll();

    List<ApplicationModel> applicationsByRealmId(String realmId);

    ApplicationModel save(ApplicationModel model);

    void update(ApplicationModel model);

}
