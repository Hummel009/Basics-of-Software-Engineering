[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Basics-of-Software-Engineering&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Hummel009_Basics-of-Software-Engineering)

Мой проект для BSUIR/БГУИР (белорусский государственный университет информатики и радиоэлектроники).

Предмет - OPI/ОПИ (основы программной инженерии).

## Общая информация

Этот репозиторий - проект Gradle, который должен быть открыт через IntelliJ IDEA. Проконтролируйте, чтобы версии Gradle JVM, Java и JDK соответствовали указанным ниже.

| Технология | Версия  | Пояснение                                    | Примечание                                                       |
|------------|---------|----------------------------------------------|------------------------------------------------------------------|
| Gradle     | 8.4-bin | Версия системы автоматической сборки         | -                                                                |
| Gradle JVM | 17.0.9  | Версия Java, используемая для запуска Gradle | [Настраивается в переменных средах ОС (JAVA_HOME и Path)][Link1] |
| Java       | 17      | Language Level, используемый в проекте       | [Настраивается в IntelliJ IDEA (Project Structure)][Link2]       |
| JDK        | 17.0.9  | Версия SDK, используемая в проекте           | [Настраивается в IntelliJ IDEA (Project Structure)][Link2]       |

[Link1]: https://java-lessons.ru/first-steps/java-home#:~:text=Теперь%20щёлкните%20правой%20кнопкой
[Link2]: https://www.jetbrains.com/help/idea/sdk.html#change-module-sdk

## Условие работы

Тема - калькулятор с графическим интерфейсом. Необходимо покрыть его юнит-тестами, настроить Github Actions, подключить SonarCloud и активировать в нём интеграцию анализа покрытия от Jacoco.

Покрытие юнит-тестами составляет 94%, что является крайне хорошим показателем. Инкапсуляция соблюдена. SonarCloud пишет, что качество достойное. Github Actions работают. Jacoco подключен и работает. Интеграция SonarCloud с Jacoco не удалась.
