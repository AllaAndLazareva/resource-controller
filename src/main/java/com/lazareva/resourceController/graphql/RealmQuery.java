package com.lazareva.resourceController.graphql;

import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RealmQuery implements GraphQLQueryResolver {

    private final RealmProvider realmProvider;

    public RealmModel getRealmById(String Id){
        return realmProvider.getRealmModelById(Id);
    }


}
