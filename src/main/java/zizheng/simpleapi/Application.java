package zizheng.simpleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

//API controller class
@RestController
@SpringBootApplication
public class Application {


    //Initialize Inventory, all data are stored in memory
    Inventory inventory = new Inventory();

    //Switch based on which column the autocomplete is targeting
    @PostMapping("/api/products/autocomplete")
    public ArrayList<String> autoComplete(@RequestBody Request prefix){
        switch (prefix.getType()){
            case "brand": return inventory.autoComplete(inventory.brand, prefix.getPrefix());
            case "productName": return inventory.autoComplete(inventory.productName, prefix.getPrefix());
            default: return inventory.autoComplete(inventory.category, prefix.getPrefix());
        }
    }

    //Returns a list of product that fits all conditions
    @PostMapping("/api/products/search")
    public ArrayList<Product> search(@RequestBody Request search){
        return inventory.productSearch(inventory.products, search.conditions);
    }

    //Returns the list of keywords with their frequencies from the title
    @PostMapping("/api/products/keywords")
    public Wordcount keywordFrequency(@RequestBody Request keyword){
        ArrayList<String[]> pairs = new ArrayList<>();
        for (String str: keyword.getKeywords()) {
            String[] pair = new String[]{str, inventory.wordCount.getOrDefault(str, 0).toString()};
            pairs.add(pair);
        }
        return new Wordcount(pairs);
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
