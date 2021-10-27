package com.reactivespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/*
@DBRef  used for referencing (Mapping) - OneToMany - auto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_tb")
public class MongoUser {
    @Id
    private String id;
    @Indexed
    private int userId;
    private String name;
    private String phone;
    @Field("mail")
    private String email;
    @DBRef
    private List<MongoUserRole> roles;
}
