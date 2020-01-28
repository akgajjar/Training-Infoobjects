package com.infoobjects.tms.view.interfaces;

import java.io.IOException;

public interface View<Integer, T> {

        public void insert() throws IOException;

        public void delete() throws NumberFormatException, IOException;

        public  void update() throws IOException;

        public void find(Integer id);

        public void findAll();

        public void mainView() throws Exception;

}
