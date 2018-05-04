package jehc.xtmodules.xtcore.base.readwritedata;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据库读写分离
 * @author
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	protected Object determineCurrentLookupKey() {
		return JdbcContextHolder.getDataSource();
	}
}
