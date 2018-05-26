package edu.wwq.car.service;

import edu.wwq.car.model.DrivePrice;

import java.util.List;

public interface DrivePriceService {

    boolean insert(DrivePrice drivePrice);

    DrivePrice getDrivePriceById(int id);

    boolean update(DrivePrice drivePrice);

    boolean delete(int id);

    List<DrivePrice> getDrivePriceList();
}
