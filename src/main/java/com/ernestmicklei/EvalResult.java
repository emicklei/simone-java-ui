package com.ernestmicklei;

import com.google.gson.Gson;

public class EvalResult {
    String error;
    String datatype;

    public EvalResult(String json) {
        Gson gson = new Gson();
        EvalResult r = gson.fromJson(json, EvalResult.class);
        this.error = r.error;
        this.datatype = r.datatype;
    }

//    public Map<String, String> parsedData() {
//        Gson gson = new Gson();
//        TypeToken<Map<String, String>> mapType = new TypeToken<Map<String, String>>() {
//        };
//        return gson.fromJson(this.data, mapType);
//    }
}

