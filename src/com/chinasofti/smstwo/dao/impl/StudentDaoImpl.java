package com.chinasofti.smstwo.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.chinasofti.smstwo.dao.StudentDao;
import com.chinasofti.smstwo.dmain.Student;

public class StudentDaoImpl implements StudentDao{

	private BufferedReader in;
	private PrintWriter out;
	public static final String URL="data/student.txt";
	
	@Override
	public boolean intertStudent(Student stu) {
		// 进行out的实例化操作
		try {
			out=new PrintWriter(new OutputStreamWriter(new FileOutputStream(URL,true),"UTF-8"));
			//写数据
			out.println(stu.show());
			//刷新缓冲区
			out.flush();
			return true;
		} catch (UnsupportedEncodingException |FileNotFoundException e) {
			return false;
		}finally {
			if(out!=null)out.close();
		}
	}

	@Override
	public List<Student> selectAllStudent() {
		// 创建一个List集合
		List<Student> list=new ArrayList<Student>();
		//创建输入流
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream(URL), "UTF-8"));
			//创建一个字符串临时存储每一行数据
			String s=null;
			while((s=in.readLine())!=null){
				String[] arr=s.split("#");
				list.add(new Student(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2])));
			}
			return list;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(in!=null)in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return null;
	}

	@Override
	public Student selectById(int id) {
		// 调用自身的查询所有的方法
		List<Student> list=selectAllStudent();
		//便利list集合
		for (Student student : list) {
			if(id==student.getStuId()){
				return student;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// 查询所有的学生
		List<Student> list=selectAllStudent();
		Iterator<Student> it=list.iterator();
		//将制定的学生从集合中删掉
		while(it.hasNext()){
			if(id==it.next().getStuScore()){
				it.remove();
				break;
			}
		}
		for (Student student : list) {
			System.out.println(student);
		}
		//删除原有的文件夹
		File file=new File(URL);
		if(file .exists()){
			file.delete();
		}
		if(list.size()==0){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//重新将所有的集合中学生写入到新的文件中
		for (Student student : list) {
			intertStudent(student);
		}
		return true;
	}
}
