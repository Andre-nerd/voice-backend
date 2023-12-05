package com.zoomvoice.voice.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "isDelete")
    private Boolean isDelete;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

}
//            <column  name="is_deleted"  type="boolean" defaultValueBoolean="false"/>
//            <column  name="first_name"  type="varchar(90)"/>
//            <column  name="second_name"  type="varchar(90)"/>