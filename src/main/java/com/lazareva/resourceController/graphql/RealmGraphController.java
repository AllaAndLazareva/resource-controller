package com.lazareva.resourceController.graphql;

import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/graph")
public class RealmGraphController {
    private final RealmProvider realmProvider;


    @QueryMapping
    public RealmModel getById(@Argument String id){
        return realmProvider.getRealmModelById(id);
    }
}
