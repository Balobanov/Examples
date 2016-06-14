package ua.org.oa.balobanov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Регулярные выражения для нахождения почтового ящика и почтового индекса в тексте 
 * @author Balobanov
 */
public class RegexMailAndZip {
    
    public static final Pattern Mailpattern = Pattern.compile("[A-Za-z0-9_\\.]+@{1}([A_Za-z0-9]+\\.){1,4}((ru)|(com)|(ua)|(ykr)|(net)|(org))");
     /*
    [A-Za-z0-9_\\.]+ - любая последовательность букв и цифр. Допускаются знаки ("_"; ".") 
    
    +@{1}([A_Za-z0-9]+\\.){1,4}((ru)|(com)|(ua)|(ykr)|(net)|(org)) - Любая последовательность которая начинается 
        со знака @ и заканчивается точкой(.)
        И эта последовательность повторяется не более 4 раз 
        и должна заканчиваться на (ru)|(com)|(ua)|(ykr)|(net)|(org)
    
   
    */
    
    public static final Pattern Zippattern = Pattern.compile("\\b[0-9]{5}\\b");
    /*
        \\b[0-9]{5}\\b - Ограничивает последовательность из любых цифр от 0 до 9, 
            чтобы она была длиной 5 символов.
    */
   
	
    public static void doMatchMail(String word) {
        Matcher matcher = Mailpattern.matcher(word);
        while(matcher.find())
       {
           System.out.println(matcher.group());
       }
    }
    
    public static void doMatchZip(String word) {
       Matcher matcher = Zippattern.matcher(word);
       while(matcher.find())
       {
           System.out.println(matcher.group());
       }
    }
	
    public static void main(String[] args) {
        
        System.out.println("-------Mails-----------");
        doMatchMail("zzwd aw awd 1vds_fg@mail.ru  aw dwad aw  wbebeveve@mail.ru   wdadg@@mail.ru .  d awd aw");
        doMatchMail("1@mail.ru");
        doMatchMail("1vds@mail.com.ua.bk");
        doMatchMail("1vds@mail.com.ua.bk.list");
        
        doMatchMail("1vds@mail.r");
        doMatchMail("1vds@mail@mail.ru");
        doMatchMail("!1vds@mail.ru");
        doMatchMail("1vds@mail.ru..");
        doMatchMail("1vds@mail..ru.");
        doMatchMail("1vds@mail ru.");
        doMatchMail("1vds@mail ru");
        
        doMatchMail("c0nst@money.simply.net");
        doMatchMail("somebody@dev.com.ua");
        doMatchMail("Name.Sur_name@gmail.com");
        doMatchMail("useR33@somewhere.in.the");
        
        
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("----------Zip code-----------");
        doMatchZip("Zip code: 64102. in Pervomayskiy and Kharkov 64108. My phone 0956116267.");
    }
}
