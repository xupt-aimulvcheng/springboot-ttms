package com.xupt.ttms.controller;/*
 * @author:ck
 * @param:
 * @date:2022/7/31
 * @description:
 -Dfile.encoding=UTF-8
 */

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Movie;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.service.MovieService;
import com.xupt.ttms.util.RedisUtil;
import com.xupt.ttms.util.ToResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@Controller
public class MovieServlet {
    @Autowired
    private MovieService movieService;
    @Autowired
    private RedisTemplate redisTemplate;
    private String keys = "movie_*";

    @RequestMapping(value = "/movie/updateMovie", method = RequestMethod.POST)
    @ResponseBody
    public String updateMovie(@RequestBody Movie movie) {
        int result = movieService.updateMovie(movie.getId(), movie);
        if (result>=1){
            RedisUtil.deleteCaChe(keys,redisTemplate);
        }
        return (result >= 1 ? "修改成功" : "修改失败");
    }

    @RequestMapping(value = "/movie/getMovieById/{id}", method = RequestMethod.GET)
    public String getMovieById(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "manager/page/movie/edit";
    }

    @RequestMapping(value = "/movie/getMovieInfoById/{id}", method = RequestMethod.POST)
    @ResponseBody
    @Cacheable(value  ="movie_",keyGenerator = "movieKeyGenerator")
    public Result getMovieInfoById(@PathVariable("id") Integer id) {
        Movie movie = movieService.getMovieById(id);
        return ToResult.getResult(movie);
    }

    @RequestMapping(value = "/movie/getMovie", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value ="movie_",keyGenerator = "movieKeyGenerator")
    public Result getMovie(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, @RequestParam(value = "status", required = false) String status) {

        PageInfo<Movie> movies = movieService.getMovie(name, startDate, endDate, status, pageNum, pageSize);
        Result result = ToResult.getResult(movies);
        return result;
    }

    @RequestMapping(value = "/movie/getMovieReleased", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value ="movie_",keyGenerator = "movieKeyGenerator")
    public Result getMovieReleased(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate) {
        PageInfo<Movie> movies = movieService.getMovie(name, startDate, endDate, "上映中", pageNum, pageSize);
        Result result = ToResult.getResult(movies);
        return result;
    }
    @GetMapping(value = "/movie/GetMovieByStatus")
    @ResponseBody
    @Cacheable(value ="movie_",keyGenerator = "movieKeyGenerator")
    public Result GetMovieByStatus(@RequestParam(value = "page",required = false) Integer pageNum, @RequestParam(value = "limit",required = false) Integer pageSize, @RequestParam(value = "type", required = false) Integer kind) {
        if (pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=5;
        }
        if (kind==null){
            PageInfo<Movie> movies = movieService.getMovie(null,null,null,"上映中",pageNum,pageSize);
            Result result = ToResult.getResult(movies);
            return result;
        }
        else {
            String type = movieService.getType(kind);
            PageInfo<Movie> movies = movieService.getMoviesByType("上映中",type, pageNum, pageSize);
            Result result = ToResult.getResult(movies);
            return result;
        }
    }

    @RequestMapping("/toMovie/{status}")
    public String toController(RedirectAttributes attr, @PathVariable String status){//第一个controller中传入RedirectAttributes参数
        attr.addAttribute("status",status);    //封装跳转是需要携带的参数
        return "redirect:/user/index";
    }

    @RequestMapping("/otherController")
    public String toOtherController(String status,Model model){//这里传入param需要和attr中的key一样
        System.out.println("param-----:"+status);//这里输出的为:"param-----:test"
        model.addAttribute("param", status);  //Model封装参数,携带到前台
        return "user/index";
    }

    @GetMapping("/movie/getLenReleased")
    @ResponseBody
    @Cacheable(value ="movie_",keyGenerator = "movieKeyGenerator")
    public Result getLenReleased(){
        int len = movieService.getLenReleased();
        return ToResult.getResult(len);
    }

    @RequestMapping(value = "/movie/addMovie", method = RequestMethod.POST)
    @ResponseBody
    public String addMovie(@RequestParam("file") MultipartFile photo, HttpSession session,@RequestParam("mName") String mName,
                           @RequestParam("mType") String mType, @RequestParam("mLength") Integer mLength,@RequestParam("mDate") String mDate,
                           @RequestParam("mDirector") String mDirector,@RequestParam("mActor") String mActor, Double mBoxOffice,
                           Double mScore,@RequestParam("mIntroduction") String mIntroduction, String mImage, @RequestParam("status") String status) throws IOException {
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = "D:\\idea-project\\ttms\\target\\classes\\static\\main\\images\\movie";
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        String url="../../main/images/movie/"+fileName;
        //实现上传功能
        log.info("封面文件的绝对路径为"+finalPath);
        log.info("数据库存储的的路径为"+url);
        photo.transferTo(new File(finalPath));
        Movie movie = new Movie(mName,mType,mLength,mDate,mDirector,mActor,mBoxOffice,mScore,mIntroduction,url,status);
        System.out.println(movie);
        int insert = movieService.insert(movie);
        if (insert>=1){
            RedisUtil.deleteCaChe(keys,redisTemplate);
        }
        return (insert >= 1 ? "添加成功" : "添加失败");
    }


    @GetMapping("/user/movie_index/{id}")
    public String toMovie(@PathVariable("id") Integer id,Model model){
        model.addAttribute("id",id);
        return "user/movie_index";
    }

    @PostMapping("/user/getMovieById/{id}")
    @ResponseBody
    @Cacheable(value = "movie_",keyGenerator = "movieKeyGenerator")
    public Result getMovieById(@PathVariable("id") Integer id){
        Movie movie = movieService.getMovieByById(id);
        Result result = ToResult.getResult(movie);
        return result;
    }

    @RequestMapping(value = "/movie/deleteMovie/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMovie(@PathVariable("ids") String ids) {
        int delete = movieService.deleteMovie(ids);
        if (delete>=1) {
            RedisUtil.deleteCaChe(keys,redisTemplate);
        }
        return (delete >= 1 ? "删除成功" : "删除失败");
    }
}
