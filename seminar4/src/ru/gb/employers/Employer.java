package seminar04.ru.gb.employers;

import java.util.ArrayList;
import java.util.List;

public class Employer {

    private class Phone {
        String category;
        String number;

        public Phone(String category, String number) {
            this.category = category;
            this.number = number;
        }

        @Override
        public String toString() {
            return category + ": " + number;
        }
    }

    String name;
    String tabNumber;
    int experience;
    List<Phone> phones;

    public Employer(String name, String tabNumber, int experience, String category, String number) {
        this(name, tabNumber, experience);
        addPhone(category, number);
    }

    public Employer(String name, String tabNumber, int experience) {
        this.name = name;
        this.tabNumber = tabNumber;
        this.experience = experience;
        this.phones = new ArrayList<>();
    }

    /**
     * Добавляет телефон сотруднику
     * @param category - категория телефона
     * @param number - номер телефона
     */
    public void addPhone(String category, String number) {
        this.phones.add(new Phone(category, number));
    }

    Phone getPhone(String number) {
        for (Phone phone : this.phones) {
            if (phone.number.equals(number))
                return phone;
        }
        return null;
    }

    public boolean hasPhone(String number) {
        return (getPhone(number) != null);
    }

    public String getPhones() {
        return phones.toString();
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Таб.№" + tabNumber + ", " + name + ", стаж " + experience + ", телефоны: " + getPhones();
    }

}
