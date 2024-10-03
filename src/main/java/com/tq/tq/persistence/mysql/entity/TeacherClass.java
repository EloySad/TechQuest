package com.tq.tq.persistence.mysql.entity;
import com.tq.tq.persistence.mysql.key.TeacherClassKey;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher_classes")
public class TeacherClass {

    @EmbeddedId
    private TeacherClassKey id;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private User teacher; // Referencia a User, con role = "TEACHER"

    @ManyToOne
    @MapsId("classId")
    @JoinColumn(name = "class_id")
    private Class Class;

    // Getters and Setters
}
