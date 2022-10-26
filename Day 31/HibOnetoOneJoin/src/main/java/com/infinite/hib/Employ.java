package com.infinite.hib;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Employ234")
public class Employ {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@PrimaryKeyJoinColumn

private int empno;
private String name;
private String dept;
private String desig;
private double basic;
@OneToOne(targetEntity=workStation.class,cascade=CascadeType.ALL)
private workStation workStation;



public workStation getWorkStation() {
return workStation;
}
public void setWorkStation(workStation workStation) {
this.workStation = workStation;
}
public int getEmpno() {
return empno;
}
public void setEmpno(int empno) {
this.empno = empno;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDept() {
return dept;
}
public void setDept(String dept) {
this.dept = dept;
}
public String getDesig() {
return desig;
}
public void setDesig(String desig) {
this.desig = desig;
}
public double getBasic() {
return basic;
}
public void setBasic(double basic) {
this.basic = basic;
}


}
