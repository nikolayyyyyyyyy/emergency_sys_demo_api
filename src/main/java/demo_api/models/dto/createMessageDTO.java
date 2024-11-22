package demo_api.models.dto;

public class createMessageDTO {
    private long categoryId;
    private long regionId;
    private String location;
    private String description;

    public createMessageDTO() {
    }

    public createMessageDTO(long categoryId, String description, String location, long regionId) {
        this.categoryId = categoryId;
        this.description = description;
        this.location = location;
        this.regionId = regionId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public long getRegionId() {
        return regionId;
    }
}
