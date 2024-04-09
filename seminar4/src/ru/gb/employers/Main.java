package seminar04.ru.gb.employers;

public class Main {

    public static void main(String[] args) {
        Employers employers = new Employers();

        System.out.println("*******************************************************");
        System.out.println("Добавление сотрудников в справочник");
        employers.add("Иванов Иван Иванович", "0001", 15, "Рабочий", "8499010101");
        employers.addPhone("0001", "Мобильный", "+7987012345");
        employers.add("Петров Василий Николаевич", "0002", 15);
        employers.addPhone("0002", "Мобильный", "+7987001122");
        employers.add("Николаев Игорь Васильевич", "0003", 12, "Рабочий", "8499010101");
        employers.add("Иванов Иван Иванович", "0004", 33, "Рабочий", "8499555555");

        System.out.println("Все сотрудники:");
        System.out.println(employers);

        System.out.println("*******************************************************");
        System.out.println("Стаж 15");
        System.out.println(employers.findByExperience(15));

        System.out.println("*******************************************************");
        System.out.println("Телефоны Ивановых");
        for (String empl : employers.getPhoneByName("Иванов Иван Иванович")) {
            System.out.println(empl);
        }

        System.out.println("*******************************************************");
        System.out.println("Поиск по табельному номеру 0003");
        System.out.println(employers.findEmployer("0003"));

        System.out.println("*******************************************************");
        System.out.println("Поиск по номеру телефона 8499010101");
        System.out.println(employers.getEmployerByPhone("8499010101"));


    }

}
