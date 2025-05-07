package com.company.mycollections;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> tomBooks = new ArrayList<Book>();
        tomBooks.add(new Book("Л.Н. Толстой", "Война и мир", 960, 1869));
        tomBooks.add(new Book("Джоан Роулинг", "Гарри Поттер и узник Азкабана", 451, 1999));
        tomBooks.add(new Book("Джоан Роулинг", "Гарри Поттер и тайная комната", 447, 1998));
        tomBooks.add(new Book("Герберт Шилдт", "С# 4.0: Полное руководство", 1056, 2010));
        tomBooks.add(new Book("Т.А. Павловская", "C#. Программирование на языке высокого уровня", 434, 2006));
        tomBooks.add(new Book("Адам Фримен", "ASP.NET Core с примерами на C# для профессионалов", 1184, 2021));
        Student tom = new Student("Tom", tomBooks);

        ArrayList<Book> alexBooks = new ArrayList<Book>();
        alexBooks.add(new Book("Джоан Роулинг", "Гарри Поттер и тайная комната", 447, 1998));
        alexBooks.add(new Book("Джоан Роулинг", "Гарри Поттер и Философский Камень", 367, 1997));
        alexBooks.add(new Book("Л.Н. Толстой", "Анна Каренина", 864, 1878));
        alexBooks.add(new Book("Игорь Блинов", "Java from EPAM", 560, 2021));
        alexBooks.add(new Book("В.И. Грекул", "Проектирование информационных систем", 187, 2012));
        Student alex = new Student("Alex", alexBooks);

        ArrayList<Book> bobBooks = new ArrayList<Book>();
        bobBooks.add(new Book("Адам Фримен", "ASP.NET Core с примерами на C# для профессионалов", 1184, 2021));
        bobBooks.add(new Book("Л.Н. Толстой", "Война и мир", 960, 1869));
        bobBooks.add(new Book("Стивен Скиена", "Алгоритмы. Руководство к разработке", 848, 2022));
        bobBooks.add(new Book("Джоан Роулинг", "Гарри Поттер и узник Азкабана", 451, 1999));
        bobBooks.add(new Book("Джоан Роулинг", "Гарри Поттер и тайная комната", 447, 1998));
        bobBooks.add(new Book("Игорь Блинов", "Java from EPAM", 560, 2021));
        Student bob = new Student("Bob", bobBooks);

        ArrayList<Book> monicaBooks = new ArrayList<Book>();
        monicaBooks.add(new Book("Андрей Курпатов", "Чертоги разума", 416, 2020));
        monicaBooks.add(new Book("Стивен Скиена", "Алгоритмы. Руководство к разработке", 848, 2022));
        monicaBooks.add(new Book("Ричард Бах", "Иллюзии", 160, 2018));
        monicaBooks.add(new Book("Карл Вигерс", "Разработка требований к программному обеспечению", 576, 2004));
        monicaBooks.add(new Book("Игорь Блинов", "Java from EPAM", 560, 2021));
        Student monica = new Student("Monica", monicaBooks);

        Stream.of(tom, alex, bob, monica)
                .peek(System.out::println)
                .map(Student::getBooks)
                .peek(System.out::println)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Book::getPagesCount))
                .distinct()
                .filter(b -> b.getReleaseYear() > 2000)
                .limit(3)
                .map(Book::getReleaseYear)
                .findAny() // Optional от года выпуска???
                .ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Book not fount")
                );
    }
}
