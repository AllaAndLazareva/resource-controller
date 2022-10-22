package com.lazareva.resourceController.provider;

import com.lazareva.resourceController.models.ValueModel;

import java.util.List;

public interface ValueProvider {

    List<ValueModel> getAllBy();

    ValueModel getAllByValue(String valueKey);

    ValueModel save(ValueModel valueModel);

    void update(ValueModel valueModel);

}
