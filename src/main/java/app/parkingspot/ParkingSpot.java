package app.parkingspot;

public class ParkingSpot {
    private float width;
    private float heigth;

    private float angleDegrees;
    private float angleRadians;

    // The parkingEntranceWidth is the 'c' in the Algoritmo.odt document.
    // It represents the horizontal width used to enter into a parking slot.
    private float parkingEntranceWidth;

    // length not used by a parking slot with an angle between 90° and 0°
    private float unusedL;
    // usedL is the vertical space used in a parking spot.
    private float usedL;

    // unusedW è lo spazio orizzontale inutilizzato in una riga di parcheggi.
    // width not used by a parking slot  with an angle between 90° and 0°
    private float unusedW;

    public float getParkingEntranceWidth() {
        return parkingEntranceWidth;
    }

    private void calcParkingEntranceWidth() {
        if(angleRadians==0){
            this.parkingEntranceWidth = heigth; //the height
        }else{
            double b = width / Math.tan(angleRadians);
            this.parkingEntranceWidth = (float) Math.sqrt((width*width) + (b*b));
        }
        this.parkingEntranceWidth = (float) (Math.round(this.parkingEntranceWidth * 1000.0) / 1000.0);
    }

    public float getUnusedL() {
        return unusedL;
    }

    private void calcUnusedL() {
        if(angleRadians==0){
            this.unusedL = 0;
        }else{
            this.unusedL = (float) (width * Math.cos(angleRadians));
            this.unusedL = (float) (Math.round(this.unusedL * 1000.0) / 1000.0);
        }
    }

    public float getAngleDegrees() {
        return angleDegrees;
    }

    public void setAngleDegrees(float angleDegrees) {
        if(angleDegrees >= 0 && angleDegrees <= 90){
            this.angleDegrees = angleDegrees;
            this.angleRadians = (float) Math.toRadians(angleDegrees);
        } else {
            throw new RuntimeException("The angle must be between 0° and 90°.");
        }
    }

    public float getAngleRadians() {
        return angleRadians;
    }

    public void setAngleRadians(float angleRadians) {
        this.angleRadians = angleRadians;
        this.angleDegrees = (float) Math.toDegrees(angleRadians);
    }

    public ParkingSpot(float heigth, float width, float angleDegrees){
        setAllDegrees(heigth, width, angleDegrees);
    }

    public void setAllDegrees(float heigth, float width, float angleDegrees){
        // if park is road side then the standard size is 2.0mx6.0m
        if(angleDegrees==0){
            this.heigth = (float) 6.0;
            this.width = (float) 2.0;
        }else{
            setHeigth(heigth);
            setWidth(width);
        }
        setAngleDegrees(angleDegrees);
        calcParkingEntranceWidth();
        calcUnusedW();
        calcUnusedL();
        calcUsedL();
    }

    public void setAllRadians(float heigth, float width, float angleRadians){
        if(angleRadians==0){
            this.heigth = (float) 6.0;
            this.width = (float) 2.0;
        }else{
            setHeigth(heigth);
            setWidth(width);
        }
        setAngleRadians(angleRadians);
        calcParkingEntranceWidth();
        calcUnusedW();
        calcUnusedL();
        calcUsedL();
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if(width >=2.30 && width <= 2.80){
            this.width = width;
        }else{
            throw new RuntimeException("Width must be between 2.30m and 2.80m");
        }
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(float heigth) {
        if(heigth >=4.50 && heigth <= 5.50){
            this.heigth = heigth;
        }else{
            throw new RuntimeException("Heigth must be between 4.50m and 5.50m");
        }
    }

    public float getUsedL() {
        return usedL;
    }

    public void calcUsedL() {
        if(angleRadians==0){
            this.usedL = width;
        } else {
            double b = getWidth() / Math.tan(getAngleRadians());
            this.usedL = (float) ((getHeigth() + b) * Math.sin(getAngleRadians()));
        }
        this.usedL = (float) (Math.round(this.usedL * 1000.0) / 1000.0);
    }

    public float getUnusedW() {
        return unusedW;
    }

    public void calcUnusedW() {
        if(getAngleRadians()==0){
            unusedW = 0;
        }else{
            double b = getWidth() / Math.tan(getAngleRadians());
            this.unusedW = (float) ((getHeigth() + b) * Math.cos(getAngleRadians()));
        }
        this.unusedW = (float) (Math.round(this.unusedW * 1000.0) / 1000.0);
//        if(getAngleDegrees()==90){
//            double b = getWidth() / Math.tan(getAngleRadians());
//            this.unusedW = (float) (Math.round(unusedW * 1000.0) / 1000.0);
//        }
    }

    //TODO cambiare i valori massimi e minimi con dei final
}
