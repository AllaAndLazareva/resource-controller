package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.ResourceModel;

import java.util.List;
import java.util.Optional;

public interface ResourceProvider {
    
    List<ResourceModel> getResourceByApplicationId (String applicationId);
    
    List<ResourceModel> getResourceByApplicationName (String applicationName);
    
    ResourceModel getResourceByCurrentValue (String currentValue);
    
    ResourceModel getResourceByValue (String value);
    
    ResourceModel save(ResourceModel resourceModel);
    
    void update(ResourceModel resourceModel);
}
