package com.xupt.ttms.service.impl;/*
 * @author:ck
 * @param:
 * @date:2022/7/6
 * @description:
 */

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.ttms.mapper.MovieMapper;
import com.xupt.ttms.pojo.Movie;
import com.xupt.ttms.pojo.MovieExample;
import com.xupt.ttms.service.MovieService;
import com.xupt.ttms.util.OOSUtil;
import com.xupt.ttms.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    private SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private MovieMapper movieMapper;
    private String keys = "movie_*";

    /*{
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }*/

    /**
     * 添加电影
     *
     * @param photo
     * @param movie
     * @return
     */
    public int insert(MultipartFile photo, Movie movie) {
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        String photoPath = "D:\\idea-project\\ttms\\target\\classes\\static\\main\\images\\movie";
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        String url = "../../main/images/movie/" + fileName;
        int insert;
        try {
            photo.transferTo(new File(finalPath));
            movie.setmImage(url);
            insert = movieMapper.insert(movie);
            if (insert >= 1) {
                RedisUtil.deleteCaChe(keys);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return insert;
    }

    /**
     * 根据电影名模糊查询
     *
     * @param name
     * @return
     */
    public PageInfo<Movie> getMovie(String name, String startDate, String endDate, String status, int pageNum, int PageSize) {
        Page<Movie> Movies = PageHelper.startPage(pageNum, PageSize);
        List<Movie> movies = movieMapper.selectMovies(name, startDate, endDate, status);
        PageInfo<Movie> pageInfo = new PageInfo(movies, 5);
        return pageInfo;
    }

    /**
     * 使用Mybatis的分页插件分页查询
     * 根据当前页码和总页面数据返回分页对应的数据
     *
     * @param pageNum  当前页码
     * @param PageSize 页面总个数
     * @return pageNum：当前页的页码
     * pageSize：每页显示的条数
     * size：当前页显示的真实条数
     * total：总记录数
     * pages：总页数
     * prePage：上一页的页码
     * nextPage：下一页的页码
     * isFirstPage/isLastPage：是否为第一页/最后一页
     * hasPreviousPage/hasNextPage：是否存在上一页/下一页
     * navigatePages：导航分页的页码数
     * navigatepageNums：导航分页的页码，[1,2,3,4,5]
     * list中的数据等同于直接输出的page数据
     */
    public PageInfo<Movie> getAllMovies(int pageNum, int PageSize) {
        Page<Movie> Movies = PageHelper.startPage(pageNum, PageSize);
        List<Movie> movies = movieMapper.selectAllMovies();
        PageInfo<Movie> pageInfo = new PageInfo(movies, 5);//5指的是导航分页的总页码数
        return pageInfo;
    }

    /**
     * 根据电影类型查询电影
     */
    public PageInfo<Movie> getMoviesByType(String status, String type, int pageNum, int PageSize) {
        Page<Movie> Movies = PageHelper.startPage(pageNum, PageSize);
        List<Movie> movies = movieMapper.getMoviesByType(status, type);
        PageInfo<Movie> pageInfo = new PageInfo(movies, 5);//5指的是导航分页的总页码数
        return pageInfo;
    }

    @Override
    public Movie getMovieByName(String name) {
        return movieMapper.getMovieByName(name);
    }

    @Override
    public Movie getMovieByById(Integer id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    /**
     * 正在上映的电影数量
     *
     * @return
     */
    @Override
    public int getLenReleased() {
        return movieMapper.getLenReleased();
    }


    /**
     * 根据id修改电影信息
     *
     * @param id
     * @param movie
     * @return
     */
    public int updateMovie(Integer id, Movie movie) {
        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria().andIdEqualTo(id);
        int result = movieMapper.updateByExampleSelective(movie, movieExample);
        if (result >= 1) {
            RedisUtil.deleteCaChe(keys);
        }
        return result;
    }

    @Override
    public String getType(Integer str) {
        String status = "";
        switch (str) {
            case 1:
                status += "剧情";
                break;
            case 2:
                status += "动作";
                break;
            case 3:
                status += "爱情";
                break;
            case 4:
                status += "喜剧";
                break;
            case 5:
                status += "惊悚";
                break;
            case 6:
                status += "悬疑";
                break;
            case 7:
                status += "战争";
                break;
            case 8:
                status += "奇幻";
                break;
            case 9:
                status += "恐怖";
                break;
            case 10:
                status += "动漫";
                break;
            case 11:
                status += "家庭";
                break;
        }
        return status;
    }

    public Movie getMovieById(int id) {
        return movieMapper.getMovieById(id);
    }

    /**
     * 批量删除演出厅
     */
    public int deleteMovie(String ids) {
        int delete = movieMapper.deleteById(ids);
        if (delete >= 1) {
            RedisUtil.deleteCaChe(keys);
        }
        return delete;
    }


    public PageInfo<Movie> getMovieReleased(int pageNum, int PageSize) {
        Page<Movie> Movies = PageHelper.startPage(pageNum, PageSize);
        MovieExample example = new MovieExample();
        example.createCriteria().andStatusEqualTo("上映中");
        List<Movie> movies = movieMapper.selectByExample(example);
        PageInfo<Movie> pageInfo = new PageInfo(movies, 5);//5指的是导航分页的总页码数
        return pageInfo;
    }
}
