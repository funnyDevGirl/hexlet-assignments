# Паттерны

В этом задании мы будем работать с HTML-тегами. Каждый класс, реализующий интерфейс `TagInterface`, представляет из себя тег HTML. Единственный метод `render()` этого интерфейса позволяет получить текстовое представление тега:

```java
TagInterface tag = new InputTag("submit", "Save");
tag.render(); // <input type="submit" value="Save">
```

Предположим, что эта система нужна для генерации разных кусков верстки, которая может быть очень разнообразной. Попробуйте ответить на вопрос, сколько понадобится классов для представления всех возможных комбинаций тегов?

Если создавать по классу на каждый возможный вариант верстки, то классов будет бесконечно много и смысла в такой реализации очень мало. Но вместо этого лучше использовать композицию. Создать класс для каждого индивидуального тега (в html5 их около 100 штук), а затем путем комбинирования получить все возможные варианты верстки.

## main/java/exercise/TagInterface.java

* Реализуйте интерфейс `TagInterface`. В интерфейсе есть один метод `render()`, который возвращает строковое представление тега

## main/java/exercise/InputTag.java

* Реализуйте класс `InputTag`, который реализует интерфейс `TagInterface`. Класс представляет собой HTML-тег `<input>`. Этот тег определяет поле ввода, в которое пользователь может вводить данные. Конструктор класса принимает два строковых параметра: значения атрибутов *type* и *value*

  ```java
  TagInterface tag = new InputTag("submit", "Save");
  tag.render(); // <input type="submit" value="Save">
  ```

## main/java/exercise/LabelTag.java

* Реализуйте класс `LabelTag`, который реализует интерфейс `TagInterface` и умеет оборачивать другие теги. Конструктор класса принимает два параметра: текстовое значение тега в виде строки и дочерний тег - любой объект, реализующий `TagInterface`

  ```java
  TagInterface inputTag = new InputTag("submit", "Save");
  TagInterface labelTag = new LabelTag("Press Submit", inputTag);
  labelTag.render();
  // <label>Press Submit<input type="submit" value="Save"></label>
  ```

### Подсказки

* Паттерн [Декоратор](https://ru.wikipedia.org/wiki/Декоратор_(шаблон_проектирования))
* [Тег \<label\>](https://developer.mozilla.org/ru/docs/Web/HTML/Element/label)
* [Тег \<input\>](https://developer.mozilla.org/ru/docs/Web/HTML/Element/input)
