public class Persona {

    private static int personaCount = 0;

    private int id;
    private String name;
    private int age;
    private Gender gender; // MALE, FEMALE, UNDEFINED

    public Persona() {
        this.name = "UND";
        this.age = 0;
        this.gender = Gender.UNDEFINED;
        personaCount++;
        this.id = getPersonaCount();
    }
    public Persona(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        personaCount++;
        this.id = getPersonaCount();
    }

    public static int getPersonaCount() {
        return personaCount;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public Gender getGender() {
        return this.gender;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // На сравнение не влияет поле ID, если остальные поля одинаковые, то персоны считаются одинаковыми
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        if (persona.hashCode() != this.hashCode()) return false;
        return (
                //this.getId() == persona.getId() &&
                this.getName().equals(persona.getName()) &&
                this.getAge() == persona.getAge() &&
                this.getGender() == persona.getGender()
        );
    }

    // В вычислении Хэш-кода объекта не учитывается поле ID
    @Override
    public int hashCode() {
        int result = this.age * 11;
        if (this.gender.ordinal() % 2 == 0) result += 109;
        else result += 157;
        result += this.getName().hashCode() * 23;
        return result;
    }

    @Override
    public String toString() {
        if (this == null) return null;
        return String.format("ID: %d | Name: %s | Age: %d | Gender: %s", this.id, this.name, this.age, this.gender);
    }

}