package com.lazareva.resourceController.graphql;


import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.jpa.repositories.RealmRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RealmGraphController {
    private final RealmRepositories realmProvider;

    @QueryMapping
    public RealmEntity realmById(@Argument(name = "id") String id) {
        return realmProvider.findById(id).get();
    }

    @QueryMapping
    public List<RealmEntity> allRealms() {
        return realmProvider.findAll();
    }
}
