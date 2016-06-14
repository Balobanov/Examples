package ua.org.ao.balobanov;

public class Date {
    private int day;
    private int month;
    private int year;
    Year y;
    Month m;
    
    // Перечисления для дней недели
    private enum DayOfWeek
    {
        MONDAY(0, "Понедельник"), TUESDAY(1, "Вторник"), WEDNEASDAY(2, "Среда"), THURSDAY(3, "Четверг"), 
        FRIDAY(4, "Пятница"), SATURDAY(5, "Суббота"), SUNDAY(6, "Воскресенье");
        int index;
        String name;
        
        DayOfWeek(int index, String name)
        {
            this.name = name;
            this.index = index;
        }
        
        public static DayOfWeek valueOf (int index)
        {
            DayOfWeek dw[] = DayOfWeek.values();
            return dw[index];
        }
        
        public String nameOfDay()
        {
            return name;
        }
        
        public String toString()
        {
            return nameOfDay();
        }
    }

    // Класс Year содержит информацию, является год високосным 
    class Year 
    {
        private boolean leapYear;
        Year(int year)
        {
            if(year % 4 == 0)
                leapYear = true;
            else
                leapYear = false;
        }

        public boolean isLeapYear() {
            return leapYear;
        }

        public void setLeapYear(boolean leapYear) {
            this.leapYear = leapYear;
        }
        
        
    }
    
    // Класс Month считает количество дней в году
    // и возвращает количество дней для каждого месяца
    class Month
    {
        byte [] days= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Вернет количество дней в указанном месяце
        // @param monthNumber
        public int getDays(int monthNumber)
        {
            if(monthNumber == 2 && y.isLeapYear())
                return 29;
            else
                return days[monthNumber];
        }
        
        /*
         * Метод вернет количество пройденых дней в году
         * до установленой даты
         */
        public int getCountDays()
        {
            int sum = 0;
            for(int i = 1; i < month; i++)
            {
                if(i == 2 && y.isLeapYear())
                    sum += 29;
                else
                    sum += days[i];
            }
            
            return (sum+day);
        }
    }
    
    // Конструктор, устанавливающий дату
    public Date(int day, int month, int year) {
        y = new Year(year);
        m = new Month();
       
       setMonth(month);
       setYear(year);
       setDay(day);
    }

    /*
     * Вычисляет день недели по дате
     */
    public DayOfWeek getDayOfWeek()
    {
        int cCoef = year / 100;
        int yCoef = year % 100;
        
        int W = day + ((13 * month - 1) / 5) + yCoef + (yCoef/4) + (cCoef /4) - 2 * cCoef;
        W %= 7;
        return DayOfWeek.valueOf(W);
    }
            
    // Возвращает день в году
    public int getDayOfYear()
    {
        return m.getCountDays();
    }
    
    // Возвращает количество дней между двумя датами
    public int daysBetween(Date date)
    {
        return (date.getYear() - year) * 360 
                + (date.getMonth() - month) * 30 + (date.getDay() - day);
    }

    // Возвращает день.
    public int getDay() {
        return day;
    }



    // Если день указан не правильно он устанавливается 1.
    public void setDay(int day) {
    	// Если Февраль и високосный, и день между 1 и 29
    	// установить заданное значение, иначе 1.
        if(month == 2 && y.isLeapYear())
                this.day = (day >= 1 && day <= 29) ? day : 1;
            else
                if(month >=1 && month <= 12)
                     this.day = (day >= 1 && day <= m.getDays(month)) ? day : 1;
    }

    public int getMonth() {
        return month;
    }

    // Если месяц меньше 1 или больше 12, устанавливается 1.
    public void setMonth(int month) {
        this.month =  (month >=1 && month <= 12) ? month : 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = (year >=1900 && year <= 3000) ? year : 1900;
    }
    
    @Override
    public String toString()
    {
       return "Дата: " + day + "/" + month + "/" + year + ". "+ getDayOfWeek() + (y.isLeapYear() ? ". високосный." : ". не високосный.");
    }
}