package com.example.demo.service;

import com.example.demo.model.Temperature;

import java.sql.Date;
import java.util.List;

public interface ITempService extends IGeneralService<Temperature> {
    List<Temperature> search(Date datetime, String name);
}
