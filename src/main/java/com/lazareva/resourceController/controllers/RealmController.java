package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/realm")
@RequiredArgsConstructor
public class RealmController {
    private final RealmProvider realmProvider;

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<RealmModel>> getAllRealms() {
        return ResponseEntity.ok(realmProvider.allRealms());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<RealmModel> save(@RequestBody RealmModel realm) {
        return ResponseEntity.ok(realmProvider.save(realm));
    }

    @PatchMapping(produces = {"application/json"})
    public void update(@RequestBody RealmModel realmModel) {
        realmProvider.update(realmModel);
    }

}
