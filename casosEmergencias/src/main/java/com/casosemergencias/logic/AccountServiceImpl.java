package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.AccountDAO;
import com.casosemergencias.dao.AccountVO;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.util.ParserModelVO;


//las transacciones se abren y cierran aqui
public class AccountServiceImpl implements AccountService{
	
	final static Logger logger = Logger.getLogger(AccountService.class);
	
	@Autowired
	private AccountDAO accountDao;
		
	/**
	 * Metodo que devuelve una lista de todas las cuentas a mostrar en la tabla de nuestra app.
	 * @return listofallaccounts
	 */
	@Override
	public List<Cuenta> listOfAccountsTable() {
		
		List<Cuenta> listOfAccountsTable= new ArrayList<Cuenta>();
		List<AccountVO> listOfAllAccounts =new ArrayList<AccountVO>();
		listOfAllAccounts=accountDao.readAllAccount();
		Cuenta cuenta= null;
		
		
		for(AccountVO cuen:listOfAllAccounts){
			
			cuenta = new Cuenta();
			
			ParserModelVO.parseDataModelVO(cuen, cuenta);
		
			listOfAccountsTable.add(cuenta);
					
		}		
		return listOfAccountsTable;		
	}




}