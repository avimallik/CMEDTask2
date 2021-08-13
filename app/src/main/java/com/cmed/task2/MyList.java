package com.cmed.task2;

import com.google.gson.annotations.SerializedName;

public class MyList {

    @SerializedName("name")
    public String artistname="";

    @SerializedName("image")
    public String artistimage="";

    @SerializedName("actor")
    public String actorname="";

    @SerializedName("gender")
    public String artistgender="";

    public MyList(String artistname, String artistimage, String actorname, String artistgender) {

        this.artistname = artistname;
        this.artistimage = artistimage;
        this.actorname = actorname;
        this.artistgender = artistgender;
    }

    public MyList() {
    }
}
