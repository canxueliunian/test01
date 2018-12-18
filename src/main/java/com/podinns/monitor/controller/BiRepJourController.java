package com.podinns.monitor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.podinns.monitor.common.util.DealDataUtil;
import com.podinns.monitor.common.util.ExeclUtil;
import com.podinns.monitor.entity.BiHotelDetail;
import com.podinns.monitor.entity.BiRepJie;
import com.podinns.monitor.entity.BiRepJour;
import com.podinns.monitor.service.BiHotelDetailService;
import com.podinns.monitor.service.BiRepJieService;
import com.podinns.monitor.service.BiRepJourService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.podinns.monitor.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author canxue
 * @since 2018-11-27
 */
@Controller
@RequestMapping("/biRepJour")
public class BiRepJourController extends BaseController {
      @Resource
      BiRepJourService biRepJourService;
      @Resource
      BiHotelDetailService biHotelDetailService;


      @RequestMapping("getPage")
      public String getList(Model model, BiRepJour biRepJour, BiHotelDetail biHotelDetail, int _index) {
            try {

                  // 初始化结果数据
                  IPage<BiRepJour> result = new Page<BiRepJour>();
                  // 构建基础查询
                  QueryWrapper<BiRepJour> queryWrapper = new QueryWrapper<>();
                  List<String> ids = new ArrayList<>();
                  Page<BiRepJour> page = getPage();
                  Boolean flag = true;
                  // 处理queryWrapper
                  buildQueryWrapper(queryWrapper, biRepJour, biHotelDetail, flag);
                  if (flag) {

                        result = biRepJourService.page(page, queryWrapper);
                  } else {
                        // 代表经过查询无可用数据,不进行下面的查询
                  }
                  // 新增入两个字段
                  buildAddFiled(result.getRecords());
                  buildPageResult(model, result, page.getSize());
                  return "/jour_detail";
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return "/jour_detail";
      }

      /**
       *
       *
       * @param records
       */
      private void buildAddFiled(List<BiRepJour> records) {
            Map<Long, Map<String, Object>> sourceMap = biHotelDetailService.queryIdCodeName();
            for (BiRepJour biRepJie :
                    records) {
                  Long hotelId = biRepJie.getHotelId();
                  Map<String, Object> map = sourceMap.get(hotelId);
                  Object ncHotelcode = map.get("hotel_code");
                  Object hotelDescript = map.get("hotel_descript");
                  biRepJie.setNcHotelcode(String.valueOf(ncHotelcode));
                  biRepJie.setHotelDescript(String.valueOf(hotelDescript));
            }

      }


      @RequestMapping("getExcel")
      @ResponseBody
      public String execute(HttpServletResponse response, BiRepJour biRepJie, BiHotelDetail biHotelDetail) {
            // 初始化结果数据
            QueryWrapper<BiRepJour> queryWrapper = new QueryWrapper<>();
            List<BiRepJour> result = new ArrayList<>();
            Boolean flag = true;
            IPage iPage = new Page(0, 25);
            try {
                  // 处理queryWrapper
                  buildQueryWrapper(queryWrapper, biRepJie, biHotelDetail, flag);
                  if (flag) {
                        IPage page = biRepJourService.page(iPage, queryWrapper);
                        result = page.getRecords();
                        buildAddFiled(result);
                  } else {

                  }
                  ExeclUtil.ListToHttp(result, "表格", "导出表格", response);
            } catch (FileNotFoundException e) {
                  e.printStackTrace();
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return "导出成功";
      }


      public void buildQueryWrapper(QueryWrapper repWrapper, BiRepJour biRepJie, BiHotelDetail biHotelDetail, boolean flag) {
            DealDataUtil.DealData(repWrapper, biRepJie);
            // 初始化查询条件
            QueryWrapper<BiHotelDetail> hotelWrapper = new QueryWrapper<>();
            DealDataUtil.DealData(hotelWrapper, biHotelDetail);
            List<String> strings = biHotelDetailService.queryIds(hotelWrapper);
            int size = strings.size();
            // 根据条件查找出零条结果
            if (size == 0) {
                  flag = false;
            }
//        根据条件查询结果相对可靠
            else if (size <= 100 && size > 0) {
                  repWrapper.in("hotel_id", strings);
            } else {
                  // 使用默认条件查询出700多条不进行修改wrapper
            }


      }
}
