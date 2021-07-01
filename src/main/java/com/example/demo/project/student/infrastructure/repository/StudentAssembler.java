package com.example.demo.project.student.infrastructure.repository;

import com.example.demo.project.student.domain.Student;
import com.example.demo.project.student.domain.StudentProperties;
import com.example.demo.project.student.domain.StudentRow;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class StudentAssembler {
    private ObjectMapper objectMapper = new ObjectMapper();
    public StudentRow studentRowFromStudent(Student student){
        try {
            return StudentRow.builder()
                    .stuId(student.getStuId())
                    .name(student.getName())
                    .sex(student.getSex())
                    .age(student.getAge())
                    .entryTime(student.getEntryTime())
                    .teachers(objectMapper.writeValueAsString(student.getTeachers()))
                    .properties(objectMapper.writeValueAsString(student.getProperties()))
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Student studentRowToStudent(StudentRow studentRow){
        Student student = Student.builder()
                .stuId(studentRow.getStuId())
                .name(studentRow.getName())
                .sex(studentRow.getSex())
                .age(studentRow.getAge())
                .entryTime(studentRow.getEntryTime())
                .build();
        if (studentRow.getTeachers() != null) {
            try {
                student.setTeachers(objectMapper.readValue(studentRow.getTeachers(), List.class));
            } catch (JsonProcessingException e) {
                System.out.println("teacher列表为空，但仍可以运行");
            }
        }
        if (studentRow.getProperties() != null){
            try {
                student.setProperties(objectMapper.readValue(studentRow.getProperties(), new TypeReference<List<StudentProperties>>() {}));
            } catch (JsonProcessingException e) {
                System.out.println("properties列表为空，但仍可以运行");
            }
        }
        return student;
    }
}
