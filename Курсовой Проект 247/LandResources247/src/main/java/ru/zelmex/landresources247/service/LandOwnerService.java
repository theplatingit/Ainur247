package ru.zelmex.landresources247.service;

import ru.zelmex.landresources247.model.LandOwner;
import ru.zelmex.landresources247.repository.LandOwnerDao;
import java.util.List;

public class LandOwnerService {

    private LandOwnerDao landOwnerDao = new LandOwnerDao();

    public List<LandOwner> findAll() {
        return landOwnerDao.findAll();
    }

    public LandOwner findOne(Long id) {
        return landOwnerDao.findOne(id);
    }

    public void save(LandOwner entity) {
        if (entity == null) return;
        landOwnerDao.save(entity);
    }

    public void update(LandOwner entity) {
        if (entity == null) return;
        landOwnerDao.update(entity);
    }

    public void delete(LandOwner entity) {
        if (entity == null) return;
        landOwnerDao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id == null) return;
        landOwnerDao.deleteById(id);
    }
}