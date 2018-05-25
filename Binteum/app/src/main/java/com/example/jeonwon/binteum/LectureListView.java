package com.example.jeonwon.binteum;

public class LectureListView {
    int LID;
    String L_Num, Title, FullInfo;

    public void setLID(int LID) {
        this.LID = LID;
    }

    public void setL_Num(String L_Num) {
        this.L_Num = L_Num;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setFullInfo(String FullInfo) {
        this.FullInfo = FullInfo;
    }

    public int getLID() {
        return this.LID;
    }

    public String getL_Num() {
        return this.L_Num;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getFullInfo() {
        return this.FullInfo;
    }


}
