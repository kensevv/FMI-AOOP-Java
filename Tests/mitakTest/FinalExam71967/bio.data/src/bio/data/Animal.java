package bio.data;

import java.util.Arrays;

public class Animal {
    private String name;
    private AnimalType animalType;
    private boolean predator;
    private String region;
    private boolean endangered;

    public static final String[] REGIONS = {"Africa", "Asia", "Australia", "Europe", "America"};

    public String getName() {
        return new String(name);
    }

    public Animal(String name, AnimalType animalType, boolean predator, String region, boolean endangered) {
        setName(name);
        setAnimalType(animalType);
        setPredator(predator);
        setRegion(region);
        setEndangered(endangered);
    }

    @Override
    public String toString() {
        return String.format("Животно { %s, тип= %s, хищник= %s, район= %s, застрашен= %s",
                name,
                this.animalType.getTypeName(),
                predator ? "Да" : "Не",
                this.region,
                endangered ? "Да" : "Не");
    }

    public void setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            this.name = "Default Name";
        }
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        if (animalType != null) {
            this.animalType = animalType;
        } else {
            // no default value provided in the task description
            this.animalType = AnimalType.BIRD;
        }
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public String getRegion() {
        return new String(region);
    }

    public void setRegion(String region) {
        if (region != null && region.length() > 0
                && Arrays.asList(REGIONS).contains(region)) {
            //Arrays.stream(this.REGIONS).filter(element -> element.equalsIgnoreCase(region)).collect(Collectors.toList()).size() > 0;
            this.region = region;
        } else {
            this.name = "Unknown";
        }
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }
}
