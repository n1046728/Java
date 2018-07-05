import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

public class JDBCTestVM {
	private StockBean stkObject = new StockBean();
	private StockBean stkUpdateObject = new StockBean();
	private ListModelList<StockBean> stkList;;
	private String stkCode;
	@Init
	public void init(){
		stkList = new StockJDBC().readAll();	
	}
	
	@NotifyChange({"stkObject","stkList"})
	@Command
	public void add(){
		int rtnNum =  new StockJDBC().insert(stkObject);
		if(rtnNum==0){
			Clients.showNotification("儲存失敗",null,null,null,3000);
			
		}else{
			Clients.showNotification("儲存成功",null,null,null,3000);
		}
		clear(stkObject);
		init();
	}
	
	@NotifyChange({"stkObject","stkUpdateObject","stkCode"})
	@Command 
	public void clear(@BindingParam("stkobj")StockBean stkobj){
		stkCode=null;
		stkobj.setStkCode(null);
		stkobj.setStkName(null);
		stkobj.setType(null);
		stkobj.setExchange(null);
	}
	
	@NotifyChange("stkUpdateObject")
	@Command
	public void query(){
		stkUpdateObject = new StockJDBC().queryByStkCode(stkCode);		
	}
	
	@NotifyChange("stkUpdateObject")
	@Command
	public void save(){
		int rtnNum =  new StockJDBC().update(stkUpdateObject);
		if(rtnNum==0){
			Clients.showNotification("儲存失敗",null,null,null,3000);
			
		}else{
			Clients.showNotification("儲存成功",null,null,null,3000);
		}
		clear(stkUpdateObject);
	}
	
	@NotifyChange({"stkUpdateObject","stkList"})
	@Command
	public void delete(){
		int rtnNum =  new StockJDBC().delete(stkUpdateObject);
		if(rtnNum==0){
			Clients.showNotification("刪除失敗",null,null,null,3000);
			
		}else{
			Clients.showNotification("刪除成功",null,null,null,3000);
		} 
		clear(stkUpdateObject);
		init();
	}
	public ListModelList<StockBean> getStkList() {
		return stkList;
	}
	public void setStkList(ListModelList<StockBean> stkList) {
		this.stkList = stkList;
	}
	public StockBean getStkObject() {
		return stkObject;
	}
	public void setStkObject(StockBean stkObject) {
		this.stkObject = stkObject;
	}

	public StockBean getStkUpdateObject() {
		return stkUpdateObject;
	}

	public void setStkUpdateObject(StockBean stkUpdateObject) {
		this.stkUpdateObject = stkUpdateObject;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}
	
	
}
