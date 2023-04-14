package user.service.dto;


public class UserRegisterDto {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UserRegisterDto(
            String name,
            int age
    ) {
        this.name = name;
        this.age = age;
    }
}
