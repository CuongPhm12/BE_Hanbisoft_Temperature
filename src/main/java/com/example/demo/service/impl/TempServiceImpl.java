package com.example.demo.service.impl;

import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.repository.ITempRepository;
import com.example.demo.service.IGeneralService;
import com.example.demo.service.ITempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

//    @Override
//    public List<Temperature> search(Date datetime, String name) {
//        return tempRepository.search(datetime,name);
//    }

    @Override
    public List<Temperature> getAllTemp(int index) {
        return tempRepository.getAllTemp(index);
    }

    @Override
    public List<Temperature> findAllByUserAndAndDatetimeAfterAndDatetimeBefore(User user, Date fdate, Date tdate) {
        return tempRepository.findAllByUserAndAndDatetimeAfterAndDatetimeBefore(user, fdate, tdate);
    }

    @Override
    public List<Temperature> findAllByUser(User user) {
        return tempRepository.findAllByUser(user);
    }

    @Override
    public List<Temperature> getAllTempNotPagination() {
        return tempRepository.getAllTempNotPagination();
    }

    @Override
    public List<Temperature> search(Date fdate, Date tdate, String name) {
        return tempRepository.search(fdate,tdate,name);
    }

    @Override
    public List<Temperature> searchByUser(Date fdate, Date tdate) {
        return tempRepository.searchByUser(fdate,tdate);
    }


//    @Override
//    public List<Temperature> findAllByUser_Id(Long id) {
//        return tempRepository.findAllByUser_Id(id);
//    }
}
