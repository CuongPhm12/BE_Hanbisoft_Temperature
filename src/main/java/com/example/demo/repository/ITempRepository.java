package com.example.demo.repository;

import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITempRepository extends JpaRepository<Temperature,Long> {
//    @Query(value = "update temperature as t set t.datime =?1, t.temperature =?2, t.status=?3" +
//            "where id =?4",nativeQuery = true)
//    void editTemp(Date datetime, Float temperature, Boolean status, Long id);

    Page<Temperature> findAll(Pageable pageable);
    @Query(value = "SELECT t.*,t.datetime, u.name, u.position, t.temperature, u.status FROM temperature t left join users u " +
            "on t.user_id=u.id group by t.datetime limit ?1,5;",nativeQuery = true)
    List<Temperature> getAllTemp(int index);
    @Query(value = "SELECT t.*,t.datetime, u.name, u.position, t.temperature, u.status FROM temperature t left join users u " +
            "on t.user_id=u.id group by t.datetime ;",nativeQuery = true)
    List<Temperature> getAllTempNotPagination();

    @Query(value = "SELECT t.* ,t.datetime as datetime,u.name as name "+
            "FROM temperature t left join users u on t.user_id = u.id " +
            "where t.datetime between :fdate and :tdate and u.name   like concat('%',:name,'%')"
            , nativeQuery = true)
    List<Temperature> search(@Param("fdate")Date fdate, @Param("tdate")Date tdate, @Param("name") String name);

    @Query(value = "SELECT t.* ,t.datetime as datetime "+
            "FROM temperature t left join users u on t.user_id = u.id " +
            "where t.datetime between :fdate and :tdate"
            , nativeQuery = true)
    List<Temperature> searchByUser(@Param("fdate")Date fdate, @Param("tdate")Date tdate);

List<Temperature> findAllByUser(User user);
List<Temperature> findAllByUserAndAndDatetimeAfterAndDatetimeBefore(User user,Date fdate,Date tdate);



}
