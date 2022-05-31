package myenigma;
import javafx.concurrent.Task;

import java.io.*;


/*
Программа запускается с одним из следующих наборов параметров:
e fileName fileOutputName
d fileName fileOutputName
/
где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
e - ключ указывает, что необходимо зашифровать данные.
d - ключ указывает, что необходимо расшифровать данные.
*/

public class crypt {
    private static int numberOfEncryptions = (int) Math.ceil(3 + Math.random() * 126); // создаем число итераций шифрования (от 3 до 126 включительно)

    private static boolean isFinished = false;

    public static boolean getFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        this.isFinished = finished;
    }

    public static void startCrypt(String[] args) {
        switch (args[0]) {
            case "e":
                crypt crypt1 = new crypt();
                crypt1.setFinished(false);
                encrypt(args[1], args[2]);
                crypt1.setFinished(true);
                break;
            case "d":
                crypt crypt = new crypt();
                crypt.setFinished(false);
                decryption(args[1], args[2]);
                crypt.setFinished(true);
                break;
        }
    }

    public static void encrypt(String fileName, String fileOutputName) {    // метод для зашифровки
        try (FileInputStream fis = new FileInputStream(fileName);           //поток для считывания байт из файла (исходные данные)
             FileOutputStream fos = new FileOutputStream(fileOutputName)) { // поток для записи байт в файл (защифрованные данные)
            byte key = (byte) Math.ceil(1 + Math.random() * 9);             // получение рандомного числа от 1 до 9 включительно (это ключ)
            byte[] bytes = new byte[fis.available() + 2];                   // создаем массив из байт, в котором будем хранить считанные байты + ключ(last index) + кол-во итераций
            if (fis.available() > 0) {
                int count = fis.read(bytes);                                // заполняем массив байтами из потока (файла)
            }
            for (int j = 0; j <= numberOfEncryptions; j++) {                //запускаем цикл равный кол-ву итераций шифрования
                for (int i = 0; i < bytes.length - 2; i++) {                // проходим по массиву байт
                    char ch = (char) bytes[i];                              // приводим каждый байт к символу char
                    bytes[i] = (byte) ((int) ch + key);                     // узнаем порядковый номер сивола char добавляем к нему ключ, приводим к типу байт и перезаписываем
                }
                bytes[bytes.length - 2] = key;                              // добавляем в массив байт предпоследним символом ключ шифрования
                if (j == numberOfEncryptions) {                             // если это последний круг, то
                    bytes[bytes.length - 1] = (byte) numberOfEncryptions;   //добавляем последним символом - кол-во итераций шифрования
                }
            }
            fos.write(bytes);                                               // записываем в файл полученный массив с ключом и кол-вом итераций
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryption(String fileName, String fileOutputName) { // метод для расшифровки
        try (FileInputStream fis = new FileInputStream(fileName);           //поток для считывания байт из файла (зашифрованные данные)
             FileOutputStream fos = new FileOutputStream(fileOutputName)) { // поток для записи в файл (расшифрованные данные)
            byte[] bytes = new byte[fis.available()];                       // создаем массив из байт для хранения полученных (зашифрованных) данных
            byte[] bytesWrite = new byte[bytes.length - 2];                 // создаем вспомогательный массив размером на два меньше (без ключа и кол-ва итераций)
            if (fis.available() > 0) {
                int count = fis.read(bytes);                                //заполняем массив байтами из файла с зашифрованным сообщением
            }
            for (int i = 0; i < bytesWrite.length; i++) {                   //заполняем вспомогательный массив копией считанных данных,
                bytesWrite[i] = bytes[i];                                   //исключая последние два символа
            }
            byte key = bytes[bytes.length - 2];                             //определяем какое число является ключом
            byte numberOfEncryptionsRead = bytes[bytes.length - 1];         //определяем какое число является кол-вом итераций
            for (int j = 0; j <= numberOfEncryptionsRead; j++) {            //запускаем цикл равный кол-ву итераций дешифрования
                for (int i = 0; i < bytesWrite.length; i++) {               // проходим по вспомогательному массиву байт
                    char ch = (char) bytesWrite[i];                         // приводим каждый байт к символу char
                    bytesWrite[i] = (byte) ((int) ch - key);                //узнаем порядковый номер символа char и отнимает от него ключ,
                }                                                           //записываем во вспомогательный массив
            }
            fos.write(bytesWrite);                                          // записываем в файл полученный массив байт с расшифрованными данными
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

