package com.assignment01.q02.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment01.q01.dao.q01DAO;
import com.assignment01.q01.dto.q01InDTO;
import com.assignment01.q01.dto.q01OutDTO;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.service.ServiceManager;

@Repository
public class q02EC {

	@Autowired
	q01DAO q01DAO;

	@Autowired
	ServiceManager serviceManager;

	public q01OutDTO select(q01InDTO input) throws Exception {

		q01OutDTO output = new q01OutDTO();

		output = q01DAO.select(input);

		// SoApp.SG_EG.SyncAsyn_test
		ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q01pc_insert");
		q01InDTO in = new q01InDTO();
		in.setEmpno(15);
		in.setEname("test");
		serviceManager.call(serviceName, in, q01OutDTO.class, 10000);

		return output;

	}
}
