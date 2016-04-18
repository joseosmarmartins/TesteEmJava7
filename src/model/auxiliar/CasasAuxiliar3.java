package model.auxiliar;

import java.util.ArrayList;
import java.util.List;

public class CasasAuxiliar3 {

    private String name;
    private String wikiSuffix;
    private String description;
    private String imageSuffix;
    private Integer numberPersons;

    private List<CasasAuxiliar3> houses = new ArrayList<>();
    private List<CasasAuxiliar3> people = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiSuffix() {
        return wikiSuffix;
    }

    public void setWikiSuffix(String wikiSuffix) {
        this.wikiSuffix = wikiSuffix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSuffix() {
        return imageSuffix;
    }

    public void setImageSuffix(String imageSuffix) {
        this.imageSuffix = imageSuffix;
    }

    public Integer getNumberPersons() {
        return numberPersons;
    }

    public void setNumberPersons(Integer numberPersons) {
        this.numberPersons = numberPersons;
    }

    public List<CasasAuxiliar3> getHouses() {
        return houses;
    }

    public void setHouses(List<CasasAuxiliar3> houses) {
        this.houses = houses;
    }

    public List<CasasAuxiliar3> getPeople() {
        return people;
    }

    public void setPeople(List<CasasAuxiliar3> people) {
        this.people = people;
    }
}
