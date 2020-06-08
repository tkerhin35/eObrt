package hr.maba.eobrt.service;

import hr.maba.eobrt.domain.port.TokenGenerator;

import java.util.UUID;

public class UUIDGenerator implements TokenGenerator {

    @Override
    public String genrate() {
        return UUID.randomUUID().toString();
    }
}
