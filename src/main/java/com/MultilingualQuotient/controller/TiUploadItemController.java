package com.MultilingualQuotient.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MultilingualQuotient.dto.MultilingualQuotientResult;
import com.MultilingualQuotient.enmus.MultilingualQuotientEnum;
import com.MultilingualQuotient.service.TiUploadItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 藏文数据接口层
 * 
 * @author 念阿郎
 *
 */
@Controller
@RequestMapping("/tiUploadItem")
@Api(value = "藏文数据控制层", tags = "藏文数据提供")
public class TiUploadItemController {
	@Resource
	private TiUploadItemService tiUploadItemService;

	// 查询所有商品的种类
	@RequestMapping(value = "/getAllKind", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文商品的种类", httpMethod = "GET", notes = "查询所有藏文商品的种类")
	public MultilingualQuotientResult<List<String>> getAllKind() {
		try {
			// 查询数据
			List<String> lists = tiUploadItemService.quaryTiItemKindName();
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有种类的分类
	@RequestMapping(value = "/getAllDetial/{upload_item_kind_name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文种类的分类", httpMethod = "GET", notes = "查询所有藏文种类的分类")
	public MultilingualQuotientResult<List<String>> getAllDetial(
			@ApiParam(name = "upload_item_kind_name", value = "种类名称", required = true) @PathVariable("upload_item_kind_name") String upload_item_kind_name) {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemKindDetailName(upload_item_kind_name);
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的产地省级
	@RequestMapping(value = "/getAllOriginName", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文产地省级", httpMethod = "GET", notes = "查询所有的藏文产地省级")
	public MultilingualQuotientResult<List<String>> getAllOriginName() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemOriginName();
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的产地市级
	@RequestMapping(value = "/getAllOriginCity/{upload_item_origin_name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文产地市级", httpMethod = "GET", notes = "查询所有的藏文产地市级")
	public MultilingualQuotientResult<List<String>> getAllOriginCity(
			@ApiParam(name = "upload_item_origin_name", value = "省级名称", required = true) @PathVariable("upload_item_origin_name") String upload_item_origin_name) {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemOriginCityName(upload_item_origin_name);
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的产地县级
	@RequestMapping(value = "/getAllOriginCounty/{upload_item_origin_county_name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文产地县级", httpMethod = "GET", notes = "查询藏文所有的产地县级")
	public MultilingualQuotientResult<List<String>> getAllOriginCounty(
			@ApiParam(name = "upload_item_origin_county_name", value = "市级名称", required = true) @PathVariable("upload_item_origin_county_name") String upload_item_origin_county_name) {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemOriginCountyName(upload_item_origin_county_name);
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的单位名称
	@RequestMapping(value = "/getAllUnit", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文单位名称", httpMethod = "GET", notes = "查询藏文所有的单位名称")
	public MultilingualQuotientResult<List<String>> getAllUnit() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemTTMUnit("0");
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有供货量的单位
	@RequestMapping(value = "/getAllSupply", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文供货量的单位", httpMethod = "GET", notes = "查询藏文所有供货量的单位")
	public MultilingualQuotientResult<List<String>> getAllSupply() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemTTMUnit("1");
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有形状
	@RequestMapping(value = "/getAllForm", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文所有形状", httpMethod = "GET", notes = "查询藏文所有形状")
	public MultilingualQuotientResult<List<String>> getAllForm() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemCharacterParameter("form");
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的颜色
	@RequestMapping(value = "/getAllColor", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文所有的颜色", httpMethod = "GET", notes = "查询藏文所有的颜色")
	public MultilingualQuotientResult<List<String>> getAllColor() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemCharacterParameter("color");
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的保存方式
	@RequestMapping(value = "/getAllMethod", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文保存方式", httpMethod = "GET", notes = "查询藏文所有的保存方式")
	public MultilingualQuotientResult<List<String>> getAllMethod() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemSaveMethod();
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有厂家地址表
	@RequestMapping(value = "/getAllAddressName", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文厂家地址", httpMethod = "GET", notes = "查询藏文所有厂家地址表")
	public MultilingualQuotientResult<List<String>> getAllAddressName() {
		try {
			List<String> lists = tiUploadItemService.quaryTiItemFactoryAddressName();
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的市级信息
	@RequestMapping(value = "/getAllAddressCity/{upload_item_factory_address_name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文市级信息", httpMethod = "GET", notes = "查询藏文所有的市级信息")
	public MultilingualQuotientResult<List<String>> getAllAddressCity(
			@ApiParam(name = "upload_item_factory_address_name", value = "省级名称", required = true) @PathVariable("upload_item_factory_address_name") String upload_item_factory_address_name) {
		try {
			List<String> lists = tiUploadItemService
					.quaryTiItemFactoryAddressCityName(upload_item_factory_address_name);
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}

	// 查询所有的县级信息
	@RequestMapping(value = "/getAllAddressCounty/{upload_item_factory_address_city_name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询藏文县级信息", httpMethod = "GET", notes = "查询藏文所有的县级信息")
	public MultilingualQuotientResult<List<String>> getAllAddressCounty(
			@ApiParam(name = "upload_item_factory_address_city_name", value = "市级名称", required = true) @PathVariable("upload_item_factory_address_city_name") String upload_item_factory_address_city_name) {
		try {
			List<String> lists = tiUploadItemService
					.quaryTiItemFactoryAddressCountyName(upload_item_factory_address_city_name);
			return new MultilingualQuotientResult<List<String>>(true, lists);
		} catch (Exception e) {
			e.printStackTrace();
			// 内部错误
			return new MultilingualQuotientResult<List<String>>(false,
					MultilingualQuotientEnum.INNER_ERROR.getStateInfo());
		}
	}
}
