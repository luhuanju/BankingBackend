package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.PayLoad;
import com.cogent.bankingsys.repo.PayLoadRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PayLoadService {

    @Autowired
    PayLoadRepo payLoadRepo;

    public PayLoad getPayLoad(long id){
        return payLoadRepo.findById(id).get();
    }

    public List<PayLoad> getAllPayLoad (){
        List<PayLoad> payLoadList = new ArrayList<PayLoad>();
        payLoadRepo.findAll().forEach(payLoad -> payLoadList.add(payLoad));

        return payLoadList;
    }

    public void saveOrUpdate (PayLoad payLoad){
        payLoadRepo.save(payLoad);
    }

    public void deletePayLoad(long id){
        payLoadRepo.deleteById(id);
    }

}
