package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.ResourceModel;

import java.util.List;

public interface ResourceProvider {


    ResourceModel getResourceById(String id);

    List<ResourceModel> getResourceByApplicationId(String applicationId);

    ResourceModel save(ResourceModel resourceModel);
}
