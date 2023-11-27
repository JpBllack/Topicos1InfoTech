package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Usuario;

public interface TokenJwtService {


    public String generateJwt(Usuario usuario);

}
