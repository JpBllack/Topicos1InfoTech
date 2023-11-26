package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Telefone;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

}
