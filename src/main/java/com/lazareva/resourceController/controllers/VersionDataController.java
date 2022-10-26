package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.VersionDataModel;
import com.lazareva.resourceController.provider.VersionDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
public class VersionDataController {

    private final VersionDataProvider versionDataProvider;

    @GetMapping("/{id}")
    public ResponseEntity<VersionDataModel> getVersionDataById(@PathVariable("/id") String id){
        return ResponseEntity.ok(versionDataProvider.getVersionDataById(id));
    }

    @GetMapping("/{value}")
    public ResponseEntity<VersionDataModel> getVersionDataByValue(@PathVariable("/value") String value){
        return ResponseEntity.ok(versionDataProvider.getVersionDataByValue(value));
    }

    @PostMapping
    public ResponseEntity<VersionDataModel> save(@RequestBody VersionDataModel versionDataModel){
        return ResponseEntity.ok(versionDataProvider.save(versionDataModel));
    }

    @PatchMapping
    public void update(@RequestBody VersionDataModel versionDataModel){
        versionDataProvider.update(versionDataModel);
    }
}