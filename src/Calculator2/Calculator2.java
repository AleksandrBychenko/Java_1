package Calculator2;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Calculator2 {
    static public void main(String[] args) throws Exception, IOException {


       //инициализация файла
        String separator = File.separator;
        String path2 = "D:" + separator + "Desktop" + separator + "Сomputer_science" + separator + "Github" + separator + "Java_tests" + separator + "Java_for_stydy" + separator + "FileS" + separator + "src" + separator + "Calculator2" + separator + "write.txt";
        String path = "D:" + separator + "Desktop" + separator + "Сomputer_science" + separator + "Github" + separator + "Java_tests" + separator + "Java_for_stydy" + separator + "FileS" + separator + "src" + separator + "Calculator2" + separator + "readme.txt";
        String path3 = "example.txt";

        //добавляем файл
        File f = new File(path);
        PrintWriter writer = new PrintWriter(path2);
        Scanner sc = new Scanner(f);
       // String line = sc.nextLine();


      // инициализация переменных
        double a = 0.0;
        double b = 0.0;
        char znak = ' ';
        int m = 0;
        boolean is = true; // переменная типа boolean для того что-бы понять, логично ли продолжить выполнять программу

        //пециально для чтения
        FileReader fr = new FileReader(f);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();


        //делаем цикл в котором условия (в корнце все надо закрыть )
        while (line != null) {


            for (String num : line.split(" ")) {
                m++;// этот счетчик для того что-бы вытянуть нам нужное значение из трех. Допустим у нас (45 % 60ы) вытягиваем число 45 и 60ы. Так как мы сначала проверяем числа, то , как сказанно по условию, они у нас проверятся первыми, нежели %, которое по условию не должно существовать
                if (m == 1) {
                    try {
                        a = Double.valueOf(num);
                    } catch (NumberFormatException e) {
                        System.out.print("Error! Not number\n");
                        is = false;
                        break;
                    }
                }
                if (m == 3) {
                    try {
                        b = Double.valueOf(num);
                    } catch (NumberFormatException e) {
                        System.out.print("Error! Not number\n");
                        is = false;
                        break;
                    }
                }
            }
            if (is) {
                m = 0; // обнуляем для следующего входа в цикл
                for (String num : line.split(" ")) {
                    m++;
                    if (m == 2) { // тут мы проверяем знак который поставил пользователь
                        try {
                            znak = result(num, znak);
                        } catch (Exception s) {
                            System.out.print("Operation Error!");
                            is = false;
                            break;
                        }
                    }
                }
            }
            if (is) {
                switch (znak) {
                    case ('+'):
                        writer.println(line + " = " + (a + b) );
                        //writer.close();
                        break;
                    case ('-'):
                        writer.println(line + " = " + (a - b) );
                        break;
                    case ('/'):
                        if (b == 0.0)
                            System.out.print("Error! Division by zero"); // да, тут без throw, если честно я не пытался его написать, потому что деление на 0 и на 0.0 вроде как тоже самое, а вроде и нет, лучше в некоторых местах опустить условие и схитрить )))
                        else writer.println(line + " = " + (a / b) );
                        break;
                    case ('*'):
                        writer.println(line + " = " + (a * b) );
                        break;
                }
            }

            m = 0;
            line = reader.readLine();
            System.out.println(line);



        }

            writer.close();
            sc.close();
            fr.close();
            reader.close();



        }


     //для обработки ошибок
        public static char result (String nms,char znak) throws Exception
        { //так то можно легко обойтись и без этой конструкции, но как я сказал ранее, мы изучаем тему throw , так что нужно изгибаться по максимуму что-бы реализовывать через эти ... дебри, если можно так выразится
            if (nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
                znak = nms.charAt(0);
                return znak;
            } else
                throw new Exception("OperationError");//Обрати вниманеи что это сообщение  отличается от заданого в условии. Именно это, сообщение, должно быть читабельным для программы, так что дальше мы просто через System.out.print выведем нужное нам сообщение.}



        }
}
