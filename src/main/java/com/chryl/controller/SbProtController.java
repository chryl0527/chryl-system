package com.chryl.controller;

import com.chryl.controller.Vo.SbProtVo;
import com.chryl.response.ReturnResult;
import com.chryl.response.error.BaseController;
import com.chryl.response.error.ResponseException;
import com.chryl.service.SbProtService;
import com.chryl.service.model.SbProtModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * Created By Chr on 2019/5/28.
 */
@Api(value = "设备信息", description = "设备的添加/查询/删除/批量删除/批量增加")
@RestController
@RequestMapping("/sb")
public class SbProtController extends BaseController {

    @Autowired
    private SbProtService sbProtService;

    //批量添加sb
    @ApiOperation(value = "批量添加设备", notes = "批量添加设备")
    @RequestMapping("/insert/sbs")
    public ReturnResult insertSbs() {
        int i = sbProtService.insertSbs();
        return ReturnResult.create(i);
//        return ReturnResult.create(HttpStatus.CREATED);
    }

    //根据协议id添加---也可以根据协议type
    @ApiOperation(value = "添加设备", notes = "添加单独的设备")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "sbId", value = "设备id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbName", value = "设备名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbType", value = "设备类型", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbDescription", value = "设备描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbProtocolId", value = "设备协议id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/add/{sbId}/{userId}/{sbName}/{sbType}/{sbDescription}/{sbProtocolId}"/*, method = RequestMethod.POST*/)
    public ReturnResult add(@PathVariable("sbId") String sbId,//
                            @PathVariable("userId") String userId,//
                            @PathVariable("sbName") String sbName,//
                            @PathVariable("sbType") String sbType,//
                            @PathVariable("sbDescription") String sbDescription,//
                            @PathVariable("sbProtocolId") Integer sbProtocolId) throws ResponseException {

        SbProtModel sbProtModel = new SbProtModel();
        sbProtModel.setSbId(sbId);
        sbProtModel.setUserId(userId);
        sbProtModel.setSbName(sbName);
        sbProtModel.setSbType(sbType);
        sbProtModel.setSbDescription(sbDescription);
        sbProtModel.setProtocolId(sbProtocolId);//prot:固定的
        sbProtModel.setSbProtocolId(sbProtocolId);//sb:应该检验设备的协议类

        sbProtService.insetSb(sbProtModel);

//        return ReturnResult.create(HttpStatus.CREATED);
        return ReturnResult.create(null);
    }

    //查询设备
    @ApiOperation(value = "查询设备", notes = "1.2.3")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "startIndex", value = "起始值下标", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "skip", value = "显示几个数据", required = false, dataType = "Integer")
    })
    @GetMapping(value = {"/queryAll/{startIndex}/{skip}", "/queryAll/{startIndex}", "/queryAll"}/*,method = RequestMethod.GET*/)
    public Callable<ReturnResult> queryAll(@PathVariable(value = "startIndex", required = false) Integer startIndex,
                                           @PathVariable(value = "skip", required = false) Integer skip) {

        return () -> {
            List<SbProtModel> sbProtModels = sbProtService.queryAll(startIndex, skip);
            List<SbProtVo> sbProtVos = sbProtModels.stream().map(sbProtModel -> {
                SbProtVo sbProtVo = convertSbProtVoFromSbProtModel(sbProtModel);
                return sbProtVo;
            }).collect(Collectors.toList());

            return ReturnResult.create(sbProtVos);
        };
    }

    //删除单个设备
    @ApiOperation(value = "删除设备", notes = "指定设备id删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "sbId", value = "设备id", required = true, dataType = "String"),
    })
    @RequestMapping(value = {"/deleteOneSb/{sbId}"})
    public Callable<ReturnResult> deleteOneSb(@PathVariable(value = "sbId", required = true) String sbId) throws ResponseException {
        sbProtService.deleteOneSb(sbId);

        return () -> ReturnResult.create(null);
    }

    //批量删除设备
    @ApiOperation(value = "删除设备", notes = "批量删除设备")
    @RequestMapping(value = {"/deleteSbs"})
    public Callable<ReturnResult> deleteSbs(String[] strSbIdArray) throws ResponseException {
        strSbIdArray = new String[]{"0161000", "053000"};
        sbProtService.deleteSbs(strSbIdArray);
        return () -> ReturnResult.create(null);
    }

    //修改单个设备
    @ApiOperation(value = "更新设备", notes = "指定设备id更新")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "sbId", value = "设备id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbName", value = "设备名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbType", value = "设备类型", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbDescription", value = "设备描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "sbProtocolId", value = "设备协议id", required = true, dataType = "String"),
    })
    @RequestMapping(value = {"/updateOneSb/{sbId}/{sbName}/{sbType}/{sbDescription}/{sbProtocolId}"})
    public ReturnResult updateOneSb(@PathVariable("sbId") String sbId,//
                                    @PathVariable("sbName") String sbName,//
                                    @PathVariable("sbType") String sbType,//
                                    @PathVariable("sbDescription") String sbDescription,//
                                    @PathVariable("sbProtocolId") String sbProtocolId) throws ResponseException {

        sbProtService.updateOneSb(sbId, sbName, sbType, sbDescription, Integer.valueOf(sbProtocolId));
        return ReturnResult.create(null);
    }

    //############################################
    //异步返回
    @RequestMapping("/callAdd/{sbId}/{userId}/{sbName}/{sbType}/{sbDescription}/{sbProtocolId}")
    public Callable<ReturnResult> callAdd(@PathVariable("sbId") String sbId,//
                                          @PathVariable("userId") String userId,//
                                          @PathVariable("sbName") String sbName,//
                                          @PathVariable("sbType") String sbType,//
                                          @PathVariable("sbDescription") String sbDescription,//
                                          @PathVariable("sbProtocolId") Integer sbProtocolId) {

        return () -> {

            SbProtModel sbProtModel = new SbProtModel();
            sbProtModel.setSbId(sbId);
            sbProtModel.setUserId(userId);
            sbProtModel.setSbName(sbName);
            System.out.println();
            sbProtModel.setSbType(sbType);
            sbProtModel.setSbDescription(sbDescription);
            sbProtModel.setProtocolId(sbProtocolId);//prot:固定的
            sbProtModel.setSbProtocolId(sbProtocolId);//sb:应该检验设备的协议类

            sbProtService.insetSb(sbProtModel);
            return ReturnResult.create(null);

        };
    }

    private SbProtVo convertSbProtVoFromSbProtModel(SbProtModel sbProtModel) {

        if (sbProtModel == null) {
            return null;
        }
        SbProtVo sbProtVo = new SbProtVo();
        BeanUtils.copyProperties(sbProtModel, sbProtVo);
        return sbProtVo;
    }
}
