package ru.ifmo.cet.javabasics;
import java.lang.String;
import java.util.TreeMap;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
     * 99 bottles of beer on the wall, 99 bottles of beer
     * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {

    private TreeMap<Integer, String> numbers = new TreeMap();
    private int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce) {

        this.bottleTakenAtOnce = bottleTakenAtOnce;

    }

    public String formOfWord(int num) {
        if (num == 1)
            return Integer.toString(num) + " bottle";
        else
            return Integer.toString(num) + " bottles";
    }

    public StringBuffer integerToWords(int num) {

        StringBuffer quantity = new StringBuffer();

        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
        numbers.put(70, "seventy");
        numbers.put(80, "eighty");
        numbers.put(90, "ninety");

        if (num <= 20)
            quantity.append(numbers.get(num));
        else {
            int decades = num / 10;
            quantity.append(numbers.get(decades * 10));
            int units = num % 10;
            if (units > 0)
                quantity.append(" " + numbers.get(units));
        }

        return quantity;

    }

    public String getBottleSongLyrics() {

        //throw new UnsupportedOperationException();
        if (this.bottleTakenAtOnce < 1 || this.bottleTakenAtOnce > 99)
            throw new java.lang.IllegalArgumentException("Neither less than 1 nor more than 99 bottles can be taken at once!");

        int bottles = 99;
        String lyrics = "";

        if (bottleTakenAtOnce == 99) {
            lyrics += "99 bottles of beer on the wall, 99 bottles of beer.\n" +
                    "Take " + integerToWords(bottleTakenAtOnce) + " down and pass around, no more bottles of beer on the wall.\n" +
                   "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
        }
        else {
            while (bottles > bottleTakenAtOnce) {
                lyrics += formOfWord(bottles) + " of beer on the wall, " + formOfWord(bottles) + " of beer.\n" +
                        "Take " + integerToWords(bottleTakenAtOnce) + " down and pass around, " + formOfWord(bottles - bottleTakenAtOnce) + " of beer on the wall.\n";
                bottles -= bottleTakenAtOnce;
            }


            lyrics += formOfWord(bottles) + " of beer on the wall, " + formOfWord(bottles) + " of beer.\n" +
                    "Take " + integerToWords(bottles) + " down and pass around, no more bottles of beer on the wall.\n" +
                    "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
        }

        return lyrics;

    }

}
