import java.io.Console;
import java.util.*;

public class CountPerm {

    private ArrayList<String> permutations;

    public CountPerm() {
        this.permutations = new ArrayList<String>();
    }

    public ArrayList<String> getPermutations() {
        return permutations;
    }

    public Integer recursiveCount(String input) {
        if (input.length() == 1) {
            return 1;
        } else {
            Integer total = 0;
            ArrayList<String> inputLs = new ArrayList<String>(Arrays.asList(input.split("")));
            for (int i = 0; i < inputLs.size(); i++) {
                ArrayList<String> temp = new ArrayList<String>(inputLs);
                String letter = temp.remove(i);
                total += recursiveCount(String.join("", temp), letter);
            }
            return total;
        }
    }

    public Integer recursiveCount(String input, String builder) {
        //System.out.println(input + " + " + builder);
        if (input.length() == 1) {
            //System.out.println("Added");
            this.permutations.add(builder + input);
            return 1;
        } else {
            Integer total = 0;
            ArrayList<String> inputLs = new ArrayList<String>(Arrays.asList(input.split("")));
            for (int i = 0; i < inputLs.size(); i++) {
                String tempBuilder = builder;
                ArrayList<String> temp = new ArrayList<String>(inputLs);
                tempBuilder += temp.remove(i);
                total += recursiveCount(String.join("", temp), tempBuilder);
            }
            return total;
        }
    }
    public static void main(String[] args) {
        
        Console cons = System.console();
        String str = cons.readLine("Input 4 alphanumeric characters: ");

        CountPerm cp = new CountPerm();
        cp.recursiveCount(str);
        HashSet<String> uniquePerm = new HashSet<String>(cp.getPermutations());
        System.out.println(cp.getPermutations().toString());
        System.out.println(uniquePerm.size());
    }

}
