package org.redisCache.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "USER_INFO")
public class UserInfo implements Serializable {
    @Id
    private Long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "REMAINING_CHARGE_AMOUNT")
    private Long remainingChargeAmount;
}
