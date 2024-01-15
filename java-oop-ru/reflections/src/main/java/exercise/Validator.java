package exercise;

import java.lang.reflect.Field;
import java.util.*;

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
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        Map<String, List<String>> result = new HashMap<>();

        //список с именами полей, не прошедших валидацию с NotNull:
        List<String> fieldNames = validate(address);

        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            //если поле содержит обе аннотацияи (NotNull, MinLength):
            if (field.isAnnotationPresent(MinLength.class)) {

                try {
                    List<String> messages = getMessagesOfAllAnnotation(address, field);
                    if (!messages.isEmpty()) {
                        result.put(field.getName(), messages);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            //если у поля только NotNull:
            else {
                if (fieldNames.contains(field.getName())) {
                    result.put(field.getName(), List.of("can not be null"));
                }
            }
        }
        return result;
    }

    //метод возвращает список сообщений у полей, не прошедших валидацию с MinLength:
    public static List<String> getMessagesOfAllAnnotation(Address address, Field field)
            throws IllegalAccessException {

        List<String> messages = new ArrayList<>();

        //список с именами полей, не прошедших валидацию с NotNull:
        List<String> fieldNames = validate(address);
        //получаю значение у аннотации:
        int value = field.getAnnotation(MinLength.class).minLength();
        //получаю длину у значения поля:
        int nameLength = String.valueOf(field.get(address)).length();

        if (fieldNames.contains(field.getName())) {
            messages.add("can not be null");

            if (nameLength < value) {
                messages.add("length less than " + value);
            }
        }
        return messages;
    }
}

// END
