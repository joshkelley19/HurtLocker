package kelley.josh.HurtLocker;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public static void main(String[] args) throws Exception{
        FoodManager foodManager = new FoodManager();
        for (Food f: foodManager.foods){
            System.out.println(f);
        }
        System.out.println(foodManager.errorBreakdown());
    }
}
