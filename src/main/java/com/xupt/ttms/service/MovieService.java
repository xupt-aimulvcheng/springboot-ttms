package com.xupt.ttms.service;

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Movie;

public interface MovieService {
    PageInfo<Movie> getAllMovies(int pageNum, int PageSize);

    Movie getMovieById(int parseInt);

    PageInfo<Movie> getMovie(String name, String startDate, String endDate, String status, int parseInt, int parseInt1);

    PageInfo<Movie> getMovieReleased(int parseInt, int parseInt1);

    int insert(Movie hall);

    int deleteMovie(String ids);

    int updateMovie(Integer id, Movie hall);

    String getType(Integer str);

    PageInfo<Movie> getMoviesByType(String status,String type, int pageNum, int PageSize);

    Movie getMovieByName(String name);

    Movie getMovieByById(Integer id);
}
