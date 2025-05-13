package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.persistence.entity.Colonia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResidentialMapper {

    @Mappings({

            @Mapping(source = "idColonia", target="residentialId"),
            @Mapping(source = "colonia", target="residential"),
    })

    Residential toResidential(Colonia colonia);
    List<Residential> toResidentials(List<Colonia> colonias);


    @InheritInverseConfiguration
    Colonia toColonia(Residential residential);
    List<Colonia> toColonias(List<Residential> residentials);
}



