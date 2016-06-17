package cn.doit123.shirodemo.services.sysres;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.doit123.shirodemo.daos.sysres.SysResDao;
import cn.doit123.shirodemo.pojo.entity.SysRes;

@Service("sysResService")
public class SysResServiceImpl implements SysResService {

	@Resource(name = "sysResDao")
	private SysResDao sysResDao;
	
	@Override
	public Set<String> findPermissions(int[] resIds) {
		List<SysRes> ress = sysResDao.queryByIds(resIds);
		Set<String> result = new HashSet<String>();
		for (SysRes res : ress) {
			result.add(res.getPermission());
		}
		return result;
	}

}
