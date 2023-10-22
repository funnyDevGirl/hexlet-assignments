package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, Object> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> result = new LinkedHashMap<>(map1);
        result.putAll(map2);

        Set<String> aset = new TreeSet<>(map1.keySet());
        Set<String> bset = new TreeSet<>(map2.keySet());

        //пересечение:
        Set<String> intersection = new TreeSet<>();
        intersection.addAll(aset);
        intersection.retainAll(bset);

        //разность: удаление того, что нет в bset
        Set<String> difference1 = new TreeSet<>();
        difference1.addAll(aset);
        difference1.removeAll(bset);

        //разность: удаление того, что нет в aset
        Set<String> difference2 = new TreeSet<>();
        difference2.addAll(bset);
        difference2.removeAll(aset);

        for (Map.Entry<String, Object> resultSets : result.entrySet()) {
            //"deleted"
            if (difference1.contains(resultSets.getKey())) {
                resultSets.setValue("deleted");
            }
            //"added"
            if (difference2.contains(resultSets.getKey())) {
                resultSets.setValue("added");
            }
            //"unchanged" or "changed"
            if (intersection.contains(resultSets.getKey())) {
                for (Map.Entry<String, Object> mapSets1 : map1.entrySet()) {
                    for (Map.Entry<String, Object> mapSets2 : map2.entrySet()) {
                        if (resultSets.getKey().equals(mapSets1.getKey()) && resultSets.getKey().equals(mapSets2.getKey())) {
                            if (mapSets1.getValue().equals(mapSets2.getValue())) {
                                resultSets.setValue("unchanged");
                            }
                            if (!mapSets1.getValue().equals(mapSets2.getValue())) {
                                resultSets.setValue("changed");
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
//END
