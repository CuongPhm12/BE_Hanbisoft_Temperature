package com.example.demo.service;

import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ITempService extends IGeneralService<Temperature> {
    List<Temperature> getAllTemp(int index);
    List<Temperature> findAllByUser(User user);
    List<Temperature> getAllTempNotPagination();
//    List<Temperature> search(Date datetime, String name);
    List<Temperature> search(Date fdate,Date tdate,String name);

    List<Temperature> searchByUser(@Param("fdate")Date fdate, @Param("tdate")Date tdate);
//    List<Temperature> findAllByUser_Id(Long id);
}
