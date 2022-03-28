package com.example.demo.service.impl;

import com.example.demo.model.Temperature;
import com.example.demo.repository.ITempRepository;
import com.example.demo.service.IGeneralService;
import com.example.demo.service.ITempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TempServiceImpl implements ITempService {
    @Autowired
    private ITempRepository tempRepository;


    @Override
    public List<Temperature> findAll() {
        return tempRepository.findAll();
    }

    @Override
    public Page<Temperature> findAll(Pageable pageable) {
        return tempRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        tempRepository.deleteById(id);

    }

    @Override
    public Temperature save(Temperature temperature) {
        return tempRepository.save(temperature);
    }

    @Override
    public Optional<Temperature> findById(Long id) {
        return tempRepository.findById(id);
    }
}
