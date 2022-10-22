package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.VersionModel;

import java.util.List;

public interface VersionProvider {

    List<VersionModel> getAllBy();

    VersionModel getVersionById (String versionId);

    VersionModel save(VersionModel versionModel);

    void update(VersionModel versionModel);
}
