package com.mitocode.service.impl;

import com.mitocode.model.Paciente;
import com.mitocode.model.SignosVitales;
import com.mitocode.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SignosVitalesServiceImpl extends CRUDImpl<SignosVitales, Integer> implements ISignosVitalesService {

    @Autowired
    private ISignosVitalesRepo repo;

    @Override
    protected IGenericRepo<SignosVitales, Integer> getRepo(){
        return repo;
    }

    @Override
    public Page<SignosVitales> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
