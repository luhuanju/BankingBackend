package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.CusBeneficiary;
import com.cogent.bankingsys.repo.CusBeneRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cusBene")

public class CusBeneController {

    @Autowired
    CusBeneRepo cusBeneRepo;

    @GetMapping(value = "/getCusBene")
    public List<CusBeneficiary> getCusBene(){
        return cusBeneRepo.findAll();
    }

    @PostMapping(value = "/addCusBene")
    public CusBeneficiary addCusBene(@Valid @RequestBody CusBeneficiary cusBeneficiary){
        return cusBeneRepo.save(cusBeneficiary);
    }

    @PutMapping(value = "/updateCusBene/{id}")
    public ResponseEntity<CusBeneficiary> updateCusBene (@PathVariable("id") long id, @RequestBody CusBeneficiary newCusBene){

        Optional<CusBeneficiary> existingCusBene = cusBeneRepo.findById(id);

        if (existingCusBene.isPresent()){
            CusBeneficiary tempCusBene = existingCusBene.get();
//          // only change the Approved
            tempCusBene.setApproved(newCusBene.getApproved());

            return new ResponseEntity<>(cusBeneRepo.save(tempCusBene), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteCusBene/{id}")
    public void deleteCusBene(@PathVariable("id") long id){
        cusBeneRepo.deleteById(id);
    }

}
