import java.util.Arrays;

public class Programmer extends Persona {

    private String companyName;
    private int jobExperience;
    private String[] jobStack;

    public Programmer() {
        this.companyName = "UND";
        this.jobExperience = 0;
        this.jobStack = new String[]{"NONE", "NONE", "NONE"};
    }
    public Programmer(String name, int age, Gender gender, String companyName, int jobExperience, String[] jobStack) {
        super(name, age, gender);
        this.companyName = companyName;
        this.jobExperience = jobExperience;
        this.jobStack = jobStack;
    }

    public String getCompanyName() {
        return companyName;
    }
    public String[] getJobStack() {
        return jobStack;
    }
    public int getJobExperience() {
        return jobExperience;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setJobExperience(int jobExperience) {
        this.jobExperience = jobExperience;
    }
    public void setJobStack(String[] jobStack) {
        this.jobStack = jobStack;
    }

    // На сравнение не влияет поле ID, если остальные поля одинаковые, то программисты считаются одинаковыми
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Programmer programmer = (Programmer) obj;
        if (programmer.hashCode() != this.hashCode()) return false;
        return (
                //this.getId() == programmer.getId() &&
                this.getName().equals(programmer.getName()) &&
                this.getAge() == programmer.getAge() &&
                this.getGender() == programmer.getGender() &&
                this.getCompanyName().equals(programmer.getCompanyName()) &&
                this.getJobExperience() == programmer.getJobExperience() &&
                Arrays.equals(this.getJobStack(), programmer.getJobStack())
        );
    }

    // В вычислении Хэш-кода объекта не учитывается поле ID
    @Override
    public int hashCode() {
        int result = this.getAge() * 11;
        if (this.getGender().ordinal() % 2 == 0) result += 109;
        else result += 157;
        result += this.getJobExperience() * 31;
        result += this.getJobStack().length * 7 + 23;
        result += this.getName().hashCode() + this.getCompanyName().hashCode() * 23;
        return result;
    }

    @Override
    public String toString() {
        if (this == null) return null;
        return String.format(
                "ID: %d | Name: %s | Age: %d | Gender: %s | Company: %s | Experience: %d | Stack: %s",
                this.getId(), this.getName(), this.getAge(), this.getGender(), companyName, jobExperience, String.join(", ", jobStack)
        );
    }

}
