package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.ApplicationModel;
import com.lazareva.resourceController.provider.ApplicationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationProvider applicationProvider;

    @GetMapping
    public ResponseEntity<List<ApplicationModel>> allApplication() {
        return ResponseEntity.ok(applicationProvider.getAll());
    }

    @GetMapping("/{realmId}")
    public ResponseEntity<List<ApplicationModel>> getApplicationsByRealmId(@PathVariable("realmId") String realmId) {
        return ResponseEntity.ok(applicationProvider.getAllByRealmId(realmId));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<ApplicationModel> save(@RequestBody ApplicationModel app) {
        return ResponseEntity.ok(applicationProvider.save(app));
    }

    @PatchMapping
    public void update(@RequestBody ApplicationModel applicationModel) {
        applicationProvider.update(applicationModel);
    }


}
