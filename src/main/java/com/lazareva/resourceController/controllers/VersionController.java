package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.VersionModel;
import com.lazareva.resourceController.provider.VersionProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionController {

    private final VersionProvider versionProvider;

    @GetMapping
    public ResponseEntity<List<VersionModel>> getAll() {
        return ResponseEntity.ok(versionProvider.getAllBy());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<VersionModel> getVersionById(@PathVariable("id") String id) {
        return ResponseEntity.ok(versionProvider.getVersionById(id));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<VersionModel> save(@RequestBody VersionModel versionModel) {
        return ResponseEntity.ok(versionProvider.save(versionModel));
    }

    @PatchMapping
    public void update(@RequestBody VersionModel versionModel) {
        versionProvider.update(versionModel);
    }
}
