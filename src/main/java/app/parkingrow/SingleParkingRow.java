package app.parkingrow;

import app.parkingspot.ParkingSpot;

// class based on the width, the length will be considered in the parking lot and algorithm
public class SingleParkingRow implements ParkingRow{
    // the parking type used
    private ParkingSpot parkingSpot;
    // parking row width
    private float widthRow;
    // parking row height + manouver lane
    private float heigthRowTotal;

    // total number of parking spots on the row
    private long numberParkingSpots;
    // manouver lane width: it's called length because the lane is meant in horizontal, so the width is the length
    private float manLength;
    // space not used dividing the row by all the spots inside it.
    private float unusedRowSpace;
    // ratio between number of spots and used space
    private float spotsSpaceRatio;

    public SingleParkingRow(float widthRow, float heigthSpot, float widthSpot, float angleDegrees) {
        parkingSpot = new ParkingSpot(heigthSpot, widthSpot, angleDegrees);
        setWidthRow(widthRow);
        calcNumberParkingSpots();
        calcManLength(angleDegrees);
        calcHeigthRowTotal();
        // compute unused space, maybe it's not the correct way
        calcUnusedRowSpace();

        calcSpotsSpaceRatio();
    }

    public long getNumberParkingSpots() {
        return numberParkingSpots;
    }

    // Compute the available parking spots number, rounding down
    private void calcNumberParkingSpots() {
        float numParkSpotsFloat = (float) Math.floor((widthRow - parkingSpot.getUnusedW()) / parkingSpot.getParkingEntranceWidth());
        this.numberParkingSpots = (int) numParkSpotsFloat;
    }

    public float getWidthRow() {
        return widthRow;
    }

    private void setWidthRow(float widthRow) {
        this.widthRow = widthRow;
    }

    public float getHeigthRowTotal() {
        return heigthRowTotal;
    }

    private void calcHeigthRowTotal() {
        this.heigthRowTotal = manLength + parkingSpot.getUsedL();
        this.heigthRowTotal = (float) (Math.round(this.heigthRowTotal * 1000.0) / 1000.0);
    }

    public float getManLength() {
        return manLength;
    }

    private void calcManLength(float angleDegrees) {
        if(angleDegrees >= 0 && angleDegrees <= 60){
            manLength = (float) 3.50;
        } else if (angleDegrees > 60 && angleDegrees <= 75) {
            manLength = (float) 4.50;
        } else {
            manLength = (float) 6.10;
        }
    }

    public float getUnusedRowSpace() {
        return unusedRowSpace;
    }

    private void calcUnusedRowSpace() {
        if(parkingSpot.getAngleDegrees()!=90 && parkingSpot.getAngleDegrees()!=0){
            this.unusedRowSpace = parkingSpot.getUnusedW();
        }else{
            this.unusedRowSpace = widthRow%parkingSpot.getParkingEntranceWidth();
        }
        this.unusedRowSpace = (float) (Math.round(this.unusedRowSpace * 1000.0) / 1000.0);
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public String toString() {
        return "Row of " + parkingSpot.getAngleDegrees() + "°. Number of spots: " + getNumberParkingSpots()
                + ". Unused row space: " + unusedRowSpace;
    }

    public float getSpotsSpaceRatio() {
        return spotsSpaceRatio;
    }

    private void calcSpotsSpaceRatio() {
        this.spotsSpaceRatio = numberParkingSpots / heigthRowTotal;
    }
}
