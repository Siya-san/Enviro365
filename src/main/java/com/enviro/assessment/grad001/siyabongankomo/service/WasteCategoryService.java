package com.enviro.assessment.grad001.siyabongankomo.service;

import com.enviro.assessment.grad001.siyabongankomo.dao.WasteCategoryDAO;
import com.enviro.assessment.grad001.siyabongankomo.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongankomo.util.MissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryDAO wasteCategoryDAO;

    public WasteCategory saveCategory(WasteCategory wasteCategory) {
           return wasteCategoryDAO.save(wasteCategory);
    }
    public List<WasteCategory>  saveCategory(List<WasteCategory>  wasteCategory) {
            return wasteCategoryDAO.saveAll(wasteCategory);
    }


    public List<WasteCategory> findAll() {
        return wasteCategoryDAO.findAll();
    }
    public WasteCategory findById(Integer id) {
        Optional<WasteCategory> wasteCategory  = wasteCategoryDAO.findById(id);
        if (!wasteCategoryDAO.existsById(id)) {
            throw new MissingException(WasteCategory.class, "id", id.toString());
        }
        return wasteCategory.orElse(null);
    }


    public void deleteById(Integer id){

        if (!wasteCategoryDAO.existsById(id)) {
            throw new MissingException(WasteCategory.class, "id", id.toString());
        }
    else{
            wasteCategoryDAO.deleteById(id);
        }

    }
    public void updateById(Integer id, WasteCategory wasteCategory){

        if (!wasteCategoryDAO.existsById(id)) {
            throw new MissingException(WasteCategory.class, "id", id.toString());
        }else {
            wasteCategory.setId(id);
        wasteCategoryDAO.save(wasteCategory);
        }
    }
}
