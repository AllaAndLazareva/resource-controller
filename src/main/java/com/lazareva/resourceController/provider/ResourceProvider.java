package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.ResourceModel;

import java.util.List;

public interface ResourceProvider {

    ResourceModel getResourceById(String id);

    List<ResourceModel> getResourceByApplicationId(String applicationId);

    List<ResourceModel> getResourceByApplicationName(String applicationName);

    ResourceModel getResourceByCurrentValue(String currentValue);

    ResourceModel getResourceByValue(String value);

    ResourceModel save(ResourceModel resourceModel);

    void update(ResourceModel resourceModel);
}
