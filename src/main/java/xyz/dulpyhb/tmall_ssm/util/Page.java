package xyz.dulpyhb.tmall_ssm.util;

public class Page {
private int count;
private int start;
private int total;
private String param;
 private static final int DEFAULTCOUNT = 5;
public int getTotalPage() {
	//页数10页
	int totalPage;
	if(0 == total % count) {
		totalPage = total/count;
	}else {
		/*
		 * 
		 * 如果多了就多加一页
		 * 
		 * */
		totalPage = total/count+1;
	}
	if(0 == totalPage) {
		totalPage = 1;
	}
	return totalPage;
}

public int getLast() {
	int last;
	/*
	 * 如果总数能与5整除的话那么总数total-count为50-45为开始页面项
	 * 
	 * */
	if(0 == total % count) {
		last =total - count;
	}else {
		//如果总数为51那么就从50号开始排序
		last = total-total%count;
	}
	last =last<0?0:last;
	return last;
}
public boolean isHasPreviouse() {
	if (start == 0) {
		return false;
		}
	return true;
}
public boolean isHasNext(){
	if(start==getLast()) {
	return false;
}
	return true;
}

public Page() {
	count=DEFAULTCOUNT;
	
}

public Page(int start,int count) {
	this.start =start;
	this.count =count;
}
public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public int getStart() {
	return start;
}

public void setStart(int start) {
	this.start = start;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public String getParam() {
	return param;
}

public void setParam(String param) {
	this.param = param;
}

@Override
public String toString() {
	return "page [count=" + count + ", start=" + start + ", total=" + total + ", param=" + param + "]";
}
}
