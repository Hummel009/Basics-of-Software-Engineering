[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Basics-of-Software-Engineering&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Hummel009_Basics-of-Software-Engineering)

Мой проект для BSUIR/БГУИР (белорусский государственный университет информатики и радиоэлектроники).

Предмет - OPI/ОПИ (основы программной инженерии).

## Общая информация

Этот репозиторий - проект Gradle, который должен быть открыт через IntelliJ IDEA. После установки среды проконтролируйте, чтобы версии Gradle JVM, Java и JDK соответствовали указанным ниже, иначе есть вероятность, что установка пройдёт некорректно.

| Технология | Версия  | Пояснение                                    | Где настроить                                                    |
|------------|---------|----------------------------------------------|------------------------------------------------------------------|
| Gradle     | 8.4-bin | Версия системы автоматической сборки         | -                                                                |
| Gradle JVM | 17.0.9  | Версия Java, используемая для запуска Gradle | File -> Settings -> Build -> Build Tools -> Gradle -> Gradle JVM |
| Java       | 17      | Language Level, используемый в проекте       | File -> Project Structure -> Project -> Language Level           |
| JDK        | 17.0.9  | Версия SDK, используемая в проекте           | File -> Project Structure -> Project -> SDK                      |

Если значения не соответствуют необходимым, необходимо перезагрузить проект Gradle. Ниже об этом будет написано подробнее.

## Установка

Собственно, для начала нужно скачать репозиторий и разархивировать его в любое место на диске. Полученную папку будем называть **папкой проекта**. В этой папке лежат папки (gradle, src) и различные файлы.

Первым делом, запустите IntelliJ IDEA и откройте папку проекта: `File -> Open -> [Выбираете папку]`. Сразу после открытия начнётся установка среды. Если от вас потребуется разрешение на скачивание файлов, дайте его. Спустя некоторое время все необходимые файлы скачаются, и среда будет готова к работе.

Если на этом моменте что-то пошло не так, значит, самое время проверить значения, указанные в таблице из первого раздела. После изменения этих значений необходимо перезагрузить проект Gradle. Это можно сделать в **меню Gradle**, нажав на циклические стрелки. Меню можно открыть, нажав на значок слона в верхней правой части окна.

## Условие

Тема - калькулятор с графическим интерфейсом. Необходимо покрыть его юнит-тестами, настроить Github Actions, подключить SonarCloud и активировать в нём интеграцию анализа покрытия от Jacoco.

Покрытие юнит-тестами составляет 94%, что является крайне хорошим показателем. Инкапсуляция соблюдена. SonarCloud пишет, что качество достойное. Github Actions работают. Jacoco подключен и работает. Интеграция SonarCloud с Jacoco не удалась.
