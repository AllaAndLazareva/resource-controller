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


    @PostMapping
    public ResponseEntity<VersionModel> save(@RequestBody VersionModel versionModel) {
        return ResponseEntity.ok(versionProvider.save(versionModel));
    }

    @PatchMapping
    public void update(@RequestBody VersionModel versionModel) {
        versionProvider.update(versionModel);
    }
}
