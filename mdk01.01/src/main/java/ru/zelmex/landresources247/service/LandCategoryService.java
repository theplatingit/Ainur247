package ru.zelmex.landresources247.service;

import ru.zelmex.landresources247.model.LandCategory;
import ru.zelmex.landresources247.repository.LandCategoryDao;
import java.util.List;

public class LandCategoryService {

    private LandCategoryDao landCategoryDao = new LandCategoryDao();

    public List<LandCategory> findAll() {
        return landCategoryDao.findAll();
    }

    public LandCategory findOne(Long id) {
        return landCategoryDao.findOne(id);
    }

    public void save(LandCategory entity) {
        if (entity == null) return;
        landCategoryDao.save(entity);
    }

    public void update(LandCategory entity) {
        if (entity == null) return;
        landCategoryDao.update(entity);
    }

    public void delete(LandCategory entity) {
        if (entity == null) return;
        landCategoryDao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id == null) return;
        landCategoryDao.deleteById(id);
    }
}