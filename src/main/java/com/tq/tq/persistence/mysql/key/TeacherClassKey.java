package com.tq.tq.persistence.mysql.key;

import jakarta.persistence.*;

import java.io.Serializable;

public class TeacherClassKey implements Serializable {

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "class_id")
    private Long classId;

    // hashCode, equals, constructors
}