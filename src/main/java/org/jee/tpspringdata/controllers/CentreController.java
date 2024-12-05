package org.jee.tpspringdata.controllers;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dtos.CentreDto;
import org.jee.tpspringdata.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CentreController {
    @Autowired
    private CentreService centreService;

    @QueryMapping()
    public List<Centre> getAllCentres() {
        return centreService.getAllCentres();
    }

    @QueryMapping()
    public Centre getCentre(@Argument Long id) {
        return centreService.getCentre(id);
    }

    @MutationMapping()
    public Centre addCentre(@Argument CentreDto centreDto) {
        Centre newCentre = new Centre(centreDto.nom(), centreDto.adresse());
        return centreService.addCentre(newCentre);
    }

    @MutationMapping()
    public Centre updateCentre(@Argument Long id, @Argument CentreDto centreDto) {
        Centre centre = new Centre(centreDto.nom(), centreDto.adresse());
        return centreService.updateCentre(id, centre);
    }

    @MutationMapping()
    public Centre deleteCentre(@Argument Long id) {
        return centreService.deleteCentre(id);
    }
}