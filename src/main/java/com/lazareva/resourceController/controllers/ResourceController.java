package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.ResourceModel;
import com.lazareva.resourceController.provider.ResourceProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceProvider resourceProvider;

    @GetMapping("{/appId}")
    public ResponseEntity<List<ResourceModel>> getResourceByApplicationId(@PathVariable("appId") String applicationId) {
        return ResponseEntity.ok(resourceProvider.getResourceByApplicationId(applicationId));
    }

    @GetMapping("{/appName}")
    public ResponseEntity<List<ResourceModel>> getResourceByApplicationName(@PathVariable("appName") String applicationName) {
        return ResponseEntity.ok(resourceProvider.getResourceByApplicationName(applicationName));
    }

    @GetMapping("{/current")
    public ResponseEntity<ResourceModel> getResourceByCurrentValue(@PathVariable("current") String currentValue) {
        return ResponseEntity.ok(resourceProvider.getResourceByCurrentValue(currentValue));
    }

    @GetMapping("{/value}")
    public ResponseEntity<ResourceModel> getResourceByValue(@PathVariable("value") String value) {
        return ResponseEntity.ok(resourceProvider.getResourceByValue(value));
    }

    @PostMapping
    public ResponseEntity<ResourceModel> save(@RequestBody ResourceModel resourceModel) {
        return ResponseEntity.ok(resourceProvider.save(resourceModel));
    }

    @PatchMapping
    public void update(@RequestBody ResourceModel resourceModel) {
        resourceProvider.update(resourceModel);
    }
}
