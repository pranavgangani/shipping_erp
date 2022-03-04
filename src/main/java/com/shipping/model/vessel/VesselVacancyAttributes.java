package com.shipping.model.vessel;

import java.util.List;

public class VesselVacancyAttributes {
    private List<Long> minRankList;
    private List<Integer> minVesselTypeIdList;
    private List<Integer> minVesselSubTypeIdList;
    private int minGrossTonnage;

    public List<Long> getMinRankList() {
        return minRankList;
    }

    public void setMinRankList(List<Long> minRankList) {
        this.minRankList = minRankList;
    }

    public List<Integer> getMinVesselTypeIdList() {
        return minVesselTypeIdList;
    }

    public void setMinVesselTypeIdList(List<Integer> minVesselTypeIdList) {
        this.minVesselTypeIdList = minVesselTypeIdList;
    }

    public List<Integer> getMinVesselSubTypeIdList() {
        return minVesselSubTypeIdList;
    }

    public void setMinVesselSubTypeIdList(List<Integer> minVesselSubTypeIdList) {
        this.minVesselSubTypeIdList = minVesselSubTypeIdList;
    }

    public int getMinGrossTonnage() {
        return minGrossTonnage;
    }

    public void setMinGrossTonnage(int minGrossTonnage) {
        this.minGrossTonnage = minGrossTonnage;
    }
}
