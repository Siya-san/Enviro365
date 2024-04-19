package com.enviro.assessment.grad001.siyabongankomo.service;

import com.enviro.assessment.grad001.siyabongankomo.dao.TipsDAO;
import com.enviro.assessment.grad001.siyabongankomo.model.Tips;
import com.enviro.assessment.grad001.siyabongankomo.util.MissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipsService {

    @Autowired
    private TipsDAO tipsDAO;

    public Tips saveTips(Tips tips) {
        return tipsDAO.save(tips);
    }
    public List<Tips> saveTips(List<Tips>  tips) {
        return tipsDAO.saveAll(tips);
    }


    public List<Tips> findAll() {
        return tipsDAO.findAll();
    }
    public Tips findById(Integer id) {
        Optional<Tips> tips  = tipsDAO.findById(id);
        if (!tipsDAO.existsById(id)) {
            throw new MissingException(Tips.class, "id", id.toString());
        }
        return tips.orElse(null);
    }


    public void deleteById(Integer id){

        if (!tipsDAO.existsById(id)) {
            throw new MissingException(Tips.class, "id", id.toString());
        }
        else{
            tipsDAO.deleteById(id);
        }

    }
    public void updateById(Integer id, Tips tips){

        if (!tipsDAO.existsById(id)) {
            throw new MissingException(Tips.class, "id", id.toString());
        }else {
            tips.setId(id);
            tipsDAO.save(tips);
        }
    }
}
