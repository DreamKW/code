package com.etc.xml0915.ui;

import com.etc.xml0915.entity.School;
import com.etc.xml0915.entity.Student;
import com.etc.xml0915.entity.Tclass;
import com.etc.xml0915.service.XmlService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class XmlUi {
    public static void main(String[] args) throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
        String path = XmlService.class.getResource("/").toURI().getPath()+"School.xml";
        File file = new File(path);
        List<School> list =XmlService.newInstance(file).parseSchool();
        for (School school :
                list) {
            System.out.println("学校信息");
            System.out.println("学校ID："+school.getId()+"学校名： "+school.getName());
            for (Tclass tc :
                    school.getTclassList()) {
                System.out.println("\n\t"+school.getName()+"学校的班级信息：");

                System.out.println("\t"+"班级ID："+tc.getId()+"班级名： "+tc.getName());
                for (Student stu :
                        tc.getStudentList()) {
                    System.out.println("\t\t"+tc.getName()+"班的学生信息");
                    System.out.println("\t\t"+"学生ID:"+stu.getId()+"学生姓名："+stu.getName());
                }
            }
        }
    }

}
