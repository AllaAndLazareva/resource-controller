package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.VersionModel;

import java.util.List;

public interface VersionProvider {

    VersionModel save(VersionModel versionModel);

    void update(VersionModel versionModel);
}
