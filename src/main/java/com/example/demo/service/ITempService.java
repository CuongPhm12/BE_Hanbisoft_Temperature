package com.example.demo.service;

import com.example.demo.model.Temperature;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ITempService extends IGeneralService<Temperature> {
//    List<Temperature> search(Date datetime, String name);
    List<Temperature> search(Date fdate,Date tdate,String name);
//    List<Temperature> findAllByUser_Id(Long id);
}
