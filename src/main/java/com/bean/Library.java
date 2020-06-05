package com.bean;

public class Library {
    private String libraryName;

    private String libraryCurator;

    private String libraryTelnumber;

    private String libraryAddress;

    private String libraryEmail;

    private String libraryUrl;

    private String libraryBuildingDate;

    private String libraryInfo;

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName == null ? null : libraryName.trim();
    }

    public String getLibraryCurator() {
        return libraryCurator;
    }

    public void setLibraryCurator(String libraryCurator) {
        this.libraryCurator = libraryCurator == null ? null : libraryCurator.trim();
    }

    public String getLibraryTelnumber() {
        return libraryTelnumber;
    }

    public void setLibraryTelnumber(String libraryTelnumber) {
        this.libraryTelnumber = libraryTelnumber == null ? null : libraryTelnumber.trim();
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress == null ? null : libraryAddress.trim();
    }

    public String getLibraryEmail() {
        return libraryEmail;
    }

    public void setLibraryEmail(String libraryEmail) {
        this.libraryEmail = libraryEmail == null ? null : libraryEmail.trim();
    }

    public String getLibraryUrl() {
        return libraryUrl;
    }

    public void setLibraryUrl(String libraryUrl) {
        this.libraryUrl = libraryUrl == null ? null : libraryUrl.trim();
    }

    public String getLibraryBuildingDate() {
        return libraryBuildingDate;
    }

    public void setLibraryBuildingDate(String libraryBuildingDate) {
        this.libraryBuildingDate = libraryBuildingDate == null ? null : libraryBuildingDate.trim();
    }

    public String getLibraryInfo() {
        return libraryInfo;
    }

    public void setLibraryInfo(String libraryInfo) {
        this.libraryInfo = libraryInfo == null ? null : libraryInfo.trim();
    }
}