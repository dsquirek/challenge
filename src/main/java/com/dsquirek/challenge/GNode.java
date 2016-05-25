package com.dsquirek.challenge;

import java.util.List;

public interface GNode {
	
	public String getName();
	
	GNode getParent();
	
	public GNode[] getChildren();
	
	public  List<GNode> walkGraph(GNode node);
	
	public List<List<GNode>> path(GNode node);

}
