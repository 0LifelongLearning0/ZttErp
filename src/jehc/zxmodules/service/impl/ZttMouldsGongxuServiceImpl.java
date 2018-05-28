package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.model.ZttMouldsDeivice;
import jehc.zxmodules.service.ZttMouldsDeiviceService;
import java.util.HashMap;
import java.util.ArrayList;
import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.zxmodules.service.ZttMouldsGongxuService;
import jehc.zxmodules.dao.ZttMouldsGongxuDao;
import jehc.zxmodules.model.ZttMouldsGongxu;

/**
* 模具部工序 
* 2018-05-24 16:46:19  季建吉
*/
@Service("zttMouldsGongxuService")
public class ZttMouldsGongxuServiceImpl extends BaseService implements ZttMouldsGongxuService{
	@Autowired
	private ZttMouldsGongxuDao zttMouldsGongxuDao;
	@Autowired
	private ZttMouldsDeiviceService zttMouldsDeiviceService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttMouldsGongxu> getZttMouldsGongxuListByCondition(Map<String,Object> condition){
		try{
			return zttMouldsGongxuDao.getZttMouldsGongxuListByCondition(condition);
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttMouldsGongxu getZttMouldsGongxuById(String id){
		try{
			ZttMouldsGongxu zttMouldsGongxu = zttMouldsGongxuDao.getZttMouldsGongxuById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("gongxu_id", id);
			List<ZttMouldsDeivice> zttMouldsDeivice = zttMouldsDeiviceService.getZttMouldsDeiviceListByCondition(condition);
			zttMouldsGongxu.setZttMouldsDeivice(zttMouldsDeivice);
			return zttMouldsGongxu;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int addZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu){
		int i = 0;
		try {
			i = zttMouldsGongxuDao.addZttMouldsGongxu(zttMouldsGongxu);
			List<ZttMouldsDeivice> zttMouldsDeiviceTempList = zttMouldsGongxu.getZttMouldsDeivice();
			if(zttMouldsDeiviceTempList!=null){
				List<ZttMouldsDeivice> zttMouldsDeiviceList = new ArrayList<ZttMouldsDeivice>();
				for(int j = 0; j < zttMouldsDeiviceTempList.size(); j++){
					if(zttMouldsGongxu.getZttMouldsDeivice_removed_flag().indexOf(","+j+",") == -1){
						/*zttMouldsDeiviceTempList.get(j).setGongxu_id(zttMouldsGongxu.getGongxu_id());*/
						zttMouldsDeiviceTempList.get(j).setId(toUUID());
						zttMouldsDeiviceTempList.get(j).setGongxu_id(zttMouldsGongxu.getId());
						zttMouldsDeiviceList.add(zttMouldsDeiviceTempList.get(j));
					}
				}
				if(!zttMouldsDeiviceList.isEmpty()&&zttMouldsDeiviceList.size()>0){
					zttMouldsDeiviceService.addBatchZttMouldsDeivice(zttMouldsDeiviceList);
				}
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
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int updateZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu){
		int i = 0;
		try {
			i = zttMouldsGongxuDao.updateZttMouldsGongxu(zttMouldsGongxu);
			List<ZttMouldsDeivice> zttMouldsDeiviceList = zttMouldsGongxu.getZttMouldsDeivice();
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("gongxu_id", zttMouldsGongxu.getId());
			List<ZttMouldsDeivice> zttMouldsDeivice = zttMouldsDeiviceService.getZttMouldsDeiviceListByCondition(condition);
			List<ZttMouldsDeivice> zttMouldsDeiviceAddList = new ArrayList<ZttMouldsDeivice>();
			List<ZttMouldsDeivice> zttMouldsDeiviceUpdateList = new ArrayList<ZttMouldsDeivice>();
			String[] idarray=zttMouldsGongxu.getZttMouldsDeivice_removed_flag().split(",");
			for(int k=0;k<idarray.length;k++){
				if(idarray[k]!=null){
					Map<String, Object> condition1 = new HashMap<String, Object>();
					String[] id=new String[1];
					id[0]=idarray[k];
					condition1.put("id", id);
					zttMouldsDeiviceService.delZttMouldsDeivice(condition1);
				}
			}
			for(int j = 0; j < zttMouldsDeiviceList.size(); j++){
					/*zttMouldsDeiviceList.get(j).setGongxu_id(zttMouldsGongxu.getGongxu_id());*/
					if(StringUtil.isEmpty(zttMouldsDeiviceList.get(j).getId())){
						zttMouldsDeiviceList.get(j).setId(toUUID());
						zttMouldsDeiviceList.get(j).setGongxu_id(zttMouldsGongxu.getId());
						zttMouldsDeiviceAddList.add(zttMouldsDeiviceList.get(j));
					}else{
						zttMouldsDeiviceUpdateList.add(zttMouldsDeiviceList.get(j));
					}
			}
			if(!zttMouldsDeiviceAddList.isEmpty()&&zttMouldsDeiviceAddList.size()>0){
				zttMouldsDeiviceService.addBatchZttMouldsDeivice(zttMouldsDeiviceAddList);
			}
			if(!zttMouldsDeiviceUpdateList.isEmpty()&&zttMouldsDeiviceUpdateList.size()>0){
				zttMouldsDeiviceService.updateBatchZttMouldsDeivice(zttMouldsDeiviceUpdateList);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int updateZttMouldsGongxuBySelective(ZttMouldsGongxu zttMouldsGongxu){
		int i = 0;
		try {
			i = zttMouldsGongxuDao.updateZttMouldsGongxuBySelective(zttMouldsGongxu);
			List<ZttMouldsDeivice> zttMouldsDeiviceList = zttMouldsGongxu.getZttMouldsDeivice();
			List<ZttMouldsDeivice> zttMouldsDeiviceAddList = new ArrayList<ZttMouldsDeivice>();
			List<ZttMouldsDeivice> zttMouldsDeiviceUpdateList = new ArrayList<ZttMouldsDeivice>();
			for(int j = 0; j < zttMouldsDeiviceList.size(); j++){
				if(zttMouldsGongxu.getZttMouldsDeivice_removed_flag().indexOf(","+j+",") == -1){
					/*zttMouldsDeiviceList.get(j).setGongxu_id(zttMouldsGongxu.getGongxu_id());*/
					if(StringUtil.isEmpty(zttMouldsDeiviceList.get(j).getId())){
						zttMouldsDeiviceList.get(j).setId(toUUID());
						zttMouldsDeiviceAddList.add(zttMouldsDeiviceList.get(j));
					}else{
						zttMouldsDeiviceUpdateList.add(zttMouldsDeiviceList.get(j));
					}
				}
			}
			if(!zttMouldsDeiviceAddList.isEmpty()&&zttMouldsDeiviceAddList.size()>0){
				zttMouldsDeiviceService.addBatchZttMouldsDeivice(zttMouldsDeiviceAddList);
			}
			if(!zttMouldsDeiviceUpdateList.isEmpty()&&zttMouldsDeiviceUpdateList.size()>0){
				zttMouldsDeiviceService.updateBatchZttMouldsDeiviceBySelective(zttMouldsDeiviceUpdateList);
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
	public int delZttMouldsGongxu(Map<String,Object> condition){
		int i = 0;
		try {
			
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zttMouldsDeiviceService.delZttMouldsDeiviceByForeignKey(id);
			}
			i = zttMouldsGongxuDao.delZttMouldsGongxu(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int addBatchZttMouldsGongxu(List<ZttMouldsGongxu> zttMouldsGongxuList){
		int i = 0;
		try {
			i = zttMouldsGongxuDao.addBatchZttMouldsGongxu(zttMouldsGongxuList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int updateBatchZttMouldsGongxu(List<ZttMouldsGongxu> zttMouldsGongxuList){
		int i = 0;
		try {
			i = zttMouldsGongxuDao.updateBatchZttMouldsGongxu(zttMouldsGongxuList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int updateBatchZttMouldsGongxuBySelective(List<ZttMouldsGongxu> zttMouldsGongxuList){
		int i = 0;
		try {
			i = zttMouldsGongxuDao.updateBatchZttMouldsGongxuBySelective(zttMouldsGongxuList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
