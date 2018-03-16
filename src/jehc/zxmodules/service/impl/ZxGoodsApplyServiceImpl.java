package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.base.BaseZTreeEntity;
import jehc.xtmodules.xtcore.util.ExceptionUtil;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.model.ZxGoodsApplyDetail;
import jehc.zxmodules.model.ZxGoodsTree;
import jehc.zxmodules.model.ZxOffice;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.model.ZxUserAndDepartment;
import jehc.zxmodules.service.ZxGoodsApplyDetailService;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;

import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.zxmodules.service.ZxGoodsApplyService;
import jehc.zxmodules.dao.ZxGoodsApplyDao;
import jehc.zxmodules.dao.ZxOfficeClassifyDao;
import jehc.zxmodules.dao.ZxOfficeDao;
import jehc.zxmodules.model.ZxGoodsApply;

/**
* 办公用品主表 
* 2018-01-08 13:18:13  季建吉
*/
@Service("zxGoodsApplyService")
public class ZxGoodsApplyServiceImpl extends BaseService implements ZxGoodsApplyService{
	@Autowired
	private ZxGoodsApplyDao zxGoodsApplyDao;
	@Autowired
	private ZxGoodsApplyDetailService zxGoodsApplyDetailService;
	@Autowired
	private ZxOfficeClassifyDao zxOfficeClassifyDao;
	@Autowired
	private ZxOfficeDao zxOfficeDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxGoodsApply> getZxGoodsApplyListByCondition(Map<String,Object> condition){
		try{
			return zxGoodsApplyDao.getZxGoodsApplyListByCondition(condition);
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param apply_id 
	* @return
	*/
	public ZxGoodsApply getZxGoodsApplyById(String apply_id){
		try{
			ZxGoodsApply zxGoodsApply = zxGoodsApplyDao.getZxGoodsApplyById(apply_id);
			ZxUserAndDepartment zxUserAndDepartment=zxGoodsApplyDao.getUserAndDepartment(zxGoodsApply.getUser_id());
			zxGoodsApply.setUser_name(zxUserAndDepartment.getUser_name());
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("apply_id", apply_id);
			List<ZxGoodsApplyDetail> zxGoodsApplyDetail = zxGoodsApplyDetailService.getZxGoodsApplyDetailListByCondition(condition);
			zxGoodsApply.setZxGoodsApplyDetail(zxGoodsApplyDetail);
			return zxGoodsApply;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
/*	*//**
	* Read the classification tree
	* @param apply_id 
	* @return
	*/
	public List<ZxGoodsTree> getZxGoodsTree(Map<String,Object> condition){
		try{
			List<ZxGoodsTree> list = new ArrayList<ZxGoodsTree>();
			List<ZxOfficeClassify> ZxOfficeClassifylist=zxOfficeClassifyDao.getZxOfficeClassifyListAll(condition);
			for(int i = 0; i < ZxOfficeClassifylist.size(); i++){
				list.add(getZxGoodTreeForEach(ZxOfficeClassifylist.get(i)));
				if(ZxOfficeClassifylist.get(i).getClassify_leaf().equals("1")){
					List<ZxOffice> ZxOfficelist=zxOfficeDao.getZxOfficeByClassifyId(ZxOfficeClassifylist.get(i).getClassify_id());
					for(int j = 0; j < ZxOfficelist.size(); j++){
						list.add(getZxGoodTreeForEachOfZxOffice(ZxOfficelist.get(j)));
					}
				}
			}
			return list;
		} catch (Exception e) {
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	
	public List<ZxGoodsTree> getZxGoodsTreeClassify(Map<String,Object> condition){
		try{
			List<ZxGoodsTree> list = new ArrayList<ZxGoodsTree>();
			List<ZxOfficeClassify> ZxOfficeClassifylist=zxOfficeClassifyDao.getZxOfficeClassifyListAll(condition);
			for(int i = 0; i < ZxOfficeClassifylist.size(); i++){
				list.add(getZxGoodTreeForEach(ZxOfficeClassifylist.get(i)));
			}
			return list;
		} catch (Exception e) {
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	
	public ZxGoodsTree getZxGoodTreeForEach(ZxOfficeClassify zxOfficeClassify){
		ZxGoodsTree zxGoodsTree=new ZxGoodsTree();
		zxGoodsTree.setId(zxOfficeClassify.getClassify_id());
		zxGoodsTree.setParentId(zxOfficeClassify.getClassify_parentId());
		zxGoodsTree.setName(zxOfficeClassify.getClassify_name());
		zxGoodsTree.setIsoffice("no_office");
		return zxGoodsTree;
	}
	
	public ZxGoodsTree getZxGoodTreeForEachOfZxOffice(ZxOffice zxOffice){
		ZxGoodsTree zxGoodsTree=new ZxGoodsTree();
		zxGoodsTree.setId(zxOffice.getOffice_id());
		zxGoodsTree.setParentId(zxOffice.getClassify_id());
		zxGoodsTree.setName(zxOffice.getName());
		zxGoodsTree.setIsoffice("office");
		zxGoodsTree.setStardard(zxOffice.getStandard());
		return zxGoodsTree;
	}
	/**
	* 添加
	* @param zx_goods_apply 
	* @return
	*/
	public int addZxGoodsApply(ZxGoodsApply zxGoodsApply){
		int i = 0;
		try {
			i = zxGoodsApplyDao.addZxGoodsApply(zxGoodsApply);
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailTempList = zxGoodsApply.getZxGoodsApplyDetail();
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailList = new ArrayList<ZxGoodsApplyDetail>();
			for(int j = 0; j < zxGoodsApplyDetailTempList.size(); j++){
					zxGoodsApplyDetailTempList.get(j).setApply_id(zxGoodsApply.getApply_id());
					zxGoodsApplyDetailTempList.get(j).setId(toUUID());
					zxGoodsApplyDetailTempList.get(j).setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
					zxGoodsApplyDetailList.add(zxGoodsApplyDetailTempList.get(j));
			}
			if(!zxGoodsApplyDetailList.isEmpty()&&zxGoodsApplyDetailList.size()>0){
				zxGoodsApplyDetailService.addBatchZxGoodsApplyDetail(zxGoodsApplyDetailList);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApply(ZxGoodsApply zxGoodsApply){
		int i = 0;
		try {
			i = zxGoodsApplyDao.updateZxGoodsApply(zxGoodsApply);
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailList = zxGoodsApply.getZxGoodsApplyDetail();
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailAddList = new ArrayList<ZxGoodsApplyDetail>();
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailUpdateList = new ArrayList<ZxGoodsApplyDetail>();
			for(int j = 0; j < zxGoodsApplyDetailList.size(); j++){
				if(zxGoodsApply.getZxGoodsApplyDetail_removed_flag().indexOf(","+j+",") == -1){
					zxGoodsApplyDetailList.get(j).setApply_id(zxGoodsApply.getApply_id());
					if(StringUtil.isEmpty(zxGoodsApplyDetailList.get(j).getId())){
						zxGoodsApplyDetailList.get(j).setId(toUUID());
						zxGoodsApplyDetailList.get(j).setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss").toString());
						zxGoodsApplyDetailAddList.add(zxGoodsApplyDetailList.get(j));
					}else{
						zxGoodsApplyDetailUpdateList.add(zxGoodsApplyDetailList.get(j));
					}
				}
			}
			if(!zxGoodsApplyDetailAddList.isEmpty()&&zxGoodsApplyDetailAddList.size()>0){
				zxGoodsApplyDetailService.addBatchZxGoodsApplyDetail(zxGoodsApplyDetailAddList);
			}
			if(!zxGoodsApplyDetailUpdateList.isEmpty()&&zxGoodsApplyDetailUpdateList.size()>0){
				zxGoodsApplyDetailService.updateBatchZxGoodsApplyDetail(zxGoodsApplyDetailUpdateList);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	
	/**
	* Aktualisierung nach Bedingung
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApplyBySelectiveByCondition(ZxGoodsApply zxGoodsApply){
		int i = 0;
		try {
			i = zxGoodsApplyDao.updateZxGoodsApplyBySelective(zxGoodsApply);
		} catch (Exception e) {
			i = 0;
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_goods_apply 
	* @return
	*/
	public int updateZxGoodsApplyBySelective(ZxGoodsApply zxGoodsApply){
		int i = 0;
		try {
			i = zxGoodsApplyDao.updateZxGoodsApplyBySelective(zxGoodsApply);
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailList = zxGoodsApply.getZxGoodsApplyDetail();
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailAddList = new ArrayList<ZxGoodsApplyDetail>();
			List<ZxGoodsApplyDetail> zxGoodsApplyDetailUpdateList = new ArrayList<ZxGoodsApplyDetail>();
			for(int j = 0; j < zxGoodsApplyDetailList.size(); j++){
				if(zxGoodsApply.getZxGoodsApplyDetail_removed_flag().indexOf(","+j+",") == -1){
					zxGoodsApplyDetailList.get(j).setApply_id(zxGoodsApply.getApply_id());
					if(StringUtil.isEmpty(zxGoodsApplyDetailList.get(j).getId())){
						zxGoodsApplyDetailList.get(j).setId(toUUID());
						zxGoodsApplyDetailAddList.add(zxGoodsApplyDetailList.get(j));
					}else{
						zxGoodsApplyDetailUpdateList.add(zxGoodsApplyDetailList.get(j));
					}
				}
			}
			if(!zxGoodsApplyDetailAddList.isEmpty()&&zxGoodsApplyDetailAddList.size()>0){
				zxGoodsApplyDetailService.addBatchZxGoodsApplyDetail(zxGoodsApplyDetailAddList);
			}
			if(!zxGoodsApplyDetailUpdateList.isEmpty()&&zxGoodsApplyDetailUpdateList.size()>0){
				zxGoodsApplyDetailService.updateBatchZxGoodsApplyDetailBySelective(zxGoodsApplyDetailUpdateList);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxGoodsApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxGoodsApplyDao.delZxGoodsApply(condition);
			String[] apply_idList= (String[])condition.get("apply_id");
			for(String apply_id:apply_idList){
				zxGoodsApplyDetailService.delZxGoodsApplyDetailByForeignKey(apply_id);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_goods_applyList 
	* @return
	*/
	public int addBatchZxGoodsApply(List<ZxGoodsApply> zxGoodsApplyList){
		int i = 0;
		try {
			i = zxGoodsApplyDao.addBatchZxGoodsApply(zxGoodsApplyList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_goods_applyList 
	* @return
	*/
	public int updateBatchZxGoodsApply(List<ZxGoodsApply> zxGoodsApplyList){
		int i = 0;
		try {
			i = zxGoodsApplyDao.updateBatchZxGoodsApply(zxGoodsApplyList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_goods_applyList 
	* @return
	*/
	public int updateBatchZxGoodsApplyBySelective(List<ZxGoodsApply> zxGoodsApplyList){
		int i = 0;
		try {
			i = zxGoodsApplyDao.updateBatchZxGoodsApplyBySelective(zxGoodsApplyList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
