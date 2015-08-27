package mode;

public class County {
	private int id;
	private String countyName;
	private String countCode;
	private int  cityId;
	public int getId(){
		return id;
	}
	public  void setId(int id){
		this.id=id;
	}
	public String getCountyName(){
		return countyName;
	}
	public void setCountyName(String countyName ){
		this.countyName=countyName;
	}
	public String getCountyCode(){
		return countCode;
	}
	public void setCountyCode(String countCode ){
		this.countCode=countCode;
	}
	public  void setCityId(int cityId){
		this.cityId=cityId;
	}
	public int getCityId(){
		return cityId;
	}


}
