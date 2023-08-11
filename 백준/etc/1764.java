import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static HashSet<String> arr;
    static ArrayList<String> result;
    static int max = 0;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int d = s.nextInt();//못들어본사람
        int b = s.nextInt();//못본사람!
        arr = new HashSet<>();
        result = new ArrayList<>();
        for(int i =0;i<d;i++){
            arr.add(s.next());
        }
        for(int i =0;i<b;i++){
            String str = s.next();
            if (arr.contains(str)) result.add(str);
        }
        Collections.sort(result);

        System.out.println(result.size());
        for (String str : result) {
            System.out.println(str);
        }

    }

}
