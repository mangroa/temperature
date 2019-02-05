package com.mangroo.temperature.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TEMPERATURE")
public class Temperature {

    @Id
    private Long id;

    private String name;
    private float temperature;
    Date timestamp;
}
