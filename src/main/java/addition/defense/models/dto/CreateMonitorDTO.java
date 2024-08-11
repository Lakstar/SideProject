package addition.defense.models.dto;

import jakarta.validation.constraints.*;

public class CreateMonitorDTO {
    @NotEmpty
    @Size(min = 3, max = 60)
    private String name;

    @NotNull
    @Positive
    private int inches;

    @NotEmpty
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
