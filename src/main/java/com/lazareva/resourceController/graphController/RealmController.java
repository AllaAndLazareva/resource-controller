package com.lazareva.resourceController.graphController;

import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RealmController {
    private final RealmProvider realmProvider;

    @QueryMapping
    public RealmModel getById(@Argument String id){
        return realmProvider.getRealmModelById(id);
    }

}
