package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.VersionDataModel;

public interface VersionDataProvider {

    VersionDataModel getVersionDataById (String id);

    VersionDataModel getVersionDataByValue(String value);

    VersionDataModel save(VersionDataModel versionDataModel);

    void update(VersionDataModel versionDataModel);



}