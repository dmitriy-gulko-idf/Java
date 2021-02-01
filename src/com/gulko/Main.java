package com.gulko;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int key = -1;

        while (key != 0) {
            System.out.print("\nВведите номер задания: ");
            key = in.nextInt();

            switch (key) {
                case 1:
                    task1();
                    break;
                case 2:
                    System.out.println("Файлы .java, .class, скрин с результатом выложены на github.com!");
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Такого задания не существует!");
                    break;
            }
        }

    }

    //Перевод из различных систем счисления:
    public static void task1() {
        // Двоичная -> Десятичная:
        System.out.println("000 = " + Integer.parseInt("000", 2));
        System.out.println("1010 = " + Integer.parseInt("1010", 2));
        System.out.println("1 = " + Integer.parseInt("1", 2));
        System.out.println("1000 = " + Integer.parseInt("1000", 2));
        System.out.println("110011 = " + Integer.parseInt("110011", 2));
        System.out.println("1111111 = " + Integer.parseInt("1111111", 2));
        System.out.println("11111111 = " + Integer.parseInt("11111111", 2));

        //Восьмиричная -> Десятичная:
        System.out.println("020 = " + Integer.parseInt("020", 8));
        System.out.println("06541 = " + Integer.parseInt("06541", 8));
        System.out.println("041222 = " + Integer.parseInt("041222", 8));

        //Шестнадцать -> Десять:
        String str1 = "0x9";
        String str2 = "0xB";
        String str3 = "0x1C";

        System.out.println("0x9 = " + Integer.parseInt(str1.substring(2), 16));
        System.out.println("0xB = " + Integer.parseInt(str2.substring(2), 16));
        System.out.println("0x1C = " + Integer.parseInt(str3.substring(2), 16));

    }

    //имеется 4500 секунд. Вывести в консоль содержащихся в этом количестве секунд:
    public static void task3() {
        int a = 4500;

        int ss = a % 60;
        int mm = (int) TimeUnit.SECONDS.toMinutes(a);
        int hh = (int) TimeUnit.SECONDS.toHours(a);
        int dd = (int) TimeUnit.SECONDS.toDays(a);
        int ww = dd / 7;

        System.out.println("В " + a + " секундах есть а) " + mm + " минут " + ss + " секунд");
        System.out.println("или в " + a + " секундах есть б) " + hh + " час " + mm + " минут " + ss + " секунд");
        System.out.println("или в " + a + " секундах есть в) " + dd + " дней " + hh + " час " + mm + " минут " + ss + " секунд");
        System.out.println("или в " + a + " секундах есть г) " + ww + " недель " + dd + " дней " + hh + " час " + mm + " минут " + ss + " секунд");

    }

    //Определить число, полученное выписыванием в обратном порядке цифр любого 4-х значного натурального числа n
    public static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите 4-х значное натуральное число: ");
        int number = in.nextInt();

        if (number > 999 && number < 10000) {
            int reversNumber = 0;
            while (number != 0) {
                reversNumber = reversNumber * 10 + number % 10;
                number /= 10;
            }

            System.out.println("Число " + number + " в обратном порядке = " + reversNumber);
        } else {
            System.out.println("Вы ввели неверное число!!!");
            task4();
        }

    }

    //Дано любое натуральное 4-х значное число. Верно ли, что все цифры числа различны?
    public static void task5() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите 4-х значное натуральное число: ");
        int number = in.nextInt();

        if (number > 999 && number < 10000) {
            int[] nums = new int[4];
            int i = 0;

            while (number != 0) {
                nums[i] = number % 10;
                number /= 10;
                i++;
            }

            boolean isNumbersDifferent = true;
            for (i = 0; i < nums.length; i++) {
                for (int i2 = 0; i2 < nums.length; i2++) {
                    if (i2 == i)
                        continue;
                    if (nums[i2] == nums[i]) {
                        isNumbersDifferent = false;
                        break;
                    }
                }
                if (!isNumbersDifferent) {
                    System.out.println("Цифры не различны!!!");
                    break;
                }
            }

            if (isNumbersDifferent)
                System.out.println("Все цифры  различны!!!");
        } else {
            System.out.println("Вы ввели неверное число!!!");
            task5();
        }

    }

    //Создайте число. Определите, является ли число трехзначным. Определите, является ли его последняя цифра семеркой. Определите, является ли число четным.
    public static void task6() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = in.nextInt();

        if (number > 99 && number < 1000) {
            System.out.println(number + " - число трёхзначное!");
        } else {
            System.out.println(number + " - число не является трёхзначным!");
        }

        if (number % 2 == 1) {
            System.out.println("Также число не чётное!");
        } else {
            System.out.println("Также число чётное!");
        }

        if (number % 10 == 7) {
            System.out.println("Последняя цифра числа " + number + " - равна 7!");
        } else {
            System.out.println("Последняя цифра числа " + number + " - не равна 7!");
        }
    }

    //имеется прямоугольное отверстие размерами a и b, определить, можно ли его полностью закрыть круглой картонкой радиусом r
    public static void task7() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите сторону А прямоугольного отверстия: ");
        double a = in.nextInt();
        System.out.print("Введите сторону B прямоугольного отверстия: ");
        double b = in.nextInt();
        System.out.print("Введите радиус круга:");
        double r = in.nextInt();

        double diagonal = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        if (2 * r >= diagonal) {
            System.out.println("Круглая картинка полностью закрывает прямоугольное отверстие!");
        } else {
            System.out.println("Круглая картинка не может полностью закрыть прямоугольное отверстие!");
        }

    }

}
