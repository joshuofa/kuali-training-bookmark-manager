package edu.arizona.kuali.training;

public class BookmarkSequenceManager {
	
	static Integer sequence = 0;
	public static Integer getNextSeqence() {
		return sequence ++;
	}
}
