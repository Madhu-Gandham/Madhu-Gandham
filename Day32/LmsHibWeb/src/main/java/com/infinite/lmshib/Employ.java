package com.infinite.lmshib;

import java.util.Date;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.NamedQueries;

import javax.persistence.NamedQuery;

import javax.persistence.Table;

@NamedQueries( 

   { 

       @NamedQuery( 

       name = "showEmploy", 

       query = "from Employ" 

       ),

       @NamedQuery( 

    	       name = "searchEmploy", 

    	       query = "from Employ where empId=:empId" 

    	       ),
       @NamedQuery( 

    	       name = "searchManager", 

    	       query = "from Employ where mgrId=:mgrId" 

    	       )
       } 
   ) 

@Entity

@Table(name="employee")

public class Employ {

 

@Id

@Column(name="EMP_ID")

private int empId;

 

@Column(name="EMP_NAME")

private String empName;

 

@Column(name="EMP_MAIL")

private String empEmail;

 

@Column(name="EMP_MOB_NO")

private String empMobile;

 

@Column(name="EMP_DT_JOIN")

private Date empDoj;

 

@Column(name="EMP_DEPT")

private String empDept;

 

@Column(name="EMP_MANAGER_ID")

private Integer mgrId;

 

public Integer getMgrId() {

           return mgrId;

}
public void setMgrId(Integer mgrId) {

           this.mgrId = mgrId;
}
@Column(name="EMP_AVAIL_LEAVE_BAL")
private int leaveAvail;
public int getEmpId() {
return empId;
}
public void setEmpId(int empId) {
this.empId = empId;

}

public String getEmpName() {
return empName;
}
public void setEmpName(String empName) {
this.empName = empName;
}

public String getEmpEmail() {

return empEmail;

}

public void setEmpEmail(String empEmail) {
this.empEmail = empEmail;
}
public String getEmpMobile() {
return empMobile;
}
public void setEmpMobile(String empMobile) {
this.empMobile = empMobile;

}

public Date getEmpDoj() {
return empDoj;
}

public void setEmpDoj(Date empDoj) {
this.empDoj = empDoj;

}

public String getEmpDept() {
return empDept;
}

public void setEmpDept(String empDept) {
this.empDept = empDept;
}

public int getLeaveAvail() {
return leaveAvail;
}

public void setLeaveAvail(int leaveAvail) {
this.leaveAvail = leaveAvail;
}

@Override

public String toString() {
return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empMobile="
+ empMobile + ", empDoj=" + empDoj + ", empDept=" + empDept + ", mgrId=" + mgrId + ", leaveAvail="
+ leaveAvail + "]";

}
}