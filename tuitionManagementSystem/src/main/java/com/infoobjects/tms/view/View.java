package com.infoobjects.tms.view;

import java.io.IOException;

public interface View {

        public void insert() throws IOException;

        public void delete() throws NumberFormatException, IOException;

        public  void update() throws IOException;

        public void find(int studentId);

        public void findAll();

        public void mainView() throws Exception;

}
