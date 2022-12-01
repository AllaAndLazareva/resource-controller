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

    @GetMapping("/{id}")
    public ResponseEntity<ResourceModel> getResourceById(@PathVariable("id") String id) {
        return ResponseEntity.ok(resourceProvider.getResourceById(id));
    }

    @GetMapping(value = "/app/{appId}", produces = {"application/json"})
    public ResponseEntity<List<ResourceModel>> getResourceByApplicationId(@PathVariable("appId") String applicationId) {
        return ResponseEntity.ok(resourceProvider.getResourceByApplicationId(applicationId));
    }

    @PostMapping
    public ResponseEntity<ResourceModel> save(@RequestBody ResourceModel resourceModel) {
        return ResponseEntity.ok(resourceProvider.save(resourceModel));
    }
}
