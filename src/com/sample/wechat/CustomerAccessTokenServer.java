/**
 * 
 */
package com.sample.wechat;

import org.sword.wechat4j.token.AccessToken;
import org.sword.wechat4j.token.DbAccessTokenServer;

/**
 * @author repo_user
 * @date   2015年1月12日
 */
public class CustomerAccessTokenServer extends DbAccessTokenServer {

	/* (non-Javadoc)
	 * @see org.sword.wechat4j.token.DbAccessTokenServer#find()
	 */
	@Override
	public String find() {
		String accessToken = null;
		//执行数据库操作
//		String sql = "select cfgValue from cfg where cfg.cfgKey = 'access_token'";
//		accessToken = DBUtil.query(sql);
		return accessToken;
	}

	/* (non-Javadoc)
	 * @see org.sword.wechat4j.token.DbAccessTokenServer#save()
	 */
	@Override
	public boolean save(AccessToken accessToken) {
		//如果没有需要插入，如果有的就更新，假设已经有了数据库配置项
//		String sql = "update cfg set cfg.cfgValue=" + accessToken.getAccessToken() + 
//				" where cfg.cfgKey= 'access_token'";
//		DBUtil.execute(sql);
		return true;
	}
}