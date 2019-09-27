package com.intercorp.retotech.commons;

public class Constants {
    public static final String CITIZENS_QUERY = "SELECT id,first_name,last_name,birth_day,null as death_date FROM citizen";
    public static final String CITIZENS_ADULT_QUERY = "SELECT id,first_name,last_name,birth_day,death_date FROM citizen where DATEDIFF('YEAR', birth_day, CURRENT_DATE)>= 18";
    public static final String CITIZENS_AVERAGE_QUERY = "SELECT AVG(DATEDIFF('YEAR', birth_day, CURRENT_DATE)) FROM citizen where DATEDIFF('YEAR', birth_day, CURRENT_DATE)>= 18";
    public static final String CITIZENS_DEVIATION_STD_QUERY = "SELECT STDDEV_POP(DATEDIFF('YEAR', birth_day, CURRENT_DATE)) FROM citizen where DATEDIFF('YEAR', birth_day, CURRENT_DATE)>= 18";
}
