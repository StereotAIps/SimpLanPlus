package utils;

import symboltable.VarInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class Utils {

    public static ArrayList<String> TakeDeclaredVariables(HashMap<String, VarInfo> ambiente){
        Iterator hmIterator = ambiente.entrySet().iterator();
        ArrayList<String> result=new ArrayList<String>();
        while (hmIterator.hasNext()) {
            Map.Entry<String, VarInfo> mapElement= (Map.Entry)hmIterator.next();
            if(mapElement.getValue().equals(true)) {
                result.add(mapElement.getKey());
            }
        }
        return result;
    }

    public static ArrayList<String> CompareEnvironmentVariables(ArrayList<String> thenList, ArrayList<String> elseList) {
        ArrayList<String> result=new ArrayList<String>();
        for(String element:thenList) {
            if(elseList.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void UpdateHashMap(HashMap<String,VarInfo> hash, ArrayList<String> variablesToUpdate){
        for(String variable:variablesToUpdate){
            if(hash.get(variable)!=null){
                hash.put(variable, new VarInfo(true));
            }
        }
    }
}