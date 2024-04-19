package com.enviro.assessment.grad001.siyabongankomo.controller;

import com.enviro.assessment.grad001.siyabongankomo.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongankomo.service.WasteCategoryService;
import com.enviro.assessment.grad001.siyabongankomo.util.MissingException;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {

    @Autowired
    public WasteCategoryService wasteCategoryService;

   @PostMapping("/create-new-waste-category")
    public WasteCategory saveWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {

            return wasteCategoryService.saveCategory(wasteCategory);

    }
    @PostMapping("/create-new-waste-category")
    public List<WasteCategory>  saveWasteCategory(@Valid @RequestBody List<WasteCategory>  wasteCategory) {

        return wasteCategoryService.saveCategory(wasteCategory);

    }
    @GetMapping("/all-waste-category")
    public List<WasteCategory> getAllCategory() {
        return wasteCategoryService.findAll();
    }
    @GetMapping("/waste-category")
    public WasteCategory getWasteCategory(@RequestParam Integer id)throws MissingException {
        Optional<WasteCategory> wasteCategory = Optional.ofNullable(wasteCategoryService.findById(id));
        return wasteCategory.orElse(null);
    }
    @DeleteMapping("/delete-waste-category")
    public void deleteById(@RequestParam Integer id)throws MissingException {
       wasteCategoryService.deleteById(id);
    }
@PutMapping("/update-waste-category")
public void updateById(@RequestParam Integer id, @RequestBody WasteCategory wasteCategory)throws MissingException {
       wasteCategoryService.updateById(id,wasteCategory);

}
}
