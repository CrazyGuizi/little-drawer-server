package com.lidegui.littledrawer.web;

import com.github.pagehelper.PageHelper;
import com.lidegui.littledrawer.bean.Video;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.VideoService;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.Util;
import com.lidegui.littledrawer.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: lidegui
 * @Date:Created in 10:09 2019/4/15
 */

@RestController
@RequestMapping(Constant.API_VIDEO)
public class VideoController {

    @Autowired
    private VideoService mVideoService;

    @RequestMapping(value = Constant.API_VIDEO_ADD_VIDEO, method = RequestMethod.POST)
    public BaseResponse addVideo(@RequestBody Video video) {
        if (video != null) {
            // 保证类别索引和名字一一对应
            VideoType type;
            if (video.getTypeIndex() > 0) {
                type = Util.getVideoType(video.getTypeIndex());
            } else if (!Util.isEmpty(video.getTypeName())) {
                type = Util.getVideoType(video.getTypeName());
            } else {
                return BaseResponse.generateFail("参数错误，视频发布失败");
            }

            if (type != null) {
                video.setTypeName(type.typeName);
                video.setTypeIndex(type.typeIndex);
            } else {
                return BaseResponse.generateFail("视频发布失败，目前平台没有设置该类视频");
            }
            // 让主键自增长
            video.setId(0);
            video.setDate(Util.getDateNow());
            Video addVideo = mVideoService.addVideo(video);

            if (addVideo != null) {
                return BaseResponse.generateSuccess("视频发布成功", addVideo);
            }

        }

        return BaseResponse.generateFail("视频发布失败");
    }

    @RequestMapping(value = Constant.API_VIDEO_DELETE_VIDEO, method = RequestMethod.POST)
    public BaseResponse deleteVideo(@RequestBody Map<String, String> map) {
        String id = map.get("videoId");
        if (!Util.isEmpty(id)) {
            if (mVideoService.deleteVideo(Integer.parseInt(id)) > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }

    @RequestMapping(value = Constant.API_VIDEO_GET_VIDEO_BY_ID, method = RequestMethod.POST)
    public BaseResponse getVideoById(@RequestBody Map<String, String> map) {
        String id = map.get("videoId");
        if (!Util.isEmpty(id)) {
            Video video = mVideoService.getVideoById(Integer.parseInt(id));
            if (video != null) {
                return BaseResponse.generateSuccess("视频获取成功", video);
            }
        }

        return BaseResponse.generateFail("视频获取失败");
    }

    /**
     * 获取用户的视频
     * @param map
     * @return
     */
    @RequestMapping(value = Constant.API_VIDEO_GET_VIDEOS_BY_USER_ID, method = RequestMethod.POST)
    public BaseResponse getVideosByUserId(@RequestBody Map<String, String> map) {
        String id = map.get("userId");
        if (!Util.isEmpty(id)) {
            List<Video> videos = mVideoService.getVideosByUserId(Integer.parseInt(id));
            if (videos != null && videos.size() > 0) {
                return BaseResponse.generateSuccess("视频获取成功", videos);
            } else {
                return BaseResponse.generateFail("你还没有发布过视频哟~");
            }
        }

        return BaseResponse.generateFail("视频获取失败");
    }


    /**
     * 分类查找视频并实现分页
     *
     * @param map
     * @return
     */
    @RequestMapping(value = Constant.API_VIDEO_GET_VIDEOS_BY_TYPE, method = RequestMethod.POST)
    public BaseResponse getVideosByType(@RequestBody Map<String, String> map) {
        String typeIndex = map.get("typeIndex");
        String typeName = map.get("typeName");
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");
        List<Video> videos = null;

        // 按类别索引查找
        if (!Util.isEmpty(typeIndex)) {
            if (!Util.isEmpty(pageNum) && !Util.isEmpty(pageSize)) {
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            }
            videos = mVideoService.getVideosByTypeIndex(Integer.parseInt(typeIndex));

            // 按类别名查找
        } else if (!Util.isEmpty(typeName)) {
            if (!Util.isEmpty(pageNum) && !Util.isEmpty(pageSize)) {
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            }
            videos = mVideoService.getVideosByTypeName(typeName);
        } else {
            return BaseResponse.generateFail("视频获取失败");
        }

        if (videos != null && videos.size() > 0) {
            return BaseResponse.generateSuccess("视频获取成功", videos);
        } else {
            return BaseResponse.generateFail("暂无该类视频o(╯□╰)o");
        }

    }

    @RequestMapping(value = Constant.API_VIDEO_GET_VIDEOS_RANDOM, method = RequestMethod.POST)
    public BaseResponse getVideosRandom(@RequestBody Map<String, String> map) {
        String typeIndex = map.get("typeIndex");
        String typeName = map.get("typeName");
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");
        List<Video> videos = null;

//        // 有分页则分页
//        if (!Util.isEmpty(pageNum) && !Util.isEmpty(pageSize)) {
//            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
//        }

        // 按类别索引查找
        if (!Util.isEmpty(typeIndex)) {
            videos = mVideoService.getVideosByTypeIndex(Integer.parseInt(typeIndex));
            // 按类别名查找
        } else if (!Util.isEmpty(typeName)) {
            videos = mVideoService.getVideosByTypeName(typeName);
        } else {
            // 不明确找哪类则找全部视频
            videos = mVideoService.getAllVideos();
        }

        List<Video> random = videos;
        if (random != null && random.size() > 0) {
            Collections.shuffle(random);
            if (!Util.isEmpty(pageSize)) {
                int end = Integer.parseInt(pageSize);
                if (end > random.size()) {
                    end = random.size();
                }
                return BaseResponse.generateSuccess("视频获取成功", random.subList(0, end));
            }
            return BaseResponse.generateSuccess("视频获取成功", random);
        } else {
            return BaseResponse.generateFail("暂无该类视频o(╯□╰)o");
        }

    }


}
