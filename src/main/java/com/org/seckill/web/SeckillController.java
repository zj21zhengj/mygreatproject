package com.org.seckill.web;


import com.org.seckill.dto.Exposer;
import com.org.seckill.dto.SeckillExecution;
import com.org.seckill.dto.SeckillResult;
import com.org.seckill.entity.Seckill;
import com.org.seckill.enums.SeckillStatEnum;
import com.org.seckill.exception.RepeatKillException;
import com.org.seckill.exception.SeckillCloseException;
import com.org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seckill") //url/模块/资源/{id}/细分
public class SeckillController {
    private final static Logger logger = LoggerFactory.getLogger(SeckillController.class);

    @Resource
    private SeckillService seckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //获取列表页
        //list.jsp+model = Modelandview
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if(seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if(seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    @RequestMapping(value="/{seckillId}/exposer",method=RequestMethod.POST,
            produces= {"application/json;charset=utf-8"}) //防止中文乱码
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult(true,exposer);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new SeckillResult(false,e.getMessage());
        }
        return result;

    }

    @RequestMapping(value="/{seckillId}/{md5}/execution",method=RequestMethod.POST,
            produces= {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value="killPhone",required=false) Long userPhone) {
        if(userPhone == null) {
            return new SeckillResult(false,"未注册");
        }
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true,seckillExecution);
        } catch (RepeatKillException e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId,SeckillStatEnum.REPEAT_KILL);
            return  new SeckillResult<SeckillExecution>(true,seckillExecution);
        }catch (SeckillCloseException e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId,SeckillStatEnum.END);
            return  new SeckillResult<SeckillExecution>(true,seckillExecution);
        }
        catch (Exception e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId,SeckillStatEnum.INNER_ERROR);
            return  new SeckillResult<SeckillExecution>(true,seckillExecution);
        }

    }

    @RequestMapping(value="/time/now",method=RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        Date now = new Date();
        //System.out.println(new SeckillResult(true,now.getTime()));
        return new SeckillResult(true,now.getTime());
    }


}