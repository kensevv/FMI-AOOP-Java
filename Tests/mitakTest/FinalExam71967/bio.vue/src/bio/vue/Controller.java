package bio.vue;

import bio.data.Animal;
import bio.data.AnimalInstance;
import bio.data.AnimalType;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    private AnimalInstance[] samples;
    private Animal[] animals;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnShuffle;

    @FXML
    private Button btnDistribution;

    @FXML
    private Button btnSortByAge;

    @FXML
    private Button btnEndangered;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea textField;

    @FXML
    void btnDistributionOnAction(ActionEvent event) {
        Map<String, Long> distributionResult =
                Arrays.stream(samples).map(it -> animals[it.getAnimalKey()])
                        .collect(Collectors.groupingBy(Animal::getRegion, Collectors.counting()));

        textField.setText("");
        for (Map.Entry<String, Long> entry : distributionResult.entrySet()) {
            textField.appendText(entry.getKey() + " : " + entry.getValue() + "\n");
        }
    }

    @FXML
    void btnEndangeredOnAction(ActionEvent event) {
        Map<AnimalType, Long> endangeredResult =
                Arrays.stream(samples).map(it -> animals[it.getAnimalKey()])
                        .filter(it -> it.isEndangered() == true)
                        .collect(Collectors.groupingBy(Animal::getAnimalType, Collectors.counting()));

        textField.setText("");
        for (Map.Entry<AnimalType, Long> entry : endangeredResult.entrySet()) {
            textField.appendText(entry.getKey().getTypeName() + " : " + entry.getValue() + "\n");
        }
        // getting the ones that have 0
        Arrays.stream(samples).map(it -> animals[it.getAnimalKey()])
                .filter(it -> it.isEndangered() == false).map(it -> it.getAnimalType()).forEach(
                it -> {
                    textField.appendText(it.getTypeName() + " : " + "0" + "\n");
                }
        );
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnShuffleOnAction(ActionEvent event) {
        List<AnimalInstance> samplesList = Arrays.asList(samples);
        Collections.shuffle(samplesList);
        samplesList.toArray(samples);

        textField.setText("");
        Arrays.stream(samples).forEach(animalInstance -> {
                    textField.appendText(animalInstance.toString() + "\n");
                }
        );
    }

    @FXML
    void btnSortByAgeOnAction(ActionEvent event) {
        samples = Arrays.asList(samples).stream().sorted(Comparator.comparing(AnimalInstance::getAnimalAge)).toArray(AnimalInstance[]::new);

        textField.setText("");
        Arrays.stream(samples).forEach(animalInstance -> {
                    textField.appendText(animalInstance.toString() + "\n");
                }
        );
    }

    @FXML
    void initialize() {
        assert btnShuffle != null : "fx:id=\"btnShuffle\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDistribution != null : "fx:id=\"btnDistribution\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSortByAge != null : "fx:id=\"btnSortByAge\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEndangered != null : "fx:id=\"btnEndangered\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'sample.fxml'.";

        animals = new Animal[]{
                new Animal("Тигър", AnimalType.MAMMAL, true, "Asia", true),
                new Animal("Фламинго", AnimalType.BIRD, false, "Africa", true),
                new Animal("Гущер", AnimalType.REPTILE, true, "Australia", true),
                new Animal("Пъстърва", AnimalType.FISH, false, "Europe", false),
                new Animal("Делфин", AnimalType.MAMMAL, false, "Australia", true),
                new Animal("Вълк", AnimalType.MAMMAL, true, "America", false),
        };

        generate20AnimalInstances();
    }

    private void generate20AnimalInstances() {
        samples = new AnimalInstance[20];

        Random random = new Random();
        int min = 0;
        int max = this.animals.length;

        for (int i = 0; i < 20; i++) {
            int animalIndex = random.nextInt(max - min) + min;
            samples[i] = new AnimalInstance(
                    animalIndex,
                    animals[animalIndex].getName(),
                    random.nextInt(20) + 10
            );
        }
    }
}
