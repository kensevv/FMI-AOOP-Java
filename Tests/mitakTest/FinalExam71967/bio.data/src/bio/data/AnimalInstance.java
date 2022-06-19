package bio.data;

public class AnimalInstance {
    private int animalKey;
    private String animalName;
    private int animalAge;

    private final String INSTANCE_ID;

    private static int nextInstanceId = 1;

    public AnimalInstance(int animalKey, String animalName, int animalAge) {
        setAnimalKey(animalKey);
        setAnimalName(animalName);
        setAnimalAge(animalAge);

        INSTANCE_ID = String.format("%s%s",
                animalName,
                generateUniqueId());
        nextInstanceId++;
    }

    private String generateUniqueId() {
        String result = Integer.toString(nextInstanceId);
        for (int i = 0; i < result.length(); i++) {
            result = "0" + result;
        }
        return result;
    }

    public int getAnimalKey() {
        return animalKey;
    }

    public void setAnimalKey(int animalKey) {
        this.animalKey = animalKey;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public String getINSTANCE_ID() {
        return INSTANCE_ID;
    }

    @Override
    public String toString() {
        return String.format("%s %s, Възраст: %d",
                animalName, INSTANCE_ID, animalAge);
    }

}
