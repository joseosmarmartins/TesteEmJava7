package model.auxiliar;

import java.util.ArrayList;
import java.util.List;

public class CasasAuxiliar {

    private String name;
    private String wikiSuffix;
    private String description;
    private String imageSuffix;

    private List<CasasAuxiliar> houses = new ArrayList<>();
    private List<CasasAuxiliar> people = new ArrayList<>();

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

    public List<CasasAuxiliar> getHouses() {
        return houses;
    }

    public void setHouses(List<CasasAuxiliar> houses) {
        this.houses = houses;
    }

    public List<CasasAuxiliar> getPeople() {
        return people;
    }

    public void setPeople(List<CasasAuxiliar> people) {
        this.people = people;
    }
}
