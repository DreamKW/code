package com.etc.xml0915.service;


import com.etc.xml0915.entity.School;
import com.etc.xml0915.entity.Student;
import com.etc.xml0915.entity.Tclass;
import com.etc.xml0915.util.SchoolUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class XmlService {
//    创建一个单例
    private static XmlService xmlService;
    Document document;
//    私有的构造方法
    private XmlService(File file) throws ParserConfigurationException, IOException, SAXException {
//        创建工厂实例
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        创建builder 实例
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//       创建Document实例
        document = documentBuilder.parse(file);
    }

   public List<School> parseSchool(){
//
        List<School> schs = new ArrayList<>();
//        在解析学校的时候把学校里班级学生 的信息都添加到学校里
//        List<Tclass> tcls = new ArrayList<>();
//        List<Student> stus = new ArrayList<>();

//        判断是否为空
        if (document != null){
//            先根据school标签获取到所有的school结点
            NodeList schools = document.getElementsByTagName(SchoolUtil.SCHOOL);
//            遍历集合
            for (int i = 0; i < schools.getLength(); i++) {
//                获取到每一个school结点
                Node school = schools.item(i);
//                判断当前的结点是否是元素结点
                if(school.getNodeType() == Node.ELEMENT_NODE){
//                    将school结点转化为element对象
                    Element sch = (Element)school;
                    int schoolid = Integer.parseInt(sch.getAttribute(SchoolUtil.ID));
                    String schoolname = sch.getAttribute(SchoolUtil.NAME);
//                   创建school对象
                    School school1 = new School(schoolid,schoolname);
                    schs.add(school1);
//                    因为是for循环嵌套在解析出一个school对象之后 解析这个学校的班级信息
//                    之后再解析此学校各班级的学生信息

//                    通过sch 结点 获取到所有的子节点
                    NodeList tclasses = sch.getChildNodes();
                    for (int j = 0; j < tclasses.getLength(); j++) {
//                        获取到每一个班级
                        Node tclass = tclasses.item(j);
//                        判断当前结点是否为元素结点
                        if (tclass.getNodeType() == Node.ELEMENT_NODE){
//                            将当前结点转换为Element
                            Element tc = (Element) tclass;
//                            获取结点的属性值
                            int tcid = Integer.parseInt(tc.getAttribute(SchoolUtil.ID));
                            String tcname = tc.getAttribute(SchoolUtil.NAME);
                            Tclass tclass1 = new Tclass(tcid,tcname,school1);
//                            tcls.add(tclass1);

                            NodeList students = tc.getChildNodes();
                            for (int k = 0; k < students.getLength(); k++) {
                                Node student = students.item(k);
                                if (student.getNodeType() == Node.ELEMENT_NODE){
                                    Element stu = (Element)student;
                                    int sid = Integer.parseInt(stu.getAttribute(SchoolUtil.ID));
                                    String sname = stu.getAttribute(SchoolUtil.NAME);
                                    Student student1 = new Student(sid,sname,tclass1);
//                                    stus.add(student1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return schs;
    }
    public  static XmlService newInstance(File file) throws IOException, SAXException, ParserConfigurationException {
        if(xmlService == null ){
            xmlService = new XmlService(file);
        }
        return xmlService;
    }
}
