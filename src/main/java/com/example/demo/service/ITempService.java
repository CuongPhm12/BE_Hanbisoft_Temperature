package com.example.demo.service;

import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ITempService extends IGeneralService<Temperature> {
    List<Temperature> getAllTemp(int index);

//    void editTemp(Temperature temperature);

    List<Temperature> findAllByUserAndAndDatetimeAfterAndDatetimeBefore(User user, Date fdate, Date tdate);

    List<Temperature> getAllTempNotPagination();
//    List<Temperature> search(Date datetime, String name);
    List<Temperature> search(Date fdate,Date tdate,String name);
    List<Temperature> findAllByUser(User user);
    List<Temperature> searchByUser(@Param("fdate")Date fdate, @Param("tdate")Date tdate);
//    List<Temperature> findAllByUser_Id(Long id);

}
