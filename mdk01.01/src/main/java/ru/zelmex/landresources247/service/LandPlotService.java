package ru.zelmex.landresources247.service;

import ru.zelmex.landresources247.model.LandPlot;
import ru.zelmex.landresources247.repository.LandPlotDao;
import java.util.List;

public class LandPlotService {

    private LandPlotDao landPlotDao = new LandPlotDao();

    public List<LandPlot> findAll() {
        return landPlotDao.findAll();
    }

    public LandPlot findOne(Long id) {
        return landPlotDao.findOne(id);
    }

    public void save(LandPlot entity) {
        if (entity == null) return;
        landPlotDao.save(entity);
    }

    public void update(LandPlot entity) {
        if (entity == null) return;
        landPlotDao.update(entity);
    }

    public void delete(LandPlot entity) {
        if (entity == null) return;
        landPlotDao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id == null) return;
        landPlotDao.deleteById(id);
    }
}