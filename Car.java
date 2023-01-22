package MedianAgeReleaseCar;

public class Car {
    private int yearRelease;
    private String idNumber;

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Car(int yearRelease, String idNumber){
        this.yearRelease = yearRelease;
        this.idNumber = idNumber;
    }
}
