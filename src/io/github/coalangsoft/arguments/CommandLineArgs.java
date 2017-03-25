package io.github.coalangsoft.arguments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandLineArgs {
	
	private List<String> names;
	private Map<String, String> named;
	private List<String> rawList;
	
	private List<String> used;
	
	public String[] getUsed(){
		return used.toArray(new String[0]);
	}
	
	public Argument getNamed(String name){
		if(!used.contains(name)){
			used.add(name);
		}
		return new Argument(names.contains(name), named.get(name));
	}
	public Argument getUnnamed(int index){
		try{
			return new Argument(true, rawList.get(index));
		}catch(IndexOutOfBoundsException e){
			return new Argument(false, null);
		}
	}
	
	public CommandLineArgs(String[] raw){
		names = new ArrayList<String>();
		named = new HashMap<String, String>();
		rawList = new ArrayList<String>();
		used = new ArrayList<String>();
		
		String name = null;
		
		for(int i = 0; i < raw.length; i++){
			String arg = raw[i];
			if(arg.startsWith("-")){
				if(name != null){
					names.add(name);
				}
				name = arg;
			}else if(name != null){
				named.put(name, arg);
				names.add(name);
				name = null;
			}else{
				rawList.add(arg);
			}
		}
	}
	
}
