package com.lazareva.resourceController.graphql.realm;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;


import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RealmQuery implements GraphQLQueryResolver {

    private final RealmProvider realmProvider;


public List<RealmModel> getAll(){
    return realmProvider.getAllBy();
}


public RealmModel getByApplicationId( String applicationId){
    return realmProvider.getRealmModelByApplicationId(applicationId);
}


}
