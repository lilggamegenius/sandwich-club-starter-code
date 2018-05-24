package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject objName = obj.getJSONObject("name");
            String mainName = objName.getString("mainName");

            JSONArray jsonArray = objName.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++) alsoKnownAs.add(i, jsonArray.getString(i));

            String placeOfOrigin = obj.getString("placeOfOrigin");
            String description = obj.getString("description");
            String image = obj.getString("image");
            jsonArray = obj.getJSONArray("ingredients");

            List<String> ingredients = new ArrayList<>(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++) ingredients.add(i, jsonArray.getString(i));

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }catch(JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
