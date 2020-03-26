package xyz.wadewhy.springboot_redis02.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/*/**
 * @Author 钟子豪
 * @Date 2020/3/26
 * @description 
 No such property: code for class: Script1
 * @Return 
 */
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity implements Serializable {
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "age")
    private int age;
}
