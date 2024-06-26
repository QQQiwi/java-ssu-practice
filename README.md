# Описания заданий

## Задание 1

### Пункт A

Написать "Hello, world!".

### Пункт B

Пример использования BigInteger и BigDecimal. 

На вход поступают два больших вещественных числа в форме строки. И тип операции
ADD, SUB, MULT, DIV, REM, POW. Сложение, вычитание, умножение, деление, остаток
после деления, возведение в степень.

Выведи мне результат операции между двумя числами в консольном вводе/выводе.

Учти пограничные случаи и возможные ошибки.

Примеры входных данных.

```
2.712121213124124124124 3 ADD
2 3.00000000000000001 SUB
20000000000000000000000 10 POW 
```

### Пункт C

На вход поступает файл input.txt в формате 

Фамилия Имя Отчество еще всякие разные данные перевод строки

Гарантируется, что первые три слова идут именно в такой последовательности
(Фамилия, Имя, Отчество). Пример загружу.

Во входных данных могут быть грязные данные, т.е. отсутствует фамилия, имя,
отчество. Может прийти даже пустая строчка.

Для каждого человека вывести его имя и инициалы через новую строчку

Ввод
Ионов Кирилл Игоревич разные данные

Вывод
Кирилл И. И. 

## Задание 2

### Пункт A

Выбери объект из реального мира и реализуй его в в виде класса (ООП). У него
будут поля (хранимые состояния) и методы (регулирующие поведение объекта).

Класс реализует интерфейсы (прилагательные, которыми можно описать объект) и от
него наследуются классы, расширяющие поведение объекта.

Т.е. сделай свой класс, который расширяет другой твой класс, в котором
реализуется один из твоих интерфейсов.

Пример:

```
interface 2DFigure {getPerimeter(); getSquare();}

abstract class AbstractFigure {abstract String getNameOfFigure();}

class Line extends AbstractFigure implements 2DFigure
class Circle extends AbstractFigure implements 2DFigure
class Triangle extends AbstractFigure implements 2DFigure
class Rectangle extends AbstractFigure implements 2DFigure
```

### Пункт B

В своем классе реализуй методы `equals()`, `hashCode()`, `compareTo()`,
`toString()`, поверхностной и глубокой копии. Разберись, зачем они нужны.

### Пункт C

Продемонстрируй работу полиморфизма на реализованных классах. В моем примере
классы `Line`, `Circle`, `Rectangle`, `Triangle` должны реализовать методы
`getPerimeter()` и `getSquare()` для подсчета периметра и площади
соответственно.

Соответственно, если я сложу их в контейнер `List<2DFigure> list` и для каждого
элемента figure вызову `figure.getPerimeter()` и `figure.getSquare()`, я получу
разные результаты.


## Задание 3

### Пункт A

Сделай функцию, которая для пришедшего на вход стрима целочисленных значений
отфильтрует этот стрим по определенному условию. Рекомендуется использовать
Predicate<>.

На вход поступают числа. Само условие не поступает, выбери на вкус и реализуй.
Например, все числа больше 10.


### Пункт B

На вход поступает массив из n (n <= 1000000) целочисленных чисел. Найди в нем
второе наибольшее и третье наименьшие числа. Сделай решение через стримы.


### Пункт C

Реализуй один из паттернов проектирования программирования (мой вариант - наблюдатель)

## Задание 4

### Пункт А

На вход подаются даты в формате "год месяц день". Вывести число дней, которое
прошло между минимальной и максимальной датой.

Ввод
2010 1 1
2022 12 31

Вывод
4747

### Пункт B

На вход подается имя дня недели и количество дней. Выведи, какой день недели
будет через заданное количество дней.

Ввод
sunday 10

Вывод
wednesday

Сделай через Enum (перечисления)

### Пункт C

В конец строки 100000 раз дописывается строчка, состоящая из 10 рандомных
символов.

Выбери из существующих классов java.lang.* такую реализацию строки, которая
будет наиболее оптимальной для использования в таком алгоритме. Докажи, что она
будет быстрее. 


## Задание 5

### Пункт A

ФИО_Владельца название_Компании рейтинг_Акции

Гарантируется что строчки непустые, данные идут именно в таком порядке, рейтинг
акции от 1 (не рекомендована к покупке) до 10 (надо было брать вчера).

Выведи строчки. отсортировав акции по убыванию рейтинга, затем по фамилии,
имени, отчеству по возрастанию. В выводе не должно присутствовать дубликатов.

### Пункт B

На вход подается название директории (относительный путь от места запуска
программы до директории) и имя целевой строки. 

Требуется обойти всю директорию рекурсивно, найти объекты. в имени которых
присутствует целевая строка как подстрока и заархивировать их.

Формат архива на ваше усмотрение.

Пример.

Входные данные
directory passport

Структура каталога
directory -> passport -> 1.txt
directory -> passport -> 2
directory -> passport -> 3.md5
directory -> 1passport2.txt
directory -> pass2port.bin
directory -> passp0rt.sh
directory -> 2138123PASSPORT214124124

Вывод
архив directory

Структура архива
passport -> 1.txt
passport -> 2
passport -> 3.md5
1passport2.txt
2138123PASSPORT214124124