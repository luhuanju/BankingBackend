package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.PayLoad;
import com.cogent.bankingsys.repo.PayLoadRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/payload")

public class PayLoadController {

    @Autowired
    PayLoadRepo payLoadRepo;

    @GetMapping(value = "/getPayLoad")
    public List<PayLoad> getPayLoad(){
        System.out.println("get all PayLoad!");
        return payLoadRepo.findAll();
    }

    @PostMapping(value = "/addPayLoad")
    public PayLoad addPayLoad(@Valid @RequestBody PayLoad payLoad){
        return payLoadRepo.save(payLoad);
    }

    @PutMapping(value = "/updatePayLoad/{id}")
    public ResponseEntity<PayLoad> udpatePayLoadReason (@PathVariable("id") long id, @RequestBody PayLoad newPayLoad){

        Optional<PayLoad> existingPayLoad = payLoadRepo.findById(id);

        if (existingPayLoad.isPresent()){
            PayLoad tempPayLoad = existingPayLoad.get();

            // only update reason
//            tempPayLoad.setPayloadId(newPayLoad.getPayloadId());
//            tempPayLoad.setFromAccNumber(newPayLoad.getFromAccNumber());
//            tempPayLoad.setToAccNumber(newPayLoad.getToAccNumber());
//            tempPayLoad.setAmount(newPayLoad.getAmount());
            tempPayLoad.setReason(newPayLoad.getReason());

            return new ResponseEntity<>(payLoadRepo.save(tempPayLoad), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePayLoad(@PathVariable("id") long id){
        payLoadRepo.deleteById(id);
    }

}
