package com.business.simple.repository;

import com.business.simple.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {

    @Query("select s from Servicos s where s.customer.id =?1")
    public List<Servicos> getServicos(Long customerId);

}
