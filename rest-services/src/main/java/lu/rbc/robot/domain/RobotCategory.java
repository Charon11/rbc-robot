package lu.rbc.robot.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by renaudchardin on 31/07/2017.
 */
@Data
@Table
@Entity
public class RobotCategory  implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
}
