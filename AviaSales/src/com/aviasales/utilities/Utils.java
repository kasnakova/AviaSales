package com.aviasales.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Provides some common methods needed throughout the project
 * @author Liza
 */
public class Utils {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static LocalDate parseToLocalDate(String dateStr){
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        return date;
    }
    
    public static String parseToString(LocalDate date){
        return date.format(dateFormatter);
    }
}
