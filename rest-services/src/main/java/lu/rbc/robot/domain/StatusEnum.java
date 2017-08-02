package lu.rbc.robot.domain;

import lombok.Getter;

/**
 * Created by renaudchardin on 31/07/2017.
 */

public enum StatusEnum {

    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    @Getter private String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
