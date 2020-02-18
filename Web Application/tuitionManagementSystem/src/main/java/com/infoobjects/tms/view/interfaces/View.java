package com.infoobjects.tms.view.interfaces;

import java.io.IOException;

public interface View<Integer, DTO> {

        void insert() throws IOException;

        void delete() throws NumberFormatException, IOException;

        void update() throws IOException;

        DTO find(Integer id);

        void findAll();

        void mainView() throws Exception;

}
