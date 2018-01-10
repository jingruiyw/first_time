package com.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Car;

@WebServlet("/show.do")
public class ShowAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Car> cars = new ArrayList<Car> ();
		//录入数据
		for(int i=0;i<4;i++){
			Car car = new Car(i,"bmw"+i,"red",i*100000);
			cars.add(car);
		}
		
		//添加对象
		
		StringBuilder json = new StringBuilder();
		json.append("[");
		for(Car car:cars){
			json.append("{");
			json.append("cno:\""+car.getCno()+"\""+",");
			json.append("cname:\""+car.getCname()+"\""+",");
			json.append("color:\""+car.getColor()+"\""+",");
			json.append("price:\""+car.getPrice()+"\"");
			json.append("}");
			json.append(",");
		}
		json.delete(json.length()-1, json.length());//删除逗号
		json.append("]");
		
		resp.getWriter().print(json);
		
	}
	
}


























