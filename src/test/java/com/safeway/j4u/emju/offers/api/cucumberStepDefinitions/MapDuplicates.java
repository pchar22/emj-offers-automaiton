//import java.util.Collection;
//import java.util.Iterator;
//import java.util.Map.Entry;
//
//import org.apache.commons.collections4.MultiValuedMap;
//import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
//
//public class MapDuplicates {
//
//    public static void main(String[] args) {
//
//        String searchString = "key1";
//
//        MultiValuedMap<String, String> multiValMap = new ArrayListValuedHashMap<>();
//        multiValMap.put("key1", "value1");
//        multiValMap.put("key1", "value1");
//        multiValMap.put("key2", "value2");
//        multiValMap.put("key1", "value1");
//        multiValMap.put("key1", "value1");
//        multiValMap.put("key1", "value1");
//        multiValMap.put("key1", "value1");
//
//        System.out.println(multiValMap);
//
//        Collection<Entry<String, String>> collectionEntries = multiValMap.entries();
//
//        Iterator<Entry<String, String>> iterator = collectionEntries.iterator();
//
//        int count = 0;
//        while(iterator.hasNext()) {
//            Entry<String, String> entry = iterator.next();
//            if(entry.getKey().equalsIgnoreCase(searchString)){
//                count++;
//            }
//        }
//
//        System.out.println(searchString + " is repeated for " + count);
//    }
//}
