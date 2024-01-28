package com.dreamhomes.dreamhomes.models;

public class Home {
    private int homeId;
    private final int addressId;
    private final double homePrice;
    private final int bedNumber;
    private final int bathNumber;
    private final double homeArea;
    private final String homeAbout;
    private final int yearBuilt;
    private final String homeType;
    private final String homeUtilities;
    private final String homeCategory;
    private final String agentName;
    private final String agentNumber;
    private String mainPic;
    private String pic1;
    private String pic2;
    private String pic3;
    private String pic4;
    private String pic5;
    private String pic6;
    private Address address;

    public Home(int homeId, int addressId, double homePrice, int bedNumber, int bathNumber, double homeArea, String homeAbout, int yearBuilt, String homeType, String homeUtilities, String homeCategory, String agentName, String agentNumber, String mainPic, String pic1, String pic2, String pic3, String pic4, String pic5, String pic6) {
        this.homeId = homeId;
        this.addressId = addressId;
        this.homePrice = homePrice;
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.homeArea = homeArea;
        this.homeAbout = homeAbout;
        this.yearBuilt = yearBuilt;
        this.homeType = homeType;
        this.homeUtilities = homeUtilities;
        this.homeCategory = homeCategory;
        this.agentName = agentName;
        this.agentNumber = agentNumber;
        this.mainPic = mainPic;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.pic4 = pic4;
        this.pic5 = pic5;
        this.pic6 = pic6;
    }

    public Home(int homeId, int addressId, double homePrice, int bedNumber, int bathNumber, double homeArea, String homeAbout, int yearBuilt, String homeType, String homeUtilities, String homeCategory, String agentName, String agentNumber, String mainPic, String pic1, String pic2, String pic3, String pic4, String pic5, String pic6, Address address) {
        this.homeId = homeId;
        this.addressId = addressId;
        this.homePrice = homePrice;
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.homeArea = homeArea;
        this.homeAbout = homeAbout;
        this.yearBuilt = yearBuilt;
        this.homeType = homeType;
        this.homeUtilities = homeUtilities;
        this.homeCategory = homeCategory;
        this.agentName = agentName;
        this.agentNumber = agentNumber;
        this.mainPic = mainPic;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.pic4 = pic4;
        this.pic5 = pic5;
        this.pic6 = pic6;
        this.address = address;
    }

    public Home(int addressId, double homePrice, int bedNumber, int bathNumber, double homeArea, String homeAbout, int yearBuilt, String homeType, String homeUtilities, String homeCategory, String agentName, String agentNumber, String mainPic, String pic1, String pic2, String pic3, String pic4, String pic5, String pic6, Address address) {
        this.addressId = addressId;
        this.homePrice = homePrice;
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.homeArea = homeArea;
        this.homeAbout = homeAbout;
        this.yearBuilt = yearBuilt;
        this.homeType = homeType;
        this.homeUtilities = homeUtilities;
        this.homeCategory = homeCategory;
        this.agentName = agentName;
        this.agentNumber = agentNumber;
        this.mainPic = mainPic;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.pic4 = pic4;
        this.pic5 = pic5;
        this.pic6 = pic6;
        this.address = address;
    }
    public Home(int homeId, int addressId, double homePrice, int bedNumber, int bathNumber, double homeArea, String homeAbout, int yearBuilt, String homeType, String homeUtilities, String homeCategory, String agentName, String agentNumber, Address address) {
        this.homeId = homeId;
        this.addressId = addressId;
        this.homePrice = homePrice;
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.homeArea = homeArea;
        this.homeAbout = homeAbout;
        this.yearBuilt = yearBuilt;
        this.homeType = homeType;
        this.homeUtilities = homeUtilities;
        this.homeCategory = homeCategory;
        this.agentName = agentName;
        this.agentNumber = agentNumber;
        this.address = address;
    }


    public int getHomeId() {
        return homeId;
    }

    public int getAddressId() {
        return addressId;
    }

    public double getHomePrice() {
        return homePrice;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public int getBathNumber() {
        return bathNumber;
    }

    public double getHomeArea() {
        return homeArea;
    }

    public String getHomeAbout() {
        return homeAbout;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public String getHomeType() {
        return homeType;
    }
    public String getHomeUtilities() {
        return homeUtilities;
    }

    public String getHomeCategory() {
        return homeCategory;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getAgentNumber() {
        return agentNumber;
    }

    public String getMainPic() {
        return mainPic;
    }

    public String getPic1() {
        return pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public String getPic4() {
        return pic4;
    }

    public String getPic5() {
        return pic5;
    }

    public String getPic6() {
        return pic6;
    }

    public Address getAddress() {
        return address;
    }
}
