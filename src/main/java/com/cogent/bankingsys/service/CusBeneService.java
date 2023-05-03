package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.CusBeneficiary;
import com.cogent.bankingsys.repo.CusBeneRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CusBeneService {
    @Autowired
    CusBeneRepo cusBeneRepo;

    public CusBeneficiary getCusBeneficiary(long id){
        return cusBeneRepo.findById(id).get();
    }

    public List<CusBeneficiary> getAllCusBeneFiciary(){
        List<CusBeneficiary> cusBeneficiaryList = new ArrayList<CusBeneficiary>();
        cusBeneRepo.findAll().forEach(cusBeneficiary -> cusBeneficiaryList.add(cusBeneficiary));

        return cusBeneficiaryList;
    }

    public void saveOrUpdate (CusBeneficiary cusBeneficiary){
        cusBeneRepo.save(cusBeneficiary);
    }

    public void deleteCusBeneficiary(long id){
        cusBeneRepo.deleteById(id);
    }

}
