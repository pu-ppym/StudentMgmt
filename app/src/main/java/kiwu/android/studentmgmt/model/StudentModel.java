package kiwu.android.studentmgmt.model;

import java.util.Objects;

public class StudentModel {
    private String num;
    private String name;
    private float kor;
    private float eng;
    private float mat;

    public StudentModel(String num, String name, float kor, float eng, float mat) {
        this.num = num;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public StudentModel(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public float getKor() {
        return kor;
    }

    public float getEng() {
        return eng;
    }

    public float getMat() {
        return mat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(float kor) {
        this.kor = kor;
    }

    public void setEng(float eng) {
        this.eng = eng;
    }

    public void setMat(float mat) {
        this.mat = mat;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
