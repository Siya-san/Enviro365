package com.enviro.assessment.grad001.siyabongankomo.controller;

import com.enviro.assessment.grad001.siyabongankomo.model.Tips;
import com.enviro.assessment.grad001.siyabongankomo.service.TipsService;
import com.enviro.assessment.grad001.siyabongankomo.util.MissingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycle-tips")
public class TipsController {

    @Autowired
    public TipsService tipsService;

    @PostMapping("/create-new-recycle-tips")
    public Tips saveTips(@Valid @RequestBody Tips tips) {

        return tipsService.saveTips(tips);

    }
    @PostMapping("/create-new-recycle-tips")
    public List<Tips> saveTips(@Valid @RequestBody List<Tips>  tips) {

        return tipsService.saveTips(tips);

    }
    @GetMapping("/all-recycle-tips")
    public List<Tips> getAllCategory() {
        return tipsService.findAll();
    }
    @GetMapping("/recycle-tips")
    public Tips getTips(@RequestParam Integer id)throws MissingException {
        Optional<Tips> tips = Optional.ofNullable(tipsService.findById(id));
        return tips.orElse(null);
    }
    @DeleteMapping("/delete-recycle-tips")
    public void deleteById(@RequestParam Integer id)throws MissingException {
        tipsService.deleteById(id);
    }
    @PutMapping("/update-recycle-tips")
    public void updateById(@RequestParam Integer id, @RequestBody Tips tips)throws MissingException {
        tipsService.updateById(id,tips);

    }
}