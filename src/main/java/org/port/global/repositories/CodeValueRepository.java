package org.port.global.repositories;

import org.port.global.entities.CodeValue;
import org.springframework.data.repository.CrudRepository;

public interface CodeValueRepository extends CrudRepository<CodeValue, String> {
    CodeValue findByCode(String code);
}
