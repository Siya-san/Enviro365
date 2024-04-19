package com.enviro.assessment.grad001.siyabongankomo.controller;

import com.enviro.assessment.grad001.siyabongankomo.model.Guide;
import com.enviro.assessment.grad001.siyabongankomo.service.GuideService;
import com.enviro.assessment.grad001.siyabongankomo.util.MissingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycle-guides")
public class GuideController {

    @Autowired
    public GuideService guideService;

    @PostMapping("/create-new-recycle-guide")
    public Guide saveGuide(@Valid @RequestBody Guide guide) {

        return guideService.saveGuide(guide);

    }
    @PostMapping("/create-new-recycle-guide")
    public List<Guide> saveGuide(@Valid @RequestBody List<Guide>  guide) {

        return guideService.saveGuide(guide);

    }
    @GetMapping("/all-recycle-guide")
    public List<Guide> getAllCategory() {
        return guideService.findAll();
    }
    @GetMapping("/recycle-guide")
    public Guide getGuide(@RequestParam Integer id)throws MissingException {
        Optional<Guide> guide = Optional.ofNullable(guideService.findById(id));
        return guide.orElse(null);
    }
    @DeleteMapping("/delete-recycle-guide")
    public void deleteById(@RequestParam Integer id)throws MissingException {
        guideService.deleteById(id);
    }
    @PutMapping("/update-recycle-guide")
    public void updateById(@RequestParam Integer id, @RequestBody Guide guide)throws MissingException {
        guideService.updateById(id,guide);

    }
}