package com.mitocode.repo;

import com.mitocode.model.Paciente;
import com.mitocode.model.SignosVitales;
import com.mitocode.service.ICRUD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISignosVitalesService extends ICRUD<SignosVitales, Integer> {
    Page<SignosVitales> listarPageable(Pageable pageable);
}
