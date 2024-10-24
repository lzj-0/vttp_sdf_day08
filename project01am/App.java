import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import day08.Product;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Mouse", "For Click UI on screen", "Computer", 99.0f));
        products.add(new Product("Keyboard", "device that allows alpha numerics inputs", "Computer", 235.5f));
        products.add(new Product("15.6 inch monitor", "Extended display panel", "Computer", 157.5f));
        products.add(new Product("Huawei Pure 70 Ultra", "Huawei phone", "Mobile", 900.0f));
        products.add(new Product("Huawei Mate 50 Pr", "Huawei phone", "Mobile", 1200.0f));
        products.add(new Product("iPhone 16 Pro", "iphone", "Mobile", 2000.0f));
        products.add(new Product("iPhone 14 Pro", "iphone", "Mobile", 1800.0f));

        // to be able to customise the date
        // LocalDate idCreated = LocalDate.of(2024, 10, 21);
        // Date createDt = Date.from(idCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Product> filteredProducts = products.stream().filter(p -> p.getProdCategory().equals("Mobile") && p.getPrice() > 1500).collect(Collectors.toList());
        filteredProducts.forEach(System.out::println);

        if (args.length > 0) {
            String[] arguments = args[0].split("/");
            File dir = new File(arguments[0]);
            if (!dir.exists()) {
                dir.mkdir();
            }

            File file = new File(args[0]);
            if (!file.exists()) {
                file.createNewFile();
            }
        }

        FileWriter fw = new FileWriter(new File(args[0]));
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Product> iterator = filteredProducts.iterator();
        while (iterator.hasNext()) {
            bw.append(iterator.next().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();

        Comparator<Product> comparator = Comparator.comparing(p -> p.getProdName());
        products.sort(comparator);
        products.forEach(System.out::println);
        System.out.println("\n");
        products.sort(comparator.reversed());
        products.forEach(System.out::println);

        String[] names = {"Bernard", "Zachary", "Alpha", "Theophilis", "Sammy", "Christopher"};
        Arrays.sort(names);
        System.out.println("Acscending order: " + Arrays.toString(names));

        Arrays.sort(names, Collections.reverseOrder());
        System.out.println("Descending order: " + Arrays.toString(names));

        Console cons = System.console();
        String str = cons.readLine("Input 4 alphanumeric characters: ");

        String[] input = str.split("");

        ArrayList<String> perm = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(input));
            String first = temp.remove(i);
            //System.out.println("first=" + first);
            for (int j = 0; j < temp.size(); j++) {
                ArrayList<String> temp2 = new ArrayList<String>(temp);
                String second = temp2.remove(j);
                //System.out.println("second=" + second);
                for (int k = 0; k < temp2.size(); k++) {
                    String third = temp2.remove(0);
                    temp2.add(third);
                    //System.out.println(first + second + String.join("", temp2));
                    perm.add(first + second + String.join("", temp2));
                }
            }
        }

        HashSet<String> uniquePerm = new HashSet<String>(perm);
        System.out.println(uniquePerm.size());
        for (String p: uniquePerm) {
            System.out.println(p);
        }


        Map<String, Integer> mapObject = new HashMap<>();
        mapObject.put("Bernard", 100);
        mapObject.put("Robert", 80);
        mapObject.put("Carrot", 150);
        mapObject.put("Blockhead", 30);
        mapObject.put("Crazy", 200);
        mapObject.put("Clown", 300);
        mapObject.forEach((k, v) -> System.out.println(k + " -> " + v));


        // to sort a dictionary by key
        List<Entry<String, Integer>> mapList = new ArrayList<>();
        mapList.sort(Entry.comparingByKey());
        mapList.forEach(System.out::println);

        // another way to sort a dictionary
        mapObject.entrySet().stream().sorted(Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
