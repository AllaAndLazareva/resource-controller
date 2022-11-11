package com.lazareva.resourceController.controllers;

import com.lazareva.resourceController.models.ValueModel;
import com.lazareva.resourceController.provider.ValueProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/value")
public class ValueController {

    private final ValueProvider valueProvider;

    @GetMapping
    public ResponseEntity<List<ValueModel>> getAll() {
        return ResponseEntity.ok(valueProvider.getAllBy());
    }

    @GetMapping("/value/{value}")
    public ResponseEntity<ValueModel> getValueByValueKey(@PathVariable("value") String valueKey) {
        return ResponseEntity.ok(valueProvider.getAllByValue(valueKey));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<ValueModel> save(@RequestBody ValueModel valueModel) {
        return ResponseEntity.ok(valueProvider.save(valueModel));
    }

    @PatchMapping
    public void update(@RequestBody ValueModel valueModel) {
        valueProvider.update(valueModel);
    }
}
