package com.example.demo.repository;

import com.example.demo.model.Temperature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITempRepository extends JpaRepository<Temperature,Long> {
    Page<Temperature> findAll(Pageable pageable);

//    Page<Temperature> findAllByUser_id(Long id);
}
