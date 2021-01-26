package org.sb.examples.simple.dyna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springbridge.action.ActionMapping;
import org.springbridge.action.DynaActionForm;

public class OptionsForm extends DynaActionForm implements HttpSessionBindingListener{
	private static final long serialVersionUID = 1L;

	String fruit1;
	String fruit2;
	String[] fruit3;
	String color1;
	String color2;
	String color3;
	String day1;
	String day2;
	String book1;
	String book2;
	String animal1;
	String animal2;
	
    public String getFruit1() {
		return fruit1;
	}

	public void setFruit1(String fruit1) {
		this.fruit1 = fruit1;
	}

	public String getFruit2() {
		return fruit2;
	}

	public void setFruit2(String fruit2) {
		this.fruit2 = fruit2;
	}

	public String[] getFruit3() {
		return fruit3;
	}

	public void setFruit3(String[] fruit3) {
		this.fruit3 = fruit3;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getColor3() {
		return color3;
	}

	public void setColor3(String color3) {
		this.color3 = color3;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getBook1() {
		return book1;
	}

	public void setBook1(String book1) {
		this.book1 = book1;
	}

	public String getBook2() {
		return book2;
	}

	public void setBook2(String book2) {
		this.book2 = book2;
	}

	public String getAnimal1() {
		return animal1;
	}

	public void setAnimal1(String animal1) {
		this.animal1 = animal1;
	}

	public String getAnimal2() {
		return animal2;
	}

	public void setAnimal2(String animal2) {
		this.animal2 = animal2;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.fruit1 = "Pear";
        this.fruit2 = "Apple";
        this.fruit3 = new String[]{"Banana", "Orange"};
    }
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("valueBound");
		//new Exception().printStackTrace();
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
	}

}
