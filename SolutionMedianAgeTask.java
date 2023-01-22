package MedianAgeReleaseCar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

public class SolutionMedianAgeTask {
    public static void main(String[] args) {

        ArrayList <Car> listCars = new ArrayList<>();
        Car car1 = new Car(1980, "qwe73");
        Car car2 = new Car(2001, "qwe01");
        Car car3 = new Car(2020, "qwe12");
        Car car4 = new Car(2017, "qwe73");
        Car car5 = new Car(2009, "qwe01");
        Car car6 = new Car(2012, "qwe73");
        Car car7 = new Car(2013, "qwe01");

        // Автомобили рассортированы правильно, если:
        // 73 = [1980, 2017, 2012]
        // 01 = [2001, 2009, 2013]
        // 12 = [2020]

        listCars.add(car1);
        listCars.add(car2);
        listCars.add(car3);
        listCars.add(car4);
        listCars.add(car5);
        listCars.add(car6);
        listCars.add(car7);

        HashMap <String, ArrayList<Integer>> carsAgeInRegions = new HashMap<>();
        HashSet <String> keysForCarAgeMap = new HashSet<>();
        HashMap <String, Integer> mediumAgeCarsInRegions = new HashMap<>();

        for (int i = 0; i < listCars.size(); i++) {
            String number = listCars.get(i).getIdNumber().substring(3);
            keysForCarAgeMap.add(number);
        }

        for (String regNum: keysForCarAgeMap){
            ArrayList <Integer> yearsList = new ArrayList<>();
            int countCars = 0;
            int sumAgeRelease = 0;
            int mediumAge = 0;
            for (int i = 0; i < listCars.size(); i++) {
                if (regNum.equals(listCars.get(i).getIdNumber().substring(3))){
                    yearsList.add(listCars.get(i).getYearRelease());
                    ++countCars;
                    sumAgeRelease = sumAgeRelease + listCars.get(i).getYearRelease();
                }
            }
            Collections.sort(yearsList);
            carsAgeInRegions.put(regNum, yearsList);
            int medianPosition = yearsList.size() / 2;
            int medianAgeRelease = yearsList.size() % 2 == 0 ? yearsList.get(medianPosition + 1) : yearsList.get(medianPosition);
            mediumAgeCarsInRegions.put(regNum, medianAgeRelease);
        }
        System.out.print("Всего машин в регионе по годам выпуска: ");
        System.out.println(carsAgeInRegions);
        System.out.print("Средний год выпуска в регионе: ");
        System.out.println(mediumAgeCarsInRegions);
    }
}
