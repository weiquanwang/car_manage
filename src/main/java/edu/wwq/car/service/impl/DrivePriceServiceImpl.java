package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.DrivePriceMapper;
import edu.wwq.car.model.DrivePrice;
import edu.wwq.car.service.DrivePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivePriceServiceImpl implements DrivePriceService {

    @Autowired
    private DrivePriceMapper drivePriceMapper;

    @Override
    public boolean insert(DrivePrice drivePrice) {
        boolean result = false;
        int index = drivePriceMapper.insert(drivePrice);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public DrivePrice getDrivePriceById(int id) {
        DrivePrice drivePrice = drivePriceMapper.getDrivePriceById(id);
        return drivePrice;
    }

    @Override
    public boolean update(DrivePrice drivePrice) {
        boolean result = false;
        int index = drivePriceMapper.update(drivePrice);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int index = drivePriceMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<DrivePrice> getDrivePriceList() {
        List<DrivePrice> drivePriceList = drivePriceMapper.getDrivePriceList();
        return drivePriceList;
    }
}
