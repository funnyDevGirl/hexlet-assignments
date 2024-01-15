package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        //создаю результирующий список:
        List<String> result = new ArrayList<>();

        //получаю доступ к приватным полям класса:
        Field[] fields = address.getClass().getDeclaredFields();

        //прохожу циклом по массиву с полями:
        for (Field field : fields) {
            //разрешение для приватного поля
            field.setAccessible(true);

            //проверяю наличие аннотации у поля:
            if (field.isAnnotationPresent(NotNull.class)) {

                try {
                    if (Objects.isNull(field.get(address))) {
                    //if (field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}

// END
