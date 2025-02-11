package com.bank.demo.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.bank.demo.controller.dto.AccountDTO;
import com.bank.demo.controller.dto.AccountTransactionDTO;
import com.bank.demo.controller.dto.ReceiveDTO;
import com.bank.demo.controller.dto.TransactionPostDTO;
import com.bank.demo.controller.dto.TransmitDTO;
import com.bank.demo.controller.dto.UserDTO;
import com.bank.demo.entity.Account;
import com.bank.demo.entity.Transaction;
import com.bank.demo.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "accounts" , qualifiedByName = "acctoAccDTO")
	UserDTO toDTO(User entity);
	
	@Mapping(target ="id" ,ignore = true)
	@Mapping(target ="accounts" ,ignore = true)
	User toUser(UserDTO dto);
	
	@Named("acctoAccDTO")
	AccountDTO toDto(Account entity);
	
	@Mapping(target ="user" ,ignore = true)
	@Mapping(target ="transmits" ,ignore = true)
	@Mapping(target ="receives" ,ignore = true)
	Account toAccount(AccountDTO dto);

	@Mapping(target ="sender", qualifiedByName = "acctoAccDTO")
	@Mapping(target ="receiver", qualifiedByName = "acctoAccDTO")
	TransactionPostDTO toTransPostDto(Transaction entity);
	
	@Mapping(target ="transmits", qualifiedByName = "toTransDto")
	@Mapping(target ="receives", qualifiedByName = "toReceiveDto")
	AccountTransactionDTO toAccTransDto(Account entity);
	
	@Named("toTransDto")
	@Mapping(target = "receiver" , source = "entity.receiver.accId")
	TransmitDTO toTransDto(Transaction entity);
	
	@Named("toReceiveDto")
	@Mapping(target = "sender" , source = "entity.sender.accId")
	ReceiveDTO toReceiveDto(Transaction entity);
}
