package app.parkingrow;

import app.parkingspot.ParkingSpot;

public interface ParkingRow {
    long getNumberParkingSpots();
    float getHeigthRowTotal();
    float getWidthRow();
    float getManLength();
    float getUnusedRowSpace();
    ParkingSpot getParkingSpot();
    String toString();
}
