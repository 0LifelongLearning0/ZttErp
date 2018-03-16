package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.model.ZxProjectWoking;
import jehc.zxmodules.service.ZxProjectWokingService;
import java.util.HashMap;
import java.util.ArrayList;
import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.zxmodules.service.ZxProjectNodeService;
import jehc.zxmodules.dao.ZxProjectNodeDao;
import jehc.zxmodules.model.ZxProjectNode;

/**
* 项目节点控制表 
* 2017-09-07 23:52:08  陈运芝
*/
@Service("zxProjectNodeService")
public class ZxProjectNodeServiceImpl extends BaseService implements ZxProjectNodeService{
	@Autowired
	private ZxProjectNodeDao zxProjectNodeDao;
	@Autowired
	private ZxProjectWokingService zxProjectWokingService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProjectNode> getZxProjectNodeListByCondition(Map<String,Object> condition){
		try{
			return zxProjectNodeDao.getZxProjectNodeListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProjectNode getZxProjectNodeById(String id){
		try{
			ZxProjectNode zxProjectNode = zxProjectNodeDao.getZxProjectNodeById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("node_id", id);
			List<ZxProjectWoking> zxProjectWoking = zxProjectWokingService.getZxProjectWokingListByCondition(condition);
			zxProjectNode.setZxProjectWoking(zxProjectWoking);
			return zxProjectNode;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_project_node 
	* @return
	*/
	public int addZxProjectNode(ZxProjectNode zxProjectNode){
		int i = 0;
		try {
			i = zxProjectNodeDao.addZxProjectNode(zxProjectNode);
			List<ZxProjectWoking> zxProjectWokingTempList = zxProjectNode.getZxProjectWoking();
			List<ZxProjectWoking> zxProjectWokingList = new ArrayList<ZxProjectWoking>();
			for(int j = 0; j < zxProjectWokingTempList.size(); j++){
				if(zxProjectNode.getZxProjectWoking_removed_flag().indexOf(","+j+",") == -1){
					zxProjectWokingTempList.get(j).setNode_id(zxProjectNode.getId());
					zxProjectWokingTempList.get(j).setId(toUUID());
					zxProjectWokingList.add(zxProjectWokingTempList.get(j));
				}
			}
			if(!zxProjectWokingList.isEmpty()&&zxProjectWokingList.size()>0){
				zxProjectWokingService.addBatchZxProjectWoking(zxProjectWokingList);
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_project_node 
	* @return
	*/
	public int updateZxProjectNode(ZxProjectNode zxProjectNode){
		int i = 0;
		try {
			i = zxProjectNodeDao.updateZxProjectNodeBySelective(zxProjectNode);
			List<ZxProjectWoking> zxProjectWokingList = zxProjectNode.getZxProjectWoking();
			List<ZxProjectWoking> zxProjectWokingAddList = new ArrayList<ZxProjectWoking>();
			List<ZxProjectWoking> zxProjectWokingUpdateList = new ArrayList<ZxProjectWoking>();
			if(null != zxProjectWokingList && zxProjectWokingList.size() > 0){
				for(int j = 0; j < zxProjectWokingList.size(); j++){
					if(zxProjectNode.getZxProjectWoking_removed_flag().indexOf(","+j+",") == -1){
						zxProjectWokingList.get(j).setNode_id(zxProjectNode.getId());
						if(StringUtil.isEmpty(zxProjectWokingList.get(j).getId())){
							zxProjectWokingList.get(j).setId(toUUID());
							zxProjectWokingAddList.add(zxProjectWokingList.get(j));
						}else{
							zxProjectWokingUpdateList.add(zxProjectWokingList.get(j));
						}
					}
				}
				if(!zxProjectWokingAddList.isEmpty()&&zxProjectWokingAddList.size()>0){
					zxProjectWokingService.addBatchZxProjectWoking(zxProjectWokingAddList);
				}
				if(!zxProjectWokingUpdateList.isEmpty()&&zxProjectWokingUpdateList.size()>0){
					zxProjectWokingService.updateBatchZxProjectWokingBySelective(zxProjectWokingUpdateList);
				}
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_project_node 
	* @return
	*/
	public int updateZxProjectNodeBySelective(ZxProjectNode zxProjectNode){
		int i = 0;
		try {
			i = zxProjectNodeDao.updateZxProjectNodeBySelective(zxProjectNode);
			List<ZxProjectWoking> zxProjectWokingList = zxProjectNode.getZxProjectWoking();
			List<ZxProjectWoking> zxProjectWokingAddList = new ArrayList<ZxProjectWoking>();
			List<ZxProjectWoking> zxProjectWokingUpdateList = new ArrayList<ZxProjectWoking>();
			for(int j = 0; j < zxProjectWokingList.size(); j++){
				if(zxProjectNode.getZxProjectWoking_removed_flag().indexOf(","+j+",") == -1){
					zxProjectWokingList.get(j).setNode_id(zxProjectNode.getId());
					if(StringUtil.isEmpty(zxProjectWokingList.get(j).getId())){
						zxProjectWokingList.get(j).setId(toUUID());
						zxProjectWokingAddList.add(zxProjectWokingList.get(j));
					}else{
						zxProjectWokingUpdateList.add(zxProjectWokingList.get(j));
					}
				}
			}
			if(!zxProjectWokingAddList.isEmpty()&&zxProjectWokingAddList.size()>0){
				zxProjectWokingService.addBatchZxProjectWoking(zxProjectWokingAddList);
			}
			if(!zxProjectWokingUpdateList.isEmpty()&&zxProjectWokingUpdateList.size()>0){
				zxProjectWokingService.updateBatchZxProjectWokingBySelective(zxProjectWokingUpdateList);
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProjectNode(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxProjectNodeDao.delZxProjectNode(condition);
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zxProjectWokingService.delZxProjectWokingByForeignKey(id);
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_project_nodeList 
	* @return
	*/
	public int addBatchZxProjectNode(List<ZxProjectNode> zxProjectNodeList){
		int i = 0;
		try {
			i = zxProjectNodeDao.addBatchZxProjectNode(zxProjectNodeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_project_nodeList 
	* @return
	*/
	public int updateBatchZxProjectNode(List<ZxProjectNode> zxProjectNodeList){
		int i = 0;
		try {
			i = zxProjectNodeDao.updateBatchZxProjectNode(zxProjectNodeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_project_nodeList 
	* @return
	*/
	public int updateBatchZxProjectNodeBySelective(List<ZxProjectNode> zxProjectNodeList){
		int i = 0;
		try {
			i = zxProjectNodeDao.updateBatchZxProjectNodeBySelective(zxProjectNodeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
