package app.parkingrow;

import app.parkingspot.ParkingSpot;

// interface with common public methods used by both single and double parking row
public interface ParkingRow {
    long getNumberParkingSpots();
    float getHeigthRowTotal();
    float getWidthRow();
    float getManLength();
    float getUnusedRowSpace();
    ParkingSpot getParkingSpot();
    float getSpotsSpaceRatio();
    String toString();
}
