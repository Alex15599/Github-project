package com.niuys.gdzc.service.impl;

import java.util.List;

import com.niuys.gdzc.dao.IEmployeeDAO;
import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.service.IEmployeeManager;

public class EmployeeManagerImpl implements IEmployeeManager {
	
	private IEmployeeDAO employeeDAOImpl;
	

	public void setEmployeeDAOImpl(IEmployeeDAO employeeDAOImpl) {
		this.employeeDAOImpl = employeeDAOImpl;
	}

	public List findPageEmployee(int pageStartRow, int pageCount) {

		return employeeDAOImpl.findPageEmployee(pageStartRow, pageCount);
	}

	public List showAllEmployee() {

		return employeeDAOImpl.showAllEmployee();
	}

	public List showAlldept() {
		
		return employeeDAOImpl.showAlldept();
	}

	public boolean insertEmployee(Comployee comp) {
		
		return employeeDAOImpl.insertEmployee(comp);
	}

	public boolean deleteEmployee(String eno) {
		
		return employeeDAOImpl.deleteEmployee(eno);
	}

	public List findEmployeebyeno(String eno) {

		return employeeDAOImpl.findEmployeebyeno(eno);
	}

	public boolean updateEmployee(Comployee com) {


		return employeeDAOImpl.updateEmployee(com);
	}

	public boolean isEmployeebyno(String eno) {

		return employeeDAOImpl.isEmployeebyno(eno);
	}

	public boolean isEmployeebyname(String name) {

		return employeeDAOImpl.isEmployeebyname(name);
	}

}
