package com.example.asm1b2.service;

import com.example.asm1b2.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    List<Video> list = new ArrayList<>();

    public MovieService() {
        list.add(new Video("1", "hoat hinh", "phim hay", true, "https://bizweb.dktcdn.net/100/438/408/files/anh-chan-dung-dep-yodyvn1.jpg?v=1683537734987"));
    }

    public List<Video> getAll() {
        return list;
    }
    
    public void addMovie(Video movie){
        list.add(movie);
    }

    public void updateMovie(Video movie){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(movie.getId())) {
                list.set(i, movie);
            }
        }
    }

    public boolean checkTrungIdMovie(String id){
        for (Video u : list) {
            if (u.getId().equals(id)) {
                return true; // ID đã tồn tại
            }
        }
        return false; // ID không tồn tại
    }

    public Video getById(String id){
        for(Video u : list){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }

    public void update(Video movie) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(movie.getId())) {
                list.set(i, movie);
            }
        }
    }

    public void deleteMovie(Video movie){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(movie.getId())){
                 list.remove(i);
            }
        }
    }

}
