package exercise;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;


// BEGIN
class Validator {

    public static List<String> validate(Address address) {
        //получаю доступ к приватным полям класса:
        List<Field> fields = List.of(address.getClass().getDeclaredFields());

        //возвращаю сразу результирующий список:
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    Object value;
                    try {
                        field.setAccessible(true);
                        value = field.get(address);
                        field.setAccessible(false);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return Objects.isNull(value);
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        Map<String, List<String>> result = new HashMap<>();

        List<Field> fields = List.of(address.getClass().getDeclaredFields());

        fields.stream()
                .filter(field ->
                        field.isAnnotationPresent(NotNull.class) ||
                        field.isAnnotationPresent(MinLength.class))
                .forEach(field -> {
                    String fieldName = field.getName();
                    List<String> errors;
                    try {
                        errors = getMessagesOfAllAnnotation(address, field);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (!errors.isEmpty()) {
                        result.put(fieldName, errors);
                    }
                });
        return result;
    }

    //мвозвращает список сообщений у полей, не прошедших валидацию с обеими аннотациями:
    public static List<String> getMessagesOfAllAnnotation(Address address, Field field)
            throws IllegalAccessException {

        List<String> messages = new ArrayList<>();

        //инициализирую имя поля:
        String nameField;
        try {
            field.setAccessible(true);
            nameField = (String) field.get(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //список с именами полей, не прошедших валидацию с NotNull:
        List<String> fieldsWithNull = validate(address);

        if (fieldsWithNull.contains(field.getName())) {
            messages.add("can not be null");
        }

        //список с именами полей, не прошедших валидацию с MinLength:
        if (field.isAnnotationPresent(MinLength.class)) {
            //получаю значение у аннотации:
            int value = field.getAnnotation(MinLength.class).minLength();

            if (nameField == null || nameField.length() < value) {
                messages.add("length less than " + value);
            }
        }

        return messages;
    }
}

// END
