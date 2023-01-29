package MedianAgeReleaseCar;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionMedianAgeTask {

    private static class Car {
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

    private static HashSet<String> getRegionNumber(List<Car> carsList){
        HashSet<String> regionNumberSet = new HashSet<>();
        for (int i = 0; i < carsList.size(); i++) {
            String fullNumber = carsList.get(i).getIdNumber();
            String number = fullNumber.substring(fullNumber.length() - 2);
            regionNumberSet.add(number);
        }
        return regionNumberSet;
    }

    private static HashMap<String, List<Integer>>getSortedYearsRegionsMap(HashSet<String>regionsNums, List<Car> carsList){
        HashMap<String, List<Integer>> YearsCarsInRegion = new HashMap<>();
        for (String regNum: regionsNums){
            List <Integer> yearsList = new ArrayList<>();
            for (Car car : carsList) {
                String fullNumber = car.getIdNumber();
                if (regNum.equals(fullNumber.substring(fullNumber.length() - 2))) {
                    yearsList.add(car.getYearRelease());
                }
            }
            Collections.sort(yearsList);
            YearsCarsInRegion.put(regNum, yearsList);
        }
        return YearsCarsInRegion;
    }

    private static HashMap<String, Integer> getMedianYearReleaseMap(HashMap<String, List<Integer>> carsYearReleaseMap){
        HashMap <String, Integer> medianYearsCarsMap = new HashMap<>();
        for (String region: carsYearReleaseMap.keySet()){
            List<Integer> yearsList = carsYearReleaseMap.get(region);
            if (yearsList.size() == 1 || yearsList.size() == 2){
                medianYearsCarsMap.put(region, yearsList.get(0));
                continue;
            }
            int medianPosition = yearsList.size() / 2;
            medianYearsCarsMap.put(region, yearsList.get(medianPosition));
        }
        return medianYearsCarsMap;
    }

    public static void main(String[] args) {

        Car car1 = new Car(1980, "qwe73");
        Car car2 = new Car(2001, "qwe01");
        Car car3 = new Car(2020, "qwe12");
        Car car4 = new Car(2017, "qwe73");
        Car car5 = new Car(2009, "qwe01");
        Car car6 = new Car(2012, "qwe73");
        Car car7 = new Car(2013, "qwe01");
        Car car8 = new Car(2010, "rty12");

        List <Car> listCars = Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8);

        // Автомобили рассортированы правильно, если:
        // 73 = [1980, 2017, 2012]
        // 01 = [2001, 2009, 2013]
        // 12 = [2020]
        if (listCars.size() == 0){
            System.out.println("Список автомобилей пуст.");
            System.exit(0);
        }

        HashSet <String> keysForCarAgeMap = getRegionNumber(listCars);
        HashMap <String, List<Integer>> carsYearReleaseMap = getSortedYearsRegionsMap(keysForCarAgeMap, listCars);
        HashMap <String, Integer> medianAgeCarsInRegions = getMedianYearReleaseMap(carsYearReleaseMap);

        System.out.println(carsYearReleaseMap);
        System.out.println(medianAgeCarsInRegions);
        }
    }

/* с использованием .groupBy()

    Map <String, List <Car>> carsYearsReleaseList = listCars.stream().collect(Collectors.groupingBy(Car::getIdNumber));
        System.out.println(carsYearsReleaseList);
        int medianPosition = yearsList.size() / 2;

 */
