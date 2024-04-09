package seminar04.ru.gb.employers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employers {
    List<Employer> employers = new ArrayList<>();

    public Employers() {}

    private Employers(List<Employer> employers) {
        this.employers = employers;
    }

    /**
     * Добавление нового сотрудника в справочник с номером телефона
     * @param name - ФИО
     * @param tabNumber - таб. номер
     * @param experience - стаж
     * @param category - категория телефона
     * @param number - номер телефона
     */
    public void add(String name, String tabNumber, int experience, String category, String number) {
        employers.add(new Employer(name, tabNumber, experience, category, number));
    }

    /**
     * Добавление нового сотрудника в справочник
     * @param name - ФИО
     * @param tabNumber - таб. номер
     * @param experience - стаж
     */
    public void add(String name, String tabNumber, int experience) {
        employers.add(new Employer(name, tabNumber, experience));
    }

    /**
     * Добавляет телефон сотруднику
     * @param employer - сотрудник
     * @param category - категория телефона
     * @param number - номер телефона
     */
    public void addPhone(Employer employer, String category, String number) {
        employer.addPhone(category, number);
    }

    /**
     * Добавляет телефон сотруднику с по табельному номеру
     * @param tabNumber - табельный номер
     * @param category - категория телефона
     * @param number - номер телефона
     */
    public void addPhone(String tabNumber, String category, String number) {
        Employer employer = findEmployer(tabNumber);
        if (employer != null)
            addPhone(employer, category, number);
    }

    /**
     * Ищет экземпляр Employer по табельному номеру
     * @param tabNumber табельный номер
     * @return Employer
     */
    public Employer findEmployer(String tabNumber) {
        for (Employer employer : employers) {
            if (employer.tabNumber.equals(tabNumber)) {
                return employer;
            }
        }
        return null;
    }

    public String getPhoneNumber(String name) {
        Employer employer = findEmployer(name);
        if (employer != null)
            return employer.getPhones();
        return "";
    }

    /**
     * Возвращает новый экземпляр Employers, отфильтрованный по номеру телефона
     * @param number номер телефона
     * @return отфильтрованный экземпляр Employers
     */
    public Employers getEmployerByPhone(String number) {
        return new Employers(employers.stream()
                .filter(employer -> employer.hasPhone(number))
                .collect(Collectors.toList()));
    }

    /**
     * Возвращает новый экземпляр Employers, отфильтрованный по стажу
     * @param experience - стаж
     * @return - отфильтрованный экземпляр
     */
    public Employers findByExperience(int experience) {
        return new Employers(employers
                                .stream()
                                .filter(employer -> employer.getExperience() == experience)
                                .collect(Collectors.toList()));
    }

    /**
     * Возвращает список строк ФИО + телефон, отфильтрованных по ФИО
     * @param name - ФИО
     * @return - список ФИО + телефон
     */
    public List<String> getPhoneByName(String name) {

        return employers
            .stream()
            .filter(employer -> employer.getName().equals(name))
            .map(employer -> String.format("%s - тел. %s", employer.getName(), employer.getPhones()))
                .collect(Collectors.toList());

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employer employer : employers) {
            sb.append(employer);
            sb.append("\n");
        }
        return sb.toString();
    }
}
