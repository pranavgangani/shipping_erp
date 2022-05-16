package com.intuitbrains.model.vessel;

import com.intuitbrains.model.crew.Rank;

import java.util.List;

public class VesselVacancyAttributes {
    private List<Rank> minRankList;
    private List<VesselType> minVesselTypeIdList;
    private List<VesselSubType> minVesselSubTypeIdList;
    private int minGrossTonnage;

    public List<Rank> getMinRankList() {
        return minRankList;
    }

    public void setMinRankList(List<Rank> minRankList) {
        this.minRankList = minRankList;
    }

    public List<VesselType> getMinVesselTypeIdList() {
        return minVesselTypeIdList;
    }

    public void setMinVesselTypeIdList(List<VesselType> minVesselTypeIdList) {
        this.minVesselTypeIdList = minVesselTypeIdList;
    }

    public List<VesselSubType> getMinVesselSubTypeIdList() {
        return minVesselSubTypeIdList;
    }

    public void setMinVesselSubTypeIdList(List<VesselSubType> minVesselSubTypeIdList) {
        this.minVesselSubTypeIdList = minVesselSubTypeIdList;
    }

    public int getMinGrossTonnage() {
        return minGrossTonnage;
    }

    public void setMinGrossTonnage(int minGrossTonnage) {
        this.minGrossTonnage = minGrossTonnage;
    }

    @Override
    public String toString() {
        return "VesselVacancyAttributes{" +
                "minRankList=" + minRankList +
                ", minVesselTypeIdList=" + minVesselTypeIdList +
                ", minVesselSubTypeIdList=" + minVesselSubTypeIdList +
                ", minGrossTonnage=" + minGrossTonnage +
                '}';
    }
}
