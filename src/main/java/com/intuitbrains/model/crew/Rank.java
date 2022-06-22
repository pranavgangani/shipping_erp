package com.intuitbrains.model.crew;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class Rank {
    private int id;
    private int groupId;
    private String name;
    private String shortName;
    private boolean isSupr;
    private RankCategory rankCategory;
    private RankSubCategory rankSubCategory;

    public Rank() {
    }

    public static List<Rank> getList() {
        return new ArrayList<>(Arrays.asList(CAPTAIN, CHIEF_OFFICER_SUPR,CHIEF_OFFICER, SECOND_OFFICER_SUPR,SECOND_OFFICER, THIRD_OFFICER, DECK_CADET,
                CHIEF_OFFICER_SUPR, AB_SEAMAN, OS_SEAMAN, TRAINEE_SEAMAN, DECK_FITTER,
                CHIEF_ENGINEER, SECOND_ENGINEER, THIRD_ENGINEER, FOURTH_ENGINEER, FIFTH_ENGINEER, JR_ENGINEER, ETO,EO,TREO,
                MOTORMAN, WIPER, SECOND_OFFICER_SUPR, SECOND_ENGINEER_SUPR, CHIEF_COOK, SECOND_COOK, MESSMAN_COOK, THIRD_ENGINEER_SUPR));
    }

    //public static final Rank ALL = new Rank(RankCategory.ALL, RankSubCategory.OFFICER, 0, "All");
    public static final Rank CAPTAIN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 1, 1, "Captain/Master", "MSTR", false);
    public static final Rank CHIEF_OFFICER_SUPR = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 2, 2, "Chief Officer(Supr)", "CO WITH SUPR", true);
    public static final Rank CHIEF_OFFICER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 3, 2, "Chief Officer", "CO", false);

    public static final Rank SECOND_OFFICER_SUPR = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 4, 3, "Second Officer(Supr)", "2O WITH SUPR", true);
    public static final Rank SECOND_OFFICER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 5, 3, "Second Officer", "2O", false);
    public static final Rank THIRD_OFFICER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 6, 4, "Third Officer", "3O", false);
    public static final Rank DECK_CADET = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.OFFICER, 7, 5, "Cadet", "CDT", false);
    public static final Rank CHIEF_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 8, 6, "Chief Engineer", "CE", false);
    public static final Rank SECOND_ENGINEER_SUPR = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 9, 7, "Second Engineer(Supr)", "2E WITH SUPR", true);
    public static final Rank SECOND_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 10, 7, "Second Engineer", "2E", false);
    public static final Rank THIRD_ENGINEER_SUPR = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 11, 8, "Third Engineer(Supr)", "3E WITH SPR", true);
    public static final Rank THIRD_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 12, 8, "Third Engineer", "3E", false);
    public static final Rank FOURTH_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 13, 9, "Fourth Engineer", "4E", false);
    public static final Rank FIFTH_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 14, 10, "Fifth Engineer", "5E", false);
    public static final Rank JR_ENGINEER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 15, 11, "Junior Engineer", "JE", false);
    public static final Rank EO = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 16, 12, "Electrical Officer", "EO", false);

    public static final Rank ETO = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 17, 13, "Electrical Technical Officer", "ETO", false);
    public static final Rank TREO = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.ENGINEER, 18, 14, "Trainee Electrical Officer", "TR EO", false);
    //public static final Rank BOSUN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 6, "Bosun");
    public static final Rank AB_SEAMAN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 19, 15, "Able Seaman", "AB", false);
    public static final Rank OS_SEAMAN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 20, 16, "Ordinary Seaman", "OS", false);
    public static final Rank TRAINEE_SEAMAN = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 21, 17, "Trainee Seaman", "TR OS", false);
    public static final Rank DECK_FITTER = new Rank(RankCategory.DECK_DEPARTMENT, RankSubCategory.RATING, 22, 18, "Fitter", "FTR", false);


    public static final Rank MOTORMAN = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 23, 19, "Motorman", "MM", false);
    public static final Rank WIPER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 24, 20, "Wiper", "WPR", false);
    //public static final Rank OILER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 20, "Oiler");
//    public static final Rank ENGINE_FITTER = new Rank(RankCategory.ENGINE_DEPARTMENT, RankSubCategory.RATING, 21, "Engine Fitter");

    public static final Rank CHIEF_COOK = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 25, 21, "Chief Cook", "CCK", false);
    public static final Rank SECOND_COOK = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 26, 22, "General Steward", "GS", false);
    public static final Rank MESSMAN_COOK = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 27, 23, "Welder", "WLDR", false);
    //public static final Rank TRAINEEE_MESSMAN = new Rank(RankCategory.GALLEY_DEPARTMENT, RankSubCategory.OTHER, 25, "Trainee Messman");


    public Rank(RankCategory rankCategory, RankSubCategory rankSubCategory, int id, int groupId, String name, String shortName, boolean isSupr) {
        this.rankCategory = rankCategory;
        this.rankSubCategory = rankSubCategory;
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.shortName = shortName;
        this.isSupr = isSupr;
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

    public int getGroupId() {
        return groupId;
    }

    public String getShortName() {
        return shortName;
    }

    public boolean isSupr() {
        return isSupr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return id == rank.id && groupId == rank.groupId && name.equals(rank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, name);
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

    public static void main(String[] args) {
        getList().forEach(r -> System.out.println(r.getName()));

    }
}
