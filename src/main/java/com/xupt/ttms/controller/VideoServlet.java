package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.pojo.Video;
import com.xupt.ttms.service.VideoService;
import com.xupt.ttms.util.FileUtils;
import com.xupt.ttms.util.ToResult;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoServlet {
    @Autowired
    private VideoService videoService;
    @Autowired
    private Video video;

    @GetMapping("/movie/upload/{m_id}")
    public String toupload(Model model, @PathVariable("m_id") Integer m_id) {
        model.addAttribute("m_id", m_id);
        return "manager/page/movie/upload";
    }

    @RequestMapping("/videoUpload")
    @ResponseBody
    public Integer fileupload(@RequestParam("file") MultipartFile photo, @RequestParam("m_id") Integer m_id, HttpSession session) throws IOException {
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = "D:\\idea-project\\ttms\\target\\classes\\static\\main\\video\\video";
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        String url = "../../main/video/video/" + fileName;
        File file1 = new File(finalPath);
        //实现上传功能
        photo.transferTo(file1);
        this.video.setmId(m_id);
        this.video.setvSrc(url);
        this.video.setLen(FileUtils.ReadVideoTime(file1));
        System.out.println(this.video);
        this.videoService.insertVideo(this.video);
        return this.video.getId();
    }

    @RequestMapping("/imgUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile photo, @RequestParam("id") Integer id, @RequestParam("m_id") Integer m_id, HttpSession session) throws IOException {
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = "D:\\idea-project\\ttms\\target\\classes\\static\\main\\video\\img";
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        String url = "../../main/video/img/" + fileName;
        this.video.setmId(m_id);
        this.video.setId(id);
        this.video.setmSrc(url);
        this.videoService.updateVideo(this.video);
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "上传成功";
    }

    @PostMapping("/video/updateDesc")
    @ResponseBody
    public String updateDesc(@RequestParam("desc") String desc, @RequestParam("id") Integer id) {
        return this.videoService.updateVideoDesc(id, desc) >= 1 ? "修改成功" : "修改失败";
    }

    @PostMapping("/video/getVideoByMId/{mId}")
    @ResponseBody
    @Cacheable(value = "getVideoByMId",keyGenerator = "videoKeyGenerator")
    public Result getVideoByMId(@PathVariable("mId") Integer mId, @RequestParam(value = "id", required = false) Integer id) {
        List<Video> videos = this.videoService.getVideoByMId(mId, id);
        if (id != null) {
            List<Video> list = this.videoService.moveVideos(videos, id);
            return ToResult.getResult(list);
        }
        return ToResult.getResult(videos);
    }

    @GetMapping("/video/toVideo/{id}")
    public String toVideo(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "user/movie_video";
    }

    @PostMapping("/video/getVideoById/{id}")
    @ResponseBody
    @Cacheable(value = "video_",keyGenerator = "videoKeyGenerator")
    public Result getVideoById(@PathVariable("id") Integer id) {
        List<Video> videos = this.videoService.getVideoById(id);
        return ToResult.getResult(videos);
    }
}
