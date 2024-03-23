package exercise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.validation.constraints.*;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;




@Entity
@Table(name = "guests")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    // BEGIN
    @NonNull
    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;

    @Size(min = 4, max = 4)
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;
    // END

    @CreatedDate
    private LocalDate createdAt;
}
//Аннотация @Pattern(regexp = "^\\+\\d{11,13}$") используется для определения шаблона (регулярного выражения),
// который определяет правила, которым должно соответствовать значение поля.

//^ - Этот символ обозначает начало строки. В данном контексте он указывает,
// что совпадение должно начинаться с начала значения строки.

//\\+ - Экранированный символ + указывает, что в значении должен быть символ +.
// Обратный слэш \ используется для экранирования символа +, чтобы указать его как обычный символ в регулярном выражении.

//\\d - Этот символ означает любую цифру. Таким образом, \\d соответствует одной цифре.

//{11,13} - Это квантификатор, который указывает, что предыдущий элемент (цифра) должен повторяться от 11 до 13 раз.
// Таким образом, в данном случае {11,13} указывает на диапазон от 11 до 13 цифр.

//$ - Этот символ обозначает конец строки. Он указывает, что совпадение должно завершаться в конце значения строки.

//В итоге, данное регулярное выражение ^\\+\\d{11,13}$ обозначает, что строка должна начинаться с символа + и содержать от 11 до 13 цифр,
// без других символов перед или после этого номера телефона.
