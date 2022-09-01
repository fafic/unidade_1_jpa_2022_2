package br.edu.fafic.ppi.dao;

import br.edu.fafic.ppi.domain.Vehicle;

import java.util.List;

public class VehicleDAO extends GenericDAOImpl<Vehicle>{

    @Override
    public void saveOrUpdate(Vehicle entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void saveList(List<Vehicle> entities) {
        super.saveList(entities);
    }
}
