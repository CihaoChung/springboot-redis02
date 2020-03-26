package xyz.wadewhy.springboot_redis02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.wadewhy.springboot_redis02.base.controller.BaseController;
import xyz.wadewhy.springboot_redis02.base.utils.RedisConstants;
import xyz.wadewhy.springboot_redis02.base.utils.RedisUtil;
import xyz.wadewhy.springboot_redis02.base.utils.SerializeUtil;
import xyz.wadewhy.springboot_redis02.base.utils.StateParameter;
import xyz.wadewhy.springboot_redis02.entity.User;

/**
 * @Author 钟子豪
 * @Date 2020/3/26
 * @description
 No such property: code for class: Script1
 * @Return
 */
@Controller
@RequestMapping(value="/redis")
public class RedisController extends BaseController {
    @Autowired
    RedisUtil redisUtil;

    /**
     * @auther: zhangyingqi
     * @date: 16:23 2018/8/29
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 执行redis写/读/生命周期
     */
    @RequestMapping("getRedis")
    @ResponseBody
    public ModelMap getRedis(){
        redisUtil.set("20200202","这是一条测试数据", RedisConstants.datebase1);
        Long resExpire = redisUtil.expire("20200202", 60, RedisConstants.datebase1);//设置key过期时间
        logger.info("resExpire="+resExpire);
        String res = redisUtil.get("20200202", RedisConstants.datebase1);
        //测试Redis保存对象
        User u = new User();
        u.setAge(24);
        u.setName("冯绍峰");
        redisUtil.set("20200212".getBytes(), SerializeUtil.serialize(u),RedisConstants.datebase1);
        byte[] user = redisUtil.get("20200212".getBytes(),RedisConstants.datebase1);
        User us = (User) SerializeUtil.unserialize(user);
        System.out.println("user="+us.toString());

        return getModelMap(StateParameter.SUCCESS, res, "执行成功");
    }

}
