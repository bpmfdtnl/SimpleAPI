package zizheng.simpleapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

//The Inventory is the database of this server,
// it reads all data from the tsv file and store them in memory
public class Inventory {

    Set<Product> products = new HashSet<>();
    TreeSet<String> productName = new TreeSet<>(String::compareTo);
    TreeSet<String> category = new TreeSet<>(String::compareTo);
    TreeSet<String> brand = new TreeSet<>(String::compareTo);
    HashMap<String, Integer> wordCount= new HashMap<>();

    public Inventory(){
        try {
            String[] st;
            BufferedReader TSVFile = new BufferedReader(new FileReader("sample_product_data.tsv"));
            String dataRow = TSVFile.readLine();
            while (dataRow != null) {
                st = dataRow.split("\t", -1);
                Product product = new Product(st[0], st[1], st[2], st[3], st[4], st[5]);
                products.add(product);
                productName.add(st[1]);
                category.add(st[5]);
                brand.add(st[3]);
                String[] keywords = st[1].split(" ");
                for (String keyword : keywords) wordCount.put(keyword, wordCount.getOrDefault(keyword, 0) + 1);
                dataRow = TSVFile.readLine();
            }
            TSVFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> autoComplete(TreeSet<String> set, String prefix){
        return (ArrayList<String>) set.parallelStream().
                filter(str -> str.startsWith(prefix)).collect(Collectors.toList());
    }

    public ArrayList<Product> productSearch(Set<Product> products, ArrayList<Condition> conditions){
        ArrayList<Product> result = new ArrayList<>(products);
        for (Condition con : conditions) {
            switch (con.getType()){
                case "productId": result =  (ArrayList<Product>) result.parallelStream().
                        filter(o -> con.getValue().contains(o.getProductId())).collect(Collectors.toList());
                break;
                case "title": result =  (ArrayList<Product>) result.parallelStream().
                        filter(o -> con.getValue().contains(o.getTitle())).collect(Collectors.toList());
                break;

                case "brandID": result =  (ArrayList<Product>) result.parallelStream().
                        filter(o -> con.getValue().contains(o.getBrandID())).collect(Collectors.toList());
                break;

                case "brandName": result =  (ArrayList<Product>) result.parallelStream().
                        filter(o -> con.getValue().contains(o.getBrandName())).collect(Collectors.toList());
                break;
                case "categoryId": result =  (ArrayList<Product>) result.parallelStream().
                        filter(o -> con.getValue().contains(o.getCategoryId())).collect(Collectors.toList());
                default: result =  (ArrayList<Product>) result.parallelStream().
                        filter(o -> con.getValue().contains(o.getCategoryName())).collect(Collectors.toList());
            }
        }
        return result;
    }
}