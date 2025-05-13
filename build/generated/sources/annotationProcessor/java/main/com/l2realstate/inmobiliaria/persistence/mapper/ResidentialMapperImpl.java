package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.persistence.entity.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:55-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ResidentialMapperImpl implements ResidentialMapper {

    @Override
    public Residential toResidential(Colonia colonia) {
        if ( colonia == null ) {
            return null;
        }

        Residential residential = new Residential();

        if ( colonia.getIdColonia() != null ) {
            residential.setResidentialId( colonia.getIdColonia() );
        }
        residential.setResidential( colonia.getColonia() );

        return residential;
    }

    @Override
    public List<Residential> toResidentials(List<Colonia> colonias) {
        if ( colonias == null ) {
            return null;
        }

        List<Residential> list = new ArrayList<Residential>( colonias.size() );
        for ( Colonia colonia : colonias ) {
            list.add( toResidential( colonia ) );
        }

        return list;
    }

    @Override
    public Colonia toColonia(Residential residential) {
        if ( residential == null ) {
            return null;
        }

        Colonia colonia = new Colonia();

        colonia.setIdColonia( residential.getResidentialId() );
        colonia.setColonia( residential.getResidential() );

        return colonia;
    }

    @Override
    public List<Colonia> toColonias(List<Residential> residentials) {
        if ( residentials == null ) {
            return null;
        }

        List<Colonia> list = new ArrayList<Colonia>( residentials.size() );
        for ( Residential residential : residentials ) {
            list.add( toColonia( residential ) );
        }

        return list;
    }
}
