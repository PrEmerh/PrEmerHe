package com.casosemergencias.logic;

import com.casosemergencias.batch.PicklistTableCreatorBatch;

public class BatchServiceImpl implements BatchService {

	@Override
	public void updateHerokuPickListTable() {
		PicklistTableCreatorBatch.fillHerokuPicklistTable();
	}
}