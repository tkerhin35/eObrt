package hr.maba.eobrt.domain.DTO;

import lombok.Getter;

@Getter
public class LocationDTO {

    private String name;

    private String cityName;

    public LocationDTO (String name, String cityName){
        this.name = name;
        this.cityName = cityName;
    }
}
