package com.infoobjects.tms.start;

import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.view.StudentViewImpl;
import com.infoobjects.tms.view.interfaces.View;

public class TmsStart {

	public static void main(String[] args) throws Exception {

		String pretty = "--------------------------------------------------------------------\n";
		String systemName = "\t\t\tTuition Management System\t\t\t";
		System.out.printf("%s %s %n %s %n", pretty, systemName, pretty);

		View<Integer, StudentDTO> view = new StudentViewImpl();
		view.mainView();
	}

}
