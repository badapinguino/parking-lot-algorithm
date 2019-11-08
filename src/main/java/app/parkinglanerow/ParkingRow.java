package app.parkinglanerow;

import app.parkingspot.ParkingSpot;

// interface with common public methods used by both single and double parking row
public interface ParkingRow {
    long getNumberParkingSpots();
    float getWidthRow();
    float getUnusedRowSpace();
    ParkingSpot getParkingSpot();
    float getSpotsSpaceRatio();
    String toString();
}
