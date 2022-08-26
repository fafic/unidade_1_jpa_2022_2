package br.edu.fafic.ppi.dao;

import br.edu.fafic.ppi.domain.Vehicle;

public class VehicleDAO extends GenericDAOImpl<Vehicle>{

    @Override
    public void saveOrUpdate(Vehicle entity) {
        super.saveOrUpdate(entity);
    }
}
