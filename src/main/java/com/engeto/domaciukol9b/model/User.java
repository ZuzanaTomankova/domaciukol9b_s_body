package com.engeto.domaciukol9b.model;

public class User {
    private String contribution;
    private int contributionId;
    private boolean isVisible;
    private String user;

    public User(String contribution, int contributionId, boolean isVisible, String user) {
        this.contribution = contribution;
        this.contributionId = contributionId;
        this.isVisible = isVisible;
        this.user = user;
    }

    public User() {
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public int getContributionId() {
        return contributionId;
    }

    public void setContributionId(int contributionId) {
        this.contributionId = contributionId;
    }



    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean visible) {
        isVisible = visible;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
