// Budowniczy jest wzorcem kreacyjnym, w którym upraszczamy tworzenie złożonych obiektów poprzez podzielenie procesu na etapy.
// Wzorzec pozwala produkować różne typy oraz reprezentacje obiektu używając tego samego kodu konstrukcyjnego.

public class Car {
    // wymagane parametry
    private Int horsepower;
    private Int maxMPH;
    private Double fuelConsumptionRate;

    // opcjonalne parametry
    private boolean isElectric;
    private boolean hasExternalStorage;

    public Car(CarBuilder carBuilder) {
        this.horsepower = carBuilder.horsepower;
        this.maxMPH = carBuilder.maxMPH;
        this.fuelConsumptionRate = carBuilder.fuelConsumptionRate;
        this.isElectric = carBuilder.isElectric;
        this.hasExternalStorage = carBuilder.hasExternalStorage;
    }

    public Int getHorsepower() {
        return horsepower;
    }

    public Int getMaxMPH() {
        return maxMPH;
    }

    public Double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public boolean isHasExternalStorage() {
        return hasExternalStorage;
    }

    // klasa budowniczego
    public static class CarBuilder {
        // wymagane parametry
        private Int horsepower;
        private Int maxMPH;
        private Double fuelConsumptionRate;

        // opcjonalne parametry
        private boolean isElectric;
        private boolean hasExternalStorage;

        public CarBuilder setElectric(boolean electric) {
            isElectric = electric;
            return this;
        }

        public CarBuilder setHasExternalStorage(boolean hasExternalStorage) {
            this.hasExternalStorage = hasExternalStorage;
            return this;
        }

        public CarBuilder(Int horsepower, Int maxMPH, Double fuelConsumptionRate) {
            this.horsepower = horsepower;
            this.maxMPH = maxMPH;
            this.fuelConsumptionRate = fuelConsumptionRate;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        // wykorzystanie budowniczego pozwala rozbić kroki budowania instancji klasy Car na bardziej czytelne
        Car car = new Car.CarBuilder(700, 240, 11.3)
                .setElectric(false)
                .setHasExternalStorage(true)
                .build();
    }
}
