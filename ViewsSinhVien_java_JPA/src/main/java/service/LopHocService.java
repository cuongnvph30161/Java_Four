package service;

import entity.LopHoc;
import responsitory.LopHocRespository;

import java.util.ArrayList;

public class LopHocService {
    LopHocRespository lopHocRespository = new LopHocRespository();
    public ArrayList<LopHoc> getAll(){
        return lopHocRespository.getList();
    }
}
