package com.lazareva.resourceController.graphql;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.jpa.repositories.RealmRepositories;
import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/graph")
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
