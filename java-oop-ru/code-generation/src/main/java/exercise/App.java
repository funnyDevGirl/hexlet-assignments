package exercise;


import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


// BEGIN
class App {
    //сохраняет представление объекта в файл по переданному пути
    public static void save(Path filepath, Car car) {
        String content = car.serialize();
        try {
            Files.writeString(filepath.toAbsolutePath().normalize(),
                    content, StandardOpenOption.WRITE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path filepath) {
        String content = "";
        try {
            content = Files.readString(filepath.toAbsolutePath().normalize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Car.unserialize(content);
    }
}
// END
