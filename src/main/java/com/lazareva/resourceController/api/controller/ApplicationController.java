package com.lazareva.resourceController.api.controller;

import com.lazareva.resourceController.model.ApplicationModel;
import com.lazareva.resourceController.provider.application.ApplicationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class ApplicationController
{
    private final ApplicationProvider provider;

    @GetMapping
    public ResponseEntity<List<ApplicationModel>> allApplication()
    {
        return ResponseEntity.ok(provider.getAll());
    }

    @GetMapping
    @PatchMapping("/{realmId}")
    public ResponseEntity<List<ApplicationModel>> getApplicationsByRealmId(@PathVariable("realmId") String realmId)
    {
        return ResponseEntity.ok(provider.applicationsByRealmId(realmId));
    }

    @PostMapping
    public ResponseEntity<ApplicationModel> save(@RequestBody ApplicationModel model)
    {
        return ResponseEntity.ok(provider.save(model));
    }

    @PatchMapping
    public void update(@RequestBody ApplicationModel model)
    {
        provider.update(model);
    }
}
