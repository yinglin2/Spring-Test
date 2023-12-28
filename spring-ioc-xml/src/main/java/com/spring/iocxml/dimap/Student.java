package com.spring.iocxml.dimap;

import java.util.List;
import java.util.Map;

public class Student {
    private String sid;
    private String sname;

    private Map<String, Teacher> teacherMap;

    private List<Lecture> lectureList;

    public void run() {
        System.out.println("Student id: " + sid + ";Student name: " + sname);
        System.out.println(teacherMap);
        System.out.println(lectureList);
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }
}
