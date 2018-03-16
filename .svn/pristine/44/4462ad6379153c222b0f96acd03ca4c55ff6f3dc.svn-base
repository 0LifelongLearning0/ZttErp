package jehc.lcmodules.activitiutil.util;

import java.util.Map;

import jehc.xtmodules.xtcore.util.springutil.SpringUtil;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtUserinfoService;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.lang.StringUtils;

/**
 * 预设置节点处理人
 * @author 邓纯杰
 */
public class AssigneeLister implements TaskListener {
	private static final long serialVersionUID = 1L;
	public void notify(DelegateTask delegaTask) {
		//获取流程设置的流程变量
		Map<String, Object> map = delegaTask.getExecution().getVariables();
		if(null != map.get("assignee") && StringUtils.isBlank(delegaTask.getAssignee())){
			String assignee = map.get("assignee").toString();
			delegaTask.setAssignee(assignee);
		}
		if(null != map.get("owner") && StringUtils.isBlank(delegaTask.getOwner())){
			String owner = map.get("owner").toString();
			delegaTask.setOwner(owner);
		}
		if(StringUtils.isBlank(delegaTask.getCategory())){
			
		}
		XtUserinfoService xtUserinfoService = (XtUserinfoService)SpringUtil.getBean("xtUserinfoService");
		XtUserinfo user = xtUserinfoService.getXtUserinfoById( map.get("owner").toString());
		System.out.println("--------------------------------------------"+user.getXt_userinfo_realName());
	}
	
	/** 使用方法如下:即在任务节点中配置事件
	 <userTask id="psApply" name="行业评审组审批">
		 <extensionElements>
			<activiti:taskListener event="create" class="activitiUtil.AssigneeLister"></activiti:taskListener>
		 </extensionElements>
	</userTask>
	**/
}
