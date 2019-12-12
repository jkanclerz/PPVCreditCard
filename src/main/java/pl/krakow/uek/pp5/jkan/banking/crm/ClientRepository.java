package pl.krakow.uek.pp5.jkan.banking.crm;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository
        extends CrudRepository <ClientData, String> {
}
