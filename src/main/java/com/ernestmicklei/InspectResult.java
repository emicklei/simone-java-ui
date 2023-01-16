package com.ernestmicklei;

import com.google.gson.Gson;
import java.util.Map;

public class InspectResult {
    String error;
    boolean is_array;
    Map<String,Object> object;
    String datatype;

    public InspectResult(String json) {
        Gson gson = new Gson();
        InspectResult r = gson.fromJson(json, InspectResult.class);
        this.error = r.error;
        this.object = r.object;
        this.datatype = r.datatype;
        this.is_array = r.datatype.startsWith("[]");
    }
}

