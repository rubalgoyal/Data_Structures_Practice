import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        HashMapCode<String, Integer> hashMapCode = new HashMapCode<>();
        System.out.println("Initial size of HashMap-->" + hashMapCode.size());
        hashMapCode.put("E1", 10);
        hashMapCode.put("E2", 15);
        hashMapCode.put("E3", 20);
        hashMapCode.put("E4", 25);
        hashMapCode.put("E5", 40);
        hashMapCode.put("E1", 100); // update value for E1
        hashMapCode.put("E6", 70);
        hashMapCode.put("E7", 80);

        System.out.println("Size after adding-->" + hashMapCode.size());
        System.out.println("Getting all the keys" + hashMapCode.keySet());
        for(String key: hashMapCode.keySet()){
            System.out.println(key + "-->" + hashMapCode.get(key));
        }

        System.out.println("Checking for key which does not exist");
        System.out.println("E10" + "-->" + hashMapCode.get("E10"));

        System.out.println("Removing E3 from HashMap-->" + hashMapCode.remove("E3"));
        System.out.println("E3" + "-->" + hashMapCode.get("E3"));

        System.out.println("Size after removing-->" + hashMapCode.size());

        System.out.println("Checking for key if exists");
        System.out.println("E1 -->" + hashMapCode.contains("E1"));
        System.out.println("E3 -->" + hashMapCode.contains("E3"));


    }
}