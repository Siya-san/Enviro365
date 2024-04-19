package com.enviro.assessment.grad001.siyabongankomo.service;

import com.enviro.assessment.grad001.siyabongankomo.dao.GuideDAO;
import com.enviro.assessment.grad001.siyabongankomo.model.Guide;
import com.enviro.assessment.grad001.siyabongankomo.util.MissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideService {

    @Autowired
    private GuideDAO guideDAO;

    public Guide saveGuide(Guide guide) {
        return guideDAO.save(guide);
    }
    public List<Guide> saveGuide(List<Guide>  guide) {
        return guideDAO.saveAll(guide);
    }


    public List<Guide> findAll() {
        return guideDAO.findAll();
    }
    public Guide findById(Integer id) {
        Optional<Guide> guide  = guideDAO.findById(id);
        if (!guideDAO.existsById(id)) {
            throw new MissingException(Guide.class, "id", id.toString());
        }
        return guide.orElse(null);
    }


    public void deleteById(Integer id){

        if (!guideDAO.existsById(id)) {
            throw new MissingException(Guide.class, "id", id.toString());
        }
        else{
            guideDAO.deleteById(id);
        }

    }
    public void updateById(Integer id, Guide guide){

        if (!guideDAO.existsById(id)) {
            throw new MissingException(Guide.class, "id", id.toString());
        }else {
            guide.setId(id);
            guideDAO.save(guide);
        }
    }
}
