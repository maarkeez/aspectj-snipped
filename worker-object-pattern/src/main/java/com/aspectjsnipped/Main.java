package com.aspectjsnipped;

import com.aspectjsnipped.worker.CachePreFetcher;
import com.aspectjsnipped.worker.ProjectSaver;

public class Main {
	public static void main(String[] args) {
		CachePreFetcher.fetch();
		ProjectSaver.backupSave();
	}
}