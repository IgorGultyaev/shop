package shop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public interface ParserJsonToProduction {
    static Map<Integer, Production> jsonToProduction(String json) throws ParseException, ProductionTypeException {

        Map<Integer, Production> productions = new HashMap<>();
        JSONParser jsonParser = new JSONParser();
        JSONArray lang = (JSONArray) jsonParser.parse(json);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        for (Object jsonObj : lang) {
            Production production = gson.fromJson(jsonObj.toString(), Production.class);
            if (productions.containsKey(production.getProductionID())) {
                throw new ProductionTypeException("Поле productionID не должно повторяться");
            }
            productions.put(production.getProductionID(), production);
        }
        return productions;
    }
}
