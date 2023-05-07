package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PayloadService {

    public Payload savePayload(Payload payload);

    public Optional<Payload> findByPayloadId(long payloadId);

    public List<Payload> findAll();

}
