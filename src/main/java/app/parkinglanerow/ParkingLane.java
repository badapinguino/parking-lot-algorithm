package app.parkinglanerow;

import app.parkingrow.ParkingRow;

// this is a class for the the parking lane, not the row made of parking lots, but only the maneuver lane
public class ParkingLane {
    // this is the width of the parking lane, if we think about an horizontal lane this will be the height
    private float parkingLaneWidth;

    public float getParkingLaneWidth() {
        return parkingLaneWidth;
    }

    public void setParkingLaneWidth(float parkingLaneWidth) {
        this.parkingLaneWidth = parkingLaneWidth;
    }

    // this method sets the parking lane width to the one that is bigger between two parking rows.
    public void setParkingLaneWidthFrom2ParkingRows(ParkingRow parkingRow1, ParkingRow parkingRow2){
        if(parkingRow1.getParkingSpot().getAngleDegrees() > parkingRow2.getParkingSpot().getAngleDegrees()) {
            if(parkingRow1.getParkingSpot().getAngleDegrees() >= 0 && parkingRow1.getParkingSpot().getAngleDegrees() <= 60){
                parkingLaneWidth = (float) 3.50;
            } else if (parkingRow1.getParkingSpot().getAngleDegrees() > 60 && parkingRow1.getParkingSpot().getAngleDegrees() <= 75) {
                parkingLaneWidth = (float) 4.50;
            } else {
                parkingLaneWidth = (float) 6.10;
            }
        } else {
            if(parkingRow2.getParkingSpot().getAngleDegrees() >= 0 && parkingRow2.getParkingSpot().getAngleDegrees() <= 60){
                parkingLaneWidth = (float) 3.50;
            } else if (parkingRow2.getParkingSpot().getAngleDegrees() > 60 && parkingRow2.getParkingSpot().getAngleDegrees() <= 75) {
                parkingLaneWidth = (float) 4.50;
            } else {
                parkingLaneWidth = (float) 6.10;
            }
        }
    }

    // this method sets the parking row to the right width associated with the parking lot angle
    public void setParkingLaneWidthFromParkingRow(ParkingRow parkingRow) {
        if (parkingRow.getParkingSpot().getAngleDegrees() > parkingRow.getParkingSpot().getAngleDegrees()) {
            if (parkingRow.getParkingSpot().getAngleDegrees() >= 0 && parkingRow.getParkingSpot().getAngleDegrees() <= 60) {
                parkingLaneWidth = (float) 3.50;
            } else if (parkingRow.getParkingSpot().getAngleDegrees() > 60 && parkingRow.getParkingSpot().getAngleDegrees() <= 75) {
                parkingLaneWidth = (float) 4.50;
            } else {
                parkingLaneWidth = (float) 6.10;
            }
        }
    }
}
