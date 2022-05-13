package com.intuitbrains.model.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class Rank {
    @Id
    private int id;
    private String name;
    private RankCategory rankCategory;
    private RankSubCategory rankSubCategory;

    public Rank() {
    }

    public static List<Rank> getList() {
        return new ArrayList<>(Arrays.asList(ALL, CAPTAIN, CHIEF_OFFICER, SECOND_OFFICER, THIRD_OFFICER, DECK_CADET,
                BOSUN, AB_SEAMAN, OS_SEAMAN, TRAINEE_SEAMAN, DECK_FITTER,
                CHIEF_ENGINEER, SECOND_ENGINEER, THIRD_ENGINEER, FOURTH_ENGINEER, FIFTH_ENGINEER, JR_ENGINEER, ETO,
                MOTORMAN, WIPER, OILER, ENGINE_FITTER, CHIEF_COOK, SECOND_COOK, MESSMAN_COOK, TRAINEEE_MESSMAN));
    }

    public static List<Rank> getDeckDeptList() {
        return new ArrayList<>(Arrays.asList(CAPTAIN, CHIEF_OFFICER, SECOND_OFFICER, THIRD_OFFICER, DECK_CADET,
                BOSUN, AB_SEAMAN, OS_SEAMAN, TRAINEE_SEAMAN, DECK_FITTER));
    }

    public static List<Rank> getEngineDeptList() {
        return new ArrayList<>(Arrays.asList(CHIEF_ENGINEER, SECOND_ENGINEER, THIRD_ENGINEER, FOURTH_ENGINEER, FIFTH_ENGINEER, JR_ENGINEER, ETO, MOTORMAN, WIPER, OILER, ENGINE_FITTER));
    }

    public static List<Rank> getGalleyDeptList() {
        return new ArrayList<>(Arrays.asList(CHIEF_COOK, SECOND_COOK, MESSMAN_COOK, TRAINEEE_MESSMAN));
    }

    public static final Rank ALL = new Rank(RankCategory.ALL, RankSubCategory.OFFICER, 0, "All");
    public static final Rank CAPTAIN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 1, "Captain/Master");
    public static final Rank CHIEF_OFFICER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 2, "Chief Officer");
    public static final Rank SECOND_OFFICER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 3, "Second Officer");
    public static final Rank THIRD_OFFICER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 4, "Third Officer");
    public static final Rank DECK_CADET = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 5, "Deck Cadet (Trainee Officer)");

    public static final Rank BOSUN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 6, "Bosun");
    public static final Rank AB_SEAMAN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 7, "AB (Able Seaman)");
    public static final Rank OS_SEAMAN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 8, "OS (Ordinary Seaman)");
    public static final Rank TRAINEE_SEAMAN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 9, "Trainee Seaman");
    public static final Rank DECK_FITTER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 10, "Deck Fitter");

    public static final Rank CHIEF_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 11, "Chief Engineer");
    public static final Rank SECOND_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 12, "Second Engineer");
    public static final Rank THIRD_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 13, "Third Engineer");
    public static final Rank FOURTH_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 14, "Fourth Engineer");
    public static final Rank FIFTH_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 15, "Fifth Engineer");
    public static final Rank JR_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 16, "Junior Engineer/Engine Cadet");
    public static final Rank ETO = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 17, "ETO (Electrical Officer)");

    public static final Rank MOTORMAN = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 18, "Motorman");
    public static final Rank WIPER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 19, "Wiper");
    public static final Rank OILER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 20, "Oiler");
    public static final Rank ENGINE_FITTER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 21, "Engine Fitter");

    public static final Rank CHIEF_COOK = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 22, "Chief Cook");
    public static final Rank SECOND_COOK = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 23, "Second Cook");
    public static final Rank MESSMAN_COOK = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 24, "Messman");
    public static final Rank TRAINEEE_MESSMAN = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 25, "Trainee Messman");


    public Rank(RankCategory rankCategory, RankSubCategory rankSubCategory, int id, String name) {
        this.rankCategory = rankCategory;
        this.rankSubCategory = rankSubCategory;
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RankCategory getRankCategory() {
        return rankCategory;
    }

    public RankSubCategory getRankSubCategory() {
        return rankSubCategory;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rankCategory == null) ? 0 : rankCategory.hashCode());
        result = prime * result + ((rankSubCategory == null) ? 0 : rankSubCategory.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rank other = (Rank) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rankCategory == null) {
            if (other.rankCategory != null)
                return false;
        } else if (!rankCategory.equals(other.rankCategory))
            return false;
        if (rankSubCategory == null) {
            if (other.rankSubCategory != null)
                return false;
        } else if (!rankSubCategory.equals(other.rankSubCategory))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Rank [id=" + id + ", name=" + name + ", rankCategory=" + rankCategory.getName() + ", rankSubCategory="
                + rankSubCategory.getName() + "]";
    }


    public static Rank createFromId(int typeId) {
        return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
    }

    public static Rank createFromDesc(String desc) {
        return ((getList().stream().filter(o -> o.getName().equalsIgnoreCase(desc)).collect(Collectors.toList())).get(0));
    }

    public static Map<String, List<Rank>> getByGroup() {
        Map<String, List<Rank>> rankMap = new HashMap<>();
        for (Rank sType : getList()) {
            String key = sType.getRankCategory().getName();
            if (!rankMap.containsKey(key)) {
                List<Rank> list = new ArrayList<>();
                list.add(sType);
                rankMap.put(key, list);
            } else {
                List<Rank> list = rankMap.get(key);
                list.add(sType);
                rankMap.put(key, list);
            }
        }
        return rankMap;
    }

    public static List<Rank> getBySubCategory(RankSubCategory rankSubCategory) {
        List<Rank> list = new ArrayList<>();
        getList().forEach(r -> {
            if (r.getRankSubCategory().equals(rankSubCategory)) {
                list.add(r);
            }
        });
        return list;
    }

    public static List<Integer> getIdsBySubCategory(RankSubCategory rankSubCategory) {
        List<Integer> list = new ArrayList<>();
        getList().forEach(r -> {
            if (r.getRankSubCategory().equals(rankSubCategory)) {
                list.add(r.getId());
            }
        });
        return list;
    }

}
