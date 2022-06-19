package bio.data;

public enum AnimalType {
    BIRD("Птица"),
    MAMMAL("Бозайник"),
    REPTILE ("Влечуго"),
    FISH("Риба");

    private String typeName;

    AnimalType(String typeName) {
        if (typeName != null && typeName.length() > 0) {
            this.typeName = typeName;
        }
    }

    public String getTypeName() {
        return typeName;
    }
}
