package com.geekbrains.staffSchedule.exception;


//Исключение для неверного колличества аргументов переданных команде
public class InvalidArgumentSetException extends RuntimeException{

    public InvalidArgumentSetException(){
        super("Невалидный набор аргументов для команды");
    }
}
