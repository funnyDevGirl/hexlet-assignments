package exercise;

import lombok.*;

// BEGIN
@Value
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
