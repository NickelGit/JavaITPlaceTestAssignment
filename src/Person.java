import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class Person {
    String pathToPropertie = "src/personProp.properties";
    FileInputStream fileInputStream;
    String FIO, DOB, phone, email, skype, avatar, codeExample;
    String[] target, experience, education, additionalEducation, skills;

    public Person(){
        Properties personProp = new Properties();
        try{
            fileInputStream = new FileInputStream(pathToPropertie);
            personProp.load(fileInputStream);

            FIO = new String(personProp.getProperty("FIO").getBytes("ISO8859-1"), "cp1251");
            DOB = new String(personProp.getProperty("DOB").getBytes("ISO8859-1"), "cp1251");
            phone = new String(personProp.getProperty("phone").getBytes("ISO8859-1"), "cp1251");
            email = new String(personProp.getProperty("email").getBytes("ISO8859-1"), "cp1251");
            skype = new String(personProp.getProperty("skype").getBytes("ISO8859-1"), "cp1251");
            avatar = new String(personProp.getProperty("avatar").getBytes("ISO8859-1"), "cp1251");
            target = new String(personProp.getProperty("target").getBytes("ISO8859-1"), "cp1251").split("\",\"");
            quotesDelete(target);
            experience = new String(personProp.getProperty("experience").getBytes("ISO8859-1"), "cp1251").split("\",\"");
            quotesDelete(experience);
            education = new String(personProp.getProperty("education").getBytes("ISO8859-1"), "cp1251").split("\",\"");
            quotesDelete(education);
            additionalEducation = new String(personProp.getProperty("additionalEducation").getBytes("ISO8859-1"), "cp1251").split("\",\"");
            quotesDelete(additionalEducation);
            skills = new String(personProp.getProperty("skills").getBytes("ISO8859-1"), "cp1251").split("\",\"");
            quotesDelete(skills);
            codeExample = new String(personProp.getProperty("codeExample").getBytes("ISO8859-1"), "cp1251");

        }
        catch(IOException e)
        {
            System.out.println("Файл с данными соискателя не найден!");
        }
    }

    public static void quotesDelete(String[] strArr){
        strArr[0] = strArr[0].substring(1);
        strArr[strArr.length - 1] = strArr[strArr.length - 1].substring(0,(strArr[strArr.length - 1].length()-1));
    }

    public void personToHTMLResume(){
        StringBuilder builder = new StringBuilder();

        StringBuilder targetBlock = new StringBuilder() ;
        for(String s : this.target){
            targetBlock.append(s);
        }
        StringBuilder experienceBlock = new StringBuilder() ;
        for(String s : this.experience){
            experienceBlock.append("<li>"+s+"</li>\n");
        }
        StringBuilder educationBlock = new StringBuilder() ;
        for(String s : this.education){
            educationBlock.append(s);
        }
        StringBuilder additionalEducationBlock = new StringBuilder() ;
        for(String s : this.additionalEducation){
            additionalEducationBlock.append("<li>"+s+"</li>\n");
        }
        StringBuilder skillsBlock = new StringBuilder() ;
        for(String s : this.target){
            skillsBlock.append(s);
        }


        builder.append("<!DOCTYPE html>\r\n" +
                "<html lang=\"ru\">\r\n" +
                "  <head>\r\n" +
                "    <meta charset=\"UTF-8\">    \r\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" +
                "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n" +
                "    <title>Резюме на должность Java-стажер </title>\r\n" +
                "\r\n" +
                "    <!-- Bootstrap -->\r\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" +
                "\r\n" +
                "    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n" +
                "    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n" +
                "    <!--[if lt IE 9]>\r\n" +
                "      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n" +
                "      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n" +
                "    <![endif]-->\r\n" +
                "  </head>\r\n" +
                "  <body>\r\n" +
                "\t<div class=\"conteiner-fluid\">\t\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-12\"><h3><p class=\"text-center\"><strong>Резюме</strong><br>на должность Java-стажер</p></h3> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-4\"><strong><p class=\"text-right\"> ФИО:</p></strong>\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><strong><p class=\"text-right\"> Дата рождения:</p></strong> </div>\r\n" +
                "\t\t\t\t</div>\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><strong><p class=\"text-right\"> Телефон:</p></strong> </div>\r\n" +
                "\t\t\t\t</div>\t\t\t\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><strong><p class=\"text-right\"> e-mail:</p></strong> </div>\r\n" +
                "\t\t\t\t</div>\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><strong><p class=\"text-right\"> Skype:</p></strong> </div>\r\n" +
                "\t\t\t\t</div>\r\n" +
                "\t\t \t</div>\r\n" +
                "\t\t\t<div class=\"col-sm-3\"><p class=\"text-left\">" + this.FIO + "</p> \r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><p class=\"text-left\">" + this.DOB + "</p> </div>\r\n" +
                "\t\t\t\t</div>\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><p class=\"text-left\">" + this.phone + "</p> </div>\r\n" +
                "\t\t\t\t</div>\t\t\t\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><p><a href=\"mailto:#\">" + this.email + "</a></p> </div>\r\n" +
                "\t\t\t\t</div>\r\n" +
                "\t\t\t\t<div class=\"row\">\r\n" +
                "\t\t\t\t\t<div class=\"col-sm-12\"><p><a href=\"https://www.skype.com/ru/\">" + this.skype + "</a></p> </div>\r\n" +
                "\t\t\t\t</div>\r\n" +
                "\t\t\t</div>\r\n" +
                "\t\t\t<div class=\"col-sm-2\"><img src=\"" + this.avatar + "\" class=\"img-responsive\" alt=\"Responsive image\"> </div>\r\n" +
                "\r\n" +
                "\t\t\t\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" ><h4><p class=\"text-left\"><strong>Цель:</strong></p></h4> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" > <p>" + targetBlock.toString() + "</p></div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" ><h4><p class=\"text-left\"><strong>Опыт:</strong></p></h4> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" > <ol>\r\n" + experienceBlock.toString() +
                "</ol>\r\n" +
                "\t\t\t</div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" ><h4><p class=\"text-left\"><strong>Образование:</strong></p></h4> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" > <p> " + educationBlock.toString() + "</p></div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" ><h4><p class=\"text-left\"><strong>Доп.образование и курсы:</strong></p></h4> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" > <ol>\r\n" + additionalEducationBlock.toString() +
                "</ol>\r\n" +
                "\t\t\t</div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" ><h4><p class=\"text-left\"><strong>Навыки:</strong></p></h4> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" > <p> " + skillsBlock.toString() + "</p></div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" ><h4><p class=\"text-left\"><strong>Пример кода:</strong></p></h4> </div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t<div class=\"row\">\r\n" +
                "\t\t\t<div class=\"col-sm-6 col-sm-offset-3\" > <pre> " + this.codeExample + " </pre>\r\n" +
                "\t\t\t</div>\r\n" +
                "\t\t</div>\r\n" +
                "\t\t\r\n" +
                "\t\t\r\n" +
                "\t\t\r\n" +
                "    \r\n" +
                "\t</div>\r\n" +
                "\r\n" +
                "    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n" +
                "    <!-- Include all compiled plugins (below), or include individual files as needed -->\r\n" +
                "    <script src=\"js/bootstrap.min.js\"></script>\r\n" +
                "  </body>\r\n" +
                "</html>");

        try {
            FileWriter fileWriter = new FileWriter("src/personHTMLResume.html");
            fileWriter.write(builder.toString());
            fileWriter.flush();
        }
        catch(IOException e){

        }


    }


}
