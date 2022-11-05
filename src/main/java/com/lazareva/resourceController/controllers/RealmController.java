package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realm")
@RequiredArgsConstructor
public class RealmController {
    private final RealmProvider realmProvider;

    @GetMapping
    public ResponseEntity<List<RealmModel>> getAllBy() {
        return ResponseEntity.ok(realmProvider.getAllBy());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<RealmModel> getRealmById(@PathVariable("Id") String id) {
        return ResponseEntity.ok(realmProvider.getRealmModelById(id));
    }

    @GetMapping("/appId/{appId}")
    public ResponseEntity<RealmModel> getRealmByApplicationId(@PathVariable("appId") String applicationId) {

        return ResponseEntity.ok(realmProvider.getRealmModelByApplicationId(applicationId));

    }

    @GetMapping("/appName/{appName}")
    public ResponseEntity<RealmModel> getRealmByApplicationName(@PathVariable("appName") String applicationName) {
        return ResponseEntity.ok(realmProvider.getRealmModelByApplicationName(applicationName));
    }

    @PostMapping
    public ResponseEntity<RealmModel> save(@RequestBody RealmModel realmModel) {
        return ResponseEntity.ok(realmProvider.save(realmModel));
    }

    @PatchMapping
    public void update(@RequestBody RealmModel realmModel) {
        realmProvider.update(realmModel);
    }



}
