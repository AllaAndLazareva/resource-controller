package com.lazareva.resourceController.graphql.application;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lazareva.resourceController.models.ApplicationModel;
import com.lazareva.resourceController.provider.ApplicationProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ApplicationQuery implements GraphQLQueryResolver {

    private final ApplicationProvider applicationProvider;

    public List<ApplicationModel> getAll(){
        return applicationProvider.getAll();
    }

    public List<ApplicationModel> getByRealmId (String realmId){
        return applicationProvider.getAllByRealmId(realmId);
    }


}
