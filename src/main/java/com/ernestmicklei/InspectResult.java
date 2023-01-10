package com.ernestmicklei;

import com.google.gson.Gson;

public class InspectResult {
    String error;
    String datatype;

    public InspectResult(String json) {
        Gson gson = new Gson();
        EvalResult r = gson.fromJson(json, EvalResult.class);
        this.error = r.error;
        this.datatype = r.datatype;
    }
}

