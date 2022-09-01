package br.edu.fafic.ppi.dao;

import br.edu.fafic.ppi.domain.Accessory;

import java.util.List;

public class AccessoryDAO extends GenericDAOImpl<Accessory> {

    @Override
    public void saveOrUpdate(Accessory entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void saveList(List<Accessory> entities) {
        super.saveList(entities);
    }
}
