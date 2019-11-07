package app.parkingrow;

import app.parkingspot.ParkingSpot;

public class DoubleParkingRow implements ParkingRow{
    // il tipo di parcheggio utilizzato
    private ParkingSpot parkingSpot;
    // larghezza della riga di parcheggi
    private float widthRow;
    // altezza della riga di parcheggi + corsia
    private float heigthRowTotal;

    // numero dei parcheggi totali sulla riga
    private long numberParkingSpots;
    // larghezza della corsia per lo spazio di manovra: length perché è vista come corsia in orizzontale quindi la lunghezza è l'altezza
    private float manLength;
    // space not used dividing the row by all the spots inside it.
    private float unusedRowSpace;
    // ratio between number of spots and used space
    private float spotsSpaceRatio;

    public DoubleParkingRow(float widthRow, float heigthSpot, float widthSpot, float angleDegrees) {
        parkingSpot = new ParkingSpot(heigthSpot, widthSpot, angleDegrees);
        this.widthRow = widthRow;
        calcNumberParkingSpots();
        calcManLength(angleDegrees);
        calcHeigthRowTotal();
        // calcolare spazio laterale inutilizzato
        calcUnusedRowSpace();
    }

    public long getNumberParkingSpots() {
        return numberParkingSpots;
    }

    // Calcolo il numero di parcheggi disponibili arrotondando per difetto
    private void calcNumberParkingSpots() {
        float numParkSpotsFloat = (float) Math.floor((widthRow - parkingSpot.getUnusedW()) / parkingSpot.getParkingEntranceWidth());
        this.numberParkingSpots = ((int) numParkSpotsFloat) * 2;
    }

    public float getWidthRow() {
        return widthRow;
    }

    public float getHeigthRowTotal() {
        return heigthRowTotal;
    }

    private void calcHeigthRowTotal() {
        this.heigthRowTotal = manLength + ((parkingSpot.getUsedL() * 2) - parkingSpot.getUnusedL());
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

    public float getSpotsSpaceRatio() {
        return spotsSpaceRatio;
    }

    private void calcSpotsSpaceRatio() {
        this.spotsSpaceRatio = numberParkingSpots / heigthRowTotal;
//        this.spotsSpaceRatio = heigthRowTotal / numberParkingSpots;
    }

    @Override
    public String toString() {
        return "Double row of " + parkingSpot.getAngleDegrees() + "°. Number of spots: " + getNumberParkingSpots()
                + ". Unused row space: " + unusedRowSpace;
    }
}
