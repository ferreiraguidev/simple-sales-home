package com.business.simple.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long contact;

    private String registration;

    private String car;

    private String urlProd = "D:\\shwoRoom.jpg";

    @OneToMany(mappedBy = "customer")
    private List<Servicos> servicos;


}
