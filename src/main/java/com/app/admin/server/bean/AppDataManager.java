package com.app.admin.server.bean;

import java.io.Serializable;

/**
 * app_data_manager
 *
 * @author
 */
public class AppDataManager  implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 数据1
     */
    private String dataOne;

    /**
     * 数据2
     */
    private String dataTwo;

    /**
     * 数据3
     */
    private String dataThree;

    /**
     * 数据4
     */
    private String dataFour;

    /**
     * 数据5
     */
    private String dataFive;

    /**
     * 数据6
     */
    private String dataSix;

    /**
     * 数据7
     */
    private String dataSeven;

    /**
     * 数据8
     */
    private String dataEight;

    /**
     * 数据9
     */
    private String dataNine;

    /**
     * 数据10
     */
    private String dataTen;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataOne() {
        return dataOne;
    }

    public void setDataOne(String dataOne) {
        this.dataOne = dataOne;
    }

    public String getDataTwo() {
        return dataTwo;
    }

    public void setDataTwo(String dataTwo) {
        this.dataTwo = dataTwo;
    }

    public String getDataThree() {
        return dataThree;
    }

    public void setDataThree(String dataThree) {
        this.dataThree = dataThree;
    }

    public String getDataFour() {
        return dataFour;
    }

    public void setDataFour(String dataFour) {
        this.dataFour = dataFour;
    }

    public String getDataFive() {
        return dataFive;
    }

    public void setDataFive(String dataFive) {
        this.dataFive = dataFive;
    }

    public String getDataSix() {
        return dataSix;
    }

    public void setDataSix(String dataSix) {
        this.dataSix = dataSix;
    }

    public String getDataSeven() {
        return dataSeven;
    }

    public void setDataSeven(String dataSeven) {
        this.dataSeven = dataSeven;
    }

    public String getDataEight() {
        return dataEight;
    }

    public void setDataEight(String dataEight) {
        this.dataEight = dataEight;
    }

    public String getDataNine() {
        return dataNine;
    }

    public void setDataNine(String dataNine) {
        this.dataNine = dataNine;
    }

    public String getDataTen() {
        return dataTen;
    }

    public void setDataTen(String dataTen) {
        this.dataTen = dataTen;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppDataManager other = (AppDataManager) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDataOne() == null ? other.getDataOne() == null : this.getDataOne().equals(other.getDataOne()))
                && (this.getDataTwo() == null ? other.getDataTwo() == null : this.getDataTwo().equals(other.getDataTwo()))
                && (this.getDataThree() == null ? other.getDataThree() == null : this.getDataThree().equals(other.getDataThree()))
                && (this.getDataFour() == null ? other.getDataFour() == null : this.getDataFour().equals(other.getDataFour()))
                && (this.getDataFive() == null ? other.getDataFive() == null : this.getDataFive().equals(other.getDataFive()))
                && (this.getDataSix() == null ? other.getDataSix() == null : this.getDataSix().equals(other.getDataSix()))
                && (this.getDataSeven() == null ? other.getDataSeven() == null : this.getDataSeven().equals(other.getDataSeven()))
                && (this.getDataEight() == null ? other.getDataEight() == null : this.getDataEight().equals(other.getDataEight()))
                && (this.getDataNine() == null ? other.getDataNine() == null : this.getDataNine().equals(other.getDataNine()))
                && (this.getDataTen() == null ? other.getDataTen() == null : this.getDataTen().equals(other.getDataTen()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataOne() == null) ? 0 : getDataOne().hashCode());
        result = prime * result + ((getDataTwo() == null) ? 0 : getDataTwo().hashCode());
        result = prime * result + ((getDataThree() == null) ? 0 : getDataThree().hashCode());
        result = prime * result + ((getDataFour() == null) ? 0 : getDataFour().hashCode());
        result = prime * result + ((getDataFive() == null) ? 0 : getDataFive().hashCode());
        result = prime * result + ((getDataSix() == null) ? 0 : getDataSix().hashCode());
        result = prime * result + ((getDataSeven() == null) ? 0 : getDataSeven().hashCode());
        result = prime * result + ((getDataEight() == null) ? 0 : getDataEight().hashCode());
        result = prime * result + ((getDataNine() == null) ? 0 : getDataNine().hashCode());
        result = prime * result + ((getDataTen() == null) ? 0 : getDataTen().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dataOne=").append(dataOne);
        sb.append(", dataTwo=").append(dataTwo);
        sb.append(", dataThree=").append(dataThree);
        sb.append(", dataFour=").append(dataFour);
        sb.append(", dataFive=").append(dataFive);
        sb.append(", dataSix=").append(dataSix);
        sb.append(", dataSeven=").append(dataSeven);
        sb.append(", dataEight=").append(dataEight);
        sb.append(", dataNine=").append(dataNine);
        sb.append(", dataTen=").append(dataTen);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}