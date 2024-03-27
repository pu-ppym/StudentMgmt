package kiwu.android.studentmgmt.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import kiwu.android.studentmgmt.model.StudentModel;

public class StudentFileController {
    private static final String FILE_NAME = "students.txt";
    private static final String SEPERATOR = "\t";
    private File file;

    public StudentFileController(String path) throws IOException {  // path -> 내장,외장 설정
        file = new File(path, FILE_NAME);

        if(! file.exists()) {
            file.createNewFile();
        }
    }

    // 성적정보 arraylist를 파라미터로 넘겨받음
    public void write(ArrayList<StudentModel> students) throws IOException {
        if(students == null || students.size() < 1) {   // * 저장할 정보 없으면 바로 반환
            return;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        Iterator<StudentModel> iterator = students.iterator();

        StudentModel student = null;
        String line = null;

        while(iterator.hasNext()) {
            student = iterator.next();

            line = student.getNum() + SEPERATOR + student.getName() + SEPERATOR +
                    student.getKor() + SEPERATOR +
                    student.getEng() + SEPERATOR +
                    student.getMat();

            out.write(line);
            out.newLine();
        }

        System.out.println("> " + students.size() + "건의 학생정보를 파일에 저장했습니다.");
        out.close();
    }

    public ArrayList<StudentModel> read() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        ArrayList<StudentModel> students = new ArrayList<>();
        StudentModel student = null;
        String line = null;
        StringTokenizer tokens = null;

        while((line = in.readLine()) != null) {
            tokens = new StringTokenizer(line, SEPERATOR);

            student = new StudentModel(tokens.nextToken());  // 학번 지정하면서 모델클래스 생성
            student.setName(tokens.nextToken());   // 성적정보 저장
            student.setKor(Float.parseFloat(tokens.nextToken()));
            student.setEng(Float.parseFloat(tokens.nextToken()));
            student.setMat(Float.parseFloat(tokens.nextToken()));

            students.add(student);
        }

        System.out.println("> " + students.size() + "건의 학생정보를 파일에서 읽었습니다");
        in.close();
        return students;
    }

}
