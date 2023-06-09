package com.cogent.bankingsys.service.serviceImpl;

import com.cogent.bankingsys.entity.Payload;
import com.cogent.bankingsys.repo.PayloadRepo;
import com.cogent.bankingsys.service.PayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayloadServiceImpl implements PayloadService {

    @Autowired
    private PayloadRepo payloadRepo;

    @Override
    public Payload savePayload(Payload payload) {
        return payloadRepo.save(payload);
    }

    @Override
    public Optional<Payload> findByPayloadId(long payloadId) {
        return payloadRepo.findById(payloadId);
    }

    @Override
    public List<Payload> findAll() {
        return payloadRepo.findAll();
    }
}
